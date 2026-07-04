package com.sodamoney.quickuconvert

import java.math.BigDecimal
import java.math.MathContext

/*
 * Copyright 2026 David Weiss
 *
 * Collection of Derived to be used.
 */

// region constants
private val context = MathContext.DECIMAL64
val Kilo = BigDecimal(1000)
val Mega = Kilo.multiply(Kilo)
val Giga = Kilo.multiply(Mega)
val Kibi = BigDecimal(1024)
val Mebi = Kibi.multiply(Kibi, context)
val Gibi = Kibi.multiply(Mebi, context)
// endregion

// region Acceleration
val InchPerSecondSquared = Units("in/s²", Category.ACCELERATION) { Inch.convertTo(it, Meter) }
val FootPerSecondSquared = Units("ft/s²", Category.ACCELERATION) { Foot.convertTo(it, Meter) }
val CentimeterPerSecondSquared =
    Units("cm/s²", Category.ACCELERATION) { it.divide(BigDecimal(100), context) }
val MillimeterPerSecondSquared =
    Units("mm/s²", Category.ACCELERATION) { it.divide(BigDecimal(1000), context) }
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
val SquareInch = Units("in²", Category.AREA) { Inch.standardize( BigDecimal(1) ).pow(2) * it }
val SquareFoot = Units("ft²", Category.AREA) { Foot.standardize( BigDecimal(1) ).pow(2) * it }
val SquareYard = Units("yd²", Category.AREA) { Yard.standardize( BigDecimal(1) ).pow(2) * it }
val SquareMile = Units("mi²", Category.AREA) { Mile.standardize( BigDecimal(1) ).pow(2) * it }
val SquareKilometer = Units("km²", Category.AREA) { it * Mega }
val SquareCentimeter = Units("cm²", Category.AREA) { it.divide(BigDecimal(10_000), context) }
val SquareMillimeter = Units("mm²", Category.AREA) { it.divide(Mega) }
val Hectare = Units("ha", Category.AREA) { it * BigDecimal(10_000) }
val Acre = Units("ac", Category.AREA) { BigDecimal(4840) * SquareYard.standardize( it) }

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
val MilligramPerDeciliter = Units("mg/dL", Category.DENSITY) { it.divide(BigDecimal(100),
    context) }
val PoundPerCubicInch = Units("lb/in³", Category.DENSITY) {
    PoundMass.standardize(BigDecimal(1)) / CubicInch.standardize(BigDecimal(1)) * it
 }
val PoundPerCubicFoot = Units("lb/ft³", Category.DENSITY) {
    PoundMass.standardize(BigDecimal(1)) / CubicFoot.standardize(BigDecimal(1)) * it
 }
val PoundPerCubicYard = Units("lb/yd³", Category.DENSITY) {
    PoundMass.standardize(BigDecimal(1)) / CubicYard.standardize(BigDecimal(1)) * it
 }
val PoundPerCubicGallon = Units("lb/gal", Category.DENSITY) {
    PoundMass.standardize(BigDecimal(1)) / Gallon.standardize(BigDecimal(1)) * it
 }
val OuncePerCubicGallon = Units("oz/gal", Category.DENSITY) {
    Ounce.standardize(BigDecimal(1)) / Gallon.standardize(BigDecimal(1)) * it
 }

val Densities = arrayOf(
    KilogramPerCubicMeter, KilogramPerLiter, KilogramPerCubicCentimeter,
    GramPerCubicCentimeter, MilligramPerDeciliter, PoundPerCubicInch,
    PoundPerCubicFoot, PoundPerCubicYard, PoundPerCubicGallon,OuncePerCubicGallon
)
// endregion

