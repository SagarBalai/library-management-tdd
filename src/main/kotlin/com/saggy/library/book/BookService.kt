package com.saggy.library.book

class BookService {

    private val books = mutableMapOf<String, Book>()

    fun getBooks(): List<Book> {
        return books.values.toList()
    }

    fun addBook(book: Book) {
        books[book.id] = book
    }

    fun borrowBook(bookId: String): Book {
        if (!books.containsKey(bookId)) {
            throw RuntimeException("Book `$bookId` is not present in library")
        }
        return books.remove(bookId)!!
    }
}
