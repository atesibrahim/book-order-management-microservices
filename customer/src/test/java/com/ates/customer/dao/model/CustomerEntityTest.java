package com.ates.customer.dao.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerEntityTest {

	
	private CustomerEntity customerEntity;
	
	@BeforeEach
	public void init() {
		customerEntity = new CustomerEntity();
	}
	
	@Test
	public void whenCalledConstructor_thenCorrect() {
		customerEntity = new CustomerEntity("ibrahim ates", 150L);

		assertEquals(null, customerEntity.getId());
	}
	
	@Test
	public void whenCalledEquals_thenCorrect() {
		assertEquals(true, customerEntity.equals(customerEntity));
	}
	
	@Test
	public void whenCalledEqualsNull_thenFalse() {
		assertEquals(false, customerEntity.equals(null));
	}
	
	@Test
	public void whenCalledHashcode_thenTrue() {
		assertEquals(31, customerEntity.hashCode());
	}
	
	
	@Test
	public void whenCalledGetId_thenCorrect() {
		assertEquals(null, customerEntity.getId());
	}
	
	@Test
	public void whenCalledGetCustomerName_thenCorrect() {
		customerEntity.setCustomerName("Ibrahim Ates");
		assertEquals("Ibrahim Ates", customerEntity.getCustomerName());
	}
	
	@Test
	public void whenCalledGetBalance_thenCorrect() {
		customerEntity.setBalance(2500L);
		assertEquals(2500L, customerEntity.getBalance());
	}
}
