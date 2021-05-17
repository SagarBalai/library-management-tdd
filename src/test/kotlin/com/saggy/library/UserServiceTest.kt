package com.saggy.library

import com.saggy.library.error.UserNotFoundException
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

internal class UserServiceTest {

    private val userService = UserService()

    @Test
    fun `addBook - should return true -- happy path`() {
        // given
        val userId = "user-1"
        val bookId = "book-1"

        userService.addUser(User(userId, "Sagar"))

        // when
        val result = userService.addBook(userId, bookId)

        // then
        assertTrue { result }
        val books = userService.get(userId).getBooks
        assertEquals(1, books.size)
        assertEquals(bookId, books[0])
    }

    @Test
    internal fun `addUser - should add and retrieve same user`() {
        // given
        val id = "user-1"
        val name = "Sagar"

        // when
        userService.addUser(User(id, name))

        // then
        val user = userService.get(id)
        assertNotNull(user)
        assertEquals(id, user.id)
        assertEquals(name, user.name)
    }

    @Test
    internal fun `get - should throw exception when user is not present`() {
        // given

        // when
        val result = assertFailsWith<UserNotFoundException> { userService.get("user-1") }

        // then
        assertEquals("user `user-1` not present", result.message)
    }
}