// region Digital Storage
// K * K = M
// K * M = G
// M * M = T
// M * G = P
// G * G = E
val Byte = Units("B", Category.DIGITAL_STORAGE) { it * BigDecimal(8) }
val KiloByte = Units("kB", Category.DIGITAL_STORAGE) { it * Kilo * BigDecimal(8) }
val MegaByte = Units("MB", Category.DIGITAL_STORAGE) { it * Mega * BigDecimal(8) }
val GigaByte = Units("GB", Category.DIGITAL_STORAGE) { it * Giga * BigDecimal(8) }
val TeraByte = Units("TB", Category.DIGITAL_STORAGE) { it  * Mega * Mega * BigDecimal(8) }
val PetaByte = Units("PB", Category.DIGITAL_STORAGE) { it * Mega * Giga * BigDecimal(8) }
val ExaByte = Units("EB", Category.DIGITAL_STORAGE) { it * Giga * Giga * BigDecimal(8) }
val KibiByte = Units("KiB", Category.DIGITAL_STORAGE) { it * Kibi * BigDecimal(8) }
val MebiByte = Units("MiB", Category.DIGITAL_STORAGE) { it * Mebi * BigDecimal(8) }
val GibiByte = Units("GiB", Category.DIGITAL_STORAGE) { it * Gibi * BigDecimal(8) }
val TebiByte = Units("TiB", Category.DIGITAL_STORAGE) { it * Mebi * Mebi * BigDecimal(8) }
val PebiByte = Units("PiB", Category.DIGITAL_STORAGE) { it * Mebi * Gibi * BigDecimal(8) }
val ExbiByte = Units("EiB", Category.DIGITAL_STORAGE) { it * Gibi * Gibi * BigDecimal(8) }
val KiloBit = Units("kbit", Category.DIGITAL_STORAGE) { it * Kilo }
val MegaBit = Units("Mbit", Category.DIGITAL_STORAGE) { it * Mega }
val GigaBit = Units("Gbit", Category.DIGITAL_STORAGE) { it * Giga }
val TeraBit = Units("Tbit", Category.DIGITAL_STORAGE) { it  * Mega * Mega }
val PetaBit = Units("Pbit", Category.DIGITAL_STORAGE) { it * Mega * Giga }
val ExaBit = Units("Ebit", Category.DIGITAL_STORAGE) { it * Giga * Giga }
val KibiBit = Units("Kibit", Category.DIGITAL_STORAGE) { it * Kibi }
val MebiBit = Units("Mibit", Category.DIGITAL_STORAGE) { it * Mebi }
val GibiBit = Units("Gibit", Category.DIGITAL_STORAGE) { it * Gibi }
val TebiBit = Units("Tibit", Category.DIGITAL_STORAGE) { it * Mebi * Mebi }
val PebiBit = Units("Pibit", Category.DIGITAL_STORAGE) { it * Mebi * Gibi }
val ExbiBit = Units("Eibit", Category.DIGITAL_STORAGE) { it * Gibi * Gibi }

val DigitalStorage = arrayOf(
    Byte, KiloByte, MegaByte, GigaByte, TeraByte, PetaByte, ExaByte, 
    KibiByte, MebiByte, GibiByte, TebiByte, PebiByte, ExbiByte, 
    Bit, KiloBit, MegaBit, GigaBit, TeraBit, PetaBit, ExaBit,
    KibiBit, MebiBit, GibiBit, TebiBit, PebiBit, ExbiBit 
)
// endregion

// region Energy
val KiloJoule = Units("kJ", Category.ENERGY) { it * Kilo }
val MegaJoule = Units("MJ", Category.ENERGY) { it * Mega }
val KiloWattHour = Units("kw⋅h", Category.ENERGY) { it * BigDecimal(3600000) }
val Calorie = Units("cal", Category.ENERGY) { it * BigDecimal("4.1868") }
val KiloCalorie = Units("kcal", Category.ENERGY) { it * BigDecimal("4186.8") }
val Btu = Units("BTU", Category.ENERGY) { it * BigDecimal("1055.05585262") }
val KiloBtu= Units("kBTU", Category.ENERGY) { Btu.standardize(it) * Kilo }
val Erg = Units("erg", Category.ENERGY) { it * BigDecimal("1E-7") }

val Energies = arrayOf(
    Joule, KiloJoule, MegaJoule, KiloWattHour, Calorie, KiloCalorie,
    Btu, KiloBtu, Erg,
)
// endregion

// region Forces
val Kilonewton = Units("kN", Category.FORCE) { Newton.standardize(it) * Kilo }
val KilogramForce = Units("kgf", Category.FORCE) { it * EARTH_GRAVITY }
val Dyne = Units("dyn", Category.FORCE) { Newton.standardize(it).divide(BigDecimal(100_000), context) }
val PoundForce = Units("lbf", Category.FORCE) { it * (EARTH_GRAVITY * PoundMass.standardize(BigDecimal(1))) }
val Kips = Units("kip", Category.FORCE) { PoundForce.standardize(it) * Kilo }
val Poundal = Units(
    "pdl", Category.FORCE
) { PoundMass.standardize(it) * FootPerSecondSquared.standardize(BigDecimal(1)) }

