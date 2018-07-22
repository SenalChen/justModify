name := "land"

version := "0.1"

scalaVersion := "2.11.0"

description := "API client for Developmentseed's landsat-api"
organization := "com.azavea"
licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))
scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-Yinline-warnings",
  "-language:implicitConversions",
  "-language:reflectiveCalls",
  "-language:higherKinds",
  "-language:postfixOps",
  "-language:existentials",
  "-feature")
publishMavenStyle := true
publishArtifact in Test := false
pomIncludeRepository := { _ => false }

shellPrompt := { s => Project.extract(s).currentProject.id + " > " }

resolvers += "LocationTech GeoTrellis Releases" at "https://repo.locationtech.org/content/repositories/geotrellis-releases"

val gtMode = if(sys.props.get("INCLUDE_GT").isDefined) "compile" else "provided"

libraryDependencies ++= Seq(
  "io.spray" %% "spray-json" % "1.3.2",
  "com.typesafe.akka" %% "akka-http" % "10.0.10",
  "com.typesafe.akka" %% "akka-stream" % "2.5.4",
  "com.typesafe.akka" %% "akka-actor"  % "2.5.4",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.10",
//  "ch.megard" %% "akka-http-cors" % "0.2.2",
  "org.locationtech.geotrellis" %% "geotrellis-vector" % "1.1.0",
  "org.locationtech.geotrellis" %% "geotrellis-raster" % "1.1.0",
  "org.apache.commons" % "commons-compress" % "1.13",
  "commons-io" % "commons-io" % "1.3.2",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
  "com.amazonaws" % "aws-java-sdk-s3" % "1.11.60",
  "com.chuusai" %% "shapeless" % "2.3.2",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

//bintrayOrganization := Some("azavea")
//bintrayRepository := "maven"
//bintrayVcsUrl := Some("https://github.com/azavea/scala-landsat-util.git")
//bintrayPackageLabels := Seq("scala", "landsat", "maps", "gis", "geographic", "data", "raster", "processing")

initialCommands in console :=
  """
import com.azavea.landsatutil._
import geotrellis.vector._
import geotrellis.vector.io._
import geotrellis.vector.io.json.GeoJson
import geotrellis.raster._
  """

