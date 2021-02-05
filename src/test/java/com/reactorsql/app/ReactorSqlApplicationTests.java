package com.reactorsql.app;

import java.util.Collections;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.reactorsql.app.model.entity.Usuario;

import reactor.core.publisher.Mono;

/**
 * Pruebas unitarias de rutas
 * 
 * @author jefersson.galvez
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReactorSqlApplicationTests {

	@Autowired
	private WebTestClient client;

	@Test
	void listarUsuarios() {
		client.get().uri("/api/v2").accept(MediaType.APPLICATION_JSON).exchange().expectStatus().isOk().expectHeader()
				.contentType(MediaType.APPLICATION_JSON).expectBodyList(Usuario.class);
	}

	@Test
	void buscarUsuario() {
		client.get().uri("/api/v2/{id}", Collections.singletonMap("id", 1)).accept(MediaType.APPLICATION_JSON)
				.exchange().expectStatus().isOk().expectHeader().contentType(MediaType.APPLICATION_JSON)
				.expectBody(Usuario.class).consumeWith(u -> {
					Usuario usuario = u.getResponseBody();
					Assertions.assertThat(usuario.getId() > 0).isTrue();
				});
	}

	@Test
	void crearUsuario() {

		Usuario usuario = new Usuario();
		usuario.setNombres("Hola");
		usuario.setApellidos("Prueba");
		usuario.setCelular("197326478324");
		usuario.setDireccion("cra 34 # 34 - 43");

		client.post().uri("/api/v2").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.body(Mono.just(usuario), Usuario.class).exchange().expectStatus().isCreated().expectHeader()
				.contentType(MediaType.APPLICATION_JSON).expectBody(Usuario.class).consumeWith(u -> {
					Usuario user = u.getResponseBody();
					Assertions.assertThat(user.getNombres().equals(usuario.getNombres()));
					Assertions.assertThat(user.getApellidos().equals(usuario.getApellidos()));
				});
	}

}
