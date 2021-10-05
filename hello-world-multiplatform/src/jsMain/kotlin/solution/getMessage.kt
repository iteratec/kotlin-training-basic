package solution

// "actual" keyword is omitted because there can only be one implementation
fun getPlatformSpecificMessagePart(): String {
    val javaScriptObject: dynamic = object{}
    javaScriptObject["runtime"] = "nodeJs"
    javaScriptObject["poweredByKotlin"] = true

    return JSON.stringify(javaScriptObject)
}