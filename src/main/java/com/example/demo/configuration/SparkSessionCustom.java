package com.example.demo.configuration;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.Level;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class SparkSessionCustom {
    private final JavaSparkContext sparkContext;
    private final SparkConfig sparkConf;

    @Bean
    public SparkSession sparkSession() {
        return SparkSession
            .builder()
            .sparkContext(sparkContext.sc())
            .config(sparkConf.sparkConf())
            .getOrCreate();
    }
}
