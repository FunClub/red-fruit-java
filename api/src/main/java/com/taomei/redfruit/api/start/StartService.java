package com.taomei.redfruit.api.start;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taomei.redfruit.api.common.ApiService;
import com.taomei.redfruit.api.start.data.Start;
import com.taomei.redfruit.api.start.data.StartResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StartService extends ApiService{

    private final static int[] dayArr = new int[] { 20, 19, 21, 20, 21, 22, 23,
            23, 23, 24, 23, 22 };

    private final static String[] START = new String[] { "摩羯座",
            "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座",
            "天蝎座", "射手座", "摩羯座" };

    private final static String[] STARTCHAR = new String[] { "mojie",
            "shuiping", "shuangyu", "baiyang", "jinniu", "shuangzi", "juxie", "shizi", "chunv", "tiancheng",
            "tianxie", "sheshou", "mojie" };

    private final static String[] CHINESE_ZODIAC = new String[] { "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊",
            "猴", "鸡", "狗", "猪" };

    public StartService(StartConfiguration configuration) {
        super(configuration.getHost(),configuration.getPath(),configuration.getAppCode(),configuration.getMethod());
    }

    public Start getStart(LocalDate birthday) throws Exception {
        queries.put("needMonth", "0");
        queries.put("needTomorrow", "0");
        queries.put("needWeek", "0");
        queries.put("needYear", "0");
        queries.put("star", calculateStartChar(birthday));
        String json = doGet();
        ObjectMapper mapper = new ObjectMapper();
        StartResponse startResponse = mapper.readValue(json, StartResponse.class);
        return startResponse.getStartResult().getStart();
    }
    /**
     * 通过生日计算星座
     *
     * @param birthday 出生日期
     * @return 星座英文标识
     */
    private  String calculateStartChar(LocalDate birthday) {
        int month = birthday.getMonthValue();
        int day = birthday.getDayOfMonth();
        return day < dayArr[month - 1] ? STARTCHAR[month - 1]
                : STARTCHAR[month];
    }

    /**
     * 通过生日计算星座
     *
     * @param birthday 出生日期
     * @return 星座
     */
    public String calculateStart(LocalDate birthday) {
        int month = birthday.getMonthValue();
        int day = birthday.getDayOfMonth();
        return day < dayArr[month - 1] ? START[month - 1]
                : START[month];
    }

    /**
     * 通过年份计算生肖
     *
     * @param birthday 出生日期
     * @return 生肖
     */
    public static String calculateChineseZodiac(LocalDate birthday) {
        Integer year = birthday.getYear();
        if (year < 1900) {
            return "未知";
        }
        int start = 1900;
        return CHINESE_ZODIAC[(year - start) % CHINESE_ZODIAC.length];
    }


   /* public Start calculateStart(String birthday){

    }*/
}
