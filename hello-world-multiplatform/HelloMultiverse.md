Required knowledge: -

# Multiplattform

Since Kotlin can be transpiled to many languages, we want to say hello world using different runtimes (JVM, Node, native == your OS).

There is the shared module <b> commonMain </b> which defines a Greeter class which is used on every platform. 
It defines a function <b> getPlatformSpecificMessagePart </b> marked with the <b> expect </b> keyword.
This means that it expects each platform-specific module to implement this function in its own way.

Go to each of the three submodules and jump into the file <b> getMessage.kt </b>. Adapt the implementation of <b> getPlatformSpecificMessagePart </b>, ideally by using platform-specific Kotlin. Start the associated application to verify the result.


