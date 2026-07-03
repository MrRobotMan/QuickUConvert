package com.sodamoney.quickuconvert

import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal
import kotlin.math.pow

class TimeTests {
    @Test
    fun testMillisecond() {
        val expected = BigDecimal("0.001")
        val actual = Millisecond.convertTo(BigDecimal(1), Second)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testMicrosecond() {
        val expected = BigDecimal("1E-6")
        val actual = Microsecond.convertTo(BigDecimal(1), Second)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testNanosecond() {
        val expected = BigDecimal("1E-9")
        val actual = Nanosecond.convertTo(BigDecimal(1), Second)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testMinute() {
        val expected = BigDecimal(60)
        val actual = Minute.convertTo(BigDecimal(1), Second)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testHour() {
        val expected = BigDecimal(3600)
        val actual = Hour.convertTo(BigDecimal(1), Second)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testDay() {
        val expected = BigDecimal(86400)
        val actual = Day.convertTo(BigDecimal(1), Second)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testYear() {
        val expected = BigDecimal(31_557_600)
        val actual = Year.convertTo(BigDecimal(1), Second)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testWeek() {
        val expected = BigDecimal(604_800)
        val actual = Week.convertTo(BigDecimal(1), Second)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    }

    @Test
    fun testMonth() {
        val expected = BigDecimal(2_629_800)
        val actual = Month.convertTo(BigDecimal(1), Second)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testDecade() {
        val expected = BigDecimal(315_576_000)
        val actual = Decade.convertTo(BigDecimal(1), Second)
        assertEquals(expected.compareTo(actual), 0)
    }

    @Test
    fun testCentury() {
        val expected = BigDecimal(3_155_760_000)
        val actual = Century.convertTo(BigDecimal(1), Second)
        assertEquals(expected.compareTo(actual), 0)
    }

}
