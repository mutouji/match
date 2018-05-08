package com.buzhou.exchange.match.configuration;

import com.google.common.base.Predicate;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
//    @ApiOperation(value = "获取指定id用户详细信息",
//            notes = "根据user的id来获取用户详细信息",
//            httpMethod = "GET")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "userName", value = "用户名",
//                    paramType = "query", required = true, dataType = "String"),
//            @ApiImplicitParam(name = "password", value = "用户密码",
//                    paramType = "query", required = true, dataType = "String")
//    })

//    @Api:注解controller，value为@RequestMapping路径
//
//    @ApiOperation:注解方法，value为简要描述,notes为全面描述,hidden=true Swagger将不显示该方法，默认为false
//
//    @ApiParam:注解参数,hidden=true Swagger参数列表将不显示该参数,name对应参数名，value为注释，defaultValue设置默认值,allowableValues设置范围值,required设置参数是否必须，默认为false
//
//    @ApiModel:注解Model
//
//    @ApiModelProperty:注解Model下的属性，当前端传过来的是一个对象时swagger中该对象的属性注解就是ApiModelProperty中的value
//
//    @ApiIgnore:注解类、参数、方法，注解后将不在Swagger UI中显示

    @Bean
    public Docket createRestApi() {
        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                if (input.isAnnotatedWith(ApiOperation.class)) {
                    return true;
                }
                return false;
            }
        };
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()) // document info
                .select()
                .apis(predicate)
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("buzhou match")
                .description("buzhou exchange match system")
                .license("Apache License Version 2.0")
                .version("1.0")
                .build();
    }
}
