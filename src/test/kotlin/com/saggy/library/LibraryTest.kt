package com.saggy.library

import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class LibraryTest {

    @Mock
    private lateinit var bookService: BookService

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
        given(bookService.getBooks()).willReturn(listOf(Book("1", "Harry potter", "J L Rowling", 12000.98)))
        val userId = ""
        val bookId = "1"

        // when
        val result= subject.borrowBook(userId, bookId)

        // then
        assertTrue(result)
    }
}