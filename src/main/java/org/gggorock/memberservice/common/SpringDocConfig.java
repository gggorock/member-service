package org.gggorock.memberservice.common;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class SpringDocConfig {

    @Value("${app.version}")
    private String version;
    @Value("${app.description}")
    private String description;
    @Value("${spring.application.name}")
    private String title;

    @Bean
    OpenAPI springDocs(){
        return new OpenAPI().info(new Info()
                .title(title)
                .description(description)
                .version(version));
    }
}
