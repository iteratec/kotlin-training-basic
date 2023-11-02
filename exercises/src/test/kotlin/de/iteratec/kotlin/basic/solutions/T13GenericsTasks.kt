package de.iteratec.kotlin.basic.solutions

import org.junit.Test

class GenericsTasks {

    /**
     * ## Producers and consumers
     * As an exercise, we build our own function interface. anyToAny is instantiated by a SAM conversion of the compiler.
     * The lambda serves as the implementation of the apply-method. Comment in the last code line and make it compile
     * by adding in/out-modifiers to MyCustomFunctionInterface.
     */
    @Test
    fun taskFunctionTypes() {
        val anyToAny: MyCustomFunctionInterface<Any, Any> = MyCustomFunctionInterface { input: Any ->
            input
        }
        
        val stringToArbitrary: MyCustomFunctionInterface<String, Any?> = anyToAny
    }

    /**
     * ## Producers and consumers 2
     * Which of the following 4 code blocks actually should be allowed to compile? Make those blocks compile by
     * changing the classes Producer/Consumer accordingly. Try to trick the compiler by using the wrong option of the
     * in/out keyword to the Producer/Consumer classes for the cases that should actually not compile. What happens?
     */
    @Test
    fun taskProducersAndConsumers() {
        val myExceptionProducer: Producer<Exception> = RuntimeExceptionProducer
        val exception = myExceptionProducer.emit()

        val myRuntimeExceptionConsumer: Consumer<RuntimeException> = ExceptionConsumer
        myRuntimeExceptionConsumer.store(RuntimeException())
    }
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
