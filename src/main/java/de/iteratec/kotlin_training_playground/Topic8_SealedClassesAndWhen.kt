package de.iteratec.kotlin_training_playground

import de.iteratec.kotlin_training_playground.CreateUserResult.OtherError
import de.iteratec.kotlin_training_playground.CreateUserResult.Success
import java.util.*
import java.util.UUID.randomUUID

// sealed class
// when as expression
// when -> exhaustive
// extra: KDoc

data class UserCredentials(
    val username: String,
    val password: String
)

data class User(
    val id: UUID = randomUUID(),
    val username: String
)

interface CreateUserResult {
    class Success(val user: User) : CreateUserResult
    class OtherError(val message: String) : CreateUserResult
}

/**
 * Creates the specified user in the database.
 */
fun createUser(credentials: UserCredentials): CreateUserResult {
    // TODO lol, didn't implement the database part

    if (credentials.username.isEmpty()) {
        return OtherError("username is empty")
    }
    return Success(User(username = credentials.username))
}


fun main() {
    val credentials = UserCredentials(
        username = "marc",
        password = "very secure"
    )

    when (createUser(credentials)) {
        is Success -> TODO()
        is OtherError -> TODO()
    }

    task1()
    task2()
}


// ---- Try it yourself!


/**
 * Task 1
 * Replace the if statements with a single when statement.
 */
private fun task1() {
    println("#### Task 1")

    val credentials = UserCredentials(username = "bob", password = "narwhal123")
    val createUserResult = createUser(credentials)
    if (createUserResult is Success) {
        println("User ${createUserResult.user.username} has been created!")
    } else if (createUserResult is OtherError) {
        println("User could not be created.")
    }
}

/**
 * Task 2
 * Replace the if statements with a single when statement. Make 'passwordStrength' immutable and assign is to
 * the value of the 'when' expression.
 */
private fun task2() {
    println("#### Task 2")

    val password = "narwhal123"
    var passwordStrength = "unknown"
    if (password.length in 0..3) {
        passwordStrength = "weak"
    } else if (password.length in 4..12) {
        passwordStrength = "medium"
    } else {
        passwordStrength = "strong"
    }

    println("Password $password has strength '$passwordStrength'")
}