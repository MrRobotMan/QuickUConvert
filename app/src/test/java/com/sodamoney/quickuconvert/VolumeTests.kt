package com.sodamoney.quickuconvert

import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal
import kotlin.math.pow

class VolumeTests() {

    @Test
    fun testLiter() {
        val expected = BigDecimal("1E-3")
        val actual = Liter.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals(expected.compareTo(actual), 0)
    } 
    
    @Test
    fun testDeciliter() {
        val expected = BigDecimal("1E-4")
        val actual = Deciliter.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals(expected.compareTo(actual), 0)
    } 
    
    @Test
    fun testCubicCentimeter() {
        val expected = BigDecimal("1E-6")
        val actual = CubicCentimeter.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals(expected.compareTo(actual), 0)
    } 
    
    @Test
    fun testCubicMillimeter() {
        val expected = BigDecimal("1E-9")
        val actual = CubicMillimeter.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals(expected.compareTo(actual), 0)
    } 
    
    @Test
    fun testCubicInch() {
        val expected = BigDecimal("0.000016387064")
        val actual = CubicInch.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    } 
    
    @Test
    fun testCubicFoot() {
        val expected = BigDecimal("0.028316846592")
        val actual = CubicFoot.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    } 
    
    @Test
    fun testCubicYard() {
        val expected = BigDecimal("0.76455486")
        val actual = CubicYard.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    } 
    
    @Test
    fun testAcreFoot() {
        val expected = BigDecimal("1233.4818375")
        val actual = AcreFoot.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    } 
    
    @Test
    fun testGallon() {
        val expected = BigDecimal("0.003785411784")
        val actual = Gallon.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    } 
    
    @Test
    fun testWetBarrel() {
        val expected = BigDecimal("0.11924")
        val actual = WetBarrel.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    } 
    
    @Test
    fun testWetQuart() {
        val expected = BigDecimal("0.000946352946")
        val actual = WetQuart.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    } 
    
    @Test
    fun testWetPint() {
        val expected = BigDecimal("0.000473176473")
        val actual = WetPint.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    } 
    
    @Test
    fun testCup() {
        val expected = BigDecimal("0.0002365882365")
        val actual = Cup.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    } 
    
    @Test
    fun testFluidOunce() {
        val expected = BigDecimal("0.0000295735295625")
        val actual = FluidOunce.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    } 
    
    @Test
    fun testTablespoon() {
        val expected = BigDecimal("0.00001478676478125")
        val actual = Tablespoon.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    } 
    
    @Test
    fun testTeaspoon() {
        val expected = BigDecimal("0.00000492892159375")
        val actual = Teaspoon.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    } 
    
    @Test
    fun testDryPint() {
        val expected = BigDecimal("0.0005506104713574999")
        val actual = DryPint.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    } 
    
    @Test
    fun testDryQuart() {
        val expected = BigDecimal("0.001101220942715")
        val actual = DryQuart.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    } 
    
    @Test
    fun testPeck() {
        val expected = BigDecimal("0.00880976754172")
        val actual = Peck.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    } 
    
    @Test
    fun testBushel() {
        val expected = BigDecimal("35.23907E-3")
        val actual = Bushel.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    } 
    
    @Test
    fun testDryBarrel     () {
        val expected = BigDecimal("0.115627123584")
        val actual = DryBarrel.convertTo(BigDecimal.ONE, CubicMeter)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    } 
    
}
