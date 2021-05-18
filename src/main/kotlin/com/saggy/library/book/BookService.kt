package com.saggy.library.book

class BookService {

    private val books = mutableMapOf<String, Book>()

    fun getBooks(): List<Book> {
        return books.values.toList()
    }

    fun addBook(book: Book) {
        var curBook = books[book.id]
        if (curBook == null) {
            curBook = book
            books[curBook.id] = curBook
        } else {
            curBook.count += book.count
        }
    }

    fun removeBook(bookId: String): Book {

        if (!books.containsKey(bookId)) {
            throw RuntimeException("Book `$bookId` is not present in library")
        }
        val book = books[bookId]!!
        if (--book.count == 0) {
            books.remove(bookId)
        }

        return book.copy(count = 0)
    }
}
