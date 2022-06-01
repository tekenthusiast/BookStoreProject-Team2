package com.client.company.hr.config;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi
@Configuration
public class SwaggerConfig {
    @Value("${swagger3.enable}")
    private Boolean enableSwagger;
    @Value("${swagger3.title}")
    private String title;
    @Value("${swagger3.description}")
    private String description;
    @Value("${swagger3.authHeaderKey}")
    private String authHeaderKey;


    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .pathMapping("/")
                // Whether to enable
                .enable(enableSwagger)
                // swagger ui header information
                .apiInfo(apiInfo())
                // Specify the interface to generate a document
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * Swagger ui header information
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .build();
    }
}
