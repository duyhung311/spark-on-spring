package com.example.demo.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class SparkConfig {

    @Value("${spark.app.name}")
    private String appName;
    @Value("${spark.master}")
    private String masterUri;

    @Value("${hadoop.home.dir}")
    private String hadoopHomeDir;

    @Value("${spark.home}")
    private String sparkHome;

    @Bean
    public SparkConf sparkConf() {
        return new SparkConf()
                .setSparkHome(sparkHome)
                .setAppName(appName)
                .setMaster(masterUri);
    }

    @Bean
    public JavaSparkContext javaSparkContext() {
        return new JavaSparkContext(sparkConf());
    }

}