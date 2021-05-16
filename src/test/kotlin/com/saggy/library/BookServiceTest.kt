package com.saggy.library

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class BookServiceTest {

    private val subject = BookService()

    @Test
    fun `getBooks should return empty list when no books available`() {
        //given

        //when
        val result = subject.getBooks()

        //then
        assertTrue(result.isEmpty())
    }

    @Test
    fun `getBooks should return list of available books`() {
        //given
        val book = Book("1", "Harry potter", "J L Rowling", 12000.98)

        //when
        var result = subject.getBooks()

        //then
        assertTrue(result.isEmpty())

        // when
        subject.addBook(book)
        result = subject.getBooks()

        // then
        assertFalse(result.isEmpty())
        assertEquals(book, result[0])

    }

    @Test
    fun `borrowBook - should return true and remove book from library for given book is available in library`() {
        // given
        val bookId = "book-1"
        subject.addBook(Book(bookId, "Harry potter", "J K Rowling", 12000.98))
        subject.addBook(Book("book-2", "Alone on a Wide, Wide Sea", "Michael Morpurgo", 543.98))
        subject.addBook(Book("book-3", "O Jerusalem!", "Larry Collins", 200.8))

        //when
        val result = subject.borrowBook(bookId)

        // then
        assertTrue(result)

        val availableBooks = subject.getBooks()
        assertTrue(availableBooks.size == 2)
        assertTrue(availableBooks.none { it.id == bookId })
    }


    @Test
    fun `borrowBook - should return false for given book is available in library`() {
        // given
        val bookId = "book-1"
        subject.addBook(Book("book-2", "Alone on a Wide, Wide Sea", "Michael Morpurgo", 543.98))
        subject.addBook(Book("book-3", "O Jerusalem!", "Larry Collins", 200.8))

        //when
        val result = subject.borrowBook(bookId)

        // then
        assertFalse(result)
        assertTrue(subject.getBooks().size == 2)
    }


}