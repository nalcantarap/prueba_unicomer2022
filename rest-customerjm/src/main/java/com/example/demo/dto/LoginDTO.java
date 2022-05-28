package com.example.demo.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class LoginDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6605732415495688526L;

	@ApiModelProperty (value = "Usuario  Ejm:admin" ,required=true,allowEmptyValue = false,allowableValues = "admin")
	private String username;
	@ApiModelProperty (value = "Contraseña Ejm:admin",required=true,allowEmptyValue = false,allowableValues = "admin")
	private String password;
	
}
