package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.RestResponse;

public interface CustomerService {

	RestResponse get(Integer idCustomer);

	RestResponse get();

	RestResponse post(CustomerDTO request);

	RestResponse put(CustomerDTO request);

}
