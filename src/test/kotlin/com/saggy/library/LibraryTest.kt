package com.saggy.library

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class LibraryTest {


    @Test
    fun `getAllBooks should return empty list when no book`() {
        // given
        val subject = Library()

        //when
        val result = subject.getAllBooks()

        // then
        assertTrue(result.isEmpty())
    }

    @Test
    fun `getAllBooks should return 1 element list when one book is available`() {
        // given
        val subject = Library()

        //when
        val result = subject.getAllBooks()

        // then
        assertEquals(1, result.size)
    }
}