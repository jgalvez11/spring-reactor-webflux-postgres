package com.reactorsql.app.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactorsql.app.model.entity.Usuario;
import com.reactorsql.app.model.repository.IusuarioRepository;
import com.reactorsql.app.model.service.IUsuarioService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Implementación del servicio
 * 
 * @author jefersson.galvez
 *
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IusuarioRepository repo;

	@Override
	public Flux<Usuario> listar() {
		return repo.findAll();
	}

	@Override
	public Mono<Usuario> buscar(int id) {
		return repo.findById(id);
	}

	@Override
	public Mono<Usuario> crear(Usuario usuario) {
		return repo.save(usuario);
	}

	@Override
	public Mono<Usuario> actualizar(Usuario usuario, int id) {
		return repo.findById(id).flatMap(user -> {
			user.setNombres(usuario.getNombres());
			user.setApellidos(usuario.getApellidos());
			user.setCelular(usuario.getCelular());
			user.setDireccion(usuario.getDireccion());
			return repo.save(user);
		});
	}

	@Override
	public Mono<Void> eliminar(int id) {
		return repo.findById(id).flatMap(repo::delete);
	}

}