val Forces = arrayOf(
    Newton, Kilonewton, KilogramForce, Dyne, PoundForce, Kips, Poundal
)
// endregion

// region Length
val Kilometer = Units("km", Category.LENGTH) { it * Kilo }
val Centimeter = Units("cm", Category.LENGTH) { it.divide(BigDecimal(100), context) }
val Millimeter = Units("mm", Category.LENGTH) { it.divide(Kilo, context) }
val Micrometer = Units("μm", Category.LENGTH) { it.divide(Mega, context) }
val Nanometer = Units("nm", Category.LENGTH) { it.divide(Giga, context) }
val Inch = Units("in", Category.LENGTH) { it * BigDecimal("0.0254") }
val Foot = Units("ft", Category.LENGTH) { it * BigDecimal("0.3048") }
val Yard = Units("yd", Category.LENGTH) { it * BigDecimal("0.3048") * BigDecimal(3) }
val Mile = Units("mi", Category.LENGTH) { it * BigDecimal("0.3048") * BigDecimal(5_280) }
val Thou = Units("mils", Category.LENGTH) { it * BigDecimal("0.0254").divide(Kilo, context) }
val NauticalMile = Units("nmi", Category.LENGTH) { it * BigDecimal(1852) }
val Fathom = Units("ftm", Category.LENGTH) { Foot.standardize(it) * BigDecimal(6) }
val Rod = Units("rd", Category.LENGTH) { Foot.standardize(it) * BigDecimal(16.5) }
val Chain = Units("ch", Category.LENGTH) { Rod.standardize(it) * BigDecimal(4) }
val Furlong = Units("fur", Category.LENGTH) { Mile.standardize(it) / BigDecimal(8) }
val Angstrom = Units("Å", Category.LENGTH) { it * BigDecimal(1E-10) }
val LightYear = Units("ly", Category.LENGTH) {
    it * (SPEED_OF_LIGHT * Year.convertTo(BigDecimal(1), Second))
}

val Lengths = arrayOf(
    Kilometer, Meter, Centimeter, Millimeter, Micrometer,
    Nanometer, Inch, Thou, Foot, Yard,
    Mile, Rod, Chain, Furlong, NauticalMile,
    Fathom, Angstrom, LightYear
)
// endregion

// region Mass
val Gram = Units("gm", Category.MASS) { it.divide(Kilo, context) }
val Milligram = Units("mg", Category.MASS) { it.divide(Mega, context) }
val PoundMass = Units("lb", Category.MASS) { it * BigDecimal("0.45359237") }
val Ounce = Units("oz", Category.MASS) { PoundMass.standardize(it).divide(BigDecimal(16), context) }
val Stone = Units("st", Category.MASS) { PoundMass.standardize(it) * BigDecimal(14) }
val HundredweightShort = Units("cwt (short)", Category.MASS) { PoundMass.standardize(it) * BigDecimal(100) }
val HundredweightLong = Units("cwt (long)", Category.MASS) { PoundMass.standardize(it) * BigDecimal(112) }
val Grain = Units("gr", Category.MASS) { it * BigDecimal("64.79891E-6") }
val ShortTon = Units("tn", Category.MASS) { PoundMass.standardize(it) * BigDecimal(2000) }
val LongTon = Units("LT", Category.MASS) { PoundMass.standardize(it) * BigDecimal(2240) }
val Tonne = Units("T", Category.MASS) { it * BigDecimal(1000) }
val Carat = Units("ct", Category.MASS) { it * BigDecimal("0.0002") }

val Masses = arrayOf(
    Kilogram, Gram, Milligram, PoundMass, Ounce,
    Stone, HundredweightShort, HundredweightLong,
    ShortTon, LongTon, Tonne, Grain, Carat
)
// endregion

