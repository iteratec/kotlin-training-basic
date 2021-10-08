package de.iteratec.kotlin_training_playground

fun main() {
    var alex = Person("Alex")
    // The Person class can store and remove Actions. toString() prints the actions a person is doing (= has stored)
    // We want to create a type-safe DSL (domain specific language) that mimics language in real life and does not compile semantically senseful sentences.
    println(alex.does().sit().and().talk().finishSentenceAndPrintActiveActions() == "Alex sits, talks")
    println(alex.does().eat().and().not().talk().finishSentenceAndPrintActiveActions() == "Alex sits, eats")

    // The brackets are annoying. We will get rid of them by using properties and putting side-effects into the getter.
    // Also we would like to finish a sentence with an exclamation mark at the end. This will not be possible in Kotlin.
    // However we can finish it by starting it with an exclamation mark (similar to Spanish) with operator overloading.
    // Uncomment the code below and make it compile.

/*        alex = Person("Alex")
        println(!alex.does.sit.and.talk == "Alex sits, talks")
        println(!alex.does.eat.and.not.talk == "Alex sits, eats")*/
}

class Person(val name: String) {
    val currentListOfActions = mutableSetOf<Action>()

    // this switch marks whether the next Action should be added or removed
    var shouldIncludeNextAction: Boolean = true

    override fun toString(): String {
        return "$name ${currentListOfActions.joinToString { it.status }}"
    }

    // "by lazy" does evaluate a property only when it is accessed. We need it here, otherwise this ends in an inifinity loop.
    fun does() = VerbExpected(this)
    val does: VerbExpected by lazy { VerbExpected(this) }
}

class VerbExpected(val person: Person) {
    // "by lazy" does evaluate a property only when it is accessed. We need it here, otherwise this ends in an inifinity loop.
    fun not(): VerbExpected {
        person.shouldIncludeNextAction = !person.shouldIncludeNextAction
        return VerbExpected(person)
    }

    val not: VerbExpected by lazy {
        person.shouldIncludeNextAction = !person.shouldIncludeNextAction
        VerbExpected(person)
    }

    fun addActionToPerson(action: Action) {
        if (person.shouldIncludeNextAction) {
            person.currentListOfActions.add(action)
        } else {
            person.currentListOfActions.remove(action)
        }
        person.shouldIncludeNextAction = true
    }
}

class EndOrVerbContinuationExpected(val person: Person) {
    // When refactoring this method, keep it in this class. This operator seems to have lower preference than method invocations.
    fun finishSentenceAndPrintActiveActions(): String {
        return person.toString()
    }

    // "by lazy" does evaluate a property  only when it is accessed. Otherwise this ends in an inifinity loop.
    val and: VerbExpected by lazy {
        VerbExpected(person)
    }

    fun and() = VerbExpected(person)
}

