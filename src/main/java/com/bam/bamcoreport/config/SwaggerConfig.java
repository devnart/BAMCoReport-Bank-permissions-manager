package com.bam.bamcoreport.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bam.bamcoreport"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        return new ApiInfoBuilder().title("Co Report API").description("Co Report API Reference for Developers")
                .version("1.0.0")
                .contact(new Contact("Bam", null, null))
                .build();


    }
}
