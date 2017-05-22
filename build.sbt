lazy val root = (project in file(".")).
  settings(
    name := "dotty-example-project",
    description := "Example sbt project that compiles using Dotty",
    version := "0.1",
    scalaBinaryVersion := "2.11",

    scalaVersion := "0.2.0-bin-SNAPSHOT-nonbootstrapped",
    libraryDependencies += "ch.epfl.lara" % "stainless-dotty_2.11" % "0.1",

    unmanagedSourceDirectories in Compile += new java.io.File("/home/florian/Desktop/EPFL/Master/sav/project/stainless/./frontends/library/")
  )
