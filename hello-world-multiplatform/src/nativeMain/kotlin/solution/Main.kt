package solution

import getGreetingMessage

// Add the name of your operating system to the message. Use the "Platform" module from the Kotlin native library to achieve this.
// Start the application with ./gradlew hello-world-multiplatform:runDebugExecutableNative. On Ubuntu, I had to install some package before it worked.
fun main() {
    println(getGreetingMessage())
}

// "actual" keyword is omitted because there can only be one implementation
fun getPlatformSpecificMessagePart(): String {
    return "Your faithful OS " + Platform.osFamily + " is serving to fulfill your desires"
}

