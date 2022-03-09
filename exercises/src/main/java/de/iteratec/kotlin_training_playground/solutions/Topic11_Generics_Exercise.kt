package de.iteratec.kotlin_training_playground.solutions

import java.util.function.Function

fun main() {
    // Often, we want to write reusable code that is applicable in situations as universal as possible.
    // Since Java and Kotlin are statically typed, we have to use generics for these use cases.
    // However, the calibration of generics in Java is often quite cumbersome.
    // In particular type erasure and generics in combination with inheritance leads to problems.
    // Kotlins generics are very similar to those of Java burt offer better support for the inheritance problem.

    val anyToAnyInJavaStyle = Function<Any, Any> { input: Any ->
        input
    }
    // In principle the following should be allowed, but works in Java only by the complicated using bounded wildcards
    // val stringToArbitraryInJavaStyle: Function<String, Any?> = anyToAnyInJavaStyle

    // In Kotlin however it works
    val anyToAnyInKotlinStyle: (Any) -> Any = {input: Any -> input}
    val stringToArbitraryInKotlinStyle: (String) -> Any? = anyToAnyInKotlinStyle
    // Of course, the generics are not really visible here and most likely the magic to see that "(Any) -> Any" is a subtype of
    // "(String) -> Any?" is done by the compiler alone. However Kotlin allows you to achieve the same effect with your generic classes.

    // Lets discuss first why Function<Any, Any> should be a subtype of Function<String, Any?> and how we can recognize such relationships.

    // In general generic classes are neither covariant nor contravariant (they are invariant).
    // If Child is a subclass of Parent and Generic<T> a generic class, it is not clear whether
    // Generic<Child> should behave like a subtype of Generic<Parent> or the other way around.
    // Theoretically, this question has a astoundingly quite simple answer.

    // In case that we use the generic parameter T only in so-called out-positions
    // (T as part of return values of methods), we can substitute an instance of
    // Generic<Child> for a Generic<Parent> type (covariance).

    // In case that we use the generic parameter T only in so-called in-positions
    // (T as part of input argument of methods), we can substitute an instance of
    // Generic<Parent> for a Generic<Child> type (contravariance).

    // In order to leverage this principle, Kotlin uses the keywords "out" and "in" in front of a generic variable to declare contravariance or covariance.
    // Such declaration can be made where a generic type will be used (call-site variance) or the generic parameter
    // of a complete class definition can be prefixed with such a keyword (declaration-site variance).
    // The latter will lead to call-site variance in every place this class is used.

    // In general, declaration-site variance should be preferred. Our Function-interface is an example as you will see in the exercise.
    // Another example is the Kotlin-inbuilt List interface. Jump into the implementation of List to see that it uses "out" in its signature.
    val listOfStrings: List<String> = listOf("example")
    var listOfArbitrary: List<Any> = listOfStrings

    // Call-site variance has to be used when the generic parameter of a class is neither only in the "out" nor in the "in" position.
    // An example is the class MutableList. For the put-method the generic parameter is in the in-position, for the pop-method in the out-position.
    // However it is a common task to copy contents from one MutableList to another while the concrete type of source and target do not need to be the same.

    fun <T> copyListItemsA(source: MutableList<out T>, target: MutableList<T>) {
        source.forEach { target.add(it) }
    }

    fun <T> copyListItemsB(source: MutableList<T>, target: MutableList<in T>) {
        source.forEach { target.add(it) }
    }

    val mutableListOfStrings: MutableList<String> = mutableListOf("text")
    val mutableListOfAny: MutableList<Any> = mutableListOf(5)

    copyListItemsA(mutableListOfStrings, mutableListOfAny)
    copyListItemsB(mutableListOfStrings, mutableListOfAny)

    // Try it yourself
    taskFunctionTypes()
    taskProducersAndConsumers()
}

/**
 * taskProducersAndConsumers
 * As an exercise, we build our own function interface. anyToAny is instantiated by a SAM conversion of the compiler.
 * The lambda serves as the implementation of the apply-method. Comment in the last code line and make it compile
 * by adding in/out-modifiers to MyCustomFunctionInterface.
 */
fun taskFunctionTypes() {
    val anyToAny: MyCustomFunctionInterface<Any, Any> = MyCustomFunctionInterface { input: Any ->
        input
    }
    val stringToArbitrary: MyCustomFunctionInterface<String, Any?> = anyToAny
}

/**
 * taskProducersAndConsumers
 * Which of the following 4 code blocks actually should be allowed to compile? Make those blocks compile by changing the classes Producer/Consumer accordingly.
 * Try to trick the compiler by using the wrong option of the in/out keyword to the Producer/Consumer classes for the cases that should actually not compile. What happens?
 */
fun taskProducersAndConsumers() {
        val myExceptionProducer: Producer<Exception> = RuntimeExceptionProducer
        val exception = myExceptionProducer.emit()

        val myRuntimeExceptionConsumer: Consumer<RuntimeException> = ExceptionConsumer
        myRuntimeExceptionConsumer.store(RuntimeException())
}

abstract class Producer<out T> {
    abstract fun emit(): T
}

abstract class Consumer<in S> {
    abstract fun store(input: S)
}

object ExceptionProducer : Producer<Exception>() {
    override fun emit() = Exception()
}

object RuntimeExceptionProducer : Producer<RuntimeException>() {
    override fun emit() = RuntimeException()
}

object ExceptionConsumer : Consumer<Exception>() {
    var exception: Exception = Exception()
    override fun store(input: Exception) {
        exception = input
    }
}

object RuntimeExceptionConsumer : Consumer<RuntimeException>() {
    var exception: RuntimeException = RuntimeException()
    override fun store(input: RuntimeException) {
        exception = input
    }
}

fun interface MyCustomFunctionInterface<in I, out O> {
    fun apply(input: I): O
}
