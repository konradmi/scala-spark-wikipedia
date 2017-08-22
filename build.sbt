name := course.value + "-" + assignment.value

scalaVersion := "2.11.8"

scalacOptions ++= Seq("-deprecation")

courseId := "e8VseYIYEeWxQQoymFg8zQ"

resolvers += Resolver.sonatypeRepo("releases")

// grading libraries
libraryDependencies += "junit" % "junit" % "4.10" % "test"
libraryDependencies ++= assignmentsMap.value.values.flatMap(_.dependencies).toSeq

// include the common dir
commonSourcePackages += "common"

assignmentsMap := {
  val depsSpark = Seq(
    "org.apache.spark" %% "spark-core" % "2.0.0"
  )
  Map(
    "example" -> Assignment(
      packageName = "example",
      key = "",
      itemId = "I6L8m",
      partId = "vsJoj",
      maxScore = 10d,
      dependencies = depsSpark,
      options = Map("Xmx"->"1540m", "grader-memory"->"2048")),
    "wikipedia" -> Assignment(
      packageName = "wikipedia",
      key = "",
      itemId = "QcWcs",
      partId = "5komc",
      maxScore = 10d,
      styleScoreRatio = 0.0,
      dependencies = depsSpark,
      options = Map("Xmx"->"1540m", "grader-memory"->"2048", "totalTimeout" -> "900", "grader-cpu" -> "2")),
    "stackoverflow" -> Assignment(
      packageName = "stackoverflow",
      key = "",
      itemId = "FWGnz",
      partId = "OY5fJ",
      maxScore = 10d,
      styleScoreRatio = 0.0,
      dependencies = depsSpark,
      options = Map("Xmx"->"1540m", "grader-memory"->"2048", "totalTimeout" -> "900", "grader-cpu" -> "2"))
  )
}

