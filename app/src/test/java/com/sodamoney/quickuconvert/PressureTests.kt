package com.sodamoney.quickuconvert

import org.junit.Test
import org.junit.Assert.*
import java.math.BigDecimal

class PressureTests {

    @Test
    fun testKiloPascal() {
        val expected = BigDecimal(1000)
        val actual = KiloPascal.convertTo(BigDecimal.ONE, Pascal)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testMegaPascal() {
        val expected = BigDecimal(1_000_000)
        val actual = MegaPascal.convertTo(BigDecimal.ONE, Pascal)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testGigaPascal() {
        val expected = BigDecimal(1_000_000_000)
        val actual = GigaPascal.convertTo(BigDecimal.ONE, Pascal)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testKilogramPerSquareCentimeter() {
        val expected = BigDecimal("9.80665")
        val actual = KilogramPerSquareCentimeter.convertTo(BigDecimal.ONE, Pascal)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testGramPerSquareCentimeter() {
        val expected = BigDecimal("98.0665")
        val actual = GramPerSquareCentimeter.convertTo(BigDecimal.ONE, Pascal)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testDynePerSquareCentimeter() {
        val expected = BigDecimal("0.1")
        val actual = DynePerSquareCentimeter.convertTo(BigDecimal.ONE, Pascal)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testBar() {
        val expected = BigDecimal(100_000)
        val actual = Bar.convertTo(BigDecimal.ONE, Pascal)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testAtmosphere() {
        val expected = BigDecimal(101_325)
        val actual = Atmosphere.convertTo(BigDecimal.ONE, Pascal)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testPoundPerSquareInch() {
        val expected = BigDecimal("6894.7572931684")
        val actual = PoundPerSquareInch.convertTo(BigDecimal.ONE, Pascal)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testKipPerSquareInch() {
        val expected = BigDecimal("6894757.2931684")
        val actual = KipPerSquareInch.convertTo(BigDecimal.ONE, Pascal)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testPoundPerSquareFoot() {
        val expected = BigDecimal("47.880259")
        val actual = PoundPerSquareFoot.convertTo(BigDecimal.ONE, Pascal)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testInchOfWater() {
        val expected = BigDecimal("248.8348393")
        val actual = InchOfWater.convertTo(BigDecimal.ONE, Pascal)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testFootOfWater() {
        val expected = BigDecimal("2986.0180717")
        val actual = FootOfWater.convertTo(BigDecimal.ONE, Pascal)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testInchOfMercury() {
        val expected = BigDecimal("3386.3886403")
        val actual = InchOfMercury.convertTo(BigDecimal.ONE, Pascal)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testMillimeterOfMercury() {
        val expected = BigDecimal("133.3223874")
        val actual = MillimeterOfMercury.convertTo(BigDecimal.ONE, Pascal)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
}
 
