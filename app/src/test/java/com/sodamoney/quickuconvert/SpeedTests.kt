package com.sodamoney.quickuconvert

import org.junit.Test
import org.junit.Assert.*
import java.math.BigDecimal
import java.math.MathContext

class SpeedTests {

    @Test
    fun testMeterPerMinute() {
        val expected = BigDecimal.ONE.divide(BigDecimal(60), MathContext.DECIMAL64)
        val actual = MeterPerMinute.convertTo(BigDecimal.ONE, MeterPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testCentimeterPerSecond() {
        val expected = BigDecimal.ONE.divide(BigDecimal(100), MathContext.DECIMAL64)
        val actual = CentimeterPerSecond.convertTo(BigDecimal.ONE, MeterPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testCentimeterPerMinute() {
        val expected = BigDecimal.ONE.divide(BigDecimal(6000), MathContext.DECIMAL64)
        val actual = CentimeterPerMinute.convertTo(BigDecimal.ONE, MeterPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testInchPerSecond() {
        val expected = BigDecimal("0.0254")
        val actual = InchPerSecond.convertTo(BigDecimal.ONE, MeterPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testInchPerMinute() {
        val expected = BigDecimal("0.0254").divide(BigDecimal(60), MathContext.DECIMAL64)
        val actual = InchPerMinute.convertTo(BigDecimal.ONE, MeterPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testFootPerSecond() {
        val expected = BigDecimal("0.3048")
        val actual = FootPerSecond.convertTo(BigDecimal.ONE, MeterPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testFootPerMinute() {
        val expected = BigDecimal("0.3048").divide(BigDecimal(60), MathContext.DECIMAL64)
        val actual = FootPerMinute.convertTo(BigDecimal.ONE, MeterPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testYardPerSecond() {
        val expected = BigDecimal("0.9144")
        val actual = YardPerSecond.convertTo(BigDecimal.ONE, MeterPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testYardPerMinute() {
        val expected = BigDecimal("0.9144").divide(BigDecimal(60), MathContext.DECIMAL64)
        val actual = YardPerMinute.convertTo(BigDecimal.ONE, MeterPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testMilePerHour() {
        val expected = BigDecimal("0.44704")
        val actual = MilePerHour.convertTo(BigDecimal.ONE, MeterPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testKilometerPerHour() {
        val expected = BigDecimal.ONE.divide(BigDecimal("3.6"), MathContext.DECIMAL64)
        val actual = KilometerPerHour.convertTo(BigDecimal.ONE, MeterPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
}
