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
### Learning
* [Kotlin website](https://kotlinlang.org) - official Kotlin documentation
* [Kotlin Koans](https://kotlinlang.org/docs/tutorials/koans.html) - interactive exercises to various Kotlin concepts

### Frameworks & libs
* [Kotlin Awesome](https://github.com/KotlinBy/awesome-kotlin/blob/readme/README.md) - huge list of Kotlin frameworks and libraries


* [Arrow](https://arrow-kt.io/) - hardcore functional programming library for Kotlin
* [config4k](https://config4k.github.io/config4k/) - type-safe property files parser
* [Exposed](https://github.com/JetBrains/Exposed) - lightweight SQL library from Jetbrains
* [Koin](https://insert-koin.io/) - lightweight dependency injection framework
* [Konform](https://github.com/konform-kt/konform) - DSL-based validation framework
* [Kotest](https://kotest.io/) - Kotlin-native testing framework with fluent assertions
* [Kotlinx serialization](https://github.com/Kotlin/kotlinx.serialization) - multiplatform serialization library from Jetbrains
* [Ktor](https://ktor.io/) - Kotlin-native HTTP server framework from Jetbrains
* [Mockk](https://github.com/mockk/mockk) - the must-have Kotlin-native mocking library

### IntelliJ plugins
* [String manipulation](https://plugins.jetbrains.com/plugin/2162-string-manipulation) - efficiently manipulate your code, great for line sorting 
* [Ace jump](https://plugins.jetbrains.com/plugin/7086-acejump) - provides great mechanics for search & jump within your code
* [IdeaVIM](https://plugins.jetbrains.com/plugin/164-ideavim) - use VIM shortcuts in IntelliJ (careful!)
* [Nyan Progress Bar](https://plugins.jetbrains.com/plugin/8575-nyan-progress-bar) - you progress bar is a [Nyan Cat](https://www.youtube.com/watch?v=jIQ6UV2onyI) now 🐱