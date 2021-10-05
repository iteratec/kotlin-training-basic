// Return a String representation of the dynamic JS object instead of [object Object]

actual fun getPlatformSpecificMessagePart(): String {
    val javaScriptObject: dynamic = object{}
    javaScriptObject["runtime"] = "nodeJs"
    javaScriptObject["poweredByKotlin"] = true

    return javaScriptObject
}