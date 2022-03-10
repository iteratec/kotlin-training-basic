package solution

import getGreetingMessage

// Add the Thread name to the message. You can access classes from the Java standard library.
// Start the application with ./gradlew hello-world-multiplatform:run

fun main() {
    println(getGreetingMessage())
}

// "actual" keyword is omitted because there can only be one implementation
fun getPlatformSpecificMessagePart(): String {
    return "JVM thread " + Thread.currentThread().name + " says hello."
}
