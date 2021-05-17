package com.saggy.library.error

data class BookConstraintViolation(override val message: String) : RuntimeException(message)
