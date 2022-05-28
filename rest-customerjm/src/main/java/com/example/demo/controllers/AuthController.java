package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.RestResponse;
import com.example.demo.service.AuthService;

import io.swagger.annotations.Api;

@RestController
@Api(value="Autenticación", description="Obtiene token jwt. Aún no implementado en servicios demo")
public class AuthController {
	@Autowired
	AuthService authService;
	@PostMapping(value= "/auth")
	public RestResponse post( LoginDTO request){
		return this.authService.login(request);
	}
}
