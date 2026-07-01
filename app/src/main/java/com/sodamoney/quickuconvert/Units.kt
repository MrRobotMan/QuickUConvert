package com.sodamoney.quickuconvert

open class Units (
    /**
     * Symbol used in equations
     */
    val symbol: String,

    /**
     * The category of unit for conversion.
     */
    val category: Category,

    /**
     * The formula to convert to a standard (base) unit.
     * 1 UNIT = X BASE UNITS
     */
    val standardize: (Double) -> Double,

){
    /**
     * Convert from one unit to another
     */
    open fun convertTo(inputValue: Double, other: Units): Double {
        if (this.category != other.category) {
            throw IllegalConversionException(
                "Can't convert from ${this.symbol} to ${other.symbol}. Base units are mismatched ${this.category.baseUnits()} and ${other.category.baseUnits()}"
            )
        }
        return 1.0 / other.standardize(1.0 / this.standardize(inputValue))
    }
}

