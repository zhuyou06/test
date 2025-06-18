package com.cubc.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        final String headerAuthorizationsBearer = "Header Authorizations Bearer";
        return new OpenAPI()
                .info(new Info()
                        .title("國泰 中台 API ")
                        .version("0.1")
                        .description("Sample app Spring Boot 3 with Swagger")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));

    }
}
