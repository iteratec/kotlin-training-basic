package de.iteratec.kotlin.basic.solutions

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import java.util.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class CustomLazy<V>(val generator: () -> V) : ReadWriteProperty<Any, V> {
    var storedValue: V? = null

    override operator fun getValue(thisRef: Any, property: KProperty<*>): V {
        return storedValue ?: run {
            storedValue = generator()
            storedValue!!
        }
    }

    override operator fun setValue(thisRef: Any, property: KProperty<*>, value: V) {
        this.storedValue = value
    }
}

class DisallowRepetition<V>(private val initial: V) : ReadWriteProperty<Any, V> {
    var historicValues: LinkedList<V> = LinkedList(listOf(initial))

    override operator fun getValue(thisRef: Any, property: KProperty<*>): V {
        return historicValues.last
    }

    override operator fun setValue(thisRef: Any, property: KProperty<*>, value: V) {
        if (historicValues.contains(value)) {
            throw RepetitionException()
        } else {
            historicValues.addLast(value)
        }
    }
}

class DelegationTasks {

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
}

class LazyDelegationExample {
    val property: String by CustomLazy {
        println("Evaluated lazy generator.")
        "Lazy property"
    }
}

class RepetitionDisallowedDelegationExample(initialPassword: String) {
    var password: String by DisallowRepetition(initialPassword)
}

class RepetitionException: RuntimeException("Setting to a previous value is not allowed")
