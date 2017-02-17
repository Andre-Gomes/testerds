package br.com.testerd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe utilizada para executar a aplicação Web através do
 *         Springboot, usando o container Tomcat embutido
 */
@SpringBootApplication
public class SpringBootWebApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}
}