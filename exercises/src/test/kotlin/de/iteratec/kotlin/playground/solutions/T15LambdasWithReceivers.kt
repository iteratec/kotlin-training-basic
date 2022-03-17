package de.iteratec.kotlin.playground.solutions

import de.iteratec.kotlin.playground.solutions.Cleaning.Companion.cleaning
import de.iteratec.kotlin.playground.solutions.TodoList.Companion.todoList
import de.iteratec.kotlin.playground.solutions.UnderParentalSupervision.Companion.supervisedTeenagerDoing

// We have already seen that we can define so-called extension functions outside of a class that can only be called on a receiver and can access it by "this".
// We remind you that extension functions are only syntactic sugar and are replaced with ordinary functions by the compiler. They allow us to make utility functions more beautiful for instance.

// As an extension of this concept, we can also define lambdas with receivers or expect them as an argument of another function or instance variable in a class.

fun writeLetter(name: String, messageCustomizer: StringBuilder.() -> Unit): String {
    val letterBuilder = StringBuilder()
    // header
    letterBuilder.append(
        """
            Dear ${name},
            
            we are thankful for your message and have worked day and night to provide the best possible answer in the shortest possible amount of time. 
            After numerous discussions and considerations we are sure the answer to your question is:
            
        """.trimIndent()
    )
    letterBuilder.messageCustomizer()
    letterBuilder.append(
        """
            
           We hope we have satisfied all your concerns and desires. We are happy to hear from your again,
            
           Yours sincerely, Harald Answer-Machine
           Certified bullshitting expert
        """.trimIndent()
    )
    return letterBuilder.toString()
}

// Lambdas with receivers are almost exclusively used as argument of other function (typically last argument).
// Since the lambda with receiver needs a proper receiver, it is the responsability of the other function to provide some and call the lambda on it.

fun main() {
    val letter = writeLetter("0815-Kunde") {
        append("It depends.")
    }
    println(letter)
    // Notice that the compiler knows what "this" is and which functions we are allowed to call.
    // The general type of a lambda with receiver is "Receiver.(Argument1, Argument2, ...) -> ReturnType"

    // You can explore typical use-cases of lambdas with receivers in the following exercises

    avoidRepetitionWithLambdasWithReceiversTask()
    allowingOperationsOnlyInCertainScopesTask()
    creatingAndCustomizingObjectsInOneLineTask()
}

// Why lambdas with receivers?
// 1. Configuration/Manipulation (Gradle type)
// 2. Type-safe scope. Make functions only visible where they belong [City - House - Room]
// 3. Dont repeat yourself


fun avoidRepetitionWithLambdasWithReceiversTask() {
    println("#### Task avoidRepetitionWithLambdasWithReceiversTask")
    // The "with"-function is the simplest Kotlin-built-in example of a function expecting a lambda as receiver as a last argument.
    // When you have a lambda with receiver and a matching receiver, you can supply both as arguments to "with".
    // "with" will simply call the lambda on the receiver and return the result.
    //
    // fun <T, R> with(receiver: T, block: T.() -> R): R {
    //   return receiver.block()
    // }
    //
    // In the following we have to repeat the same variable all the time. Improve the situation by using the "with"-function
    val whyDoesMyColleagueAlwaysHasToUseTheseIncrediblyLongVariableNamesWhichPreventMeCodingOnMySmartphoneAndAnnoyMeDeeply =
        IteratecMitarbeiter("Heiko Schrader", true, "MS Word")

    // Block with repetetive use of our variable
    with(whyDoesMyColleagueAlwaysHasToUseTheseIncrediblyLongVariableNamesWhichPreventMeCodingOnMySmartphoneAndAnnoyMeDeeply) {
        println(name)
        println(isMarried)
        println(favouriteTechnology)
    }
}

class IteratecMitarbeiter(var name: String, var isMarried: Boolean, var favouriteTechnology: String)


fun allowingOperationsOnlyInCertainScopesTask() {
    println("#### Task allowingOperationsOnlyInCertainScopesTask")
    // Kotlin allows us to hide extension functions of a class A in another class B.
    // They can only be used in a lambda with receiver of type B.
    // In the scope of the lambda all public members of A become visible, in particular the extension functions
    // Uncomment the code in this function and UnderParentalSupervision and make it compile.
    // Check that you cannot lift the calls on child to top-level
    val child = Teenager()

    supervisedTeenagerDoing() {
        child.driveInATestDrivingParkour()
        child.openABankAccount()
    }
}

class Teenager

class UnderParentalSupervision {
    fun Teenager.driveInATestDrivingParkour() {
        println("Drive in a test driving parkour")
    }

    fun Teenager.openABankAccount() {
        println("Bank account opened")
    }

    companion object {
        fun supervisedTeenagerDoing(actions: UnderParentalSupervision.() -> Any) {
            UnderParentalSupervision().actions()
        }
    }
}

fun creatingAndCustomizingObjectsInOneLineTask() {
    println("#### Task creatingAndCustomizingObjectsInOneLineTask")
    // Code with lambdas with receivers often looks more like a Domain-specific-language than normal code we are used to write.
    // Some libraries make extensive use of this feature. This could be some examples:

    // Gradle files in Kotlin
    /*
       tasks {
        compileKotlin {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }*/

    // Building frontends with Jetpack Compose
    /*
    Row {
        Column {
            Text("Click on the button")
            Image("http://image.jpg")
        }
        Button {
            Text("Button text")
        }
    }
    */

    // Functions like tasks, compileKotlin, Row, Button have two responsibilities:
    // They instantiate a new object and apply a lambda with receiver of the same type to this object to customize it.

    // Resolve the TODO instructions ocurring in the following calls and try to understand the code.

    val myTodoList = todoList {
        cleaning {
            isBathroomDirty = true
        }
    }

    println(myTodoList.tasks)
}

open class Task

class TodoList {
    val tasks: MutableList<Task> = mutableListOf()
    fun addTask(task: Task) = tasks.add(task)

    companion object {
        fun todoList(codeBlock: TodoList.() -> Unit): TodoList {
            val todoList = TodoList()
            todoList.codeBlock()
            return todoList
        }
    }
}

data class Cleaning(
    var isBathroomDirty: Boolean = false,
    var isMainRoomDirty: Boolean = false,
    var isKitchenDirty: Boolean = false
) : Task() {
    companion object {
        fun TodoList.cleaning(codeBlock: Cleaning.() -> Unit) {
            val cleaningTask = Cleaning()
            cleaningTask.codeBlock()
            addTask(cleaningTask)
        }
    }
}


