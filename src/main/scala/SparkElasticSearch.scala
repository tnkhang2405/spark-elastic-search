import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.elasticsearch.spark.rdd.EsSpark

object SparkElasticSearch {
  def main(args: Array[String]): Unit = {

    val appName = this.getClass.getSimpleName
    val master = "local[4]"

    val conf = new SparkConf().setAppName(appName).setMaster(master)
    // elastic search config
    conf.set("es.index.auto.create", "true")

    val spark = SparkSession.builder()
      .appName(appName)
      .config(conf)
      .master(master)
      .getOrCreate()

    import spark.implicits._
    val df = Seq(1, 2, 3, 4).toDF()

    df.show()


    val numbers = Map("one" -> 1, "two" -> 2, "three" -> 3)
    val airports = Map("arrival" -> "Otopeni", "SFO" -> "San Fran")

//    val rdd = spark.sparkContext.makeRDD(
//      Seq(numbers, airports)
//    )
//    EsSpark.saveToEs(rdd, "spark/docs")
  }
}
