package com.ates.customer.service.customer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ates.customer.dao.customer.CustomerRepositoryImpl;
import com.ates.customer.dao.model.CustomerEntity;
import com.ates.customer.service.mapper.CustomerMapper;
import com.ates.customer.service.model.CustomerModel;
import com.ates.customer.utils.SufficientException;
import com.ates.customer.utils.DeleteException;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	CustomerRepositoryImpl customerRepository;
	
	@Autowired
	CustomerMapper customerMapper;
	

	@Override
	public List<CustomerModel> getAllCustomers() {
		
		logger.debug("service get all customers method was called");
		
		return customerMapper.listCustomerModels(customerRepository.getAllCustomers());
	}

	@Override
	public CustomerModel addCustomer(CustomerModel customerModel) {
		
		CustomerEntity customerEntity = customerMapper.mapCustomerModelToEntity(customerModel);
		
		customerEntity = customerRepository.addCustomer(customerEntity);

		return customerMapper.mapCustomerEntityToCustomerModel(customerEntity);
	}

	@Override
	public CustomerModel getCustomerInfo(Long id) {
		
		return customerMapper.mapCustomerEntityToCustomerModel(customerRepository.getCustomerInfo(id));
	}

	@Override
	public Boolean deleteCustomer(Long id){

		Boolean result = true;
		try {
			customerRepository.deleteCustomer(id);

		} catch (DeleteException e) {
			logger.error("service delete customer method error occured. Error :"+e.getMessage());

			result = false;
		}
		return result;
	}
	
	public void checkCustomerBalance(Long id, Long amount) throws SufficientException {
		CustomerEntity customerEntity = customerRepository.getCustomerInfo(id);
		if(customerEntity.getBalance()>=amount) {
			customerEntity.setBalance(customerEntity.getBalance()-amount);
			customerRepository.addCustomer(customerEntity);
		}
		else {
			throw new SufficientException("Your balance is not sufficient");
		}
		
	}

}
