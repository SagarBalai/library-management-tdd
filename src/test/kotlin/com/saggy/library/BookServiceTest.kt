package com.saggy.library

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class BookServiceTest {

    @Test
    fun `getBooks should return empty list when no books available`() {
        //given
        val subject = BookService()

        //when
        val result = subject.getBooks()

        //then
        assertTrue(result.isEmpty())
    }

    @Test
    fun `getBooks should return list of available books`() {
        //given
        val subject = BookService()

        //when
        var result = subject.getBooks()

        //then
        assertTrue(result.isEmpty())

        // when
        subject.addBook(Book("1", "Harry potter", "J L Rowling", 12000.98))
        result = subject.getBooks()

        // then
        assertFalse(result.isEmpty())

    }


}