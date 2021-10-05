package solution

// "actual" keyword is omitted because there can only be one implementation
fun getPlatformSpecificMessagePart(): String {
    return "Your faithful OS " + Platform.osFamily.name + " is serving to fulfill your desires"
}
