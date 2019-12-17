# Unit Testing in Scala
This project uses `ScalaTest` to write all the unit tests in the course.

## Prerequisites
- You must have `git` installed
- You must have [Java v13](https://jdk.java.net/13/) installed
```text
➜ java -version
openjdk version "13" 2019-09-17
OpenJDK Runtime Environment AdoptOpenJDK (build 13+33)
OpenJDK 64-Bit Server VM AdoptOpenJDK (build 13+33, mixed mode, sharing)
```
- You must have [sbt 1.3.3](https://github.com/hhimanshu/sbt-getting-started#how-to-install-sbt) or higher installed
```text
➜ sbt --version
sbt version in this project: 1.3.3
sbt script version: 1.3.3
```
- You must have [Scala 2.13.1](https://www.scala-lang.org/download/) installed
```text
➜ scala --version
Scala code runner version 2.13.1 -- Copyright 2002-2019, LAMP/EPFL and Lightbend, Inc.
```

## How to run?
- Create a fork of this repo. Follow [Github](https://help.github.com/en/github/getting-started-with-github/fork-a-repo) documentation on how to achieve this.
- Clone your forked repo.
```shell script
git clone https://github.com/<your-user-name>/Unit-Testing-In-Scala
cd Unit-Testing-In-Scala
```

## Verify if the project is setup for the course
```shell script
sbt "runMain BankOfScala"
```

## Module 03 - Writing the First Test
### Add the scalatest dependency in `build.sbt`
```text
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % "test"
```

### Compiling & Running test using Scala
- Download the [ScalaTest](https://oss.sonatype.org/content/groups/public/org/scalatest/scalatest-app_2.13/3.1.0/scalatest-app_2.13-3.1.0.jar) jar file. This is available on [Quickstart](http://www.scalatest.org/quick_start) page  
- Download the [scala-xml](https://repo1.maven.org/maven2/org/scala-lang/modules/scala-xml_2.13/1.2.0/scala-xml_2.13-1.2.0.jar) jar file
- Compile the Test class
```shell script
scalac -classpath "*.jar" HelloWorldSpec.scala
```
- Run the Test
```shell script
scala -classpath "*.jar" org.scalatest.run HelloWorldSpec
```

## Module 07 - Mocking and Tagging Your Tests
The latest ScalaMock release `4.4.0` has not been updated with the latest ScalaTest release `3.1.0`.
There is an open [pull request](https://github.com/paulbutcher/ScalaMock/pull/274) to merge the changes.

However, there are no breaking or conflicting changes between ScalaTest and ScalaMock.
So, in order to learn ScalaMock, you can learn it with the ScalaTest release `3.0.8` which is 1 release behind the latest ScalaTest `3.1.0`.

Clone the repository
```shell script
https://github.com/hhimanshu/Unit-Testing-In-Scala-Mocking
```

The test source is available under `src/test/scala`.

To run all the tests, run
```shell script
test
```

To run the test including a specific tag, run
```shell script
testOnly -- -n com.h2.tags.Fast
testOnly -- -n com.h2.tags.Slow
```

To run the test excluding a specific tag, run
```shell script
testOnly -- -l com.h2.tags.Fast
testOnly -- -l com.h2.tags.Slow
```

