package it.caoxin.pojo.in.action.chapter03_use_domain_model.service;

import it.caoxin.pojo.in.action.chapter03_use_domain_model.domain.PendingOrder;
import it.caoxin.pojo.in.action.chapter03_use_domain_model.domain.Restaurant;
import it.caoxin.pojo.in.action.chapter03_use_domain_model.dto.Address;
import it.caoxin.pojo.in.action.chapter03_use_domain_model.dto.PlaceOrderServiceResult;
import it.caoxin.pojo.in.action.chapter03_use_domain_model.repository.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2019/12/7
 * 功能描述:
 * 修改日期:2019/12/7
 * 修改描述:
 */

public class PlaceOrderServiceTest {
    private static Logger logger = LoggerFactory.getLogger(PlaceOrderServiceTest.class);

    @Mock
    private RestaurantRepository restaurantRepository;
    @Mock
    private Restaurant restaurant;
    @Mock
    private PlaceOrderService placeOrderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockitoVerify() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void testMockitoStubbing1() {
        List mockedList = mock(List.class);
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());
        System.out.println(mockedList.get(0));
        //System.out.println(mockedList.get(1));
        System.out.println(mockedList.get(999));
    }

    @Test
    public void testMockitoStubbing2() {
        PlaceOrderService mock = mock(PlaceOrderService.class);
        when(mock.updateDeliveryInfo(anyString(), any(Address.class), any(Date.class))).thenReturn(new PlaceOrderServiceResult(1, new PendingOrder()));
        PlaceOrderServiceResult placeOrderServiceResult = mock.updateDeliveryInfo("pendingOrderId", new Address(), new Date());
        logger.info("PlaceOrderServiceResult: "+ placeOrderServiceResult);
    }
    @Test
    public void testUpdateRestaurantGood() {
        when(restaurantRepository.findRestaurant(anyString())).thenReturn(new Restaurant("糖果酒店", "时代地产"));
        when(placeOrderService.updateRestaurant(anyString(), anyString())).thenReturn(new PlaceOrderServiceResult(1, new PendingOrder()));

        Restaurant restaurant = restaurantRepository.findRestaurant("");
        System.out.println(restaurant.getName());
        System.out.println(restaurant.getType());

        PlaceOrderServiceResult placeOrderServiceResult = placeOrderService.updateRestaurant("", "");
        System.out.println(placeOrderServiceResult.getStatusCode());
        System.out.println(placeOrderServiceResult.getPendingOrder());

        verify(restaurantRepository).findRestaurant("");
        verify(placeOrderService).updateRestaurant("", "");
    }
}