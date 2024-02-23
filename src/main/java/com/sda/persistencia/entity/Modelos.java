package com.sda.persistencia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Modelos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String descripcion;
	private Float precio; 
	
	@Enumerated(EnumType.STRING)
	private ModelosEstatus estatus; 
	
	@ManyToOne 
	@JoinColumn(name="marca_id")
	private Marcas marcas; 
	
	public static enum ModelosEstatus{
		HABILITADO, DESHABILITADO
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public ModelosEstatus getEstatus() {
		return estatus;
	}

	public void setEstatus(ModelosEstatus estatus) {
		this.estatus = estatus;
	}

	public Marcas getMarcas() {
		return marcas;
	}

	public void setMarcas(Marcas marcas) {
		this.marcas = marcas;
	}
	

}
