package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.RestResponse;
import com.example.demo.service.CustomerService;

import io.swagger.annotations.Api;




@RestController
@Api(value="Clientes", description="Obtiene y modifica clientes")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	Log LOG=LogFactory.getLog(CustomerController.class);
	
	@GetMapping(value= "/customer/{idCustomer}")
	public RestResponse get( HttpServletRequest request,@PathVariable("idCustomer") Integer idCustomer){
		return this.customerService.get(idCustomer);
	}
	@GetMapping(value= "/customer")
	public RestResponse get( ){
		return this.customerService.get();
	}
	@PostMapping(value= "/customer")
	public RestResponse post( CustomerDTO request){
		return this.customerService.post(request);
	}
	@PutMapping(value= "/customer")
	public RestResponse put(CustomerDTO request ){
		return this.customerService.put(request);
	}
}
