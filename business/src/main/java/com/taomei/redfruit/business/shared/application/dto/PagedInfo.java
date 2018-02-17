package com.taomei.redfruit.business.shared.application.dto;

import lombok.Data;

/**
 * 数据分页
 */
@Data
public class PagedInfo {

    /**
     * 数据总数
     */
    private Integer totals;

    /**
     *是否还有下一页
     */
    private Boolean hasNext;

    /**
     * 数据
     */
    private Object data;
}
