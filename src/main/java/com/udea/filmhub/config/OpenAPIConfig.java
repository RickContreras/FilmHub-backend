package com.udea.filmhub.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI defineOpenApi() {

        Contact myContact = new Contact();
        myContact.setName("Rick Contreras");

        Info information = new Info()
                .title("FilmHub API")
                .version("1.0")
                .description("This API exposes endpoints to manage audiovisual content.")
                .contact(myContact);
        return new OpenAPI().info(information);
    }
}
