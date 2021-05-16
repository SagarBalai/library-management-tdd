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

    @Test
    fun `borrowBook - should return true and remove book from library for given book is available in library`() {
        // given
        val subject = BookService()
        subject.addBook(Book("book-1", "Harry potter", "J K Rowling", 12000.98))
        subject.addBook(Book("book-2", "Alone on a Wide, Wide Sea", "Michael Morpurgo", 543.98))
        subject.addBook(Book("book-3", "O Jerusalem!", "Larry Collins", 200.8))

        //when
        val result = subject.borrowBook("book-1")

        // then
        assertTrue(result)
    }


}