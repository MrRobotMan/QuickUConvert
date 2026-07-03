package com.sodamoney.quickuconvert

import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal
import kotlin.math.pow

class MassTests {

    @Test
    fun testGram() {
        val expected = BigDecimal("0.001")
        val actual = Gram.convertTo(BigDecimal(1), Kilogram)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }
    @Test
    fun testMilligram() {
        val expected = BigDecimal("1E-6")
        val actual = Milligram.convertTo(BigDecimal(1), Kilogram)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }
    @Test
    fun testPoundMass() {
        val expected = BigDecimal("0.45359237")
        val actual = PoundMass.convertTo(BigDecimal(1), Kilogram)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }
    @Test
    fun testOunce() {
        val expected = BigDecimal("0.028349523125")
        val actual = Ounce.convertTo(BigDecimal(1), Kilogram)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }
    @Test
    fun testStone() {
        val expected = BigDecimal("6.3502932")
        val actual = Stone.convertTo(BigDecimal(1), Kilogram)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }
    @Test
    fun testHundredweightShort() {
        val expected = BigDecimal("45.359237")
        val actual = HundredweightShort.convertTo(BigDecimal(1), Kilogram)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }
    @Test
    fun testHundredweightLong() {
        val expected = BigDecimal("50.8023454")
        val actual = HundredweightLong.convertTo(BigDecimal(1), Kilogram)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }
    @Test
    fun testGrain() {
        val expected = BigDecimal("6.479891E-5")
        val actual = Grain.convertTo(BigDecimal(1), Kilogram)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }
    @Test
    fun testShortTon() {
        val expected = BigDecimal("907.18474")
        val actual = ShortTon.convertTo(BigDecimal(1), Kilogram)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }
    @Test
    fun testLongTon() {
        val expected = BigDecimal("1016.0469088")
        val actual = LongTon.convertTo(BigDecimal(1), Kilogram)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }
    @Test
    fun testTonne() {
        val expected = BigDecimal("1000.0")
        val actual = Tonne.convertTo(BigDecimal(1), Kilogram)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }
    @Test
    fun testCarat() {
        val expected = BigDecimal("0.0002")
        val actual = Carat.convertTo(BigDecimal(1), Kilogram)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }
}
