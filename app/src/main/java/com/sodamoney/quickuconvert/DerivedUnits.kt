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

// region Areas
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
// endregion

// region Density
val KilogramPerLiter = Units("kg/L", Category.DENSITY) { it * Kilo }
val KilogramPerCubicCentimeter = Units("kg/cm³", Category.DENSITY) { it * Mega }
val GramPerCubicCentimeter = Units("g/cm³", Category.DENSITY) { it * Kilo }
val MilligramPerDeciliter = Units("mg/dL", Category.DENSITY) { it / 100 }
val PoundPerCubicInch = Units("lb/in³", Category.DENSITY) {
    PoundMass.standardize(1.0) / CubicInch.standardize(1.0) * it
 }
val PoundPerCubicFoot = Units("lb/ft³", Category.DENSITY) {
    PoundMass.standardize(1.0) / CubicFoot.standardize(1.0) * it
 }
val PoundPerCubicYard = Units("lb/yd³", Category.DENSITY) {
    PoundMass.standardize(1.0) / CubicYard.standardize(1.0) * it
 }
val PoundPerCubicGallon = Units("lb/gal", Category.DENSITY) {
    PoundMass.standardize(1.0) / CubicGallon.standardize(1.0) * it
 }
val OuncePerCubicGallon = Units("oz/gal", Category.DENSITY) {
    Ounce.standardize(1.0) / CubicGallon.standardize(1.0) * it
 }

val Densities = arrayOf(
    KilogramPerCubicMeter, KilogramPerLiter, KilogramPerCubicCentimeter,
    GramPerCubicCentimeter, MilligramPerDeciliter, PoundPerCubicInch,
    PoundPerCubicFoot, PoundPerCubicYard, PoundPerCubicGallon,OuncePerCubicGallon
)
// endregion

// region Digital Storage
// k * k = m
// k * m = g
// m * m = t
// m * g = p
// g * g = e
val Byte = Units("B", Category.DIGITAL_STORAGE) { it * 8 }
val KiloByte = Units("kB", Category.DIGITAL_STORAGE) { it * Kilo * 8 }
val MegaByte = Units("MB", Category.DIGITAL_STORAGE) { it * Mega * 8 }
val GigaByte = Units("GB", Category.DIGITAL_STORAGE) { it * Giga * 8 }
val TeraByte = Units("TB", Category.DIGITAL_STORAGE) { it  * Mega * Mega * 8 }
val PetaByte = Units("PB", Category.DIGITAL_STORAGE) { it * Mega * Giga * 8 }
val ExaByte = Units("EB", Category.DIGITAL_STORAGE) { it * Giga * Giga * 8 }
val KibiByte = Units("KiB", Category.DIGITAL_STORAGE) { it * 1024 * 8 }
val MebiByte = Units("MiB", Category.DIGITAL_STORAGE) { it * (1024 shl 10) * 8 }
val GibiByte = Units("GiB", Category.DIGITAL_STORAGE) { it * (1024 shl 20) * 8 }
val TebiByte = Units("TiB", Category.DIGITAL_STORAGE) { it * (1024 shl 30) * 8 }
val PebiByte = Units("PiB", Category.DIGITAL_STORAGE) { it * (1024 shl 40) * 8 }
val ExbiByte = Units("EiB", Category.DIGITAL_STORAGE) { it * (1024 shl 50) * 8 }
val KiloBit = Units("kbit", Category.DIGITAL_STORAGE) { it * Kilo }
val MegaBit = Units("Mbit", Category.DIGITAL_STORAGE) { it * Mega }
val GigaBit = Units("Gbit", Category.DIGITAL_STORAGE) { it * Giga }
val TeraBit = Units("Tbit", Category.DIGITAL_STORAGE) { it  * Mega * Mega }
val PetaBit = Units("Pbit", Category.DIGITAL_STORAGE) { it * Mega * Giga }
val ExaBit = Units("Ebit", Category.DIGITAL_STORAGE) { it * Giga * Giga }
val KibiBit = Units("Kibit", Category.DIGITAL_STORAGE) { it * 1024 }
val MebiBit = Units("Mibit", Category.DIGITAL_STORAGE) { it * (1024 shl 10)}
val GibiBit = Units("Gibit", Category.DIGITAL_STORAGE) { it * (1024 shl 20)}
val TebiBit = Units("Tibit", Category.DIGITAL_STORAGE) { it * (1024 shl 30)}
val PebiBit = Units("Pibit", Category.DIGITAL_STORAGE) { it * (1024 shl 40)}
val ExbiBit = Units("Eibit", Category.DIGITAL_STORAGE) { it * (1024 shl 50)}

val DigitalStorage = arrayOf(
    Byte, KiloByte, MegaByte, GigaByte, TeraByte, PetaByte, ExaByte, 
    KibiByte, MebiByte, GibiByte, TebiByte, PebiByte, ExbiByte, 
    Bit, KiloBit, MegaBit, GigaBit, TeraBit, PetaBit, ExaBit, 
    KibiBit, MebiBit, GibiBit, TebiBit, PebiBit, ExbiBit 
)
// endregion


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
val Gram = Units("gm", Category.MASS) { it / Kilo } 
val Milligram = Units("mg", Category.MASS) { it / Mega } 
val PoundMass = Units("lb", Category.MASS) { it * 0.45359237 }
val Ounce = Units("oz", Category.MASS) { PoundMass.standardize(it) / 16 }
val Stone = Units("st", Category.MASS) { PoundMass.standardize(it) * 14 }
val HundredweightShort = Units("cwt (short)", Category.MASS) { PoundMass.standardize(it) * 100 }
val HundredweightLong = Units("cwt (long)", Category.MASS) { PoundMass.standardize(it) * 112 }
val Grain = Units("gr", Category.MASS) { it * 64.79891E-6 }
val ShortTon = Units("tn", Category.MASS) { PoundMass.standardize(it) * 2000 }
val LongTon = Units("LT", Category.MASS) { PoundMass.standardize(it) * 2240 }
val Tonne = Units("T", Category.MASS) { it * 1000 }
val Carat = Units("ct", Category.MASS) { it * 0.0002 }

val Masses = arrayOf(
    Kilogram, Gram, Milligram, PoundMass, Ounce,
    Stone, ShortHundredweight, LongHundredweight,
    ShortTon, LongTon, Tonne, Grain, Carat
)
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
