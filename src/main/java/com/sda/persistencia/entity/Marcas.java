package com.sda.persistencia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Marcas {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	private String nombre; 
	@Enumerated(EnumType.STRING)
	private MarcaEstatus estatus; 
	
	public static enum MarcaEstatus{
		HABILITADA, DESABILITADA 
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public MarcaEstatus getEstatus() {
		return estatus;
	}

	public void setEstatus(MarcaEstatus estatus) {
		this.estatus = estatus;
	}
	
	

}
