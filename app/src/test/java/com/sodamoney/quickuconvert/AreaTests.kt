package com.sodamoney.quickuconvert

import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal
import kotlin.math.pow

class AreaTests {

    @Test
    fun testSquareKilometer() {
        val expected = BigDecimal(1_000_000.0)
        val actual = SquareKilometer.convertTo(BigDecimal(1), SquareMeter)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testSquareCentimeter() {
        val expected = BigDecimal("1E-4")
        val actual = SquareCentimeter.convertTo(BigDecimal(1), SquareMeter)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testSquareMillimeter() {
        val expected = BigDecimal("1E-6")
        val actual = SquareMillimeter.convertTo(BigDecimal(1), SquareMeter)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testSquareMile() {
        val expected = BigDecimal("2589988.110336")
        val actual = SquareMile.convertTo(BigDecimal(1), SquareMeter)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testSquareYard() {
        val expected = BigDecimal("0.8361274")
        val actual = SquareYard.convertTo(BigDecimal(1), SquareMeter)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testSquareFoot() {
        val expected = BigDecimal("0.092903")
        val actual = SquareFoot.convertTo(BigDecimal(1), SquareMeter)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testSquareInch() {
        val expected = BigDecimal("0.00064516")
        val actual = SquareInch.convertTo(BigDecimal(1), SquareMeter)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testHectare() {
        val expected = BigDecimal(10_000)
        val actual = Hectare.convertTo(BigDecimal(1), SquareMeter)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testAcre() {
        val expected = BigDecimal("4046.8564224")
        val actual = Acre.convertTo(BigDecimal(1), SquareMeter)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }
}
