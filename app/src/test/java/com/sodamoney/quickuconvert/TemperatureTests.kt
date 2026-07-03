package com.sodamoney.quickuconvert

import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal
import kotlin.math.pow

class TemperatureTests {
    @Test
    fun testFromCentigrade() {
        val expected = BigDecimal("274.15")
        val actual = Centigrade.convertTo(BigDecimal(1), Kelvin)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testFromFahrenheit() {
        val expected = BigDecimal("255.37")
        val actual = Fahrenheit.convertTo(BigDecimal(0), Kelvin)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testFromRankine() {
        val expected = BigDecimal(1) / BigDecimal("1.8")
        val actual = Rankine.convertTo(BigDecimal(1), Kelvin)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testToCentigrade() {
        val expected = BigDecimal("-173.15")
        val actual = Kelvin.convertTo(BigDecimal(100), Centigrade)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testToFahrenheit() {
        val expected = BigDecimal("-279.67")
        val actual = Kelvin.convertTo(BigDecimal(100), Fahrenheit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testToRankine() {
        val expected = BigDecimal(180)
        val actual = Kelvin.convertTo(BigDecimal(100.0), Rankine)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun temperatureConversion() {
        val expected = BigDecimal(104)
        val kelvin = BigDecimal("313.15")
        assertEquals((kelvin/Centigrade.standardize(BigDecimal("40.0"))).compareTo(BigDecimal(1)), 0)
        assertEquals((kelvin/Fahrenheit.standardize(BigDecimal("104.0"))).compareTo(BigDecimal(1)), 0)
        val actual = Centigrade.convertTo(BigDecimal("40.0"), Fahrenheit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }
}
