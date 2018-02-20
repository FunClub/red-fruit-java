package com.taomei.redfruit.business.shared.infrastructure.websocket.serverendpoint;


import com.taomei.redfruit.business.shared.infrastructure.configuration.CustomSpringConfigurator;
import com.taomei.redfruit.business.shared.infrastructure.websocket.decode.NoticeMessageEncoder;
import com.taomei.redfruit.business.shared.infrastructure.websocket.encode.NoticeMessageDecoder;
import com.taomei.redfruit.business.shared.infrastructure.websocket.message.NoticeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理聊天信息的socket
 */
@ServerEndpoint(value="/chat/{userId}",configurator = CustomSpringConfigurator.class,
        encoders = {NoticeMessageEncoder.class},
        decoders = {NoticeMessageDecoder.class}
)
@Component
public class ChatEndPoint {
    /**
     * 保存会话
     */
    private Map<String,Session> chatSessionMap;
    private final NoticeEndPoint noticeEndPoint;

    private final  static Logger LOGGER = LoggerFactory.getLogger(ChatEndPoint.class);
    private final HttpSession session;
    @Autowired
    public ChatEndPoint(NoticeEndPoint noticeEndPoint,  HttpSession session) {

        this.chatSessionMap = new HashMap<>();
        this.noticeEndPoint = noticeEndPoint;

        this.session = session;
    }

    @OnOpen
    public void open(Session session, @PathParam("userId")String userId) throws IOException {
        this.chatSessionMap.put(userId,session);
        LOGGER.info(userId+"connected");
    }

    @OnMessage
    public void message(Session session, NoticeMessage noticeMessage) throws IOException, EncodeException {
        String receivedUserId =noticeMessage.getReceivedUserId();
        Map<String,Session> noticeSessionMap = noticeEndPoint.getNoticeSessionMap();
        Session chatSession= chatSessionMap.get(receivedUserId);
        Session noticeSession = noticeSessionMap.get(receivedUserId);

       /* Chat chat = new Chat();
        noticeMessage.setDate(TimeUtil.generateShortDate(TimeUtil.getSimpleTime()));
        BeanUtils.copyProperties(noticeMessage,chat);
        chatService.insertChat(chat);*/

        if(noticeSession!=null){
            noticeMessage.setType("chat");
            if(chatSession!=null){
                chatSession.getBasicRemote().sendObject(noticeMessage);
            }else{
                noticeSession.getBasicRemote().sendObject(noticeMessage);
            }
        }
    }

    @OnClose
    public void close(Session session, CloseReason closeReason, @PathParam("userId")String userId){
        try {
            session.close();
            chatSessionMap.remove(userId);
        } catch (IOException e) {
            LOGGER.error(session.getId()+"close socket failed");
        }
        LOGGER.info(closeReason.getReasonPhrase()+","+session.getId()+"close socket");
    }
    @OnError
    public void error(Throwable throwable, Session session, @PathParam("userId")String userId){
        try {
            session.close();
            chatSessionMap.remove(userId);
        } catch (IOException e) {
            LOGGER.error(session.getId()+"发生错误"+throwable.getMessage());
        }
    }
}
