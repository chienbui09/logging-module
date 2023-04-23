package com.example.loggingmodule;

import com.example.loggingmodule.entity.Account;
import com.example.loggingmodule.forms.AccountCreateForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LoggingModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoggingModuleApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(AccountCreateForm.class, Account.class)
                .addMappings(mapper ->mapper.skip(Account::setId));
        return modelMapper;
    }

    @Bean
    public ObjectWriter objectWriter(){
        return new ObjectMapper()
                .findAndRegisterModules()
                .writerWithDefaultPrettyPrinter();
    }

    /*
    dùng để object ra ngoài màn hình
    tìm tk nào có object writer
    format lai và ghi ra
    * */

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .allowedOrigins("localhost:5500")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
