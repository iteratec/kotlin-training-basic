package de.iteratec.kotlin.bestpractises.solutions

import kotlin.random.Random

/**
 * # classes
 *
 *  - use data class for value objects, dto's, ... (like Java POJO)
 *  - use class for Services, Repositories, ...
 *  - use sealed class for hierarchies
 */

sealed class Response {
    object Success : Response()

    data class Error(val msg: String) : Response()
}

data class UserDto(val name: String, val email: String, val age:Int)

class UserService(private val dao: UserDao) {

    fun save(user: UserDto): Response {
        if (user.age > MAX_AGE) {
            println("$user too old")
            return Response.Error("too old")
        }

        return dao.save(user)
    }

    companion object {
        const val MAX_AGE = 99
    }
}

class UserDao {
    fun save(user: UserDto): Response {
        if (Random.nextBoolean()) {
            println("saved $user")
            return Response.Success
        }
        return Response.Error("error during save")
    }
}

fun main() {
    val user = UserDto("John Smith", "js@mail.com", 33)

    val service = UserService(UserDao())

    val result = service.save(user)

    when(result) {
        is Response.Success -> println("success")
        is Response.Error -> println("error: ${result.msg}")
    }

    login(Username(user.name), Password("top secret!!!"))
}

@JvmInline
value class Username(private val value: String)

@JvmInline
value class Password(private val value: String)

fun login(userName: Username, password: Password) {
    println("$userName successfully logged in with $password")
}