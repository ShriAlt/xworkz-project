package com.xworkz.techRoute.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;

@Configuration
@ComponentScan(basePackages = "com.xworkz.techRoute")
@EnableWebMvc
public class WebAppConfiguration implements WebMvcConfigurer {

    public WebAppConfiguration(){
        System.out.println("no args of WebAppConfiguration");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver()
    {
        return new InternalResourceViewResolver("/",".jsp");
    }
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() throws IOException {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        Resource[] resources = new Resource[] {
                new ClassPathResource("application.properties"),
                new ClassPathResource("application-secret.properties")
        };
        configurer.setLocations(resources);
        return configurer;
    }

}
