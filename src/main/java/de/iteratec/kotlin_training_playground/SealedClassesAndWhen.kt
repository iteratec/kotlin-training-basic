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
}
