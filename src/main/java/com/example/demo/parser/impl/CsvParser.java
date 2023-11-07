package com.example.demo.parser.impl;

import com.example.demo.configuration.SparkSessionCustom;
import com.example.demo.parser.ICsvParser;
import com.example.demo.util.Stopwatch;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.nio.file.Path;
import java.nio.file.Paths;


@AllArgsConstructor
@Slf4j
@Component
public class CsvParser implements ICsvParser {
    private final SparkSession sparkSession;
    @Override
    public Dataset<Row> parse(String filePath) {
        try {

            log.info("Start parse " + filePath);
            Stopwatch stopwatch = Stopwatch.start();
            //.option("delimiter", "!")
            DataFrameReader reader = sparkSession.read()
                    .option("header", "true")
                    .option("inferSchema", "true")
                    .format("csv");

            // Maybe slow because of lazy initialization
            Dataset<Row> result = reader
                    .csv(filePath);

            log.info(
                    "Finish parse file in " + stopwatch.lap() + "ms");

            return result;
        } catch (Exception e) {
            log.error("Failed parse file", e);

            // TODO: handle detail exception
            Path filename = Paths.get(filePath).getFileName();
            String filenameStr = filename == null ? filePath : filename.toString();
            throw new NullPointerException(filenameStr + " is not exist!");
        }
    }

}
