package com.sodamoney.quickuconvert

import org.junit.Test
import org.junit.Assert.*
import java.math.BigDecimal

class MomentTests {

    @Test
        fun testKilonewtonMeter() {
            val expected = BigDecimal(1000)
            val actual = KilonewtonMeter.convertTo(BigDecimal(1), NewtonMeter)
            assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
        }

    @Test
        fun testNewtonCentimeter() {
            val expected = BigDecimal("0.01")
            val actual = NewtonCentimeter.convertTo(BigDecimal(1), NewtonMeter)
            assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
        }

    @Test
        fun testNewtonMillimeter() {
            val expected = BigDecimal("0.001")
            val actual = NewtonMillimeter.convertTo(BigDecimal(1), NewtonMeter)
            assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
        }
    
    @Test
        fun testKilogramForceMeter() {
            val expected = BigDecimal("9.80665")
            val actual = KilogramForceMeter.convertTo(BigDecimal(1), NewtonMeter)
            assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
        }

    @Test
        fun testKilogramForceCentimeter() {
            val expected = BigDecimal("0.0980665")
            val actual = KilogramForceCentimeter.convertTo(BigDecimal(1), NewtonMeter)
            assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
        }

    @Test
        fun testKilogramForceMillimeter() {
            val expected = BigDecimal("0.00980665")
            val actual = KilogramForceMillimeter.convertTo(BigDecimal(1), NewtonMeter)
            assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
        }
    
    @Test
        fun testFootPound() {
            val expected = BigDecimal("1.3558179483")
            val actual = FootPound.convertTo(BigDecimal(1), NewtonMeter)
            assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
        }

    @Test
        fun testFootKip() {
            val expected = BigDecimal("1355.8179483")
            val actual = FootKip.convertTo(BigDecimal(1), NewtonMeter)
            assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
        }

    @Test
        fun testInchPound() {
            val expected = BigDecimal("0.112984829")
            val actual = InchPound.convertTo(BigDecimal(1), NewtonMeter)
            println(expected)
            println(actual)
            assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
        }

    @Test
        fun testInchKip() {
            val expected = BigDecimal("112.984829")
            val actual = InchKip.convertTo(BigDecimal(1), NewtonMeter)
            assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
        }
    

}

