// Add the type of your operating system to the message. Use a call of the form "Platform.xyz" from the Kotlin native library to achieve this.
// Start the application with ./gradlew hello-world-multiplatform:runDebugExecutableNative. On Ubuntu, I had to install some package before it worked.
fun main() {
    println(getGreetingMessage())
}

actual fun getPlatformSpecificMessagePart(): String {
    return "Your faithful OS " + "TODO: Replace me" + " is serving to fulfill your desires"
}
