package com.sodamoney.quickuconvert

/*
 * Copyright 2026 David Weiss
 *
 * Collection of Derived to be used.
 */

// region Acceleration
val InchPerSecondSquared = Units("in/s²", Category.ACCELERATION) { Inch.convertTo(it, Meter) }
val FootPerSecondSquared = Units("ft/s²", Category.ACCELERATION) { Foot.convertTo(it, Meter) }
val CentimeterPerSecondSquared =
    Units("cm/s²", Category.ACCELERATION) { Centimeter.convertTo(it, Meter) }
val MillimeterPerSecondSquared =
    Units("mm/s²", Category.ACCELERATION) { Millimeter.convertTo(it, Meter) }
val EarthGravity = Units("g", Category.ACCELERATION) { EARTH_GRAVITY * it }
val Accelerations = arrayOf(
    EarthGravity,
    MeterPerSecondSquared,
    CentimeterPerSecondSquared,
    MillimeterPerSecondSquared,
    InchPerSecondSquared,
    FootPerSecondSquared
)
// endregion

//region Areas
val SquareInch = Units("in²", Category.AREA) {
    val c = Inch.standardize( 1.0 )
    c * c * it
}
val SquareFoot = Units("ft²", Category.AREA) {
    val c = Foot.standardize( 1.0 )
    c * c * it
}
val SquareYard = Units("yd²", Category.AREA) {
    val c = Yard.standardize( 1.0 )
    c * c * it
}
val SquareMile = Units("mi²", Category.AREA) {
    val c = Mile.standardize( 1.0 )
    c * c * it
}
val SquareKilometer = Units("km²", Category.AREA) { it * Mega }
val SquareCentimeter = Units("cm²", Category.AREA) { it / 10_000 }
val SquareMillimeter = Units("mm²", Category.AREA) { it / Mega }
val Hectare = Units("ha", Category.AREA) { it * 10_000 }
val Acre = Units("ac", Category.AREA) { 4840 * SquareYard.standardize( it) }
val Areas = arrayOf(
    SquareKilometer, SquareMeter, SquareCentimeter, SquareMillimeter,
    SquareMile, SquareYard, SquareFoot, SquareInch,
    Hectare, Acre
)
//endregion

// region Forces
val Kilonewton = Units("kN", Category.FORCE) { Newton.standardize(it) * Kilo }
val KilogramForce = Units("kgf", Category.FORCE) { it * EARTH_GRAVITY }
val Dyne = Units("dyn", Category.FORCE) { Newton.standardize(it) / 100_000 }
val PoundForce = Units("lbf", Category.FORCE) { it * (EARTH_GRAVITY * PoundMass.standardize(1.0)) }
val Kips = Units("kip", Category.FORCE) { PoundForce.standardize(it) * Kilo }
val Poundal = Units(
    "pdl", Category.FORCE
) { PoundMass.standardize(it) * FootPerSecondSquared.standardize(1.0) }
val Forces = arrayOf(
    Newton, Kilonewton, KilogramForce, Dyne, PoundForce, Kips, Poundal
)
// endregion

// region Length
val Kilometer = Units("km", Category.LENGTH) { it * Kilo }
val Centimeter = Units("cm", Category.LENGTH) { it / 100 }
val Millimeter = Units("mm", Category.LENGTH) { it / Kilo }
val Micrometer = Units("μm", Category.LENGTH) { it / Mega }
val Nanometer = Units("nm", Category.LENGTH) { it / Giga }
val Inch = Units("in", Category.LENGTH) { it * 0.0254 }
val Foot = Units("ft", Category.LENGTH) { it * 0.3048 }
val Yard = Units("yd", Category.LENGTH) { it * 0.3048 * 3 }
val Mile = Units("mi", Category.LENGTH) { it * 0.3048 * 5_280 }
val Thou = Units("mils", Category.LENGTH) { it * 0.0254 / Kilo }
val NauticalMile = Units("nmi", Category.LENGTH) { it * 1852 }
val Fathom = Units("ftm", Category.LENGTH) { Foot.standardize(it) * 6 }
val Rod = Units("rd", Category.LENGTH) { Foot.standardize(it) * 16.5 }
val Chain = Units("ch", Category.LENGTH) { Rod.standardize(it) * 4 }
val Furlong = Units("fur", Category.LENGTH) { Mile.standardize(it) / 8 }
val Angstrom = Units("Å", Category.LENGTH) { it * 1E-10 }
val LightYear = Units("ly", Category.LENGTH) {
    it * (SPEED_OF_LIGHT * Year.convertTo(1.0, Second))
}

val Lengths = arrayOf(
    Kilometer,
    Meter,
    Centimeter,
    Millimeter,
    Micrometer,
    Nanometer,
    Inch,
    Thou,
    Foot,
    Yard,
    Mile,
    Rod,
    Chain,
    Furlong,
    NauticalMile,
    Fathom,
    Angstrom,
    LightYear
)
// endregion

// region Mass
val PoundMass = Units("lb", Category.MASS) { it * 0.45359237 }
// endregion

// region Temperatures
class TemperatureUnits(
    symbol: String, standardize: (Double) -> Double, val fromStandard: (Double) -> Double
) : Units(
    symbol, Category.TEMPERATURE, standardize
) {
    override fun convertTo(inputValue: Double, other: Units): Double {
        if (other !is TemperatureUnits) {
            throw IllegalConversionException(
                "Can't convert from ${this.symbol} to ${other.symbol}. Base units are mismatched ${this.category.baseUnits()} and ${other.category.baseUnits()}"
            )
        }
        return other.fromStandard(this.standardize(inputValue))
    }
}

val Centigrade = TemperatureUnits("°C", { 273.15 + it }, { it - 273.15 })
val Fahrenheit = TemperatureUnits("°F", { (459.67 + it) / 1.8 }, { (it * 1.8) - 459.67 })
val Rankine = TemperatureUnits("°R", { it / 1.8 }, { it * 1.8 })
val Temperatures = arrayOf(Centigrade, Fahrenheit, Kelvin, Rankine)
// endregion

// region Time
val Millisecond = Units("ms", Category.TIME) { it / Kilo }
val Microsecond = Units("μs", Category.TIME) { it / Mega }
val Nanosecond = Units("ns", Category.TIME) { it / Giga }
val Minute = Units("m", Category.TIME) { it * 60 }
val Hour = Units("hr", Category.TIME) { Minute.standardize(it) * 60 }
val Day = Units("d", Category.TIME) { Hour.standardize(it) * 24 }
val Year = Units("yr", Category.TIME) { Day.standardize(it) * 365.25 }
val Week = Units("wk", Category.TIME) { Day.standardize(it) * 7 }
val Month = Units("mo", Category.TIME) { Year.standardize(it) / 12 }
val Decade = Units("dec", Category.TIME) { Year.standardize(it) * 10 }
val Century = Units("cen", Category.TIME) { Year.standardize(it) * 100 }
val Times = arrayOf(
    Nanosecond,
    Microsecond,
    Millisecond,
    Second,
    Minute,
    Hour,
    Day,
    Week,
    Month,
    Year,
    Decade,
    Century
)
// endregion
