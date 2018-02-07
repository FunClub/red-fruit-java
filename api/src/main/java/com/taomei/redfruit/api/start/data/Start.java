package com.taomei.redfruit.api.start.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 星座数据
 */
@Data
@JsonIgnoreProperties({"work_txt","work_star","money_star","lucky_time",
"lucky_direction","summary_star","time","money_txt","general_txt","day_notice"
})
public class Start {

    @JsonProperty("love_txt")
    private String loveText;

    @JsonProperty("grxz")
    private String luckyStart;

    @JsonProperty("lucky_color")
    private String luckyColor;

    @JsonProperty("lucky_num")
    private String luckyNumber;

    @JsonProperty("love_star")
    private String loveStart;

}