// region Mass Flow Rate
val KilogramPerMinute = Units("kg/min", Category.MASS_FLOW) { it.divide(BigDecimal(60), context) }
val KilogramPerHour = Units("kg/hr", Category.MASS_FLOW) { it.divide(BigDecimal(3600), context) }
val GramPerSecond = Units("g/s", Category.MASS_FLOW) { it.divide(BigDecimal(1000)) }
val GramPerMinute = Units("g/min", Category.MASS_FLOW) { it.divide(BigDecimal(60_000), context) }
val GramPerHour = Units("g/hr", Category.MASS_FLOW) { it.divide(BigDecimal(3_600_000), context) }
val PoundPerSecond = Units("lb/s", Category.MASS_FLOW) { PoundMass.standardize(it) }
val PoundPerMinute = Units("lb/min", Category.MASS_FLOW) {PoundPerSecond.standardize(it).divide(BigDecimal(60), context) }
val PoundPerHour = Units("lb/hr", Category.MASS_FLOW) {PoundPerSecond.standardize(it).divide(BigDecimal(3600), context) }
val OuncePerSecond = Units("oz/s", Category.MASS_FLOW) { Ounce.standardize(it) }
val OuncePerMinute = Units("oz/min", Category.MASS_FLOW) {OuncePerSecond.standardize(it).divide(BigDecimal(60), context) }
val OuncePerHour = Units("oz/hr", Category.MASS_FLOW) {OuncePerSecond.standardize(it).divide(BigDecimal(3600), context) }

val MassFlowRates = arrayOf(
    KilogramPerSecond, KilogramPerMinute, KilogramPerHour,
    GramPerSecond, GramPerMinute, GramPerHour,
    PoundPerSecond, PoundPerMinute, PoundPerHour,
    OuncePerSecond, OuncePerMinute, OuncePerHour
)
// endregion

// region Moments / Torques
val KilonewtonMeter = Units("kN⋅m", Category.MOMENT) { it * Kilo }
val NewtonCentimeter = Units("N⋅cm", Category.MOMENT) { it * BigDecimal("0.01") }
val NewtonMillimeter = Units("N⋅mm", Category.MOMENT) { it * BigDecimal("0.001") }
val KilogramForceMeter = Units("kg⋅m", Category.MOMENT) { it * EARTH_GRAVITY }
val KilogramForceCentimeter = Units("kg⋅cm", Category.MOMENT) { it * EARTH_GRAVITY * BigDecimal("0.01") }
val KilogramForceMillimeter = Units("kg⋅mm", Category.MOMENT) { it * EARTH_GRAVITY * BigDecimal("0.001") }
val FootPound = Units("ft⋅lb", Category.MOMENT) { PoundForce.standardize(it) * Foot.standardize(BigDecimal(1)) }
val FootKip = Units("ft⋅kip", Category.MOMENT) { Kips.standardize(it) * Foot.standardize(BigDecimal(1)) }
val InchPound = Units("in⋅lb", Category.MOMENT) { PoundForce.standardize(it) * Inch.standardize(BigDecimal(1)) }
val InchKip = Units("in⋅kip", Category.MOMENT) { Kips.standardize(it) * Inch.standardize(BigDecimal(1)) }

val Moments = arrayOf(
    KilonewtonMeter, NewtonMeter, NewtonCentimeter, NewtonMillimeter,
    KilogramForceMeter, KilogramForceCentimeter, KilogramForceMillimeter,
    FootPound, FootKip, InchPound, InchKip
)
// endregion

// region Temperatures
class TemperatureUnits(
    symbol: String, standardize: (BigDecimal) -> BigDecimal, val fromStandard: (BigDecimal) -> BigDecimal
) : Units(
    symbol, Category.TEMPERATURE, standardize
) {
    override fun convertTo(inputValue: BigDecimal, other: Units): BigDecimal {
        if (other !is TemperatureUnits) {
            throw IllegalConversionException(
                "Can't convert from ${this.symbol} to ${other.symbol}. Base units are mismatched ${this.category.baseUnits()} and ${other.category.baseUnits()}"
            )
        }
        return other.fromStandard(this.standardize(inputValue))
    }
}

val Centigrade = TemperatureUnits("°C", { BigDecimal("273.15") + it }, { it - BigDecimal("273.15") })
val Fahrenheit = TemperatureUnits("°F", { (BigDecimal("459.67") + it) / BigDecimal("1.8") }, { (it * BigDecimal("1.8")) - BigDecimal("459.67") })
val Rankine = TemperatureUnits("°R", { it / BigDecimal("1.8") }, { it * BigDecimal("1.8") })

