package com.jv5.jv5backend;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Jv5BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jv5BackendApplication.class, args);
	}
	
	//http://localhost:8080/swagger-ui.html#/
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.jv5.jv5backend"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		Contact DEFAULT_CONTACT = new Contact("", "", "");
		
		return new ApiInfo(
				"JV5 Back End Apis",
				"Apis for the jv5 site back end",
				"0.0.1",
				"", DEFAULT_CONTACT, "","", new ArrayList()
				);
	}

}
