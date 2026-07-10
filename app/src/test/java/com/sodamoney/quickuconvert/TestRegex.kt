package com.sodamoney.quickuconvert

import org.junit.Test

class TestRegex {

    @Test
    fun testValidSimpleNumber() {
        assert(VALID_INPUT.matches("12345"))
    }

    @Test
    fun testValidSimpleNegativeNumber() {
        assert(VALID_INPUT.matches("-12345"))
    }
    @Test
    fun testValidSimpleDecimalNumber() {
        assert(VALID_INPUT.matches("123.45"))
    }
    @Test
    fun testValidSimpleNegativeDecimalNumber() {
        assert(VALID_INPUT.matches("-123.45"))
    }
    @Test
    fun testValidExponentNumber() {
        assert(VALID_INPUT.matches("123435E4"))
    }
    @Test
    fun testInvalidNumber() {
        assert(!VALID_INPUT.matches("123,435"))
    }
}