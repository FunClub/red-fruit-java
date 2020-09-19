package com.taomei.redfruit.business.shared.application;

import com.taomei.redfruit.business.message.infrastructure.po.TrendNotice;
import com.taomei.redfruit.business.shared.application.dto.PageComm;
import com.taomei.redfruit.business.shared.application.dto.PagedInfo;
import com.taomei.redfruit.business.shared.application.dto.discussion.*;
import com.taomei.redfruit.business.shared.application.dto.TitleUserInfo;
import com.taomei.redfruit.business.shared.infrastructure.po.ParentDiscussion;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 共享服务接口
 */
@Service
public interface SharedService {

    /**
     * 生成base64URL
     * @param code 等待加密的字符串
     * @return
     * @throws UnsupportedEncodingException
     */
    String generateBase64Url(String code) throws UnsupportedEncodingException;

    /**
     *  取消赞
     * @param targetId 点赞目标 id
     * @param userId 点赞的用户 Id
     * @return 取消结果
     */
    boolean deleteThumb(String targetId,String userId);
    /**
     * 点赞
     * @return 点赞结果
     */
    boolean createThumb(TrendNotice notice);
    /**
     * 插入子级评论
     * @param comm 子级评论命令
     * @return 子级评论信息
     */
    SubDiscussionInfo insertSubDiscussion(InsertSubDiscussionComm comm);
    /**
     * 查询父级评论
     * @param comm 查询评论
     * @return 分页的父级评论
     */
    PagedInfo selectParentDiscussionInfo(PageComm<ParentDiscussionInfo,QueryDiscussionComm> comm);

    /**
     * 插入父级评论
     * @param discussionComm 插入父级评论 命令
     * @return 父级评论信息
     */
    ParentDiscussionInfo createParentDiscussion(InsertParentDiscussionComm discussionComm);
    /**
     * 获取用户主页标题信息
     * @param userId 用户Id
     * @return 标题信息
     */
    TitleUserInfo selectTitleUserInfo(String userId);
}
