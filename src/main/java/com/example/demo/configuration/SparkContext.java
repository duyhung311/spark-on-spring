package com.example.demo.configuration;


import lombok.RequiredArgsConstructor;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SparkContext {

    private final SparkConfig sparkConf;

    @Bean
    public JavaSparkContext javaSparkContext() {
        return new JavaSparkContext(sparkConf.sparkConf());
    }
}
