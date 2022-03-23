package de.iteratec.kotlin.playground

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.concurrent.atomic.AtomicLong

// VERY IMPORTANT
// Change the Run configuration of these tests in the way that you add the VM option "-Dkotlinx.coroutines.debug".
// Then you always see which coroutine is currently logging a statement.
class T17CoroutinesTasks {

    // We are making two independent calls that each take one second and combine the results. That should be possible in less than 2 seconds with a minor adaption. Try to find this improvement.
    @Test
    fun startMultipleComputationsConcurrentlyTask() {
        fun startMultipleComputationsConcurrently() {
            runBlocking {
                val deferredResult1: Deferred<Long> = async {
                    delayedComputation()
                }
                val result1 = deferredResult1.await()

                val deferredResult2: Deferred<Long> = async {
                    delayedComputation()
                }
                val result2 = deferredResult2.await()

                val result = result1 + result2
                println("Result is ${result}")
            }
        }

        val executionTime = measureExecutionTime { startMultipleComputationsConcurrently() }
        println("Execution time: $executionTime")
        assertTrue(executionTime <= 1500)
    }

    // We are starting 5 asynchronous coroutines simultaneously (see deferredResults). Stop all coroutines when the first one is completed successfully.
    // You can cancel a job from inside with coroutineScope.cancel() on an appropriate coroutineContext.
    // Assign the result of the first completed async task as the return value of structuredConcurrency.
    @Test
    fun structuredConcurrencyTask() {
        fun structuredConcurrency(): Long {
            // Using a thread-safe type
            var result: AtomicLong = AtomicLong(0L)
            runBlocking {
                try {
                    val job = launch {
                        println("Started computation in ${Thread.currentThread().name}")
                        val deferredResults = (1..5).map {
                            async {
                                delayedComputation(it * 1000L)
                            }
                        }
                    }
                } catch (e: CancellationException) {
                    println("Cancelled remaining computations in ${Thread.currentThread().name}")
                }
            }

            return result.get()
        }


        var result = 0L
        val executionTime = measureExecutionTime {
            structuredConcurrency().also { result = it }
        }
        println("Execution time: $executionTime")
        assertThat(result, equalTo(1000L))
        assertTrue(executionTime <= 2000)
    }
}
