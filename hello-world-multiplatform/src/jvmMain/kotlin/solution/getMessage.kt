package solution

// "actual" keyword is omitted because there can only be one implementation
fun getPlatformSpecificMessagePart(): String {
    return "JVM thread " + Thread.currentThread().name + " says hello."
}
