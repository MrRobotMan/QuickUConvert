package com.sodamoney.quickuconvert

import org.junit.Test
import org.junit.Assert.*
import java.math.BigDecimal

class StiffnessTests {

    @Test
    fun testNewtonPerCentimeter() {
        val expected = BigDecimal(100)
        val actual = NewtonPerCentimeter.convertTo(BigDecimal.ONE, NewtonPerMeter)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testNewtonPerMillimeter() {
        val expected = BigDecimal(1000)
        val actual = NewtonPerMillimeter.convertTo(BigDecimal.ONE, NewtonPerMeter)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testKilonewtonPerMillimeter() {
        val expected = BigDecimal(1_000_000)
        val actual = KilonewtonPerMillimeter.convertTo(BigDecimal.ONE, NewtonPerMeter)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testKilogramPerMeter() {
        val expected = BigDecimal("9.80665")
        val actual = KilogramPerMeter.convertTo(BigDecimal.ONE, NewtonPerMeter)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testKilogramPerMillimeter() {
        val expected = BigDecimal("9806.65")
        val actual = KilogramPerMillimeter.convertTo(BigDecimal.ONE, NewtonPerMeter)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testPoundPerInch() {
        val expected = BigDecimal("175.1268352465")
        val actual = PoundPerInch.convertTo(BigDecimal.ONE, NewtonPerMeter)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testPoundPerFoot() {
        val expected = BigDecimal("14.5939029372")
        val actual = PoundPerFoot.convertTo(BigDecimal.ONE, NewtonPerMeter)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testKipPerInch() {
        val expected = BigDecimal("175126.8352465")
        val actual = KipPerInch.convertTo(BigDecimal.ONE, NewtonPerMeter)
        println(expected)
        println(actual)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
    
    @Test
    fun testKipPerFoot() {
        val expected = BigDecimal("14593.9029372")
        val actual = KipPerFoot.convertTo(BigDecimal.ONE, NewtonPerMeter)
        println(expected)
        println(actual)
        assertEquals((expected / actual).compareTo(BigDecimal.ONE), 0)
    }
}
