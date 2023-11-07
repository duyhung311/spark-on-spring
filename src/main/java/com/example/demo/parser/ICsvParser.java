package com.example.demo.parser;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public interface ICsvParser {
    Dataset<Row> parse(String filePath);

}