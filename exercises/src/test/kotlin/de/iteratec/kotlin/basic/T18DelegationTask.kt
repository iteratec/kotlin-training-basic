package de.iteratec.kotlin.basic

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class DisallowRepetition<V>(private val initial: V) : ReadWriteProperty<Any, V> {
    override operator fun getValue(thisRef: Any, property: KProperty<*>): V {
        return initial
    }

    override operator fun setValue(thisRef: Any, property: KProperty<*>, value: V) {
    }
}

class DelegationTasks {
    /**
     * ## disallowRepetitionDelegate
     * Replace the code of DisallowRepetition such that it disallows setting the property to a previous value.
     */
    @Test
    fun disallowRepetitionDelegate() {
        val initialPassword = "initialSuperSafe123"
        val newPassword = "evenSafer123!"

        val example = RepetitionDisallowedDelegationExample(initialPassword)
        assertEquals(initialPassword, example.password)
        example.password = newPassword
        assertEquals(newPassword, example.password)
        assertThrows(RepetitionException::class.java) {
            example.password = initialPassword
        }
    }

    /**
     * ## customLazyPropertyDelate
     * Replace the call to "lazy" in lazyDelegationExample with a call to a custom class written by yourself.
     * The test log "Constructed instance" and afterwards "Evaluated lazy generator." once.
     */
    @Test
    fun customLazyPropertyDelate() {
        val lazyDelegator = LazyDelegationExample()
        println("Constructed instance")
        lazyDelegator.property
        lazyDelegator.property
    }
}

class RepetitionDisallowedDelegationExample(initialPassword: String) {
    var password: String by DisallowRepetition(initialPassword)
}

class RepetitionException: RuntimeException("Setting to a previous value is not allowed")


class LazyDelegationExample {
    val property: String by lazy {
        println("Evaluated lazy generator.")
        "Lazy property"
    }
}