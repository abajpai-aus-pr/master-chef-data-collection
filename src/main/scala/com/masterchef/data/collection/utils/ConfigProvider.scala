package com.masterchef.data.collection.utils

import com.typesafe.config.ConfigFactory
import collection.JavaConverters._

object ConfigProvider {
  private lazy val configObj = ConfigFactory.load("application.conf")
  private lazy val apiConfig = configObj.getConfig("api.endpoint")
  private lazy val kafkaConfig = configObj.getConfig("kafka.producer")

  def getTrafficEndpoint:String = {
    apiConfig.getString("traffic")
  }

  def getBookingEndpoint:String = {
    apiConfig.getString("booking")
  }

  def getKafkaBrokers:String = {
    kafkaConfig.getString("brokers")
  }

  def getTrafficKafkaTopic:String = {
    kafkaConfig.getString("topic.traffic")
  }

  def getBookingKafkaTopic:String = {
    kafkaConfig.getString("topic.booking")
  }
}
