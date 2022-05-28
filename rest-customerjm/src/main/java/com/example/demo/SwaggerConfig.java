package com.example.demo;


import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig
{                                    
    @Bean
    public Docket api() { 

        return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo())
				;
    }

    private ApiInfo getApiInfo() 
    {
        return new ApiInfo(
          "Clientes REST API", 
          "Servicios de GET,POST, UPDATE", 
          "1.0", 
          "Terminos de servicio", 
          new Contact("Noe", "https://demo.com", "noe.alca24@gmail.com"), 
          "License of API", "API license URL", 
          Collections.emptyList());
   }
}