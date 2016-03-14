package com.app.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableAsync
@ComponentScan(basePackages = { "com.athena", "com.spartan", "com.app" })
public class WebConfigExtended extends WebConfig {
}
