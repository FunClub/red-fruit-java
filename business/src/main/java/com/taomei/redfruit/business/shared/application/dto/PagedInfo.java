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
     *
     */
    private Boolean hasNext;
    private Object data;
}
