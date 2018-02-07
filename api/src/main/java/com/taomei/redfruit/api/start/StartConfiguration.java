package com.taomei.redfruit.api.start;

import com.taomei.redfruit.api.common.ApiConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "api.start")
@Component
public class StartConfiguration extends ApiConfiguration{
}
