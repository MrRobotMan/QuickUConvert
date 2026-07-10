package com.sodamoney.quickuconvert

import org.junit.Test
import org.junit.Assert.*

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

class MassFlowTests {

    @Test
    fun testKilogramPerMinute() {
        val expected = BigDecimal.ONE.divide(BigDecimal(60), MathContext.DECIMAL64)
        val actual = KilogramPerMinute.convertTo(BigDecimal.ONE, KilogramPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testKilogramPerHour() {
        val expected = BigDecimal.ONE.divide(BigDecimal(3600), MathContext.DECIMAL64)
        val actual = KilogramPerHour.convertTo(BigDecimal.ONE, KilogramPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testGramPerSecond() {
        val expected = BigDecimal.ONE.divide(BigDecimal(1000), MathContext.DECIMAL64)
        val actual = GramPerSecond.convertTo(BigDecimal.ONE, KilogramPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testGramPerMinute() {
        val expected = BigDecimal.ONE.divide(BigDecimal(60_000), MathContext.DECIMAL64)
        val actual = GramPerMinute.convertTo(BigDecimal.ONE, KilogramPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testGramPerHour() {
        val expected = BigDecimal.ONE.divide(BigDecimal(3_600_000), MathContext.DECIMAL64)
        val actual = GramPerHour.convertTo(BigDecimal.ONE, KilogramPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testPoundPerSecond() {
        val expected = BigDecimal("0.45359237")
        val actual = PoundPerSecond.convertTo(BigDecimal.ONE, KilogramPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testPoundPerMinute() {
        val expected = BigDecimal("0.45359237").divide(BigDecimal(60), MathContext.DECIMAL64).setScale(16, RoundingMode.HALF_EVEN)
        val actual = PoundPerMinute.convertTo(BigDecimal.ONE, KilogramPerSecond).setScale(16, RoundingMode.HALF_EVEN)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testPoundPerHour() {
        val expected = BigDecimal("0.45359237").divide(BigDecimal(3600), MathContext.DECIMAL64)
        val actual = PoundPerHour.convertTo(BigDecimal.ONE, KilogramPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testOuncePerSecond() {
        val expected = BigDecimal("0.028349523125")
        val actual = OuncePerSecond.convertTo(BigDecimal.ONE, KilogramPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testOuncePerMinute() {
        val expected = BigDecimal("0.0004724920520833333")
        val actual = OuncePerMinute.convertTo(BigDecimal.ONE, KilogramPerSecond)
        println(actual)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testOuncePerHour() {
        val expected = BigDecimal("0.000007874867534722221")
        val actual = OuncePerHour.convertTo(BigDecimal.ONE, KilogramPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
}

