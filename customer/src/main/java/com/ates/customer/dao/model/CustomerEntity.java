package com.ates.customer.dao.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "customer")
public class CustomerEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3897811280783252922L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String customerName;

	@Column
	private Long balance;


	public CustomerEntity() {
		super();
	}

	public CustomerEntity(String customerName, Long balance) {
		super();
		this.customerName = customerName;
		this.balance = balance;
	}
	
	public Long getId() {
		return id;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CustomerEntity customer = (CustomerEntity) o;
		return id.equals(customer.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	

}
