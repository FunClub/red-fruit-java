package com.taomei.redfruit.business.shared.infrastructure.websocket.serverendpoint;

import com.taomei.redfruit.business.shared.infrastructure.configuration.CustomSpringConfigurator;
import com.taomei.redfruit.business.shared.infrastructure.websocket.decode.NoticeMessageEncoder;
import com.taomei.redfruit.business.shared.infrastructure.websocket.encode.NoticeMessageDecoder;
import com.taomei.redfruit.business.shared.infrastructure.websocket.message.NoticeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理通知信息的socket
 */
@ServerEndpoint(value="/notice/{userId}",configurator = CustomSpringConfigurator.class,
        encoders = {NoticeMessageEncoder.class},
        decoders = {NoticeMessageDecoder.class}
)
@Component
public class NoticeEndPoint {
    private final  static Logger LOGGER = LoggerFactory.getLogger(NoticeEndPoint.class);
    /**
     * 保存会话
     */
    private Map<String,Session> noticeSessionMap;

    public NoticeEndPoint() {
        this.noticeSessionMap = new HashMap<>();
    }

    @OnOpen
    public void open(Session session, @PathParam("userId")String userId) throws IOException {
        this.noticeSessionMap.put(userId,session);

        System.out.println(session.getId()+"connected");
    }
    @OnMessage
    public void message(Session session, NoticeMessage noticeMessage) {
        String recevieUserId = noticeMessage.getReceivedUserId();
        Session receiveUserSession = noticeSessionMap.get(recevieUserId);
        if(receiveUserSession==null)return;
        try {
            receiveUserSession.getBasicRemote().sendObject(noticeMessage);
        } catch (Exception e) {
            e.printStackTrace();
            if (LOGGER.isDebugEnabled()){
                LOGGER.error("发送通知消息失败");
            }
        }
    }
    @OnClose
    public void close(Session session, CloseReason closeReason, @PathParam("userId")String userId){
        try {
            session.close();
            noticeSessionMap.remove(userId);
        } catch (IOException e) {
            LOGGER.error(session.getId()+"close socket failed");
        }
        LOGGER.info(closeReason.getReasonPhrase()+","+session.getId()+"close socket");
    }
    @OnError
    public void error(Throwable throwable, Session session, @PathParam("userId")String userId){
        try {
            session.close();
            noticeSessionMap.remove(userId);
        } catch (IOException e) {
            LOGGER.error(session.getId()+"发生错误"+throwable.getMessage());
        }
    }

    public Map<String, Session> getNoticeSessionMap() {
        return noticeSessionMap;
    }

}
