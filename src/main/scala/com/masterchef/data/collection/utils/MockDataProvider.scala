package com.masterchef.data.collection.utils

import java.util.Random

import com.masterchef.data.collection.models._

object MockDataProvider {
  private val objRandom = new Random()

  private lazy val trafficResponse: List[TrafficMessage] = {
    val trafficUrl = ConfigProvider.getTrafficEndpoint
    val response = FormatterUtils.getCastedHttpResponse[TrafficMessage](trafficUrl)
    response
  }

  def getTrafficData:List[String] = {
    val trafficJsonData = FormatterUtils.getData[TrafficMessage](trafficResponse)
    trafficJsonData
  }

  def getBookingData:List[String] = {
    val bookingUrl = ConfigProvider.getBookingEndpoint
    val response = FormatterUtils.getCastedHttpResponse[BookingMessage](bookingUrl)
    val bookingData = FormatterUtils.getData(response)

    bookingData
  }

  def getTrafficGUID:String = {
    val trafficResponse = MockDataProvider.trafficResponse
    val lstTrafficUID = trafficResponse.map(element => element.uid)
    val size = lstTrafficUID.length
    val guid = lstTrafficUID(objRandom.nextInt(size))
    guid
  }
}
