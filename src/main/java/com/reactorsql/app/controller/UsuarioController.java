package com.reactorsql.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactorsql.app.model.entity.Usuario;
import com.reactorsql.app.model.service.IUsuarioService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controller de Usuario
 * 
 * @author jefersson.galvez
 *
 */
@RestController
@RequestMapping("api/v1")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;

	@GetMapping
	public Flux<Usuario> listar() {
		return service.listar();
	}

	@GetMapping("/{id}")
	public Mono<Usuario> buscar(@PathVariable int id) {
		return service.buscar(id);
	}

	@PostMapping
	public Mono<Usuario> crear(@RequestBody Usuario usuario) {
		return service.crear(usuario);
	}

	@PatchMapping("/{id}")
	public Mono<Usuario> actualizar(@RequestBody Usuario usuario, @PathVariable int id) {
		return service.actualizar(usuario, id);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> eliminar(@PathVariable int id) {
		return service.eliminar(id);
	}

}
