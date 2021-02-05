package com.reactorsql.app.handler;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactorsql.app.model.entity.Usuario;
import com.reactorsql.app.model.service.IUsuarioService;

import reactor.core.publisher.Mono;

/**
 * Componente Handler para usuario
 * 
 * @author jefersson.galvez
 *
 */
@Component
public class UsuarioHandler {

	@Autowired
	private IUsuarioService service;

	/**
	 * Obtener todos los usuarios
	 * 
	 * @param request Entrada de la petición
	 * @return Mono<ServerResponse>
	 */
	public Mono<ServerResponse> listar(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(service.listar(), Usuario.class);
	}

	/**
	 * Buscar un usuario especifico
	 * 
	 * @param request Entrada de la petición
	 * @return Mono<ServerResponse>
	 */
	public Mono<ServerResponse> buscar(ServerRequest request) {
		int id = Integer.parseInt(request.pathVariable("id"));

		return service.buscar(id).flatMap(
				u -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(u)))
				.switchIfEmpty(ServerResponse.notFound().build());
	}

	/**
	 * Crear usuario
	 * 
	 * @param request Entrada de la petición
	 * @return Mono<ServerResponse>
	 */
	public Mono<ServerResponse> crear(ServerRequest request) {

		Mono<Usuario> usuario = request.bodyToMono(Usuario.class);

		return usuario.flatMap(service::crear).flatMap(u -> ServerResponse.created(URI.create("/api/v2"))
				.contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(u)));

	}

	/**
	 * Actualizar usuario
	 * 
	 * @param request Entrada de la petición
	 * @return Mono<ServerResponse>
	 */
	public Mono<ServerResponse> actualizar(ServerRequest request) {
		Mono<Usuario> usuario = request.bodyToMono(Usuario.class);
		int id = Integer.parseInt(request.pathVariable("id"));

		Mono<Usuario> usuarioDB = service.buscar(id);

		return usuarioDB.zipWith(usuario, (db, req) -> {
			db.setNombres(req.getNombres());
			db.setApellidos(req.getApellidos());
			db.setCelular(req.getCelular());
			db.setDireccion(req.getDireccion());
			return db;
		}).flatMap(u -> ServerResponse.created(URI.create("/api/v2")).contentType(MediaType.APPLICATION_JSON)
				.body(service.actualizar(u, id), Usuario.class)).switchIfEmpty(ServerResponse.notFound().build());
	}

	/**
	 * Eliminar usuario
	 * 
	 * @param request Entrada de la petición
	 * @return Mono<ServerResponse>
	 */
	public Mono<ServerResponse> eliminar(ServerRequest request) {
		int id = Integer.parseInt(request.pathVariable("id"));

		return service.buscar(id).flatMap(u -> service.eliminar(u.getId()).then(ServerResponse.noContent().build()))
				.switchIfEmpty(ServerResponse.notFound().build());
	}

}
