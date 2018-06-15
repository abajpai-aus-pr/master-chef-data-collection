package com.masterchef.data.collection

import com.masterchef.data.collection.models.MessageType
import com.masterchef.data.collection.utils.{KafkaUtils, MockDataProvider}

object Generator extends App {
  generateTraffic
    //    val trafficData = List("""{"message":{"uid":"3e91ac73-0630-4663-a360-1bc8ec668009","origin":"au","language":"zh","ipv4":"205.24.67.246","device":"mob","browser":"ie","os":"and","guest":false},"logTime":1529038954058}""",
    //      """{"message":{"uid":"b47af07e-8ba3-44a3-adf8-89ce3192d7bd","origin":"uk","language":"fr","ipv4":"53.207.150.151","device":"tab","browser":"ie","os":"and","guest":true},"logTime":1529038954058}""",
    //      """{"message":{"uid":"c96e44f8-750c-402f-a87d-d3d5618911e4","origin":"us","language":"de","ipv4":"248.120.88.187","device":"des","browser":"fi","os":"osx","guest":true},"logTime":1529038954058}""",
    //      """{"message":{"uid":"de4a6ce5-c493-487c-b2cb-09cf5c4ecfca","origin":"in","language":"th","ipv4":"251.159.42.129","device":"tab","browser":"ie","os":"win","guest":true},"logTime":1529038954058}""",
    //      """{"message":{"uid":"1183d415-1485-44f8-804b-52b0a11ef599","origin":"us","language":"de","ipv4":"238.70.49.120","device":"tab","browser":"ie","os":"ios","guest":true},"logTime":1529038954058}""")

  generateBooking
//    val bookingData = List("""{"message":{"id":"3520207672","value":7352.25,"currency":"THB","mode":"cc","city":"lon","hotel":"novotel","room":"basic","guid":"a75526a3-b600-4fb2-a900-8c1aa770ca6c"},"logTime":1529041066858}""",
//    """{"message":{"id":"4784412107","value":9860.5302734375,"currency":"CNY","mode":"cc","city":"bkk","hotel":"novotel","room":"delux","guid":"72e825c9-3296-4607-ab41-0c21c0f9e0e6"},"logTime":1529041066858}""",
//    """{"message":{"id":"7407913692","value":3497.7900390625,"currency":"CNY","mode":"pp","city":"bkk","hotel":"ibis","room":"delux","guid":"bfeb4ed0-a69e-4480-a6ae-01f9c0a70a2d"},"logTime":1529041066858}""",
//    """{"message":{"id":"4589361884","value":3676.889892578125,"currency":"BGN","mode":"pp","city":"mel","hotel":"accord","room":"delux","guid":"58007cda-1804-444e-a07e-5d18eefab468"},"logTime":1529041066858}""",
//    """{"message":{"id":"8610518434","value":1403.6500244140625,"currency":"CZK","mode":"dc","city":"bkk","hotel":"accord","room":"dorm","guid":"72e825c9-3296-4607-ab41-0c21c0f9e0e6"},"logTime":1529041066858}""")

  def generateTraffic = {
    val trafficData = MockDataProvider.getTrafficData
    trafficData.foreach(println(_))
    KafkaUtils.pushToKafka(trafficData,MessageType.TRAFFIC)
  }

  def generateBooking={
    val bookingData = MockDataProvider.getBookingData
    bookingData.foreach(println(_))
    KafkaUtils.pushToKafka(bookingData,MessageType.BOOKING)
  }
}
