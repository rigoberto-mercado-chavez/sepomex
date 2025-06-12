package com.sepomex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.VersionResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Configuración principal de Spring MVC para la aplicación SEPOMEX.
 * 
 * <p>Esta clase configura el manejo de vistas, la resolución de recursos estáticos 
 * y escanea los componentes del paquete base {@code com.sepomex}.</p>
 * 
 * <p>Se habilita explícitamente el soporte para Spring MVC con {@link EnableWebMvc},
 * y se implementa la interfaz {@link WebMvcConfigurer} para proporcionar configuraciones
 * personalizadas como el manejo de recursos y la resolución de vistas JSP.</p>
 * 
 * <p>Los recursos estáticos se sirven desde {@code /WEB-INF/resources/} con 
 * control de versiones mediante {@link VersionResourceResolver}.</p>
 * 
 * @author Rigoberto Mercado
 * @version 1.0
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sepomex")
public class SepomexConfig implements WebMvcConfigurer {

	/**
     * Define el {@link ViewResolver} que se encarga de resolver las vistas JSP
     * ubicadas en el directorio {@code /WEB-INF/views/} con la extensión {@code .jsp}.
     *
     * @return un {@link InternalResourceViewResolver} configurado
     */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	/**
     * Configura los manejadores de recursos estáticos, incluyendo una estrategia
     * de versión basada en el contenido para optimizar el cacheo de recursos.
     *
     * @param registry el registro de manejadores de recursos proporcionado por Spring
     */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/WEB-INF/resources/")
				.resourceChain(true)
				.addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
	}
	
}
