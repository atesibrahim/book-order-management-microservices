package com.ates.order.service.order;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ates.order.dao.order.OrderRepository;
import com.ates.order.service.mapper.OrderMapper;
import com.ates.order.service.model.OrderModel;
import com.ates.order.utils.SufficientException;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderMapper orderMapper;
	
	public OrderServiceImpl() {
		super();
	}
	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
		super();
		this.orderRepository = orderRepository;
		this.orderMapper = orderMapper;
	}



	@Override
	public Long createOrder(OrderModel orderModel) throws SufficientException {
		Long result = 0L;
		try {
		
			
			// create order
			
			result = orderRepository.save(orderMapper.mapToOrderEntity(orderModel)).getId();
			
		} catch (Exception e) {
			String errorMessage = "Sufficient exception occured. Order has not been create.";
			logger.error(errorMessage);
			throw new SufficientException(e, errorMessage);
			
		}
		
		// if all success then return that is success
		return result;
	}

	@Override
	public List<OrderModel> getAllOrders() {
		
		return orderMapper.mapToModelList(orderRepository.findAll());
		
	}

	@Override
	public List<OrderModel> getCustomerOrders(Long customerId) {
		
		return orderMapper.mapToModelList(orderRepository.findByCustomeridEquals(customerId));
	
	}

}
