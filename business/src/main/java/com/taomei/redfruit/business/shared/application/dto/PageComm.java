package com.taomei.redfruit.business.shared.application.dto;

import com.baomidou.mybatisplus.plugins.Page;
import lombok.Data;

/**
 * 分页命令
 */
@Data
public class PageComm<P,D> {

    private Page<P> page;
    private D condition;
}
