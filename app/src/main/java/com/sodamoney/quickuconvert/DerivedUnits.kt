package com.sodamoney.quickuconvert

import androidx.annotation.StringRes

/*
 * Copyright 2026 David Weiss
 *
 * Collection of Derived to be used.
 */

// Time
val Millisecond = Units("Millisecond", R.string.millisecond, "ms", { it / 1_000 }, Category.TIME)
val Microsecond =
    Units("Microsecond", R.string.microsecond, "μs", { it / 1_000_000 }, Category.TIME)
val Nanosecond =
    Units("Nanosecond", R.string.nanosecond, "ns", { it / 1_000_000_000 }, Category.TIME)
val Minute = Units("Minute", R.string.minute, "m", { it * 60 }, Category.TIME)
val Hour = Units("Hour", R.string.hour, "hr", { Minute.standardize(it) * 60 }, Category.TIME)
val Day = Units("Day", R.string.day, "d", { Hour.standardize(it) * 24 }, Category.TIME)
val Year = Units("Year", R.string.year, "yr", { Day.standardize(it) * 365.25 }, Category.TIME)

// Lengths
val Kilometer = Units("Kilometer", R.string.kilogram, "km", { it * 1_000 }, Category.LENGTH)
val Centimeter = Units("Centimeter", R.string.centimeter, "cm", { it / 100 }, Category.LENGTH)
val Millimeter = Units("Millimeter", R.string.millimeter, "mm", { it / 1_000 }, Category.LENGTH)
val Micrometer = Units("Micrometer", R.string.micrometer, "μm", { it / 1_000_000 }, Category.LENGTH)
val Nanometer =
    Units("Nanometer", R.string.nanometer, "nm", { it / 1_000_000_000 }, Category.LENGTH)
val Inch = Units("Inch", R.string.inch, "in", { it * 0.0254 }, Category.LENGTH)
val Foot = Units("Foot", R.string.foot, "ft", { it * 0.3048 }, Category.LENGTH)
val Yard = Units("Yard", R.string.yard, "yd", { it * 0.3048 / 3 }, Category.LENGTH)
val Mile = Units("Mile", R.string.mile, "mi", { it * 0.3048 / 5_280 }, Category.LENGTH)
val Thou = Units("Thou", R.string.thou, "thou", { it * 0.0254 / 1_000 }, Category.LENGTH)
val Furlong =
    Units("Furlong", R.string.furlong, "fur", { Yard.standardize(it) / 220 }, Category.LENGTH)
val NauticalMile =
    Units("Nautical Mile", R.string.nautical_mile, "NMI", { it / 1852 }, Category.LENGTH)
val LightYear =
    Units(
        "Light-Year",
        R.string.light_year,
        "ly",
        { it * (SPEED_OF_LIGHT * Year.convertTo(1.0, Second)) },
        Category.LENGTH
    )

// Forces
val Newton = Units("Newton", R.string.newton, "N", { it }, Category.FORCE)
val KilogramForce =
    Units(
        "Kilogram Force",
        R.string.kilogram_force,
        "kgf",
        { it * GRAVITATIONAL_ACCELERATION },
        Category.FORCE
    )


// Temperatures
class TemperatureUnits(
    name: String,
    @StringRes stringId: Int,
    symbol: String,
    standardize: (Double) -> Double,
    val fromStandard: (Double) -> Double
) : Units(
    name,
    stringId,
    symbol,
    standardize,
    Category.TEMPERATURE
) {
    fun convertTo(inputValue: Double, other: TemperatureUnits): Double {
        if (this.category != other.category) {
            throw IllegalConversionException(
                "Can't convert from ${this.name} to ${other.name}. Base units are mismatched ${this.category.baseUnits()} and ${other.category.baseUnits()}"
            )
        }
        println("Standardized = ${this.standardize(inputValue)}")
        return other.fromStandard(this.standardize(inputValue))
    }
}

val Centigrade =
    TemperatureUnits("Centigrade", R.string.centigrade, "°C", { 273.15 + it }, { it - 273.15 })
val Fahrenheit =
    TemperatureUnits(
        "Fahrenheit",
        R.string.fahrenheit,
        "°F",
        { (459.67 + it) / 1.8 },
        { (it * 1.8) - 459.67 })

val Rankine = TemperatureUnits("Rankine", R.string.rankine, "°R", { it / 1.8 }, { it * 1.8 })