package com.ates.customer.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ates.customer.dao.model.CustomerEntity;
import com.ates.customer.service.model.CustomerModel;

@Component
public class CustomerMapper {
	
	
	public CustomerModel mapCustomerEntityToCustomerModel(CustomerEntity customerEntity) {
		
		CustomerModel customerModel = new CustomerModel();
		
		customerModel.setBalance(customerEntity.getBalance());
		
		customerModel.setCustomerName(customerEntity.getCustomerName());
		
		customerModel.setId(customerEntity.getId());
		
		
		return customerModel;
	}
	
	public List<CustomerModel> listCustomerModels(List<CustomerEntity> customerEntities){
		
		List<CustomerModel> customerList = new ArrayList<>();
		
		customerEntities.forEach(element -> {
			customerList.add(mapCustomerEntityToCustomerModel(element));
		});
		
		return customerList;
	}

	public CustomerEntity mapCustomerModelToEntity(CustomerModel customerModel) {
		
		CustomerEntity customerEntity = new CustomerEntity();
		
		customerEntity.setBalance(customerModel.getBalance());
		
		customerEntity.setCustomerName(customerModel.getCustomerName());
		
		return customerEntity;
	}

}
