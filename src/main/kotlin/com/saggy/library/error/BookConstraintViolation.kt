package com.saggy.library.error

import java.lang.RuntimeException

data class BookConstraintViolation(override val message: String) : RuntimeException(message)
