package de.iteratec.kotlin.playground

import de.iteratec.kotlin.playground.Cleaning.Companion.cleaning
import de.iteratec.kotlin.playground.TodoList.Companion.todoList
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Test

class T15LambdasWithReceiversTasks {

    /**
     * ## avoidRepetitionWithLambdasWithReceiversTask
     * The "with"-function is the simplest Kotlin-built-in example of a function expecting a lambda as receiver as a last argument.
     * When you have a lambda with receiver and a matching receiver, you can supply both as arguments to "with".
     * "with" will simply call the lambda on the receiver and return the result.
     *
     * fun <T, R> with(receiver: T, block: T.() -> R): R {
     *   return receiver.block()
     * }
     *
     * In the following we have to repeat the same variable all the time. Improve the situation by using the "with"-function
     */
    @Test
    fun avoidRepetitionWithLambdasWithReceiversTask() {
        val whyDoesMyColleagueAlwaysHasToUseTheseIncrediblyLongVariableNamesWhichPreventMeCodingOnMySmartphoneAndAnnoyMeDeeply =
            IteratecMitarbeiter("Heiko", true, "MS Word")

        // Block with repetetive use of our variable
        println(
            whyDoesMyColleagueAlwaysHasToUseTheseIncrediblyLongVariableNamesWhichPreventMeCodingOnMySmartphoneAndAnnoyMeDeeply.name
        )
        println(
            whyDoesMyColleagueAlwaysHasToUseTheseIncrediblyLongVariableNamesWhichPreventMeCodingOnMySmartphoneAndAnnoyMeDeeply.isMarried
        )
        println(
            whyDoesMyColleagueAlwaysHasToUseTheseIncrediblyLongVariableNamesWhichPreventMeCodingOnMySmartphoneAndAnnoyMeDeeply.favouriteTechnology
        )
    }

    class IteratecMitarbeiter(var name: String, var isMarried: Boolean, var favouriteTechnology: String)

    /**
     *  ## allowingOperationsOnlyInCertainScopes
     *  Kotlin allows us to hide extension functions of a class A in another class B.
     *  They can only be used in a lambda with receiver of type B.
     *  In the scope of the lambda all public members of A become visible, in particular the extension functions.
     *  Uncomment the code in this function and UnderParentalSupervision and make it compile.
     *  Check that you cannot lift the calls on child to top-level*/
    @Test
    fun allowingOperationsOnlyInCertainScopesTask() {
        val child = Teenager()
        val parent = Adult()

        /* supervisedTeenagerDoing(parent) {
              child.driveInATestDrivingParkour()
              child.openABankAccount()
        } */
    }

    class Teenager
    class Adult

    class UnderParentalSupervision(val parentalSupervisor: Adult) {
        fun Teenager.driveInATestDrivingParkour() {
            println("Minor $this drives by car. Parent $parentalSupervisor takes care that nobody dies")
        }

        fun Teenager.openABankAccount() {
            println("Minor $this opened a bank account. Parent $parentalSupervisor signed all the boring documents.")
        }

        companion object {
/*        fun supervisedTeenagerDoing(parentalSupervisor: Adult, actions: ??? -> Any) {
            TODO: Implement
        }*/
        }
    }

/**
 * ## creatingAndCustomizingObjectsInOneLineTask
 * Code with lambdas with receivers often looks more like a Domain-specific-language than normal code we are used to write.
 * Some libraries make extensive use of this feature. This could be some examples:
 *
 * Gradle files in Kotlin
 *
 * tasks {
 *   compileKotlin {
 *     kotlinOptions {
 *       jvmTarget = "11"
 *     }
 *   }
 * }
 *
 * Building frontends with Jetpack Compose
 *
 * Row {
 *     Column {
 *         Text("Click on the button")
 *         Image("http://image.jpg")
 *     }
 *     Button {
 *         Text("Button text")
 *     }
 * }
 *
 * Functions like tasks, compileKotlin, Row, Button have two responsibilities:
 * They instantiate a new object and apply a lambda with receiver of the same type to this object to customize it.
 * Resolve the instructions ocurring in the following calls and try to understand the code.
 */
    @Test
    fun creatingAndCustomizingObjectsInOneLineTask() {


        val myTodoList = todoList {
            cleaning {
                isBathroomDirty = true
            }
        }

        assertThat(myTodoList.tasks, equalTo(mutableListOf(Cleaning(
            isBathroomDirty = true,
            isMainRoomDirty = false,
            isKitchenDirty = false
        ))))
    }
}

open class Task

class TodoList {
    val tasks: MutableList<Task> = mutableListOf()
    fun addTask(task: Task) = tasks.add(task)

    companion object {
        fun todoList(codeBlock: TodoList.() -> Unit): TodoList {
            // TODO: This should instantiate a TodoList, call the code block on it and return the TodoList
            throw NotImplementedError("Implement me")
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
            // TODO: This function should instantiate a Cleaning task with default values.
            // Then it should execute the codeBlock and finally add itself to the task list by calling addTask
        }
    }
}


