package com.reactorsql.app.model.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.reactorsql.app.model.entity.Usuario;

/**
 * Repositorio para usuario
 * 
 * @author jefersson.galvez
 *
 */
@Repository
public interface IusuarioRepository extends ReactiveCrudRepository<Usuario, Integer> {

}