val Temperatures = arrayOf(Centigrade, Fahrenheit, Kelvin, Rankine)
// endregion

// region Time
val Millisecond = Units("ms", Category.TIME) { it.divide(Kilo, context) }
val Microsecond = Units("μs", Category.TIME) { it.divide(Mega, context) }
val Nanosecond = Units("ns", Category.TIME) { it.divide(Giga, context) }
val Minute = Units("m", Category.TIME) { it * BigDecimal(60) }
val Hour = Units("hr", Category.TIME) { Minute.standardize(it) * BigDecimal(60) }
val Day = Units("d", Category.TIME) { Hour.standardize(it) * BigDecimal(24) }
val Year = Units("yr", Category.TIME) { Day.standardize(it) * BigDecimal(365.25) }
val Week = Units("wk", Category.TIME) { Day.standardize(it) * BigDecimal(7) }
val Month = Units("mo", Category.TIME) { Year.standardize(it) / BigDecimal(12) }
val Decade = Units("dec", Category.TIME) { Year.standardize(it) * BigDecimal(10) }
val Century = Units("cen", Category.TIME) { Year.standardize(it) * BigDecimal(100) }

val Times = arrayOf(
    Nanosecond, Microsecond, Millisecond, Second, Minute, Hour,
    Day, Week, Month, Year, Decade, Century
)
// endregion

// region Power
val Kilowatt = Units("kW", Category.POWER) { it * Kilo }
val Megawatt = Units("MW", Category.POWER) { it * Mega }
val Gigawatt = Units("GW", Category.POWER) { it * Giga }
val ErgPerSecond = Units("erg/s", Category.POWER) { it * BigDecimal("1E-7") }
val CaloriePerSecond = Units("cal/s", Category.POWER) { it * BigDecimal("4.1868") }

val BtuPerSecond = Units("BTU/s", Category.POWER) { Btu.standardize(it) }
val BtuPerMinute = Units("BTU/min", Category.POWER) { Btu.standardize(it).divide(BigDecimal(60), context) }
val BtuPerHour = Units("BTU/hr", Category.POWER) { Btu.standardize(it).divide(BigDecimal(3600), context) }
val TonOfRefrigeration = Units("TR", Category.POWER) { BtuPerHour.standardize(it) * BigDecimal(12_000) }
val HorsePower = Units("HP", Category.POWER) { FootPound.standardize(it) * BigDecimal(550) }
val MetricHorsePower = Units("PS", Category.POWER) { KilogramForce.standardize(it) * BigDecimal(75) }

val Powers = arrayOf(
    Watt, Kilowatt, Megawatt, Gigawatt, ErgPerSecond, CaloriePerSecond,
    BtuPerSecond, BtuPerMinute, BtuPerHour, TonOfRefrigeration,
    HorsePower, MetricHorsePower
)
// endregion

// region Pressure
val KiloPascal = Units("kPa", Category.PRESSURE) { it * Kilo } 
val MegaPascal = Units("MPa", Category.PRESSURE) { it * Mega } 
val GigaPascal = Units("GPa", Category.PRESSURE) { it * Giga } 
val KilogramPerSquareCentimeter = Units("kg/cm²", Category.PRESSURE) { it * EARTH_GRAVITY } 
val GramPerSquareCentimeter = Units("gm/cm²", Category.PRESSURE) { it * EARTH_GRAVITY * BigDecimal(10) } 
val DynePerSquareCentimeter = Units("gm/cm²", Category.PRESSURE) { it.divide(BigDecimal(10), context) }
val Bar = Units("bar", Category.PRESSURE) { it * BigDecimal(100_000) } 
val Atmosphere = Units("atm", Category.PRESSURE) { it * BigDecimal(101_325) } 
val PoundPerSquareInch = Units("psi", Category.PRESSURE) { PoundForce.standardize(it).divide(SquareInch.standardize(BigDecimal(1)), context)}
val KipPerSquareInch = Units("ksi", Category.PRESSURE) { Kips.standardize(it).divide(SquareInch.standardize(BigDecimal(1)), context)}
val PoundPerSquareFoot = Units("psf", Category.PRESSURE) { PoundForce.standardize(it).divide(SquareFoot.standardize(BigDecimal(1)), context)}
// Water column pressure: density (ρ) * length * g
// ρH₂O @ 60F = 998.98kg/m^2
// ρHg @ 0C = 13595.1kg/m^2
val InchOfWater = Units("inH₂O", Category.PRESSURE) { it * BigDecimal("998.98") * Inch.standardize(BigDecimal(1)) * EARTH_GRAVITY }
val FootOfWater = Units("ftH₂O", Category.PRESSURE) { it * BigDecimal("998.98") * Foot.standardize(BigDecimal(1)) * EARTH_GRAVITY }
val InchOfMercury = Units("inHg", Category.PRESSURE) { it * BigDecimal("13595.1") * Inch.standardize(BigDecimal(1)) * EARTH_GRAVITY }
val MillimeterOfMercury= Units("mmHg", Category.PRESSURE) { it * BigDecimal("13595.1") * Millimeter.standardize(BigDecimal(1)) * EARTH_GRAVITY }

