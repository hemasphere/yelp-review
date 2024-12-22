package com.turtles.yelp.parser

import io.circe.*
import io.circe.parser.*
import io.circe.generic.auto.*
import scala.io.Source

case class Data(business_id: String, postal_code: String)

object DataParser {
  def aggregateZipCodes(fileName: String): List[String] =
    val jsonStringList: List[String] = 
      Source.fromInputStream(getClass.getResourceAsStream(fileName)).getLines().toList
    jsonStringList.map(extractZipCode).map(_.postal_code)  
    
  private def extractZipCode(jsonString: String): Data =
    decode[Data](jsonString).toOption.get
}


