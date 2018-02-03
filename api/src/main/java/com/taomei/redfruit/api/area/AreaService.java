package com.taomei.redfruit.api.area;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taomei.redfruit.api.area.data.Area;
import com.taomei.redfruit.api.area.data.AreaResponse;
import com.taomei.redfruit.api.common.ApiService;
import com.taomei.redfruit.common.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 区域服务
 * 提供省市级，区级城市查询服务
 */
@Service
public class AreaService{

    /**
     * 区域配置
     */
    private AreaConfiguration configuration;

    /**
     * 请求头部参数
     */
    private Map<String,String> headers;

    /**
     * 父级区域查询参数
     */
    private Map<String,String> parentAreaQueries;

    /**
     * 子级区域查询参数
     */
    private Map<String,String> subAreaQueries;

    @Autowired
    public AreaService(AreaConfiguration configuration) {
        this.configuration = configuration;
        headers = new HashMap<>();
        parentAreaQueries = new HashMap<>();
        subAreaQueries = new HashMap<>();
        headers.put("Authorization", "APPCODE " + this.configuration.getAppCode());
    }

    /**
     * 获取父级区域集合
     * @param leave 行政区域等级（0: 省级 1:市级 2:县级 3:镇级 4:乡村级）
     * @param pageNumber 页码，从1开始
     * @param pageSize 每页区域数
     * @return 区域集合
     * @throws Exception
     */
    public List<Area> getParentArea(String leave, String pageNumber, String pageSize) throws Exception {
        parentAreaQueries.put("level", leave);
        parentAreaQueries.put("page", pageNumber);
        parentAreaQueries.put("size", pageSize);

        HttpResponse response = HttpUtils.doGet(
                configuration.getHost(), configuration.getPathOfGetParent(),
                configuration.getMethod(), headers, parentAreaQueries);

        return  handleResponse(response);
    }

    /**
     * 获取指定id的子级区域集合
     * @param parentId 父级区域id
     * @return 区域集合
     * @throws Exception
     */
    public List<Area> getSubArea(String parentId) throws Exception {
        subAreaQueries.put("parent_id", parentId);
        HttpResponse response = HttpUtils.doGet(
                configuration.getHost(), configuration.getPathOfGetSub(),
                configuration.getMethod(), headers, subAreaQueries);
        List<Area> areas= handleResponse(response);

        //如果父级区域是直辖市则查询所拥有的直辖区和县
        if(areas.size()>2){//查询结果区域数量大于二，说明待查询区域不是直辖市；
            return areas;
        }

        //查询待查询区域所拥有的直辖区和县
        List<Area> resultAreas = new ArrayList<>();
        for (Area area:areas){
            if("直辖区".equals(area.getName())||"直辖县".equals(area.getName())){
                resultAreas.addAll(getSubArea(area.getId()));
            }
        }
        return resultAreas;
    }

    /**
     * 将响应处理成自定义数据类
     * @param response 响应
     * @return 区域集合
     * @throws Exception IO异常
     */
    private List<Area> handleResponse(HttpResponse response) throws Exception{
        String json = EntityUtils.toString(response.getEntity());
        ObjectMapper objectMapper = new ObjectMapper();
        AreaResponse areaResponse = objectMapper.readValue(json,AreaResponse.class);
        return areaResponse.getData();
    }

}
