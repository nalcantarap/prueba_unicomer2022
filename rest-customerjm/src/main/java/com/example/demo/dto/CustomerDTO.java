package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.demo.enums.GenderEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

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
public class CustomerDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6605732415495688526L;
	private Integer id;
	@ApiModelProperty (value = "Nombre" ,required=true,allowEmptyValue = false)
	private String firstName;
	@ApiModelProperty (value = "Apellido",required=true,allowEmptyValue = false)
	private String lastName;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@ApiModelProperty (value = "Fecha de nacimiento yyyy/MM/dd")
	private Date birthday ;
	@ApiModelProperty (value = "Género",required=true)
	private GenderEnum gender;
	@ApiModelProperty (value = "Número celular. Ejm:987654321",allowableValues ="range[600000000,999999999]" )
	private Long cellphone ;
	@ApiModelProperty (value = "Número fijo. Ejm:87654321",allowableValues ="range[20000000,88888888]" )
	private Long homephone ;
	@ApiModelProperty (value = "Dirección")
	private String addresshome;
	@ApiModelProperty (value = "Profesión")
	private String profession;
	@ApiModelProperty (value = "Ingresos",allowableValues ="range[1,8]" )
	private Long incomes;
	
}
