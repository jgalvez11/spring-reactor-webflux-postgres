package com.reactorsql.app.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactorsql.app.handler.UsuarioHandler;

/**
 * RouterFunction para mapeo de peticiones REST
 * 
 * @author jefersson.galvez
 *
 */
@Configuration
public class UsuarioRoute {

	/**
	 * Implementación de las rutas para el handler Usuario
	 * 
	 * @param handler Controlador de usuario
	 * @return RouterFunction<ServerResponse>
	 */
	@Bean
	public RouterFunction<ServerResponse> rutasUsuario(UsuarioHandler handler) {
		return RouterFunctions.route(GET("/api/v2"), handler::listar).andRoute(GET("/api/v2/{id}"), handler::buscar)
				.andRoute(POST("/api/v2"), handler::crear).andRoute(PATCH("/api/v2/{id}"), handler::actualizar)
				.andRoute(DELETE("/api/v2/{id}"), handler::eliminar);
	}
}
