package com.taomei.redfruit.business.shared.infrastructure.websocket.message;




/**
 * 邀请另一半消息
 */
public class InviteMessage{
    /**
     * 消息类型
     */
    private int type;

    private String invitationId;
    private String inviteId;
    private String invitedId;
    private String nickname;
    private String profileImg;
    /**
     * 消息的状态，是否操作成功
     */
    private boolean status;
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
