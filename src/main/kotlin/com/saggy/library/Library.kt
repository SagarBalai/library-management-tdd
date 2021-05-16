package com.saggy.library

class Library(private val bookService: BookService) {

    fun getAllBooks():List<Book>{
        return bookService.getBooks()
    }
}