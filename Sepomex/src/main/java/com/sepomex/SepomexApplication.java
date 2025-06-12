package com.sepomex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot para SEPOMEX.
 * 
 * <p>Esta clase contiene el método {@code main} que arranca la aplicación
 * utilizando {@link SpringApplication}. Se encuentra anotada con 
 * {@link org.springframework.boot.autoconfigure.SpringBootApplication},
 * lo que habilita la configuración automática, el escaneo de componentes
 * y otras características de Spring Boot.</p>
 *
 * <p>Para iniciar la aplicación, se debe ejecutar el método {@code main}.</p>
 *
 * @author Rigoberto Mercado
 * @version 1.0
 */
@SpringBootApplication
public class SepomexApplication {

	/**
     * Punto de entrada principal para iniciar la aplicación SEPOMEX.
     *
     * @param args argumentos de línea de comandos (opcional)
     */
	public static void main(String[] args) {
		SpringApplication.run(SepomexApplication.class, args);
	}

}
