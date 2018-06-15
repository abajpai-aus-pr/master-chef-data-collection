package com.masterchef.data.collection.utils

import java.util.Properties

import com.masterchef.data.collection.models.MessageType
import com.masterchef.data.collection.models.MessageType.MessageType
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object KafkaUtils {
  private lazy val trafficTopic = ConfigProvider.getTrafficKafkaTopic
  private lazy val bookingTopic = ConfigProvider.getBookingKafkaTopic
  private lazy val brokers = ConfigProvider.getKafkaBrokers

  private def getProperties: Properties = {
    val props = new Properties()
    props.put("bootstrap.servers", brokers)
    props.put("client.id", "master-chef-data-generator")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props
  }

  def pushToKafka(messages: List[String], msgType:MessageType): Unit = {
    val producer = new KafkaProducer[String, String](getProperties)

    val targetTopic = msgType match {
      case MessageType.TRAFFIC => trafficTopic
      case MessageType.BOOKING => bookingTopic
    }

    val records = messages.map { msg =>
      new ProducerRecord[String, String](targetTopic, msg)
    }

    records.foreach(data => producer.send(data))
    producer.close()
  }
}
