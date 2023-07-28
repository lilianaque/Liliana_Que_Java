package com.company.customerdataservice.simplecrmapi;

import com.company.customerdataservice.simplecrmapi.controller.CustomerController;
import com.company.customerdataservice.simplecrmapi.model.Customer;
import com.company.customerdataservice.simplecrmapi.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
public class CustomerTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CustomerRepository customerRepository;

	private List<Customer> testCustomers;

	@BeforeEach
	public void setup() {
		testCustomers = new ArrayList<>();
		testCustomers.add(new Customer(1, "Lily", "Que", "BofA", "New York"));
		testCustomers.add(new Customer(2, "Kiara", "Chombo", "TIAA", "North Carolina"));
	}

	@Test
		public void contextLoads() {
	}

	@Test
	public void createCustomer_ShouldReturnCreatedStatus() throws Exception {
		Customer newCustomer = new Customer(3, "New", "Customer", "Company C", "State C");
		when(customerRepository.save(any(Customer.class))).thenReturn(newCustomer);

		mockMvc.perform(post("/customers")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"firstName\":\"New\",\"lastName\":\"Customer\",\"company\":\"Company C\",\"state\":\"State C\"}"))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").value(newCustomer.getId()))
				.andExpect(jsonPath("$.firstName").value(newCustomer.getFirstName()))
				.andExpect(jsonPath("$.lastName").value(newCustomer.getLastName()))
				.andExpect(jsonPath("$.company").value(newCustomer.getCompany()))
				.andExpect(jsonPath("$.state").value(newCustomer.getState()));
	}

	@Test
	public void updateCustomer_ShouldReturnUpdatedCustomer() throws Exception {
		int customerId = 1;
		Customer updatedCustomer = new Customer(1, "Updated", "Customer", "Updated Company", "Updated State");
		when(customerRepository.findById(customerId)).thenReturn(Optional.of(testCustomers.get(0)));
		when(customerRepository.save(any(Customer.class))).thenReturn(updatedCustomer);

		mockMvc.perform(put("/customers/{id}", customerId)
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"firstName\":\"Updated\",\"lastName\":\"Customer\",\"company\":\"Updated Company\",\"state\":\"Updated State\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(updatedCustomer.getId()))
				.andExpect(jsonPath("$.firstName").value(updatedCustomer.getFirstName()))
				.andExpect(jsonPath("$.lastName").value(updatedCustomer.getLastName()))
				.andExpect(jsonPath("$.company").value(updatedCustomer.getCompany()))
				.andExpect(jsonPath("$.state").value(updatedCustomer.getState()));
	}

	@Test
	public void deleteCustomer_ShouldReturnNoContent() throws Exception {
		int customerId = 1;
		when(customerRepository.existsById(customerId)).thenReturn(true);

		mockMvc.perform(delete("/customers/{id}", customerId))
				.andExpect(status().isNoContent());
	}

	@Test
	public void getCustomerById_ShouldReturnCustomer() throws Exception {
		int customerId = 1;
		when(customerRepository.findById(customerId)).thenReturn(Optional.of(testCustomers.get(0)));

		mockMvc.perform(get("/customers/{id}", customerId))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(testCustomers.get(0).getId()))
				.andExpect(jsonPath("$.firstName").value(testCustomers.get(0).getFirstName()))
				.andExpect(jsonPath("$.lastName").value(testCustomers.get(0).getLastName()))
				.andExpect(jsonPath("$.company").value(testCustomers.get(0).getCompany()))
				.andExpect(jsonPath("$.state").value(testCustomers.get(0).getState()));
	}

	@Test
	public void getCustomersByState_ShouldReturnCustomers() throws Exception {
		String state = "Ohio";
		when(customerRepository.findByState(state)).thenReturn(List.of(testCustomers.get(0)));

		mockMvc.perform(get("/customers/state/{state}", state))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id").value(testCustomers.get(0).getId()))
				.andExpect(jsonPath("$[0].firstName").value(testCustomers.get(0).getFirstName()))
				.andExpect(jsonPath("$[0].lastName").value(testCustomers.get(0).getLastName()))
				.andExpect(jsonPath("$[0].company").value(testCustomers.get(0).getCompany()))
				.andExpect(jsonPath("$[0].state").value(testCustomers.get(0).getState()));
	}
}
