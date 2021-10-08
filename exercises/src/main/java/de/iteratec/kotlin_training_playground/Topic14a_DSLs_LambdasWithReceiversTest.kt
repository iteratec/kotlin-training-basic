package de.iteratec.kotlin_training_playground

import de.iteratec.kotlin_training_playground.KotlinCompiler.Companion.compileKotlin
import de.iteratec.kotlin_training_playground.TasksContainer.Companion.tasks

fun main() {
    withFunctionTask()
    lambdasWithReceiversForDslsTask()
}

fun withFunctionTask() {
    // "let" has the signature
    // <T, R> T.let(block: (T) -> R): R
    // with an ordinary lambda as argument. If you did not come across "let" in the previous exercises:
    // variable.let(lambda) is basically syntactic sugar for lambda(variable).

    // "with" does the same as let but has a different signature and takes a lambda with receiver as an argument.
    // <T, R> with(receiver: T, block: T.() -> R): R
    // rewrite the code with "with" instead of "let"
    val person = EntsMitarbeiter("Heiko Schrader", true, "Word")
    person.let {
        println(it.name == "Heiko Schrader")
        println(it.isMarried == true)
        println(it.favouriteTechnology == "Word")
    }
}

class EntsMitarbeiter(var name: String, var isMarried: Boolean, var favouriteTechnology: String)

fun lambdasWithReceiversForDslsTask() {
    // The following expression is taken from a Gradle file written in Kotlin. It does not look like Kotlin at all and rather like some Gradle DSL. The code below should do the following:
    // Create a CompileKotlin-Task instance with default values and nested field "options.jvmTarget" set to "11" and add it to the list of Gradle tasks.
    // Provide the necessary implementations for the functions and try to understand what is going on.
    val tasksContainer = tasks {
        compileKotlin {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }

    val kotlinTask: KotlinCompiler = tasksContainer.tasks.first() as KotlinCompiler
    println(kotlinTask.kotlinOptions.jvmTarget == "11")
}

class TasksContainer {
    val tasks: MutableList<Task> = mutableListOf()
    fun addTask(task: Task) = tasks.add(task)

    companion object {
        fun tasks(codeBlock: TasksContainer.() -> Any): TasksContainer {
            // TODO: This should instantiate a Tasks object and call the code block on it
            return TasksContainer()
        }
    }
}

open class Task

class KotlinCompiler : Task() {
    var kotlinOptions: KotlinOptions = KotlinOptions()

    companion object {
        // Of course compileKotlin could be shifted to the Task class. However since it comes probably from a Gradle-Kotlin-Plugin it is more likely to be defined as extension function here.
        fun TasksContainer.compileKotlin(codeBlock: KotlinCompiler.() -> Unit) {
            // TODO: This function should instantiate a Kotlin compiler task with default values.
            // Then it should execute the codeBlock and finally add itself to the task list by calling addTask
        }
    }
}

class KotlinOptions(var jvmTarget: String = "16") {
    // invoke is a special operator function. When you implement it, it means that an instance of your class can be called like a function with the same signature as the invoke function
    operator fun invoke(codeBlock: KotlinOptions.() -> Unit) {
        // This function should apply the code block to the instance
    }
}



