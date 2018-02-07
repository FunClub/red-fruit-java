package com.taomei.redfruit.api.start.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties({"ret_code","star","day_notice"})
public class StartResult {
    @JsonProperty("day")
    private Start start;
}