val Pressures = arrayOf(
    Pascal, KiloPascal, MegaPascal, GigaPascal, KilogramPerSquareCentimeter,
    GramPerSquareCentimeter, DynePerSquareCentimeter, Bar, Atmosphere,
    PoundPerSquareInch, KipPerSquareInch, PoundPerSquareFoot, InchOfWater,
    FootOfWater, InchOfMercury, MillimeterOfMercury
)
// endregion

// region Volume
val Liter = Units("L", Category.VOLUME) { it.divide(BigDecimal(1_000), context) }
val Deciliter = Units("dL", Category.VOLUME) { it.divide(BigDecimal(10_000), context) }
val CubicCentimeter = Units("CC/mL", Category.VOLUME) { it.divide(Mega, context) }
val CubicMillimeter = Units("mm³", Category.VOLUME) { it.divide(Giga, context) }
val CubicInch = Units("in³", Category.VOLUME) { Inch.standardize(BigDecimal(1)).pow(3) * it }
val CubicFoot = Units("ft³", Category.VOLUME) { Foot.standardize(BigDecimal(1)).pow(3) * it }
val CubicYard = Units("yd³", Category.VOLUME) { Yard.standardize(BigDecimal(1)).pow(3) * it }
val AcreFoot = Units("acre⋅ft", Category.VOLUME) { CubicFoot.standardize(it) * BigDecimal(43_560) }
val Gallon = Units("gal", Category.VOLUME) { CubicInch.standardize(it) * BigDecimal(231) }
val WetBarrel = Units("bbl (wet)", Category.VOLUME) { Gallon.standardize(it) * BigDecimal("31.5") }
val WetQuart = Units("qt (wet)", Category.VOLUME) { Gallon.standardize(it).divide(BigDecimal(4),
    context) }
val WetPint = Units("pt (wet)", Category.VOLUME) { Gallon.standardize(it).divide(BigDecimal(8),
    context) }
val Cup = Units("cu", Category.VOLUME) { Gallon.standardize(it).divide(BigDecimal(16), context) }
val FluidOunce = Units("fl oz", Category.VOLUME) { Gallon.standardize(it).divide(BigDecimal(128),
    context) }
val Tablespoon = Units("tbsp", Category.VOLUME) { FluidOunce.standardize(it).divide(BigDecimal(2),
    context) }
val Teaspoon = Units("tsp", Category.VOLUME) { FluidOunce.standardize(it).divide(BigDecimal(6),
    context) }
val DryPint = Units("pt (dry)", Category.VOLUME) { CubicInch.standardize(it) * BigDecimal("33.6003125") }
val DryQuart = Units("qt (dry)", Category.VOLUME) { DryPint.standardize(it) * BigDecimal(2) }
val Peck = Units("pk", Category.VOLUME) { DryQuart.standardize(it) * BigDecimal(8) }
val Bushel = Units("bu", Category.VOLUME) { Peck.standardize(it) * BigDecimal(4) }
val DryBarrel = Units("bbl (dry)", Category.VOLUME) { CubicInch.standardize(it) * BigDecimal(7056) }

val Volumes = arrayOf(
    CubicMeter, Liter, Deciliter, CubicCentimeter, CubicMillimeter,
    CubicInch, CubicFoot, CubicYard, AcreFoot,
    Gallon, WetBarrel, WetQuart, WetPint, Cup, FluidOunce, Tablespoon, Teaspoon,
    DryPint, DryQuart, Peck, Bushel, DryBarrel,
)
// endregion
