package com.ates.order.service.order;

import java.util.List;

import com.ates.order.service.model.OrderModel;
import com.ates.order.utils.SufficientException;

public interface OrderService {

	public List<OrderModel> getAllOrders();
	
	public List<OrderModel> getCustomerOrders(Long customerId);
	
	public Long createOrder(OrderModel orderModel) throws SufficientException;
}
