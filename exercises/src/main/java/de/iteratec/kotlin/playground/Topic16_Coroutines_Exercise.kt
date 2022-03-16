package de.iteratec.kotlin.playground

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*Coroutines are Kotlins concept for concurrent and parallel programming. They can be imagined as being light-weight threads.

A coroutine is "running" code that can be suspended at any time and later be resumed. The idea is the following: A coroutine can be suspended or suspend itself
(for instance when being idle and waiting for an API call to return). Suspending a coroutine does not block the thread executing the coroutine.
Hence the thread can do other work. Later some thread can continue running the suspended coroutine.

Functions that can suspend need to be marked with the <b> suspend </b> modifier. They can be only called out of other suspend functions and only executed in coroutines.
*/

// delay suspends itself. Therefore delayedComputation has to feature the "suspend" keyword.
suspend fun delayedComputation(delayTime: Long = 2000L): Int {
    println("Started computation in thread ${Thread.currentThread().name}")
    delay(delayTime)
    println("Finished computation in thread ${Thread.currentThread().name}")
    return 1
}

// VERY IMPORTANT
// Change the Run configuration of this function in the way that you add the VM option "-Dkotlinx.coroutines.debug".
// Then you always see which coroutine is currently logging a statement.
fun main() {
    startMultipleComputationsConcurrentlyTask()
    structuredConcurrencyTask()
    parallelComputingTask()
}

fun startMultipleComputationsConcurrentlyTask() {
    fun startMultipleComputationsConcurrently() {
        println("####  Task startMultipleComputationsConcurrently")
        // runBlocking bridges the normal world and the coroutine world in Kotlin. It blocks the current thread and starts a coroutine that runs the code in its body.
        // runBlocking blocks until the coroutine is finished.
        runBlocking {
            println("Top-level coroutine started in ${Thread.currentThread().name}")
            // async is a Coroutine builder and starts a new coroutine executing the code in its body. Nesting coroutines inside each other is normal. It is called structured concurrency.
            // We will see in a later exercise why this is useful. async returns a Deferred<T> which can be compared to Promise in Javascript. An instance of Deferred can be awaited which suspends
            // the coroutine it is called in until the result is available.
            val deferredResult1: Deferred<Int> = async {
                delayedComputation()
            }
            val result1 = deferredResult1.await()

            val deferredResult2: Deferred<Int> = async {
                delayedComputation()
            }
            val result2 = deferredResult2.await()
            val result = result1 + result2
            println("Result is ${result}")
        }
    }

    // Look at your console when running the test. The coroutines inform you on which thread they are running and what there name/identity is.
    // We are making two independent calls that each take 2 seconds and combine the results. That should be possible in less than 3 seconds with a minor adaption. Try to find this improvement.
    println("Execution time was ${measureExecutionTime { startMultipleComputationsConcurrently() }}")
}

fun structuredConcurrencyTask() {
    println("####  Task structuredConcurrency")

    fun structuredConcurrency() {
        // Imagine we are writing frontend code. The main thread handles the UI and another thread with a lot of coroutines is calling APIs to provide the necessary data.
        // Sometimes the user leaves the current sub-page and we can basically abort the data-fetching coroutines. We certainly do not want to abort every coroutine by hand.
        // For that purpose we have the concept of structured concurrency. We can use the "coroutineScope" Coroutine builder (The coroutine scope is basically the configuration object of a coroutine).
        // This is creating a new coroutine (lets call it parent). When launching other coroutines inside parent, parent waits for all of them to finish.
        // On the other hand, when we abort parent, then parent is trying to abort all children.
        // A Coroutine can be aborted by calling the coroutineContext.cancel() method on its CoroutineScope. That throws a CancellationException.
        // The following code starts five Jobs that each take different time. Abort all Jobs when the first one finished delayedComputation
        runBlocking {
            println("Top-level coroutine started in ${Thread.currentThread().name}")
            try {
                coroutineScope {
                    println("Started computation in ${Thread.currentThread().name}")
                    val jobs = (1..5).map {
                        // launch is another Coroutine builder which starts a Coroutine and returns a Job instance. Unlike asnyc it symbolizes a computation where the result is not needed anymore and we only need to know if it has finished or not.
                        launch {
                            delayedComputation(it * 1000L)
                        }
                    }
                }
            } catch (e: CancellationException) {
                println("Cancelled remaining computations in ${Thread.currentThread().name}")
            }
        }
    }

    println("Execution time was ${measureExecutionTime { structuredConcurrency() }}")
}


fun parallelComputingTask() {
    println("####  Task parallelComputingTask")
    // Maybe you have realized that we have only done concurrent programming but not parallel one. How can we distribute coroutines across different threads?
    // The thread distribution is managed by the Dispatcher which is situated in the CoroutineScope.
    // When launching a new Coroutine, its own CoroutineScope is created and basically inherits the configuration of the scope of its parent. This is another
    // advantage of structured concurrency. We can run multiple coroutines but only have to configure a parent coroutine.
    fun parallelComputing() {
        // Dispatchers.Default uses a thread pool and distributes the coroutines on this pool.
        runBlocking(Dispatchers.Default) {
            // Coroutines are very light-weight. You can even launch 100 000 at the same time without any performance problem.
            (1..100).forEach {
                launch {
                    delayedComputation()
                }
            }
        }
    }

    // Take a look at the console. When a coroutine is suspended running on a particular thread, does it necessarily continue in the same thread?
    // In this exericse you dont have to implement anything ;). You have earned yourself this break.
    parallelComputing()
}

fun measureExecutionTime(codeBlock: () -> Any): Long {
    val start = System.currentTimeMillis()
    codeBlock()
    val executionTime = System.currentTimeMillis() - start
    println("Execution time was $executionTime")
    return executionTime
}
