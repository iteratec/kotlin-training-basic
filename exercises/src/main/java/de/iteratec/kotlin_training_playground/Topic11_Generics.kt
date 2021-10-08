package de.iteratec.kotlin_training_playground

abstract class Producer<T> {
    abstract fun emit(): T
}

abstract class Consumer<S> {
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

/**
 * Task main
 * Which of the following 4 code blocks actually should be allowed to compile? Make those blocks compile by changing the classes Producer/Consumer accordingly.
 * Try to trick the compiler by wrongly fixing the Producer/Consumer classes for the cases that should actually not compile. What happens?
 */
fun main() {
/*        val myRuntimeExceptionProducer: Producer<RuntimeException> = ExceptionProducer
        val runtimeException = myRuntimeExceptionProducer.emit()

        val myExceptionProducer: Producer<Exception> = RuntimeExceptionProducer
        val exception = myExceptionProducer.emit()

        val myRuntimeExceptionConsumer: Consumer<RuntimeException> = ExceptionConsumer
        myRuntimeExceptionConsumer.store(RuntimeException())

        val myExceptionConsumer: Consumer<Exception> = RuntimeExceptionConsumer
        myExceptionConsumer.store(Exception())*/
}
