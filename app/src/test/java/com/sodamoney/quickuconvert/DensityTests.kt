package com.sodamoney.quickuconvert

import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal
import kotlin.math.pow

class DensityTests() {

    @Test
    fun testKilogramPerLiter() {
        val expected = BigDecimal(1000)
        val actual = KilogramPerLiter.convertTo(BigDecimal.ONE, KilogramPerCubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testKilogramPerCubicCentimeter() {
        val expected = BigDecimal(1_000_000)
        val actual = KilogramPerCubicCentimeter.convertTo(BigDecimal.ONE, KilogramPerCubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testGramPerCubicCentimeter() {
        val expected = BigDecimal(1000)
        val actual = GramPerCubicCentimeter.convertTo(BigDecimal.ONE, KilogramPerCubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testMilligramPerDeciliter() {
        val expected = BigDecimal("0.01")
        val actual = MilligramPerDeciliter.convertTo(BigDecimal.ONE, KilogramPerCubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testPoundPerCubicInch() {
        val expected = BigDecimal("27679.9047102")
        val actual = PoundPerCubicInch.convertTo(BigDecimal.ONE, KilogramPerCubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testPoundPerCubicFoot() {
        val expected = BigDecimal("16.0184634")
        val actual = PoundPerCubicFoot.convertTo(BigDecimal.ONE, KilogramPerCubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testPoundPerCubicYard() {
        val expected = BigDecimal("0.5932764")
        val actual = PoundPerCubicYard.convertTo(BigDecimal.ONE, KilogramPerCubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testPoundPerCubicGallon() {
        val expected = BigDecimal("119.8264273")
        val actual = PoundPerCubicGallon.convertTo(BigDecimal.ONE, KilogramPerCubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testOuncePerCubicGallon() {
        val expected = BigDecimal("7.4891517")
        val actual = OuncePerCubicGallon.convertTo(BigDecimal.ONE, KilogramPerCubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    }
    
}
    
