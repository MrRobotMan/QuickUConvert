package com.sodamoney.quickuconvert

import org.junit.Test
import org.junit.Assert.*
import java.math.BigDecimal
import java.math.MathContext

class VolumetricFlowTests {
    val context = MathContext.DECIMAL64

    @Test
    fun testCubicMeterPerMinute() {
        val expected = BigDecimal(1).divide(BigDecimal(60), context)
        val actual = CubicMeterPerMinute.convertTo(BigDecimal(1), CubicMeterPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }
    
    @Test
    fun testCubicMeterPerHour() {
        val expected = BigDecimal(1).divide(BigDecimal(3600), context)
        val actual = CubicMeterPerHour.convertTo(BigDecimal(1), CubicMeterPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testLiterPerSecond() {
        val expected = BigDecimal(1).divide(BigDecimal(1000), context)
        val actual = LiterPerSecond.convertTo(BigDecimal(1), CubicMeterPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }
    
    @Test
    fun testLiterPerMinute() {
        val expected = BigDecimal(1).divide(BigDecimal(60_000), context)
        val actual = LiterPerMinute.convertTo(BigDecimal(1), CubicMeterPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }
    
    @Test
    fun testLiterPerHour() {
        val expected = BigDecimal(1).divide(BigDecimal(3_600_000), context)
        val actual = LiterPerHour.convertTo(BigDecimal(1), CubicMeterPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testCubicFootPerSecond() {
        val expected = BigDecimal("0.028316846592")
        val actual = CubicFootPerSecond.convertTo(BigDecimal(1), CubicMeterPerSecond)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }
    
    @Test
    fun testCubicFootPerMinute() {
        val expected = BigDecimal("0.028316846592").divide(BigDecimal(60), context)
        val actual = CubicFootPerMinute.convertTo(BigDecimal(1), CubicMeterPerSecond)
        println(expected)
        println(actual)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }
    
    @Test
    fun testCubicFootPerHour() {
        val expected = BigDecimal("0.028316846592").divide(BigDecimal(3600), context)
        val actual = CubicFootPerHour.convertTo(BigDecimal(1), CubicMeterPerSecond)
        println(expected)
        println(actual)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }
    
    @Test
    fun testGallonPerMinute() {
        val expected = BigDecimal("0.003785411784").divide(BigDecimal(60), context)
        val actual = GallonPerMinute.convertTo(BigDecimal(1), CubicMeterPerSecond)
        println(expected)
        println(actual)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }
    
    @Test
    fun testGallonPerHour() {
        val expected = BigDecimal("0.003785411784").divide(BigDecimal(3600), context)
        val actual = GallonPerHour.convertTo(BigDecimal(1), CubicMeterPerSecond)
        println(expected)
        println(actual)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }
    
    @Test
    fun testBarrelPerHour() {
        val expected = BigDecimal("0.119240471196").divide(BigDecimal(3600), context)
        val actual = BarrelPerHour.convertTo(BigDecimal(1), CubicMeterPerSecond)
        println(expected)
        println(actual)
        assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
    }
}
