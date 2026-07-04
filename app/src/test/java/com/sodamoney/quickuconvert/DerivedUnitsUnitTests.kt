package com.sodamoney.quickuconvert

import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal
import kotlin.math.pow

/**
 * Testing that derived units give the correct values.
 */
class DerivedUnitsUnitTests {

    @Test
    fun convertBetweenUnitTypes_isBad() {
        assertThrows(
            "Can't convert from LENGTH to FORCE. Base units are mismatched m and N",
            IllegalConversionException::class.java,
        ) { Meter.convertTo(BigDecimal(10.0), Newton) }
    }

    @Test
    fun convertBetweenBaseUnitAndTemperature_isBad() {
        assertThrows(
            "Can't convert from LENGTH to FORCE. Base units are mismatched m and N",
            IllegalConversionException::class.java,
        ) { Kelvin.convertTo(BigDecimal(10.0), Kilogram) }
        assertThrows(
            "Can't convert from LENGTH to FORCE. Base units are mismatched m and N",
            IllegalConversionException::class.java,
        ) { Kilogram.convertTo(BigDecimal(10.0), Kelvin) }
    }

    @Test
    fun totalUnitCountIsCorrect() {
        val expected = 228
        val actual = AllUnits.values.map{it.size}.sum()
        assertEquals(expected, actual)
    }
}

