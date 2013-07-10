import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "todolist"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "se.radley" %% "play-plugins-salat" % "1.2"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    resolvers +=
      "Repo" at "https://oss.sonatype.org/content/repositories/snapshots"
  )

}
