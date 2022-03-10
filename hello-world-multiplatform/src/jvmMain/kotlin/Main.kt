// Add the Thread name to the message. You can access classes from the Java standard library.
// Start the application with ./gradlew hello-world-multiplatform:run

fun main() {
    println(getGreetingMessage())
}

actual fun getPlatformSpecificMessagePart(): String {
    return "JVM thread " + "TODO: Replace me" + " says hello."
}
