expect fun getPlatformSpecificMessagePart(): String

fun getGreetingMessage(): String {
    return "Welcome to Kotlin! " + getPlatformSpecificMessagePart()
}

