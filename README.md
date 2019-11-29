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
- You must have [Scala 2.13](https://www.scala-lang.org/download/) or higher installed
```text
➜ scala --version
Scala code runner version 2.13.1 -- Copyright 2002-2019, LAMP/EPFL and Lightbend, Inc.
```

## How to run?
```shell script
git clone https://github.com/hhimanshu/Unit-Testing-In-Scala
cd Unit-Testing-In-Scala
```

## Verify if the project is setup for the course
```shell script
sbt "runMain BankOfScala"
```
