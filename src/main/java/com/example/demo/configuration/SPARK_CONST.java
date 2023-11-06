package com.example.demo.configuration;

public class SPARK_CONST {

    public static final String LOCAL_MASTER = "local[*]";

    // Driver
    public static final String DRIVER_CORES_CONF = "spark.driver.cores";
    public static final String DRIVER_MEMORY_CONF = "spark.driver.memory";
    @SuppressWarnings("SpellCheckingInspection")
    public static final String DRIVER_MAXRESULTSIZE_CONF = "spark.driver.maxResultSize";

    // Executor
    public static final String EXECUTOR_CORES_CONF = "spark.executor.cores";
    public static final String EXECUTOR_MEMORY_CONF = "spark.executor.memory";
    public static final String EXECUTOR_INSTANCES_CONF = "spark.executor.instances";
    public static final String EXECUTOR_MEMORY_OVERHEAD_CONF = "spark.executor.memoryOverhead";

    public static final String PARALLELISM = "spark.default.parallelism";

    public static final String SQL_SHUFFLE_PARTITIONS = "spark.sql.shuffle.partitions";
}
