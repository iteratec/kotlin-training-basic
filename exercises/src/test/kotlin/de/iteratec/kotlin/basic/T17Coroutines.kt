package de.iteratec.kotlin.basic

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Coroutines are Kotlins concept for concurrent and parallel programming. They can be imagined as being light-weight threads.
// A coroutine is "running" code that can be suspended at any time and later be resumed.

// Functions whose execution can be suspended need to be marked with the <b> suspend </b> modifier.
// They can be only called out of other suspend functions and only executed in coroutines.
suspend fun delayedComputation(delayTime: Long = 1000L): Long {
    println("Started computation in thread ${Thread.currentThread().name}")
    delay(delayTime)
    println("Finished computation in thread ${Thread.currentThread().name}")
    return delayTime
}

// VERY IMPORTANT
// Change the Run configuration of these tests in the way that you add the VM option "-Dkotlinx.coroutines.debug".
// Then you always see which coroutine is currently logging a statement.
fun main() {
    println("Running two delayed computations in a coroutine took ${measureExecutionTime { runningCoroutines() }}")
    println("Running two delayed computations in separate sub-coroutines took ${measureExecutionTime { suspendingCoroutinesIsNonBlocking() }}")
    println("Waiting for one delayed computation and supplying its result to another delayed computation took ${measureExecutionTime { waitingForResults() }}")
    println("Running two delayed computations in separate sub-coroutines and cancelling them after 500ms took ${measureExecutionTime { cancellingCoroutines() }}")
    println("Parallel computing took ${measureExecutionTime { parallelComputing() }}")
    println("Implementing and reviewing tickets took ${measureExecutionTime { channels() }}")
}

fun runningCoroutines() {
    // runBlocking bridges the normal world and the coroutine world in Kotlin.
    // It blocks the current thread and starts a coroutine that runs the code in its body.
    // runBlocking blocks until the coroutine is finished.
    runBlocking {
        delayedComputation()
        delayedComputation()
    }
}

fun suspendingCoroutinesIsNonBlocking() {
    // Suspending coroutines is non-blocking. The underlying thread can do other work. In this case it runs another coroutine.
    runBlocking {
        // launch is a Coroutine builder. It starts a coroutine inside another coroutines. Crazy!
        // Nesting coroutines is totally common in Kotlin. This concept is called structured concurrency.
        launch {
            delayedComputation()
        }
        launch {
            delayedComputation()
        }
    }
}

fun waitingForResults() {
    runBlocking {
        // We can wait for a coroutine and its result with the async coroutine builder and the await function.
        val computation1: Deferred<Long> = async {
            delayedComputation()
        }
        val result1 = computation1.await()
        launch {
            delayedComputation(result1)
        }
    }
}

fun cancellingCoroutines() {
    runBlocking {
        val job = launch {
            try {
                coroutineScope {
                    // A CoroutineScope represents position in structured concurrency tree and contains configuration for all running coroutines inside.
                    // We need another layer here to net enter the finally block prematurely.
                    launch {
                        delayedComputation()
                    }
                    launch {
                        delayedComputation()
                    }
                }
            } catch (e: CancellationException) {
                println("Cancelled remaining computations in ${Thread.currentThread().name}")
            } finally {
                println("Doing some cleanup")
            }
        }

        delay(500L)
        job.cancel()
        // Structured concurrency is very useful. Parent coroutines are responsible for their children.
        // Cancelling a parent coroutine will automatically cancel all child coroutines (at least if the children are well written).
    }
}

fun parallelComputing() {
    // Dispatchers.Default uses a thread pool and distributes the coroutines on this pool.
    // Structured concurrency lets subcoroutines use the dispatcher of their parent.
    runBlocking(Dispatchers.Default) {
        // Coroutines are very light-weight. You can even launch 100 000 at the same time without any performance problem. Be brave and try it.
        // Suspended coroutines might be picked up by different threads than they started with.
        repeat(100) {
            launch {
                delayedComputation()
            }
        }
    }
}

// Coroutines can communicate with each other with channels
fun channels() {
    val channel = Channel<Int>()

    runBlocking {
        launch { reviewTickets(channel, 1) }
        launch { reviewTickets(channel, 2) }

        val workProcess1 = async { putTicketsToReview(channel, 1) }
        val workProcess2 = async { putTicketsToReview(channel, 2) }
        awaitAll(workProcess1, workProcess2)
        channel.close()
    }
}

suspend fun putTicketsToReview(channel: SendChannel<Int>, index: Int) {
    repeat(3) {
        delayedComputation(index * 1000L)
        channel.send(index)
        println("Developer${index} has put a ticket to review")
    }
}

suspend fun reviewTickets(channel: ReceiveChannel<Int>, index: Int) {
    for (number in channel) {
        delayedComputation(index * 500L)
        println("Reviewer${index} has reviewed a ticket of Developer${number}")
    }
}

fun measureExecutionTime(codeBlock: () -> Any?): Long {
    val start = System.currentTimeMillis()
    codeBlock()
    return System.currentTimeMillis() - start
}