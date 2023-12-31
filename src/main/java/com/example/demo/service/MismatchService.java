package com.example.demo.service;


import com.example.demo.configuration.SPARK_CONST;
import com.example.demo.configuration.SparkConfWrapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MismatchService {
    private final JavaSparkContext javaSparkContext;

    public void foo() {
        System.out.println(javaSparkContext.appName());
    }

}
