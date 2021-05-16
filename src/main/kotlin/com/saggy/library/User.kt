package com.saggy.library

data class User(val id: String, val name: String) {
    private val bookList = mutableListOf<String>()

    val getBooks = bookList

    fun addBook(bookId: String) {
        bookList.add(bookId)
    }

}