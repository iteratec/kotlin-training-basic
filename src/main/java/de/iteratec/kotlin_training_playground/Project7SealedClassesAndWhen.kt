package de.iteratec.kotlin_training_playground

import de.iteratec.kotlin_training_playground.CreateUserResult.*
import java.util.*
import java.util.UUID.randomUUID

data class UserCredentials(
    val username: String,
    val password: String
)

data class User(
    val id: UUID = randomUUID(),
    val username: String
)

sealed class CreateUserResult {
    class Success(val user: User) : CreateUserResult()
    class OtherError(val message: String) : CreateUserResult()
    class UserDoesAlreadyExist(val username: String) : CreateUserResult()
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

    val result = createUser(credentials)
    val message = when (result) {
        is Success -> "User ${result.user.username} created"
        is OtherError -> "Other error occurred: ${result.message}"
        is UserDoesAlreadyExist -> "Error: user ${result.username} does already exist"
    }
    println(message)
}

// show sealed class

// show when usage

// when as expression

// when -> exhaustive

// extra: KDoc
