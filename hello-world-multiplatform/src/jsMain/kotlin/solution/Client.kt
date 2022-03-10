package solution

import getGreetingMessage

// Return a String representation of the dynamic JS object instead of [object Object] in the message.
// Imagine how you would do it in Javascript and try to use the "same" code here.
// Start the application with ./gradlew hello-world-multiplatform:jsRun

fun main() {
    println(getGreetingMessage())
}

// "actual" keyword is omitted because there can only be one implementation
fun getPlatformSpecificMessagePart(): String {
    // These lines create a Javascript object {runtime: "nodeJS", poweredByKotlin: true}.
    // For the moment, we do not need to understand the syntax
    val javaScriptObject: dynamic = object{}
    javaScriptObject["runtime"] = "nodeJs"
    javaScriptObject["poweredByKotlin"] = true

    return JSON.stringify(javaScriptObject)
}