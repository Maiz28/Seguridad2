package com.sda.persistencia.entity;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity 
public class carreras {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	private String nombre; 
	private String competencias;
	
	@Enumerated
	private TipoCarrea tipoCarrera; 
	
	private Date fechaRegistro;
	
	public static enum TipoCarrea{
		ESCOLARIZADA, SEMIESCOLARIZADA 
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

	public String getCompetencias() {
		return competencias;
	}

	public void setCompetencias(String competencia) {
		this.competencias = competencia;
	}

	public TipoCarrea getTipoCarrera() {
		return tipoCarrera;
	}

	public void setTipoCarrera(TipoCarrea tipoCarrera) {
		this.tipoCarrera = tipoCarrera;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
}
