package com.taomei.redfruit.api.start;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taomei.redfruit.api.common.ApiService;
import com.taomei.redfruit.api.start.data.Start;
import com.taomei.redfruit.api.start.data.StartResponse;
import com.taomei.redfruit.common.utils.TimeUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StartService extends ApiService{



    public StartService(StartConfiguration configuration) {
        super(configuration.getHost(),configuration.getPath(),configuration.getAppCode(),configuration.getMethod());
    }

    public Start getStart(String birthday) throws Exception {

        queries.put("needMonth", "0");
        queries.put("needTomorrow", "0");
        queries.put("needWeek", "0");
        queries.put("needYear", "0");
        queries.put("star", TimeUtils.calculateStartChar(birthday));
        String json = doGet();
        ObjectMapper mapper = new ObjectMapper();
        StartResponse startResponse = mapper.readValue(json, StartResponse.class);
        return startResponse.getStartResult().getStart();
    }



   /* public Start calculateStart(String birthday){

    }*/
}
