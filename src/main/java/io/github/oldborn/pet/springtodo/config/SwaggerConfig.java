package io.github.oldborn.pet.springtodo.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Narcissistic Cannibal (feat. Skrillex & Kill the Noise) - Korn	@Link https://open.spotify.com/track/65XY6Cx0263J5BPnY8mPyE
 * Modified while listening @SpotRepeat {Narcissistic Cannibal (feat. Skrillex & Kill the Noise) - Korn	@Link https://open.spotify.com/track/65XY6Cx0263J5BPnY8mPyE}
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/user/*")))
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(Collections.singletonList(
                        SecurityContext.builder()
                                .securityReferences(Collections.singletonList(
                                        new SecurityReference("Bearer", new AuthorizationScope[0])
                                        )
                                )
                                .forPaths(Predicates.not(PathSelectors.regex("/user/*")))
                                .build()
                ));
    }

    private static ArrayList<? extends SecurityScheme> securitySchemes() {

        return new ArrayList<>(Collections.singletonList(new ApiKey("Bearer", "Authorization", "header")));
    }
}
