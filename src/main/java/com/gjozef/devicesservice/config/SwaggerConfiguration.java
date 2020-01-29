package com.gjozef.devicesservice.config;

import com.gjozef.devicesservice.config.security.DeviceAuthenticationFilter;
import com.gjozef.devicesservice.domain.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.AllowableListValues;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.YearMonth;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .directModelSubstitute(YearMonth.class, String.class)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .globalOperationParameters(Collections.singletonList(createAuthorizationParameter()));
    }

    private Parameter createAuthorizationParameter() {
        return new ParameterBuilder()
            .name(DeviceAuthenticationFilter.AUTHORIZATION_HEADER)
            .description("Only for dev purpose authorization header specifying role of logged in user")
            .modelRef(new ModelRef("string"))
            .allowableValues(getAuthorizationHeaderAllowableValues())
            .parameterType("header")
            .required(false)
            .allowEmptyValue(false)
            .build();
    }

    private AllowableListValues getAuthorizationHeaderAllowableValues() {
        //List<String> allowableUsersToLogIn = Arrays.asList("ADMIN", "USER");
        List<String> allowableUsersToLogIn = Arrays.stream(UserRole.values())
            .map(UserRole::toString)
            .map(userRoleValue -> userRoleValue.replace("ROLE_", ""))
            .map(String::toLowerCase)
            .collect(Collectors.toList());

        return new AllowableListValues(allowableUsersToLogIn, "string");
    }
}
