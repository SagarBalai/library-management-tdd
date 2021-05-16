package com.saggy.library

class BookService {

    private val books = mutableListOf<Book>()

    fun getBooks(): List<Book> {
        return books
    }

    fun addBook(book: Book) {
        books.add(book)
    }

    fun borrowBook(bookId: String): Boolean {
        return false
    }
}
