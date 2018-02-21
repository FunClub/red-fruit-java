package com.taomei.redfruit.business.shared.infrastructure.po;

import lombok.Data;

/**
 * 点赞实体类
 */
@Data
public class Thumb {
    /**
     * 点赞 Id
     */
    private String thumbId;

    /**
     * 点赞目标 Id
     */
    private String targetId;

    /**
     * 攒点用户 Id
     */
    private String userId;
}
