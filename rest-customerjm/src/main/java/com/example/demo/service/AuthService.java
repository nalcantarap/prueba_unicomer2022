package com.example.demo.service;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.RestResponse;

public interface AuthService {

	RestResponse login(LoginDTO request);

}
