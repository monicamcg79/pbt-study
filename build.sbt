ThisBuild / version := "0.1.0-SNAPSHHOT"

ThisBuild / scalaVersion := "2.12.18"

lazy val root = (project in file("."))
    .settings(
        name := "pbt-study"
    )

libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.2.17")    