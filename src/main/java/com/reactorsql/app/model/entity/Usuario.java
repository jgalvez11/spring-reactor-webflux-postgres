package com.reactorsql.app.model.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

/**
 * Entidad usuario
 * 
 * @author jefersson.galvez
 *
 */
@Data
public class Usuario {

	@Id
	private int id;
	private String nombres;
	private String apellidos;
	private String celular;
	private String direccion;
}
