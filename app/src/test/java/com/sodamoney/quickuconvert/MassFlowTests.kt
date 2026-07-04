package com.sodamoney.quickuconvert

import org.junit.Test
import org.junit.Assert.*

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

class MassFlowTests {

    @Test
    fun testKilogramPerMinute() {
        val expected = BigDecimal(1).divide(BigDecimal(60), MathContext.DECIMAL64)
        val actual = KilogramPerMinute.convertTo(BigDecimal(1), KilogramPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testKilogramPerHour() {
        val expected = BigDecimal(1).divide(BigDecimal(3600), MathContext.DECIMAL64)
        val actual = KilogramPerHour.convertTo(BigDecimal(1), KilogramPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testGramPerSecond() {
        val expected = BigDecimal(1).divide(BigDecimal(1000), MathContext.DECIMAL64)
        val actual = GramPerSecond.convertTo(BigDecimal(1), KilogramPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testGramPerMinute() {
        val expected = BigDecimal(1).divide(BigDecimal(60_000), MathContext.DECIMAL64)
        val actual = GramPerMinute.convertTo(BigDecimal(1), KilogramPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testGramPerHour() {
        val expected = BigDecimal(1).divide(BigDecimal(3_600_000), MathContext.DECIMAL64)
        val actual = GramPerHour.convertTo(BigDecimal(1), KilogramPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testPoundPerSecond() {
        val expected = BigDecimal("0.45359237")
        val actual = PoundPerSecond.convertTo(BigDecimal(1), KilogramPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testPoundPerMinute() {
        val expected = BigDecimal("0.45359237").divide(BigDecimal(60), MathContext.DECIMAL64).setScale(16, RoundingMode.HALF_EVEN)
        val actual = PoundPerMinute.convertTo(BigDecimal(1), KilogramPerSecond).setScale(16, RoundingMode.HALF_EVEN)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testPoundPerHour() {
        val expected = BigDecimal("0.45359237").divide(BigDecimal(3600), MathContext.DECIMAL64)
        val actual = PoundPerHour.convertTo(BigDecimal(1), KilogramPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testOuncePerSecond() {
        val expected = BigDecimal("0.028349523125")
        val actual = OuncePerSecond.convertTo(BigDecimal(1), KilogramPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testOuncePerMinute() {
        val expected = BigDecimal("0.0004724920520833333")
        val actual = OuncePerMinute.convertTo(BigDecimal(1), KilogramPerSecond)
        println(actual)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testOuncePerHour() {
        val expected = BigDecimal("0.000007874867534722221")
        val actual = OuncePerHour.convertTo(BigDecimal(1), KilogramPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }
}

