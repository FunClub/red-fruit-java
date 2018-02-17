package com.taomei.redfruit.business.shared.application.dto;

import com.baomidou.mybatisplus.plugins.Page;
import lombok.Data;

/**
 * 分页命令
 * P:分页得到的数据
 * D:分页条件
 */
@Data
public class PageComm<P,D> {

    /**
     * 分页参数
     */
    private Page<P> page;

    /**
     * 分页条件
     */
    private D condition;
}
