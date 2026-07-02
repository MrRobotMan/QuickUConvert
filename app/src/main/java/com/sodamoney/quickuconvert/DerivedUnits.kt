package com.sodamoney.quickuconvert

/*
 * Copyright 2026 David Weiss
 *
 * Collection of Derived to be used.
 */

inline fun Double.squared(): Double = this * this
inline fun Double.cubed(): Double = this * this * this

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
val SquareInch = Units("in²", Category.AREA) { Inch.standardize( 1.0 ).squared() * it }
val SquareFoot = Units("ft²", Category.AREA) { Foot.standardize( 1.0 ).squared() * it }
val SquareYard = Units("yd²", Category.AREA) { Yard.standardize( 1.0 ).squared() * it }
val SquareMile = Units("mi²", Category.AREA) { Mile.standardize( 1.0 ).squared() * it }
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
    Kilometer, Meter, Centimeter, Millimeter, Micrometer,
    Nanometer, Inch, Thou, Foot, Yard,
    Mile, Rod, Chain, Furlong, NauticalMile,
    Fathom, Angstrom, LightYear
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
    Nanosecond, Microsecond, Millisecond, Second, Minute, Hour,
    Day, Week, Month, Year, Decade, Century
)
// endregion

// region Volume
val Liter = Units("L", Category.VOLUME) { it / 1_000 }
val Deciliter = Units("dL", Category.VOLUME) { it  / 10_000 }
val CubicCentimeter = Units("CC/mL", Category.VOLUME) { it / Mega }
val CubicMillimeter = Units("mm³", Category.VOLUME) { it / Giga }
val CubicInch = Units("in³", Category.VOLUME) { Inch.standardize(1.0).cubed() * it }
val CubicFoot = Units("ft³", Category.VOLUME) { Foot.standardize(1.0).cubed() * it }
val CubicYard = Units("yd³", Category.VOLUME) { Yard.standardize(1.0).cubed() * it }
val AcreFoot = Units("acre⋅ft", Category.VOLUME) { CubicFoot.standardize(it) * 43_560 }
val Gallon = Units("gal", Category.VOLUME) { CubicInch.standardize(it) * 231 }
val WetBarrel = Units("bbl (wet)", Category.VOLUME) { Gallon.standardize(it) * 31.5 }
val WetQuart = Units("qt (wet)", Category.VOLUME) { Gallon.standardize(it) / 4 }
val WetPint = Units("pt (wet)", Category.VOLUME) { Gallon.standardize(it) / 8 }
val Cup = Units("cu", Category.VOLUME) { Gallon.standardize(it) / 16 }
val FluidOunce = Units("fl oz", Category.VOLUME) { Gallon.standardize(it) / 128 }
val Tablespoon = Units("tbsp", Category.VOLUME) { FluidOunce.standardize(it) / 2 }
val Teaspoon = Units("tsp", Category.VOLUME) { FluidOunce.standardize(it) / 6 }
val DryPint = Units("pt (dry)", Category.VOLUME) { CubicInch.standardize(it) * 33.600_312_5 }
val DryQuart = Units("qt (dry)", Category.VOLUME) { DryPint.standardize(it) * 2 }
val Peck = Units("bu", Category.VOLUME) { DryQuart.standardize(it) * 8 }
val Bushel = Units("bu", Category.VOLUME) { Peck.standardize(it) * 4 }
val DryBarrel = Units("bbl (dry)", Category.VOLUME) { CubicInch.standardize(it) * 7056 }

val Volumes = arrayOf(
    CubicMeter, Liter, Deciliter, CubicCentimeter, CubicMillimeter,
    CubicInch, CubicFoot, CubicYard, AcreFoot,
    Gallon, WetBarrel, WetQuart, WetPint, Cup, FluidOunce, Tablespoon, Teaspoon,
    DryPint, DryQuart, Peck, Bushel, DryBarrel,
)
// endregion
