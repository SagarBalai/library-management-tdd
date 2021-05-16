package com.saggy.library

class UserService {

    private val users = mutableMapOf<String, User>()

    fun addBook(userId: String, bookId: String): Boolean {
        val user = get(userId)
        user.addBook(bookId)
        return true
    }

    fun get(userId: String): User {
        return users[userId]!!
    }

    fun addUser(user: User) {
        users[user.id] = user
    }

}
