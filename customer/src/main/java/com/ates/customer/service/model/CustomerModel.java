package com.ates.customer.service.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class CustomerModel {

	@Schema(description = "Unique identifier of the Customer.", example = "1", required = true)
	private Long id;
	

	@Schema(description = "Customer name.", example = "ibrahim ates", required = true)
	private String customerName;
	

	@Schema(description = "Customer balance.", example = "1250", required = true)
	private Long balance;
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public Long getBalance() {
		return balance;
	}


	public void setBalance(Long balance) {
		this.balance = balance;
	}
	
	
	

}
