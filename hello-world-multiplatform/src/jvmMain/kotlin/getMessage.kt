// Add the Thread name to the message
// Afterwards start the application with ./gradlew run

actual fun getPlatformSpecificMessagePart(): String {
    return "JVM thread " + "" + " says hello."
}
