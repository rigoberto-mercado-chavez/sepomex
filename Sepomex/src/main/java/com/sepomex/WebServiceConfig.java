package com.sepomex;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * Configuración del servicio web SOAP para la aplicación Sepomex.
 *
 * Esta clase habilita y configura el soporte para servicios web usando Spring Web Services.
 * Registra el servlet necesario para manejar solicitudes SOAP, define el WSDL expuesto
 * y carga el esquema XSD que define la estructura del servicio.
 */
@SuppressWarnings("removal")
@EnableWs // Habilita el soporte de servicios web SOAP en Spring
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

	/**
     * Registra el {@link MessageDispatcherServlet} que se encargará de procesar las solicitudes SOAP.
     *
     * @param applicationContext el contexto de Spring de la aplicación
     * @return un bean de registro de servlet configurado para interceptar las solicitudes en la ruta "/ws/*"
     */
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}

	/**
     * Define el WSDL del servicio web a partir del esquema XSD.
     *
     * Este bean expone el WSDL en la ruta "/ws/sepomex.wsdl".
     *
     * @param countriesSchema el esquema XSD que describe los tipos de datos del servicio
     * @return una definición de WSDL basada en el esquema proporcionado
     */
	@Bean(name = "sepomex")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("SepomexPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
		wsdl11Definition.setSchema(countriesSchema);
		return wsdl11Definition;
	}

	/**
     * Carga el esquema XSD desde el classpath.
     *
     * El archivo XSD define los tipos de datos usados en el servicio SOAP.
     *
     * @return una instancia de {@link XsdSchema} que representa el esquema cargado
     */
	@Bean
	public XsdSchema countriesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("/soap/sepomex.xsd"));
	}
	
}
