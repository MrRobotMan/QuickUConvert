package com.sodamoney.quickuconvert

import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal
import java.math.MathContext

/**
 * Testing that derived units give the correct values.
 */
class AccelerationTests {

    @Test
    fun testInchPerSecondSquared() {
        val expected = BigDecimal("0.0254")
        val actual = InchPerSecondSquared.convertTo(BigDecimal.ONE, MeterPerSecondSquared)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testFootPerSecondSquared() {
        val expected = BigDecimal(0.3048, MathContext.DECIMAL64)
        val actual = FootPerSecondSquared.convertTo(BigDecimal.ONE, MeterPerSecondSquared)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testCentimeterPerSecondSquared() {
        val expected = BigDecimal("0.01")
        val actual = CentimeterPerSecondSquared.convertTo(BigDecimal.ONE, MeterPerSecondSquared)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testMillimeterPerSecondSquared() {
        val expected = BigDecimal("0.001")
        val actual = MillimeterPerSecondSquared.convertTo(BigDecimal.ONE, MeterPerSecondSquared)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testEarthGravity() {
        val expected = BigDecimal("9.80665")
        val actual = EarthGravity.convertTo(BigDecimal.ONE, MeterPerSecondSquared)
        assertEquals((expected /actual).compareTo(BigDecimal.ONE), 0)
    }
}
