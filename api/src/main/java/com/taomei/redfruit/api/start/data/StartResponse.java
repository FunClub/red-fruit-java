package com.taomei.redfruit.api.start.data;

/**
 * 星座数据响应对象
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * {
 "showapi_res_code": 0,
 "showapi_res_error": "",
 "showapi_res_body": {
 "ret_code": 0,
 "star": "shizi",
 "day": {
 "love_txt": "单身者多注意自己的穿着打扮，可提升异性缘；恋爱中的人有机会拜见双方父母。",
 "work_txt": "重复、乏味的工作会让你显得无精打采，事业中需要新挑战或新事物进行调剂。",
 "work_star": 3,
 "money_star": 2,
 "lucky_color": "草根白",
 "lucky_time": "下午5:00--6:00",
 "love_star": 4,
 "lucky_direction": "正西方",
 "summary_star": 3,
 "time": "20161011",
 "money_txt": "财气不稳定，外力干扰多，不利于投资买卖。有金钱耗损的迹象，趁今日去吃吃喝喝，把钱花在享受上吧！",
 "general_txt": "单身者与性情直率的人颇合得来，而恋爱中的人则在小打小闹中增进了彼此的情谊。切莫因喜好而盲目消费，今天财运犯小人，谨慎为妙。越是忙碌反而越觉得空虚，人也变得有些焦躁，找家人聊聊，可解除烦恼。",
 "grxz": "天蝎座",
 "lucky_num": "8",
 "day_notice": "工作情绪起伏不断。"
 },
 "day_notice": "aa"
 }
 }
 */
@Data
@JsonIgnoreProperties({"showapi_res_code","showapi_res_error"})
public class StartResponse {
    @JsonProperty("showapi_res_body")
    private StartResult startResult;

}
