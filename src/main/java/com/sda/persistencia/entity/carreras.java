package com.sda.persistencia.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity 
public class carreras {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	private String nombre; 
	private String competencia; 
	private int tipo_carrera; 
	
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

	public String getCompetencia() {
		return competencia;
	}

	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}

	public int getTipo_carrera() {
		return tipo_carrera;
	}

	public void setTipo_carrera(int tipo_carrera) {
		this.tipo_carrera = tipo_carrera;
	}
}
