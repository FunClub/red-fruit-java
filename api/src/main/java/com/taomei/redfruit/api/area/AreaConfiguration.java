package com.taomei.redfruit.api.area;

import com.taomei.redfruit.api.common.ApiConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 区域配置
 */
@Component
@ConfigurationProperties("api.area")
public class AreaConfiguration extends ApiConfiguration {

    /**
     * 获取父级区域的路径
     */
    private String pathOfGetParent;

    /**
     * 获取子级区域的路径
     */
    private String pathOfGetSub;


    public String getPathOfGetParent() {
        return pathOfGetParent;
    }

    public void setPathOfGetParent(String pathOfGetParent) {
        this.pathOfGetParent = pathOfGetParent;
    }

    public String getPathOfGetSub() {
        return pathOfGetSub;
    }

    public void setPathOfGetSub(String pathOfGetSub) {
        this.pathOfGetSub = pathOfGetSub;
    }
}
