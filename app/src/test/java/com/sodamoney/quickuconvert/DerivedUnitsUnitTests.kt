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
    fun allSymbolsUnique() {
        // Filter out UNIFORM_LOAD since it's a subset of STIFFNESS
        val expected = AllUnits.filter{ it.key != Category.UNIFORM_LOAD }.map{it.value.size}.sum()
        var allSymbols = AllUnits.filter {it.key != Category.UNIFORM_LOAD }.flatMap{it.value.map{it.symbol}}.toMutableList()
        val actual = allSymbols.toSet()
        for (s in actual) {
            allSymbols.remove(s)
        }
        assertEquals(expected, actual.count())
    }
}

