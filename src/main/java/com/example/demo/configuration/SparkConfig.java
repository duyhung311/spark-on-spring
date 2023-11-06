package com.example.demo.configuration;

import lombok.Getter;
import lombok.Setter;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
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


    @Bean
    public SparkConf sparkConf() {
        return new SparkConf()
                .setAppName(appName)
                .setMaster(masterUri);
    }

    @Bean
    public JavaSparkContext javaSparkContext() {
        return new JavaSparkContext(sparkConf());
    }

    @Bean
    public SparkSession sparkSession() {
        return SparkSession.builder()
                .config(sparkConf())
                .getOrCreate();
    }

    public static Object get(Row row, int i) {
        return getOrDefault(row, i, "");
    }

    public static Object getOrDefault(
            Row row
            , int i
            , Object defaultValue
    ) {
        if (row.isNullAt(i)) {
            return defaultValue;
        }

        return row.get(i);
    }
}