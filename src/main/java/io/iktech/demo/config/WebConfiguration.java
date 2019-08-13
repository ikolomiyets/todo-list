package io.iktech.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"io.iktech.demo.controllers"})
public class WebConfiguration {
}
