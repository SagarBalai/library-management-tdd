package com.saggy.library

class Library(private val bookService: BookService, private val userService: UserService) {

    fun getAllBooks(): List<Book> {
        return bookService.getBooks()
    }

    fun borrowBook(userId: String, bookId: String): Boolean {
        var borrowBook = bookService.borrowBook(bookId)
        if (borrowBook != null) {
            val added = userService.addBook(userId, bookId)
            if (!added) {
                bookService.addBook(borrowBook)
            }
            return true
        }
        return false
    }


}