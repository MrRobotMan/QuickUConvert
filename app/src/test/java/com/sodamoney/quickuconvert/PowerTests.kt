package com.sodamoney.quickuconvert

import org.junit.Test
import org.junit.Assert.*
import java.math.BigDecimal
import java.math.MathContext

class PowerTests {

    @Test
    fun testKilowatt() {
        val expected = BigDecimal(1000)
        val actual = Kilowatt.convertTo(BigDecimal.ONE, Watt)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testMegawatt() {
        val expected = BigDecimal(1_000_000)
        val actual = Megawatt.convertTo(BigDecimal.ONE, Watt)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testGigawatt() {
        val expected = BigDecimal(1_000_000_000)
        val actual = Gigawatt.convertTo(BigDecimal.ONE, Watt)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testErgPerSecond() {
        val expected = BigDecimal("1E-7")
        val actual = ErgPerSecond.convertTo(BigDecimal.ONE, Watt)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testCaloriePerSecond() {
        val expected = BigDecimal("4.1868")
        val actual = CaloriePerSecond.convertTo(BigDecimal.ONE, Watt)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testBtuPerSecond() {
        val expected = BigDecimal("1055.0558526")
        val actual = BtuPerSecond.convertTo(BigDecimal.ONE, Watt)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testBtuPerMinute() {
        val expected = BigDecimal("1055.0558526").divide(BigDecimal(60), MathContext.DECIMAL64)
        val actual = BtuPerMinute.convertTo(BigDecimal.ONE, Watt)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testTonOfRefrigeration() {
        val expected = BigDecimal("3516.852842")
        val actual = TonOfRefrigeration.convertTo(BigDecimal.ONE, Watt)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testHorsePower() {
        val expected = BigDecimal("745.699716")
        val actual = HorsePower.convertTo(BigDecimal.ONE, Watt)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testMetricHorsePower() {
        val expected = BigDecimal("735.49875")
        val actual = MetricHorsePower.convertTo(BigDecimal.ONE, Watt)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
}
