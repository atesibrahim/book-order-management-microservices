package com.ates.order.service.order;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ates.order.service.mapper.OrderMapper;
import com.ates.order.service.model.OrderModel;
import com.ates.order.dao.model.OrderEntity;
import com.ates.order.dao.order.OrderRepository;


@SpringBootTest
public class OrderServiceTest {


	@Mock
	private OrderRepository orderRepository;
		
	private OrderMapper orderMapper = new OrderMapper();
	
	private OrderServiceImpl orderServiceImpl;
	
	private List<OrderEntity> orderEntities = new ArrayList<>();
	
	private OrderEntity orderEntity;
	
	private OrderModel orderModel;
	
	@BeforeEach
	public void init() {
		
		orderServiceImpl = new OrderServiceImpl(orderRepository, orderMapper);
		
		orderEntity = new OrderEntity();
		orderEntity.setOrderAmount(100L);
		orderEntity.setBookCount(5);
		orderEntity.setCustomerId(3L);
		orderEntity.setBookId(1L);
		orderEntities.add(orderEntity);
		
		orderModel = new OrderModel();
		

		orderModel.setOrderAmount(100L);
		orderModel.setBookCount(5);
		orderModel.setCustomerId(3L);
		orderModel.setBookId(1L);
		
	}
	
	@Test
	public void whenCalledGetAllOrder_thenReturnList() {
		
		when(orderRepository.findAll()).thenReturn(orderEntities);
		
		assertTrue(orderServiceImpl.getAllOrders().size()>0);
		
	}
	
	@Test
	public void whenCalledGetCustomerOrders_thenReturnList() {
		
		when(orderRepository.findByCustomeridEquals(anyLong())).thenReturn(orderEntities);
		
		assertTrue(orderServiceImpl.getCustomerOrders(1L).size()>0);
		
	}
	
}
