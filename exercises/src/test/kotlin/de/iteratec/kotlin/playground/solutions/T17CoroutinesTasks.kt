package de.iteratec.kotlin.playground.solutions

import de.iteratec.kotlin.playground.delayedComputation
import de.iteratec.kotlin.playground.measureExecutionTime
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.concurrent.atomic.AtomicLong
import kotlin.random.Random

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
                val deferredResult2: Deferred<Long> = async {
                    delayedComputation()
                }

                val result1 = deferredResult1.await()
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
            var result: AtomicLong = AtomicLong(0L)
            runBlocking {
                try {
                    val job = launch {
                        println("Started computation in ${Thread.currentThread().name}")
                        val deferredResults = (1..5).map {
                            async {
                                val computationResult = delayedComputation(it * 1000L)
                                result.set(computationResult)
                                this@launch.cancel()
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

    /**
     * Lets play a 2-player-game:
     * Alice is provided a starting integer > 0 and play goes in turns.
     * A players turn starts by receiving an integer. She/He then decrements the integer by 1, 2 or 3 and sends it to the other player.
     * A player can claim a win when receiving an integer <= 0.
     *
     * Implement this game using channels. Simulate the decision with the random generator.
     * Print a line indicating whats going on in each move.
     * Hint: Terminate your program by closing both channels.
     */
    @Test
    fun nimGame() {
        val startValue = 20
        val aliceToBobChannel = Channel<Int>()
        val bobToAliceChannel = Channel<Int>()

        runBlocking {
            withTimeout(5000) {
                val aliceConsuming = async { makeMoves(bobToAliceChannel, aliceToBobChannel, 1) }
                val bobConsuming = async { makeMoves(aliceToBobChannel, bobToAliceChannel, 2) }
                aliceToBobChannel.send(startValue)
            }
        }
    }
}

val random = Random

suspend fun makeMoves(receiveChannel: Channel<Int>, sendChannel: Channel<Int>, playerNumber: Int) {
    for (input in receiveChannel) {
        if (input <= 0) {
            sendChannel.close()
            receiveChannel.close()
            println("Player ${playerNumber} claims win on ${input}")
        } else {
            println("Player ${playerNumber} received ${input}")
            sendChannel.send(input - random.nextInt(1, 4))
        }
    }
}
