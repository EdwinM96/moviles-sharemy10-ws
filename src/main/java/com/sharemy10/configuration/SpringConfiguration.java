package com.sharemy10.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.sharemy10","com.sharemy10.controller"})
public class SpringConfiguration implements WebMvcConfigurer {

	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		return viewResolver;
	}
        
        @Bean(name = "multipartResolver")
        public CommonsMultipartResolver filterMultipartResolver() {
            CommonsMultipartResolver resolver = new CommonsMultipartResolver();
            resolver.setDefaultEncoding("utf-8");
            resolver.setMaxUploadSize(1000000);
            return resolver;
        }
        
}
