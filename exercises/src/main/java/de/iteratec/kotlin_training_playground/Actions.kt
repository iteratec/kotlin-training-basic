package de.iteratec.kotlin_training_playground

open class Action(val status: String)

object Talk: Action("talks")

// When refactoring dont move the resulting thing into VerbExpected. That class should not know about all the subclasses of Action.
fun VerbExpected.talk(): EndOrVerbContinuationExpected {
    this.addActionToPerson(Talk)
    return EndOrVerbContinuationExpected(person)
}

object Eat: Action("eats")

// When refactoring dont move the resulting thing into VerbExpected. That class should not know about all the subclasses of Action.
fun VerbExpected.eat(): EndOrVerbContinuationExpected {
    this.addActionToPerson(Eat)
    return EndOrVerbContinuationExpected(person)
}

object Sit: Action("sits")

// When refactoring dont move the resulting thing into VerbExpected. That class should not know about all the subclasses of Action.
fun VerbExpected.sit(): EndOrVerbContinuationExpected {
    this.addActionToPerson(Sit)
    return EndOrVerbContinuationExpected(person)
}
