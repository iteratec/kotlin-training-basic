package de.iteratec.kotlin.playground

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertTrue
import org.junit.Test

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
    // Assign the result as the return value of structuredConcurrency.
    @Test
    fun structuredConcurrencyTask() {
        fun structuredConcurrency(): Long {
            var result = 0L
            runBlocking {
                coroutineScope {
                    println("Started computation in ${Thread.currentThread().name}")
                    val deferredResults = (1..5).map {
                        // launch is another Coroutine builder which starts a Coroutine and returns a Job instance. Unlike asnyc it symbolizes a computation where the result is not needed anymore and we only need to know if it has finished or not.
                        async {
                            result = delayedComputation(it * 1000L)
                        }
                    }
                }
            }

            return result
        }


        var result = 0L
        val executionTime = measureExecutionTime {
            result = structuredConcurrency()
            Unit
        }
        println("Execution time: $executionTime")
        assertThat(result, equalTo(1000L))
        assertTrue(executionTime <= 2000)
    }
}
