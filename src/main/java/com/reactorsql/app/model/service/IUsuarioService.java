package com.reactorsql.app.model.service;

import com.reactorsql.app.model.entity.Usuario;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interface para servicio
 * 
 * @author jefersson.galvez
 *
 */
public interface IUsuarioService {

	public Flux<Usuario> listar();

	public Mono<Usuario> buscar(int id);

	public Mono<Usuario> crear(Usuario usuario);

	public Mono<Usuario> actualizar(Usuario usuario, int id);

	public Mono<Void> eliminar(int id);
}
