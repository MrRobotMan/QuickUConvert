package com.sodamoney.quickuconvert

import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal
import kotlin.math.pow


class ForceTests {
    @Test
    fun testKilonewton() {
        val expected = BigDecimal("1000.0")
        val actual = Kilonewton.convertTo(BigDecimal.ONE, Newton)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testKilogramForce() {
        val expected = EARTH_GRAVITY
        val actual = KilogramForce.convertTo(BigDecimal.ONE, Newton)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testDyne() {
        val expected = BigDecimal("1E-5")
        val actual = Dyne.convertTo(BigDecimal.ONE, Newton)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testPoundForce() {
        val expected = BigDecimal("4.44822")
        val actual = PoundForce.convertTo(BigDecimal.ONE, Newton)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testKips() {
        val expected = BigDecimal("4448.22")
        val actual = Kips.convertTo(BigDecimal.ONE, Newton)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    }

    @Test
    fun testPoundal() {
        val expected = BigDecimal("0.138254954376")
        val actual = Poundal.convertTo(BigDecimal.ONE, Newton)
        assertEquals((expected/actual).compareTo(BigDecimal.ONE), 0)
    }

}
