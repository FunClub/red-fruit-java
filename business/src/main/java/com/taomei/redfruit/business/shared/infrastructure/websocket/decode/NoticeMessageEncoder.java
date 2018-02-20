package com.taomei.redfruit.business.shared.infrastructure.websocket.decode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taomei.redfruit.business.shared.infrastructure.websocket.message.NoticeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * 邀请消息编码器，将Java对象转换为json字符串
 */
public class NoticeMessageEncoder implements Encoder.Text<NoticeMessage> {
    private final  static Logger LOGGER = LoggerFactory.getLogger(NoticeMessageEncoder.class);
    @Override
    public String encode(NoticeMessage object) throws EncodeException {
        ObjectMapper objectMapper = new ObjectMapper();
        String message=null;
        try {
            message=objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.error("java对象=》json字符串，解析失败");
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
