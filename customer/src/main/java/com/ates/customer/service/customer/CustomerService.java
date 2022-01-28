package com.ates.customer.service.customer;

import java.util.List;

import com.ates.customer.service.model.CustomerModel;
import com.ates.customer.utils.SufficientException;

public interface CustomerService {
	
	List<CustomerModel> getAllCustomers();
	
	CustomerModel getCustomerInfo(Long id);
	
	CustomerModel addCustomer(CustomerModel customerModel);
	
	Boolean deleteCustomer(Long id);
	
	void checkCustomerBalance(Long id, Long amount) throws SufficientException;

}
