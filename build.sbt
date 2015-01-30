name := """demoApp"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "com.google.inject" % "guice" % "4.0-beta",
  "commons-beanutils" % "commons-beanutils" % "1.9.2",
  "org.mockito" % "mockito-core" % "1.10.19"
)
