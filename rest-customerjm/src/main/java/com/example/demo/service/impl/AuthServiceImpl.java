package com.example.demo.service.impl;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.RestResponse;
import com.example.demo.entity.User;
import com.example.demo.enums.CodeResponseEnum;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import com.example.demo.util.JWTUtil;

@Service
public class AuthServiceImpl implements AuthService{
	Log LOG=LogFactory.getLog(AuthServiceImpl.class);
	@Autowired
	UserRepository userRepository;
	@Autowired
	JWTUtil jwtUtil;
	@Override
	public RestResponse login(LoginDTO request) {
		RestResponse response=new RestResponse();
		response.setResponse(false);
		if(request==null || request.getUsername()==null || request.getPassword()==null) {
			response.setCode(CodeResponseEnum.BadRequest.name());
			response.setMessage(CodeResponseEnum.BadRequest.getDescription());
			return response;
		}
		try {
			Optional<User> user=userRepository.findById(1);//en modo real hay que validar usuario y contraseña correcto
			if(user.isPresent()) {
				String token=jwtUtil.create(String.valueOf(user.get().getId()), user.get().getName());
				response.setResponse(true);
				response.setData(token);
				response.setCode(CodeResponseEnum.OK.name());
				response.setMessage("Login correcto");
			}else {
				response.setCode(CodeResponseEnum.NoResponse.name());
				response.setMessage("Credenciales incorrectas");
			}
		}catch(Exception ex) {
			LOG.error(ex.getMessage());
			response.setCode(CodeResponseEnum.InternalServerError.name());
			response.setMessage(CodeResponseEnum.InternalServerError.getDescription());
		}
		return response;
	}

}
