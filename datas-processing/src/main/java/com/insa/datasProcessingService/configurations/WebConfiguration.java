package com.insa.datasProcessingService.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/* Permit to discover images from Static
 * http://localhost:8082/images/name_image.jpg
 */
/**
 * WebConfiguration Class
 * permits to make discoverable graphs in the folder static
 * @author Nicolas
 *
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/**")
                 .addResourceLocations("classpath:/static/");
    }
}