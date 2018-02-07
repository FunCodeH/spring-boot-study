package com.funcodeh.shiro.demo.core.swagger;

import com.funcodeh.shiro.demo.core.utils.SwaggerUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(SwaggerUtils.basePackages(new String[]{("com.funcodeh.mybatis.demo")}))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Mybatis demo system RESTful APIs")
                .description("Mybatis demo system RESTful APIs document")
                .termsOfServiceUrl("http://xxx.com/")
                .version("1.0")
                .build();
    }
}
