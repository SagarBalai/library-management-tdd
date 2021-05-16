package com.saggy.library

class BookService {

    private val books = mutableMapOf<String, Book>()

    fun getBooks(): List<Book> {
        return books.values.toList()
    }

    fun addBook(book: Book) {
        books[book.id] = book
    }

    fun borrowBook(bookId: String): Boolean {
        return books.remove(bookId) !=null
    }
}
