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

  "DataParser first 5 zip codes" in {
    // List the expected first 5 zip codes
    val expectedZipCodes = List("93101", "19124", "19047", "85742", "19406")
    println("Expected: " + expectedZipCodes)

    // Aggregate zip codes from the JSON file
    val resultZipCodes = DataParser.aggregateZipCodes("/yelp_academic_dataset_business.json")
    println("Results: " + resultZipCodes.take(5))

    // Check if the first 5 zip codes match the expected values
    resultZipCodes.take(5) should equal(expectedZipCodes)
  }
}
