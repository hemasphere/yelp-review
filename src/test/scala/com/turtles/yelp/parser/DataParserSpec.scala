package com.turtles.yelp.parser
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.*


class DataParserSpec extends AnyFreeSpec with Matchers {
  "DataParser happy case" in {
    DataParser.aggregateZipCodes("/yelp_academic_dataset_business_small.json") should be (List("93101"))
  }
  "DataParser sad case" in {
    DataParser.aggregateZipCodes("/yelp_academic_dataset_business_small_error.json") should be(Nil)
  }
}
