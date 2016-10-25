/***************************************************************************
 * Copyright (C) Accenture
 * 
 * The reproduction, transmission or use of this document or its contents is not permitted without
 * prior express written consent of Accenture. Offenders will be liable for damages. All rights,
 * including but not limited to rights created by patent grant or registration of a utility model or
 * design, are reserved.
 * 
 * Accenture reserves the right to modify technical specifications and features.
 * 
 * Technical specifications and features are binding only insofar as they are specifically and
 * expressly agreed upon in a written contract.
 * 
 **************************************************************************/
package com.acn.avs.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * The Class ConfigServerApplication.
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
@EnableAutoConfiguration
public class ConfigServerApplication extends SpringBootServletInitializer {

	/**
 * The main method.
 *
 * @param args the arguments
 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

	/**
 * Dispatcher registration.
 *
 * @param dispatcherServlet the dispatcher servlet
 * @return the servlet registration bean
 */
	@Bean
	public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
		registration.addUrlMappings("/*");
		return registration;
	}
}
