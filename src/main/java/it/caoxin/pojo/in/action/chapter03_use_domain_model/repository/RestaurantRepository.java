package it.caoxin.pojo.in.action.chapter03_use_domain_model.repository;

import it.caoxin.pojo.in.action.chapter03_use_domain_model.domain.Restaurant;
import it.caoxin.pojo.in.action.chapter03_use_domain_model.dto.Address;

import java.util.Date;
import java.util.List;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2019/12/7
 * 功能描述:
 * 修改日期:2019/12/7
 * 修改描述:
 */
public interface RestaurantRepository {
    List<Restaurant> findAvailableResturants(Address address, Date deliveryTime);

    Restaurant findRestaurant(String restaurantId);
}
