package com.saggy.library

class Library(private val bookService: BookService, val userService: UserService) {

    fun getAllBooks(): List<Book> {
        return bookService.getBooks()
    }

    fun borrowBook(userId: String, bookId: String): Boolean {
        var borrowBook = bookService.borrowBook(bookId)
        if (borrowBook) {
            userService.addBook(bookId)
            return true
        }
        return false
    }


}