package com.sodamoney.quickuconvert

import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal
import java.math.MathContext

class LengthTests {
    @Test
    fun testKilometer() {
        val expected = BigDecimal(1000)
        val actual = Kilometer.convertTo(BigDecimal.ONE, Meter)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testCentimeter() {
        val expected = BigDecimal("0.01")
        val actual = Centimeter.convertTo(BigDecimal.ONE, Meter)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testMillimeter() {
        val expected = BigDecimal("0.001")
        val actual = Millimeter.convertTo(BigDecimal.ONE, Meter)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testMicrometer() {
        val expected = BigDecimal("1E-6")
        val actual = Micrometer.convertTo(BigDecimal.ONE, Meter)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testNanometer() {
        val expected = BigDecimal("1E-9")
        val actual = Nanometer.convertTo(BigDecimal.ONE, Meter)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testInch() {
        val expected = BigDecimal("0.0254")
        val actual = Inch.convertTo(BigDecimal.ONE, Meter)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testFoot() {
        val expected = BigDecimal("0.3048")
        val actual = Foot.convertTo(BigDecimal.ONE, Meter)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testYard() {
        val expected = BigDecimal("0.9144")
        val actual = Yard.convertTo(BigDecimal.ONE, Meter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testMile() {
        val expected = BigDecimal("1609.344")
        val actual = Mile.convertTo(BigDecimal.ONE, Meter)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testThou() {
        val expected = BigDecimal("0.0000254")
        val actual = Thou.convertTo(BigDecimal.ONE, Meter)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testNauticalMile() {
        val expected = BigDecimal(1852)
        val actual = NauticalMile.convertTo(BigDecimal.ONE, Meter)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testFathom() {
        val expected = BigDecimal("1.8288")
        val actual = Fathom.convertTo(BigDecimal.ONE, Meter)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testRod() {
        val expected = BigDecimal("5.0292")
        val actual = Rod.convertTo(BigDecimal.ONE, Meter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testChain() {
        val expected = BigDecimal("20.1168")
        val actual = Chain.convertTo(BigDecimal.ONE, Meter)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testFurlong() {
        val expected = BigDecimal("201.168")
        val actual = Furlong.convertTo(BigDecimal.ONE, Meter)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testAngstrom() {
        val expected = BigDecimal("1E-10")
        val actual = Angstrom.convertTo(BigDecimal.ONE, Meter)
        assertEquals(expected.divide(actual, MathContext.DECIMAL64).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testLightYear() {
        val expected = SPEED_OF_LIGHT * BigDecimal(60) * BigDecimal(60) * BigDecimal(24) * BigDecimal("365.25")
        val actual = LightYear.convertTo(BigDecimal.ONE, Meter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    }

}
