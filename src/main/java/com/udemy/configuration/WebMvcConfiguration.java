package com.udemy.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.udemy.component.RequestTimeInterceptor;

/*Para poder utilizar el RequestTimeInterceptor hay que hacer una configuración y en Spring Boot
 * no está la opción para poder meter esta configuración en el application.properties con lo cual
 * la solución es crear esta clase*/

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{

	@Autowired
	@Qualifier("requestTimeInterceptor")
	private RequestTimeInterceptor requestTimeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(requestTimeInterceptor);
		
	}
	
	

}
