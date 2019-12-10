package it.caoxin.pojo.in.action.chapter03_use_domain_model.dto;

import it.caoxin.pojo.in.action.chapter03_use_domain_model.domain.PendingOrder;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2019/12/7
 * 功能描述:
 * 修改日期:2019/12/7
 * 修改描述:
 */
public class PlaceOrderServiceResult {
    // 表示送货核实结果
    private int statusCode;
    // 返回PendingOrder调用者需要这个对象
    private PendingOrder pendingOrder;

    public PlaceOrderServiceResult(int statusCode, PendingOrder pendingOrder) {
        this.statusCode = statusCode;
        this.pendingOrder = pendingOrder;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public PendingOrder getPendingOrder() {
        return pendingOrder;
    }
}
