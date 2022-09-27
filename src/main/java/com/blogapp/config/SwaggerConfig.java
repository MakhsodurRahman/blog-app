package com.blogapp.config;

import io.swagger.annotations.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collection;
import java.util.Collections;

//swagger part : 3
@Configuration
public class SwaggerConfig {


    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo()).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    };

    private ApiInfo getInfo(){

        return new ApiInfo("Blogging Application",
                "this is blooging app developed by Makhsodur Rahman","1.0",
                "terms of Service Url",
                new Contact("Makhsodur Rahman","http://localhsot:8080","makhsodurrahmanhridoy@gmail.com"),
                "Licence of Apis","api licence url", Collections.emptyList());

    };
}
