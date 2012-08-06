import sbt._
import Keys._

object HelloBuild extends Build {

  resolvers ++= Seq(
    "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/",
    "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
    "repo.novus rels" at "http://repo.novus.com/releases/",
    "repo.novus snaps" at "http://repo.novus.com/snapshots/")

  lazy val root = Project(id = "polyscalaz",
    base = file("."),
    settings = Project.defaultSettings ++
      Seq(libraryDependencies ++=
        Seq(
          "org.scalaz" %% "scalaz-full" % "6.0.4",
          "org.scalatest" %% "scalatest" % "1.8" % "test",
          "org.specs2" %% "specs2" % "1.12" % "test",
          "org.scalacheck" %% "scalacheck" % "1.10.0" % "test"
        )
      )
  )

}
