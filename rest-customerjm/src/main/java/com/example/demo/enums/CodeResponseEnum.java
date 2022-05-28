package com.example.demo.enums;

public enum CodeResponseEnum {
	OK("OK"),
	Created("Creado"),
	BadRequest("Request incorrecto"),
	Unauthorized("No autorizado"),
	InternalServerError("Error interno"),
	NoResponse("No hay datos");
	
	private String description;

	CodeResponseEnum(String description){
		this.description=description;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
