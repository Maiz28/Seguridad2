package com.sda.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ModelosDto {
	@NotBlank
	private String descripcion; 
	@DecimalMin(value="0.01")
	private Float precio; 
	@Min(value=1)
	private Integer marca_id;
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Integer getMarca_id() {
		return marca_id;
	}
	public void setMarca_id(Integer marca_id) {
		this.marca_id = marca_id;
	} 
	

}
