name := "master-chef-data-collection"

version := "1.0"

scalaVersion := "2.12.6"

resolvers ++= Seq("apache-snapshots" at "http://repository.apache.org/snapshots/")

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.2.1",
  "org.apache.httpcomponents" % "httpclient" % "4.3.6",
  "org.json4s" %% "json4s-jackson" % "3.2.11",
  "org.apache.kafka" % "kafka-clients" % "1.1.0",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0")



