package com.sepomex;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Clase de inicialización del servlet para despliegues en contenedores de aplicaciones tradicionales.
 *
 * <p>Extiende {@link SpringBootServletInitializer} y sobrescribe el método 
 * {@code configure} para registrar la clase principal {@link SepomexApplication}
 * como fuente de configuración. Esto permite ejecutar la aplicación SEPOMEX
 * como un archivo WAR desplegado en un servidor externo (por ejemplo, Apache Tomcat).</p>
 *
 * <p>Esta clase solo es necesaria si se empaqueta la aplicación como WAR
 * y no como JAR ejecutable.</p>
 *
 * @autor Rigoberto Mercado
 * @version 1.0
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
     * Configura la aplicación para su despliegue en un contenedor de servlets.
     *
     * @param application instancia de {@link SpringApplicationBuilder}
     * @return el builder con la clase principal registrada
     */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SepomexApplication.class);
	}

}