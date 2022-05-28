package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controllers.CustomerController;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.RestResponse;
import com.example.demo.entity.Customer;
import com.example.demo.enums.CodeResponseEnum;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.util.CustomerMapping;

@Service
public class CustomerServiceImp implements CustomerService {
	Log LOG=LogFactory.getLog(CustomerServiceImp.class);
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CustomerMapping customerMapping;
	
	@Override
	public RestResponse get(Integer idCustomer) {
		RestResponse response=new RestResponse();
		response.setResponse(false);
		if(idCustomer==null || idCustomer.intValue()==0) {
			response.setCode(CodeResponseEnum.BadRequest.name());
			response.setMessage(CodeResponseEnum.BadRequest.getDescription());
			return response;
		}
		try {
			Optional<Customer> customer=customerRepository.findById(idCustomer);
			if(customer.isPresent()) {
				response.setResponse(true);
				response.setData(customerMapping.entityToModel(customer.get()));
				response.setCode(CodeResponseEnum.OK.name());
				response.setMessage(CodeResponseEnum.OK.getDescription());
			}else {
				response.setCode(CodeResponseEnum.NoResponse.name());
				response.setMessage(CodeResponseEnum.NoResponse.getDescription());
			}
		}catch(Exception ex) {
			LOG.error(ex.getMessage());
			response.setCode(CodeResponseEnum.InternalServerError.name());
			response.setMessage(CodeResponseEnum.InternalServerError.getDescription());
		}
		return response;
	}

	@Override
	public RestResponse get() {
		RestResponse response=new RestResponse();
		response.setResponse(false);
		try {
			List<CustomerDTO> customers=new ArrayList<>();
			customerRepository.findAll().forEach(e->customers.add(customerMapping.entityToModel(e)));
			response.setResponse(true);
			response.setData(customers);
			response.setCode(CodeResponseEnum.OK.name());
			response.setMessage(CodeResponseEnum.OK.getDescription());
			
		}catch(Exception ex) {
			LOG.error(ex.getMessage());
			response.setCode(CodeResponseEnum.InternalServerError.name());
			response.setMessage(CodeResponseEnum.InternalServerError.getDescription());
		}
		return response;
	}

	@Override
	public RestResponse post(CustomerDTO request) {
		RestResponse response=new RestResponse();
		response.setResponse(false);
		if(request==null ) {
			response.setCode(CodeResponseEnum.BadRequest.name());
			response.setMessage(CodeResponseEnum.BadRequest.getDescription());
			return response;
		}
		request.setId(null);
		try {
			Customer customer=customerMapping.modelToEntity(request);
			if(customer==null ) {
				response.setCode(CodeResponseEnum.BadRequest.name());
				response.setMessage("Nombre y apellidos son obligatorios");
				return response;
			}
			customerRepository.save(customer);
			response.setResponse(true);
			response.setData(customerMapping.entityToModel(customer));
			response.setCode(CodeResponseEnum.OK.name());
			response.setMessage(CodeResponseEnum.OK.getDescription());
			
		}catch(Exception ex) {
			LOG.error(ex.getMessage());
			response.setCode(CodeResponseEnum.InternalServerError.name());
			response.setMessage(CodeResponseEnum.InternalServerError.getDescription());
		}
		return response;
	}

	@Override
	public RestResponse put(CustomerDTO request) {
		RestResponse response=new RestResponse();
		response.setResponse(false);
		if(request==null ) {
			response.setCode(CodeResponseEnum.BadRequest.name());
			response.setMessage(CodeResponseEnum.BadRequest.getDescription());
			return response;
		}
		if(request.getId()==null ) {
			response.setCode(CodeResponseEnum.BadRequest.name());
			response.setMessage("Falta id cliente a modificar");
			return response;
		}
		try {
			Customer customer=customerMapping.modelToEntity(request);
			if(customer==null ) {
				response.setCode(CodeResponseEnum.BadRequest.name());
				response.setMessage("Nombre y apellidos son obligatorios");
				return response;
			}
			customerRepository.save(customer);
			response.setResponse(true);
			response.setData(customerMapping.entityToModel(customer));
			response.setCode(CodeResponseEnum.OK.name());
			response.setMessage(CodeResponseEnum.OK.getDescription());
			
		}catch(Exception ex) {
			LOG.error(ex.getMessage());
			response.setCode(CodeResponseEnum.InternalServerError.name());
			response.setMessage(CodeResponseEnum.InternalServerError.getDescription());
		}
		return response;
	}

}
