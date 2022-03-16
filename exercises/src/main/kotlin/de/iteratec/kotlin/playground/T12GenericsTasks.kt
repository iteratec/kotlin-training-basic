package de.iteratec.kotlin.playground

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
        
        //val stringToArbitrary: MyCustomFunctionInterface<String, Any?> = anyToAny
    }

    /**
     * ## Producers and consumers 2
     * Which of the following 4 code blocks actually should be allowed to compile? Make those blocks compile by
     * changing the classes Producer/Consumer accordingly. Try to trick the compiler by using the wrong option of the
     * in/out keyword to the Producer/Consumer classes for the cases that should actually not compile. What happens?
     */
    @Test
    fun taskProducersAndConsumers() {
/*        val myRuntimeExceptionProducer: Producer<RuntimeException> = ExceptionProducer
        val runtimeException = myRuntimeExceptionProducer.emit()

        val myExceptionProducer: Producer<Exception> = RuntimeExceptionProducer
        val exception = myExceptionProducer.emit()

        val myRuntimeExceptionConsumer: Consumer<RuntimeException> = ExceptionConsumer
        myRuntimeExceptionConsumer.store(RuntimeException())

        val myExceptionConsumer: Consumer<Exception> = RuntimeExceptionConsumer
        myExceptionConsumer.store(Exception())*/
    }
}
