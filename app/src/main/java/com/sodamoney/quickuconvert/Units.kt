package com.sodamoney.quickuconvert

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

open class Units (
    /**
     * Symbol used in equations
     */
    val symbol: String,

    /**
     * Name of the unit for tooltip display
     */
    val name: String,
    /**
     * The category of unit for conversion.
     */
    val category: Category,

    /**
     * The formula to convert to a standard (base) unit.
     * 1 UNIT = X BASE UNITS
     */
    val standardize: (BigDecimal) -> BigDecimal,

    ){
    /**
     * Convert from one unit to another
     */
    open fun convertTo(inputValue: BigDecimal, other: Units): BigDecimal {
        if (this.category != other.category) {
            throw IllegalConversionException(
                "Can't convert from ${this.symbol} to ${other.symbol}. Base units are mismatched ${this.category.baseUnits()} and ${other.category.baseUnits()}"
            )
        }
        val one = BigDecimal.ONE
        val ctx = MathContext(512, RoundingMode.HALF_EVEN)
        val thisStandard = this.standardize(inputValue)
        val base = try {
            one.divide(thisStandard)
        } catch (_: ArithmeticException) {
            one.divide(thisStandard, ctx)
        }
        val otherStandard = other.standardize(base)
        return try {
            one.divide(otherStandard)
        } catch (_: ArithmeticException) {
            one.divide(otherStandard,ctx)
        }
    }
}

