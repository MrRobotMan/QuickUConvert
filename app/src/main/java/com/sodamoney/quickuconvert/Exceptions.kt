package com.sodamoney.quickuconvert

/*
 * Copyright 2026 David Weiss
 *
 * Unit converter exceptions and errors
 */

class IllegalConversionException(message: String? = null, cause: Throwable? = null) : Exception(message, cause)
class UnknownCategoryException(message: String? = null, cause: Throwable? = null) : Exception(message, cause)