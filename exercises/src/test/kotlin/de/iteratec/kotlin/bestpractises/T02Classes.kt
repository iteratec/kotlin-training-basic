package de.iteratec.kotlin.bestpractises

import kotlin.random.Random

/**
 * # classes
 *
 *  - use data class for value objects, dto's, ... (like Java POJO)
 *  - use class for Services, Repositories, ...
 *  - use sealed class for hierarchies
 */

enum class Response {
    SUCCESS, ERROR_TOO_OLD, ERROR
}

class UserDto(var name: String, var email: String, var age:Int)

data class UserService(val dao: UserDao) {

    val MAX_AGE = 99

    fun save(user: UserDto): Response {
        if (user.age > MAX_AGE) {
            println("$user too old")
            return Response.ERROR_TOO_OLD
        }

        return dao.save(user)
    }

}

class UserDao() {
    fun save(user: UserDto): Response {
        if (Random(1).nextBoolean()) {
            println("saved $user")
            return Response.SUCCESS
        }
        return Response.ERROR
    }
}

class UserUtils() {
    fun login(userName: String, password: String) {
        println("$userName successfully logged in with $password")
    }
}

fun main() {
    val user = UserDto("John Smith", "js@mail.com", 33)

    val service = UserService(UserDao())

    val result = service.save(user)

    if (result == Response.SUCCESS) {
        println("Success")
    } else if(result == Response.ERROR_TOO_OLD) {
        println("too old")
    } else {
        println("error")
    }

    val utils = UserUtils()

    utils.login(user.name, "top secret!!!")
}