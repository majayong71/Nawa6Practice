package com.example.nawa6practice.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("Swagger 연습용 ")
                .version("v0.0.1")
                .description("Swagger 연습용");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }

}
