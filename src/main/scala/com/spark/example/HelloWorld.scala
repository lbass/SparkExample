package com.spark.example

import org.apache.spark.{SparkConf, SparkContext}


object HelloWorld {

  def main(args: Array[String]): Unit = {
    val fileName = "README.md"
    val filePath: String  = getClass.getClassLoader.getResource(fileName).getPath

    val conf = new SparkConf().setAppName("Simple Application").setMaster("local").set("spark.driver.host", "localhost")
    val sparkContext = new SparkContext(conf)

    val logData = sparkContext.textFile(filePath, 2).cache()

    val lineCount = logData.count()

    println(lineCount)

    sparkContext.stop()
  }

}
