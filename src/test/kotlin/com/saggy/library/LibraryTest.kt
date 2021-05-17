package com.saggy.library

import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.BDDMockito.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

internal class LibraryTest {

    @Mock
    private lateinit var bookService: BookService

    @Mock
    private lateinit var userService: UserService

    @InjectMocks
    private lateinit var subject: Library

    @Before
    fun init() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `getAllBooks should return empty list when library dont have any book`() {
        // given
        given(bookService.getBooks()).willReturn(emptyList())

        // when
        val result = subject.getAllBooks()

        // then
        assertTrue(result.isEmpty())
    }

    @Test
    fun `getAllBooks should return 1 element list when one book is available`() {
        // given
        given(bookService.getBooks()).willReturn(listOf(Book("1", "Harry potter", "J L Rowling", 12000.98)))

        // when
        val result = subject.getAllBooks()

        // then
        assertEquals(1, result.size)
    }

    @Test
    fun `borrowBook -- happy path`() {
        // given
        val userId = "user-1"
        val bookId = "book-1"
        val book = Book("book-3", "Harry Potter", "J K Rolling", 123.4)

        given(bookService.borrowBook(anyString())).willReturn(book)
        given(userService.addBook(anyString(), anyString())).willReturn(true)

        // when
        val result = subject.borrowBook(userId, bookId)

        // then
        verify(bookService).borrowBook(bookId)
        verify(userService).addBook(userId, bookId)
        assertTrue(result)
    }

    @Test
    fun `borrowBook -- should not add book to user when given book is not available in library`() {
        // given
        val userId = "user-1"
        val bookId = "book-1"
        given(bookService.borrowBook(bookId)).willThrow(RuntimeException("Book book-1 is not present in library"))

        // when
        val result = assertFailsWith<RuntimeException> {
            val a = subject.borrowBook(userId, bookId)
            println(a)
        }

        // then
        assertEquals("Book book-1 is not present in library", result.message)
        verify(bookService).borrowBook(bookId)
        verifyNoInteractions(userService)
    }

    @Test
    fun `borrowBook -- should not add third book for given user`() {
        // given
        val userId = "user-1"
        val book = Book("book-3", "Harry Potter", "J K Rolling", 123.4)
        given(bookService.borrowBook(anyString())).willReturn(book)
        given(userService.addBook(userId, book.id)).willReturn(false)

        // when
        val result = subject.borrowBook(userId, book.id)

        // then
        verify(bookService).borrowBook(book.id)
        verify(userService).addBook(userId, book.id)
        verify(bookService).addBook(book)
        assertTrue(result)
    }

}