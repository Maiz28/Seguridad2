package com.sda.dto;

import jakarta.validation.constraints.NotBlank;

public class MarcasDto {
	@NotBlank
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	} 
	
	

}
