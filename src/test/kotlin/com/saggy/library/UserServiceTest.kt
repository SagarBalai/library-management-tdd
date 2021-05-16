package com.saggy.library

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

internal class UserServiceTest {

    @Test
    fun `addBook - should return true -- happy path`() {
        // given
        val userService = UserService()

        // when
        val result = userService.addBook("user-1", "book-1")

        // then
        assertTrue { result }

    }
}