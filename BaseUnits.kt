/*
 * Copyright 2026 David Weiss
 *
 * Collection of Base Units to be used.
 */

/**
 * Unit base class
 */
class Unit(
    /**
     * The name of the unit
     */
    val name: String,

    /**
     * The scale factor to use to convert to the SI Unit.
     */
    val factor: Double,

    /**
     * The offset to use to convert to the SI Unit.
     * Most commonly used for temperature conversions where the value is
     * of the form a*x + b
     */
    val offset: Double = 0.0,

    /**
     * The base SI unit for conversion
     */
    val category: Category
) {
    /**
     * Convert the input value to the output unit.
     */
    fun convert(input_value: Double, other: Unit): Double {
        if (this.category != other.category) {
            throw IllegalConversionException(
                "Can't convert from ${this.name} to ${other.name}. Base units are mismatched ${this.category.pretty()} and ${other.category.pretty()}"
            )
        }
        return (input_value + this.offset) * this.factor / other.factor - other.offset
    }
} 

enum class Category {
    LENGTH,
    AREA,
    WET_VOLUME,
    DRY_VOLUME,
    MASS,
    FORCE,
    MOMENT,
    PRESSURE,
    TEMPERATURE,
    SPEED,
    ACCELERATION,
    STIFFNESS,
    MASS_FLOW,
    VOL_FLOW,
    POWER,
    ENERGY,
    DENSITY;

    fun pretty(): String {
        return when (this) {
            SiUnit.LENGTH -> "m"
            SiUnit.AREA -> "m²"
            SiUnit.WET_VOLUME -> "m³"
            SiUnit.DRY_VOLUME -> "m³"
            SiUnit.MASS -> "kg"
            SiUnit.FORCE -> "N"
            SiUnit.MOMENT -> "Nm"
            SiUnit.PRESSURE -> "Pa"
            SiUnit.TEMPERATURE -> "°C"
            SiUnit.SPEED -> "m/s"
            SiUnit.ACCELERATION -> "m/s²"
            SiUnit.STIFFNESS -> "N/mm"
            SiUnit.MASS_FLOW -> "kg/s"
            SiUnit.VOL_FLOW -> "m³/hr"
            SiUnit.POWER -> "W"
            SiUnit.ENERGY -> "J"
            SiUnit.DENSITY -> "kg/m³"
        }
    }
}

class IllegalConversionException(message: String) : Exception(message)
