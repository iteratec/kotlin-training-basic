# Playground for Kotlin training

This is the Iteratec Kotlin Workshop. 

## Prerequisites

In order to execute the exercises you need Java 11 or newer. For one minor exercise you might need Node JS.

The workshop is intended for developers familiar with Java. In Kotlin, we start from 0. 

However we do not outline most of things that work exactly as in Java. For example, we do not explain what object-oriented programming is, when introducing classes in Kotlin.

## How to use this training

We recommend to use IntelliJ out of inconvenience. First build everywthing running ./gradlew build or ./mvnw verify 
(IntelliJ might do this automatically). There might be some failing tests. As long as not all tests are failing, everything is ok.

Navigate to the exercises module. We have distributed the content into smaller topics.
Normally each topic has one Kotlin demo file where new concepts will be explained by the tutor. 
Each topic has an exercise file (name contains "Tasks") containing the exercises, which are implemented as unit tests.

Some exercise tests are already green. This means you have to verify your solution by yourself. Check your solution by examining the log output and potentially adding further log lines.
You can also compare your code with the solution folder.

Most topics contain also a theory file. These contain explanations in different wording. Using them is optional.
The demo files together with the explanations from the tutor should normally be sufficient.

Exercises can be done out of order. However some are based on previous knowledge. Consult the exercise header to find out about the prerequisites.

Have fun :)

## Further reading and exercising

Check out the excellent official documentation [Kotlin website](https://kotlinlang.org) as well as the main interactive tutorial [Kotlin Koans](https://kotlinlang.org/docs/tutorials/koans.html).
