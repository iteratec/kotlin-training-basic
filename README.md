# Kotlin basic training
Welcome to Kotlin basic training!

The training is intended for developers familiar with Java. In Kotlin, we start from scratch and explain every basic
Kotlin feature. However, we do not outline most of the things that work exactly as in Java.  For example, we do not
explain what object-oriented programming is, when introducing classes in Kotlin.

## Preparation
In order to execute the exercises you need Java 11 or newer.

We recommend to use IntelliJ out of inconvenience. Import the project into IntelliJ preferably as Gradle project (Maven
is supported as fallback solution).

To check, that everything is up and running, open the file `T01Functions.kt` and run the main function inside it.

## Project structure
We'll work with the `exercises` module most of the time. It contains a single test package `de.iteratec.kotlin.basic`,
where you will find all resources and exercises. For every topic discussed in the training, you will find the following files:
* `T01Topic.kt` - template used by trainers during the live-coding demo 
* `T01Topic.md` - short reference explaining the given topic in a nutshell
* `T01TopicTasks.md` - tasks for the trainees. Every task is a simple unit test, that you will have to fix.

Sample solutions for all the tasks are provided in the package `de.iteratec.kotlin.basic.solutions`.

Have fun 😺

## Further reading
Check out the excellent official documentation [Kotlin website](https://kotlinlang.org) as well as the main interactive tutorial [Kotlin Koans](https://kotlinlang.org/docs/tutorials/koans.html).
