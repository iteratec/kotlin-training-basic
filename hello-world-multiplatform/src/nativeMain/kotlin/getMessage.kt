// Add the name of your operating system to the message
// Afterwards run the application with ./gradlew runDebugExecutableNative. On Ubuntu, I had to install some package before it worked.
actual fun getPlatformSpecificMessagePart(): String {
    return "Your faithful OS " + "" + " is serving to fulfill your desires"
}