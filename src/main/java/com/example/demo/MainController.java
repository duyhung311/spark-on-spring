package com.example.demo;


import com.example.demo.parser.ICsvParser;
import com.example.demo.parser.impl.CsvParser;
import com.example.demo.util.Stopwatch;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
@Slf4j
public class MainController {

    private final CsvParser csvParser;
    private final SparkSession sparkSession;

    @GetMapping("/home")
    public String test() {
        System.out.println(System.getProperty("user.dir"));
        if (!Files.exists(Paths.get("src/main/resources/PL_IRD_03.xlsx")))
            return "not exists";
        parse("src/main/resources/MV1.src.csv");
        return "hung";
    }

    private Dataset<Row> parse(String filePath) {
//        try {
//
//            log.info("Start parse " + filePath);
//            Stopwatch stopwatch = Stopwatch.start();
//
//            //.option("delimiter", "!")
//            DataFrameReader reader = sparkSession.read()
//                    .format("jdbc")
//                    .option("url", jdbcUrl)
//                    .option("user", username)
//                    .option("password", password);
//            reader.
//            result.show();
//            // Maybe slow because of lazy initialization
//
//            log.info(
//                    "Finish parse file in " + stopwatch.lap() + "ms");
//
//            return result;
//        } catch (Exception e) {
//            log.error("Failed parse file", e);
//
//            // TODO: handle detail exception
//            Path filename = Paths.get(filePath).getFileName();
//            String filenameStr = filename == null ? filePath : filename.toString();
//            throw new NullPointerException(filenameStr + " is not exist!");
//        }
        return null;
    }
}
