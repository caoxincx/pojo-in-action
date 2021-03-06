package it.caoxin.pojo.in.action.chapter03_use_domain_model.service;

import it.caoxin.pojo.in.action.chapter03_use_domain_model.dto.Address;
import it.caoxin.pojo.in.action.chapter03_use_domain_model.dto.PlaceOrderServiceResult;

import java.util.Date;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2019/12/7
 * 功能描述:
 * 修改日期:2019/12/7
 * 修改描述:
 */
public interface PlaceOrderService {
    PlaceOrderServiceResult updateDeliveryInfo(String pendingOrderId,
                                               Address deleveryAddress,
                                               Date deliverTime);

    PlaceOrderServiceResult updateRestaurant(String pendingOrderId, String restaurantId);
}
