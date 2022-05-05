package de.iteratec.kotlin.playground

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// Sometimes we want to enrich properties of classes with further logic. In order to make this logic reusable Kotlin has the concept of property delegation.

class DelegationExample() {
    // On the right-side of the "by"-keyword an instance of the delegate class is instantiated. Calls to the getter or setter of the property will be delegated to methods of the instance.
    var underSurveillanceVariable: String by UnderSurveillanceDelegate("underSurveillanceVariable")
    val lazyLoadedVariable: String by lazy {
        println("Initialized lazyLoadedVariable")
        "lazyLoadedVariable"
    }
}

class UnderSurveillanceDelegate<V: Any>(var storedValue: V) : ReadWriteProperty<Any, V> {
    override operator fun getValue(thisRef: Any, property: KProperty<*>): V {
        println("Somebody is accessing property with name ${property.name} on ${thisRef} with value $storedValue")
        return storedValue
    }

    override operator fun setValue(thisRef: Any, property: KProperty<*>, value: V) {
        println("Somebody is setting property with name ${property.name} on ${thisRef} to $value")
        this.storedValue = value
    }
}

fun main() {
    val example = DelegationExample()
    example.underSurveillanceVariable
    example.underSurveillanceVariable = "newValue"
    example.lazyLoadedVariable // Only logs message now.
    example.lazyLoadedVariable // Only logs once.
}