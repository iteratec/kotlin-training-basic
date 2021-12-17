// Return a String representation of the dynamic JS object instead of [object Object] in the message
// Afterwards start the application with ./gradlew jsRun

actual fun getPlatformSpecificMessagePart(): String {
    val javaScriptObject: dynamic = object{}
    javaScriptObject["runtime"] = "nodeJs"
    javaScriptObject["poweredByKotlin"] = true

    return javaScriptObject
}