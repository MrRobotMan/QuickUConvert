package com.sodamoney.quickuconvert

import org.junit.Test
import org.junit.Assert.*

import java.math.BigDecimal

class EnergyTests {
    
    @Test
        fun testKiloJoule() {
            val expected = BigDecimal(1_000)
            val actual = KiloJoule.convertTo(BigDecimal(1), Joule)
            assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
        }
    
    @Test
        fun testMegaJoule() {
            val expected = BigDecimal(1_000_000)
            val actual = MegaJoule.convertTo(BigDecimal(1), Joule)
            assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
        }
    
    @Test
        fun testKiloWattHour() {
            val expected = BigDecimal(3_600_000)
            val actual = KiloWattHour.convertTo(BigDecimal(1), Joule)
            assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
        }

    @Test
        fun testCalorie() {
            val expected = BigDecimal("4.1868")
            val actual = Calorie.convertTo(BigDecimal(1), Joule)
            assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
        }

    @Test
        fun testKiloCalorie() {
            val expected = BigDecimal("4186.8")
            val actual = KiloCalorie.convertTo(BigDecimal(1), Joule)
            assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
        }

    @Test
        fun testBtu() {
            val expected = BigDecimal("1055.05585262")
            val actual = Btu.convertTo(BigDecimal(1), Joule)
            assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
        }

    @Test
        fun testKiloBtu() {
            val expected = BigDecimal("1055055.85262")
            val actual = KiloBtu.convertTo(BigDecimal(1), Joule)
            assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
        }

    @Test
        fun testErg() {
            val expected = BigDecimal("1E-7")
            val actual = Erg.convertTo(BigDecimal(1), Joule)
            assertEquals((expected / actual).compareTo(BigDecimal(1)), 0)
        }
    }

