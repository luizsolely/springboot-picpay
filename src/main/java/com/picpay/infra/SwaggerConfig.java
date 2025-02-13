package com.picpay.infra;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Spring Boot PicPay API")
                        .version("1.0")
                        .description("API para simulação de pagamentos via PicPay"))
                .servers(List.of(
                        new Server().url("https://springboot-picpay-production.up.railway.app").description("Servidor de Produção"),
                        new Server().url("http://localhost:8080").description("Servidor Local")
                ));
    }
}
