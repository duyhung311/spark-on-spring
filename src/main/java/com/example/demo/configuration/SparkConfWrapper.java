package com.example.demo.configuration;

import org.apache.spark.SparkConf;

public class SparkConfWrapper {

    private final SparkConf sparkConf;

    public SparkConfWrapper() {
        sparkConf = new SparkConf();
    }

    public SparkConfWrapper setAppName(final String appName) {
        sparkConf.setAppName(appName);
        return this;
    }

    public SparkConfWrapper setMaster(final String master) {
        sparkConf.setMaster(master);
        return this;
    }

    public SparkConfWrapper setDriverCores(final int cores) {
        sparkConf.set(SPARK_CONST.DRIVER_CORES_CONF, String.valueOf(cores));
        return this;
    }

    /**
     * @param memory num + size litter (Eg: 8GB -> 8g)
     * @return
     */
    public SparkConfWrapper setDriverMemory(final String memory) {
        sparkConf.set(SPARK_CONST.DRIVER_MEMORY_CONF, memory);
        return this;
    }

    /**
     * @param maxResultSize num + size litter (Eg: 8GB -> 8g)
     * @return
     */
    public SparkConfWrapper setDriverMaxResultSize(final String maxResultSize) {
        sparkConf.set(SPARK_CONST.DRIVER_MAXRESULTSIZE_CONF, maxResultSize);
        return this;
    }

    public SparkConfWrapper setExecutorCores(final int cores) {
        sparkConf.set(SPARK_CONST.EXECUTOR_CORES_CONF, String.valueOf(cores));
        return this;
    }

    /**
     * @param memory num + size litter (Eg: 8GB -> 8g)
     * @return
     */
    public SparkConfWrapper setExecutorMemory(final String memory) {
        sparkConf.set(SPARK_CONST.EXECUTOR_MEMORY_CONF, memory);
        return this;
    }

    public SparkConfWrapper setExecutorInstances(final int instances) {
        sparkConf.set(SPARK_CONST.EXECUTOR_INSTANCES_CONF, String.valueOf(instances));
        return this;
    }

    public SparkConfWrapper setExecutorMemoryOverhead(final String memory) {
        sparkConf.set(SPARK_CONST.EXECUTOR_MEMORY_OVERHEAD_CONF, memory);
        return this;
    }

    public SparkConfWrapper setParallelism(final int parallelism) {
        sparkConf.set(SPARK_CONST.PARALLELISM, String.valueOf(parallelism));
        return this;
    }

    public SparkConfWrapper setSqlShufflePartitions(final int partitions) {
        sparkConf.set(SPARK_CONST.SQL_SHUFFLE_PARTITIONS, String.valueOf(partitions));
        return this;
    }

    public SparkConf getInner() {
        return sparkConf;
    }

//      conf.set("spark.driver.extraJavaOptions", "-Dlogback.configurationFile=logback.xml")
//          .set("spark.executor.extraJavaOptions", "-Dlogback.configurationFile=logback.xml");
}
