package com.reactorsql.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import io.r2dbc.spi.ConnectionFactory;

/**
 * Clase que inicializa la aplicación
 * 
 * @author jefersson.galvez
 *
 */
@SpringBootApplication
public class ReactorSqlApplication {

	/**
	 * Método main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ReactorSqlApplication.class, args);
	}

	/**
	 * Busca en la carpeta de recursos el archivo de schema.sql para ejecutar en DB
	 * el script
	 * 
	 * @param connectionFactory
	 * @return ConnectionFactoryInitializer
	 */
	@Bean
	ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);
		initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));

		return initializer;
	}

}
