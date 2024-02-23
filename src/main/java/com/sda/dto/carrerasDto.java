package com.sda.dto;

import com.sda.persistencia.entity.carreras.TipoCarrea;


public class carrerasDto {

	private String nombre;
	private String competencias;
	private TipoCarrea tipoCarrera; 
	private String fechaRegistro;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCompetencias() {
		return competencias;
	}
	public void setCompetencias(String competencias) {
		this.competencias = competencias;
	}
	public TipoCarrea getTipoCarrera() {
		return tipoCarrera;
	}
	public void setTipoCarrera(TipoCarrea tipoCarrera) {
		this.tipoCarrera = tipoCarrera;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
