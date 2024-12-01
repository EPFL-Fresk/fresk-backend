import com.typesafe.sbt.packager.docker.DockerPlugin.autoImport._
import sbt.Keys._

val scala3Version = "3.5.2"

// Core project settings
lazy val root = project
  .in(file("."))
  .enablePlugins(JavaAppPackaging, DockerPlugin, AshScriptPlugin)
  .settings(
    name := "fresk-backend",
    version := "1.0",
    scalaVersion := scala3Version,
    Compile / mainClass := Some("Main"), // Entry point of the app

    // Docker settings
    Docker / packageName := "fresk-backend-dev",
    Docker / dockerRepository := Some("paultisaw"), // Replace with your Docker Hub username
    dockerBaseImage := "openjdk:17-jdk-alpine",
    dockerExposedPorts := Seq(9090),
    run / fork := true // Fork a new JVM for the `run` task
  )

// Add dependencies here
libraryDependencies ++= Seq(
  "org.scalameta" %% "munit" % "1.0.0" % Test,
  "com.lihaoyi" %% "cask" % "0.10.2",
  "com.lihaoyi" %% "upickle" % "4.0.2"
)

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.5.2",
  "com.typesafe.slick" %% "slick-codegen" % "3.5.2",
  "org.postgresql" % "postgresql" % "42.6.0"
)

