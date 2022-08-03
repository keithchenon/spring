package com.in28minutes.example.layering;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.in28minutes.example.layering.business.impl",
        "com.in28minutes.example.layering.data.stub"})
public class SpringTestContext {
}
