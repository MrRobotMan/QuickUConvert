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
val InchPerSecondSquared = Units("in/s²", "Inches per second squared",  Category.ACCELERATION) { Inch.convertTo(it, Meter) }
val FootPerSecondSquared = Units("ft/s²", "Feet per second squared",  Category.ACCELERATION) { Foot.convertTo(it, Meter) }
val CentimeterPerSecondSquared =
    Units("cm/s²", "Centimeters per second squared",  Category.ACCELERATION) { it.divide(BigDecimal(100), context) }
val MillimeterPerSecondSquared =
    Units("mm/s²", "Millimeters per second squared",  Category.ACCELERATION) { it.divide(BigDecimal(1000), context) }
val EarthGravity = Units("g", "Earth gravity",  Category.ACCELERATION) { EARTH_GRAVITY * it }

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
val SquareInch = Units("in²", "Square inches",  Category.AREA) { Inch.standardize( BigDecimal(1) ).pow(2) * it }
val SquareFoot = Units("ft²", "Square feet",  Category.AREA) { Foot.standardize( BigDecimal(1) ).pow(2) * it }
val SquareYard = Units("yd²", "Square yards",  Category.AREA) { Yard.standardize( BigDecimal(1) ).pow(2) * it }
val SquareMile = Units("mi²", "Square miles",  Category.AREA) { Mile.standardize( BigDecimal(1) ).pow(2) * it }
val SquareKilometer = Units("km²", "Square kilometers",  Category.AREA) { it * Mega }
val SquareCentimeter = Units("cm²", "Square centimeters",  Category.AREA) { it.divide(BigDecimal(10_000), context) }
val SquareMillimeter = Units("mm²", "Square millimeters",  Category.AREA) { it.divide(Mega) }
val Hectare = Units("ha", "Hectares",  Category.AREA) { it * BigDecimal(10_000) }
val Acre = Units("ac", "Acres",  Category.AREA) { BigDecimal(4840) * SquareYard.standardize( it) }

val Areas = arrayOf(
    SquareKilometer, SquareMeter, SquareCentimeter, SquareMillimeter,
    SquareMile, SquareYard, SquareFoot, SquareInch,
    Hectare, Acre
)
// endregion

// region Density
val KilogramPerLiter = Units("kg/L", "Kilograms per liter",  Category.DENSITY) { it * Kilo }
val KilogramPerCubicCentimeter = Units("kg/cm³", "Kilograms per centimeter cubed",  Category.DENSITY) { it * Mega }
val GramPerCubicCentimeter = Units("g/cm³", "Grams per centimeter cubed",  Category.DENSITY) { it * Kilo }
val MilligramPerDeciliter = Units("mg/dL", "Milligrams per deciliter",  Category.DENSITY) { it.divide(BigDecimal(100),
    context) }
val PoundPerCubicInch = Units("lb/in³", "Pounds per inch cubed",  Category.DENSITY) {
    PoundMass.standardize(BigDecimal(1)) / CubicInch.standardize(BigDecimal(1)) * it
 }
val PoundPerCubicFoot = Units("lb/ft³", "Pounds per foot cubed",  Category.DENSITY) {
    PoundMass.standardize(BigDecimal(1)) / CubicFoot.standardize(BigDecimal(1)) * it
 }
val PoundPerCubicYard = Units("lb/yd³", "Pounds per yard cubed",  Category.DENSITY) {
    PoundMass.standardize(BigDecimal(1)) / CubicYard.standardize(BigDecimal(1)) * it
 }
val PoundPerCubicGallon = Units("lb/gal", "Pounds per gallon cubed",  Category.DENSITY) {
    PoundMass.standardize(BigDecimal(1)) / Gallon.standardize(BigDecimal(1)) * it
 }
val OuncePerCubicGallon = Units("oz/gal", "Ounces per gallon cubed",  Category.DENSITY) {
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
val Byte = Units("B", "Bytes",  Category.DIGITAL_STORAGE) { it * BigDecimal(8) }
val KiloByte = Units("kB", "Kilobytes",  Category.DIGITAL_STORAGE) { it * Kilo * BigDecimal(8) }
val MegaByte = Units("MB", "Megabytes",  Category.DIGITAL_STORAGE) { it * Mega * BigDecimal(8) }
val GigaByte = Units("GB", "Gigabytes",  Category.DIGITAL_STORAGE) { it * Giga * BigDecimal(8) }
val TeraByte = Units("TB", "Terabytes",  Category.DIGITAL_STORAGE) { it  * Mega * Mega * BigDecimal(8) }
val PetaByte = Units("PB", "Petabytes",  Category.DIGITAL_STORAGE) { it * Mega * Giga * BigDecimal(8) }
val ExaByte = Units("EB", "Exabytes",  Category.DIGITAL_STORAGE) { it * Giga * Giga * BigDecimal(8) }
val KibiByte = Units("KiB", "Kibibytes",  Category.DIGITAL_STORAGE) { it * Kibi * BigDecimal(8) }
val MebiByte = Units("MiB", "Mebibytes",  Category.DIGITAL_STORAGE) { it * Mebi * BigDecimal(8) }
val GibiByte = Units("GiB", "Gibibytes",  Category.DIGITAL_STORAGE) { it * Gibi * BigDecimal(8) }
val TebiByte = Units("TiB", "Tebibytes",  Category.DIGITAL_STORAGE) { it * Mebi * Mebi * BigDecimal(8) }
val PebiByte = Units("PiB", "Pebibytes",  Category.DIGITAL_STORAGE) { it * Mebi * Gibi * BigDecimal(8) }
val ExbiByte = Units("EiB", "Exbibytes",  Category.DIGITAL_STORAGE) { it * Gibi * Gibi * BigDecimal(8) }
val KiloBit = Units("kbit", "Kilobits",  Category.DIGITAL_STORAGE) { it * Kilo }
val MegaBit = Units("Mbit", "Megabits",  Category.DIGITAL_STORAGE) { it * Mega }
val GigaBit = Units("Gbit", "Gigabits",  Category.DIGITAL_STORAGE) { it * Giga }
val TeraBit = Units("Tbit", "Terabits",  Category.DIGITAL_STORAGE) { it  * Mega * Mega }
val PetaBit = Units("Pbit", "Petabits",  Category.DIGITAL_STORAGE) { it * Mega * Giga }
val ExaBit = Units("Ebit", "Exabits",  Category.DIGITAL_STORAGE) { it * Giga * Giga }
val KibiBit = Units("Kibit", "Kibibits",  Category.DIGITAL_STORAGE) { it * Kibi }
val MebiBit = Units("Mibit", "Mebibits",  Category.DIGITAL_STORAGE) { it * Mebi }
val GibiBit = Units("Gibit", "Gibibits",  Category.DIGITAL_STORAGE) { it * Gibi }
val TebiBit = Units("Tibit", "Tebibits",  Category.DIGITAL_STORAGE) { it * Mebi * Mebi }
val PebiBit = Units("Pibit", "Pebibits",  Category.DIGITAL_STORAGE) { it * Mebi * Gibi }
val ExbiBit = Units("Eibit", "Exbibits",  Category.DIGITAL_STORAGE) { it * Gibi * Gibi }

val DigitalStorage = arrayOf(
    Byte, KiloByte, MegaByte, GigaByte, TeraByte, PetaByte, ExaByte, 
    KibiByte, MebiByte, GibiByte, TebiByte, PebiByte, ExbiByte, 
    Bit, KiloBit, MegaBit, GigaBit, TeraBit, PetaBit, ExaBit,
    KibiBit, MebiBit, GibiBit, TebiBit, PebiBit, ExbiBit 
)
// endregion

// region Energy
val KiloJoule = Units("kJ", "Kilojoules",  Category.ENERGY) { it * Kilo }
val MegaJoule = Units("MJ", "Megajoules",  Category.ENERGY) { it * Mega }
val KiloWattHour = Units("kw⋅h", "Kilowatt-hours",  Category.ENERGY) { it * BigDecimal(3600000) }
val Calorie = Units("cal", "Calories",  Category.ENERGY) { it * BigDecimal("4.1868") }
val KiloCalorie = Units("kcal", "Kilocalorie",  Category.ENERGY) { it * BigDecimal("4186.8") }
val Btu = Units("BTU", "BTUs",  Category.ENERGY) { it * BigDecimal("1055.05585262") }
val KiloBtu = Units("kBTU", "KiloBTUs",  Category.ENERGY) { Btu.standardize(it) * Kilo }
val Erg = Units("erg", "Ergs",  Category.ENERGY) { it * BigDecimal("1E-7") }

val Energies = arrayOf(
    Joule, KiloJoule, MegaJoule, KiloWattHour, Calorie, KiloCalorie,
    Btu, KiloBtu, Erg,
)
// endregion

// region Forces
val Kilonewton = Units("kN", "Kilonewtons",  Category.FORCE) { Newton.standardize(it) * Kilo }
val KilogramForce = Units("kgf", "Kilograms (force)",  Category.FORCE) { it * EARTH_GRAVITY }
val Dyne = Units("dyn", "Dynes",  Category.FORCE) { Newton.standardize(it).divide(BigDecimal(100_000), context) }
val PoundForce = Units("lbf", "Pounds (force)",  Category.FORCE) { it * (EARTH_GRAVITY * PoundMass.standardize(BigDecimal(1))) }
val Kips = Units("kip", "Thousand Pounds",  Category.FORCE) { PoundForce.standardize(it) * Kilo }
val Poundal = Units(
    "pdl", "Poundals",  Category.FORCE
) { PoundMass.standardize(it) * FootPerSecondSquared.standardize(BigDecimal(1)) }

val Forces = arrayOf(
    Newton, Kilonewton, KilogramForce, Dyne, PoundForce, Kips, Poundal
)
// endregion

// region Length
val Kilometer = Units("km", "Kilometers",  Category.LENGTH) { it * Kilo }
val Centimeter = Units("cm", "Centimeters",  Category.LENGTH) { it.divide(BigDecimal(100), context) }
val Millimeter = Units("mm", "Millimeters",  Category.LENGTH) { it.divide(Kilo, context) }
val Micrometer = Units("μm", "Micrometers",  Category.LENGTH) { it.divide(Mega, context) }
val Nanometer = Units("nm", "Nanometers",  Category.LENGTH) { it.divide(Giga, context) }
val Inch = Units("in", "Inches",  Category.LENGTH) { it * BigDecimal("0.0254") }
val Foot = Units("ft", "Feet",  Category.LENGTH) { it * BigDecimal("0.3048") }
val Yard = Units("yd", "Yards",  Category.LENGTH) { it * BigDecimal("0.3048") * BigDecimal(3) }
val Mile = Units("mi", "Miles",  Category.LENGTH) { it * BigDecimal("0.3048") * BigDecimal(5_280) }
val Thou = Units("mils", "Mils (Thous)",  Category.LENGTH) { it * BigDecimal("0.0254").divide(Kilo, context) }
val NauticalMile = Units("nmi", "Nautical miles",  Category.LENGTH) { it * BigDecimal(1852) }
val Fathom = Units("ftm", "Fathoms",  Category.LENGTH) { Foot.standardize(it) * BigDecimal(6) }
val Rod = Units("rd", "Rods",  Category.LENGTH) { Foot.standardize(it) * BigDecimal(16.5) }
val Chain = Units("ch", "Chains",  Category.LENGTH) { Rod.standardize(it) * BigDecimal(4) }
val Furlong = Units("fur", "Furlongs",  Category.LENGTH) { Mile.standardize(it) / BigDecimal(8) }
val Angstrom = Units("Å", "Angstroms",  Category.LENGTH) { it * BigDecimal(1E-10) }
val LightYear = Units("ly", "Light years",  Category.LENGTH) {
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
val Gram = Units("gm", "Grams",  Category.MASS) { it.divide(Kilo, context) }
val Milligram = Units("mg", "Milligrams",  Category.MASS) { it.divide(Mega, context) }
val PoundMass = Units("lb", "Pounds (mass)",  Category.MASS) { it * BigDecimal("0.45359237") }
val Ounce = Units("oz", "Ounces",  Category.MASS) { PoundMass.standardize(it).divide(BigDecimal(16), context) }
val Stone = Units("st", "Stones",  Category.MASS) { PoundMass.standardize(it) * BigDecimal(14) }
val HundredweightShort = Units("cwt (short)", "Hundredweights (short)",  Category.MASS) { PoundMass.standardize(it) * BigDecimal(100) }
val HundredweightLong = Units("cwt (long)", "Hundredweights (long)",  Category.MASS) { PoundMass.standardize(it) * BigDecimal(112) }
val Grain = Units("gr", "Grains",  Category.MASS) { it * BigDecimal("64.79891E-6") }
val ShortTon = Units("tn", "Tons (short)",  Category.MASS) { PoundMass.standardize(it) * BigDecimal(2000) }
val LongTon = Units("LT", "Tons (long)",  Category.MASS) { PoundMass.standardize(it) * BigDecimal(2240) }
val Tonne = Units("T", "Tonnes (metric)",  Category.MASS) { it * BigDecimal(1000) }
val Carat = Units("ct", "Carats",  Category.MASS) { it * BigDecimal("0.0002") }

val Masses = arrayOf(
    Kilogram, Gram, Milligram, PoundMass, Ounce,
    Stone, HundredweightShort, HundredweightLong,
    ShortTon, LongTon, Tonne, Grain, Carat
)
// endregion

// region Mass Flow Rate
val KilogramPerMinute = Units("kg/min", "Kilograms per minute",  Category.MASS_FLOW) { it.divide(BigDecimal(60), context) }
val KilogramPerHour = Units("kg/hr", "Kilograms per hour",  Category.MASS_FLOW) { it.divide(BigDecimal(3600), context) }
val GramPerSecond = Units("g/s", "Grams per second",  Category.MASS_FLOW) { it.divide(BigDecimal(1000)) }
val GramPerMinute = Units("g/min", "Grams per minute",  Category.MASS_FLOW) { it.divide(BigDecimal(60_000), context) }
val GramPerHour = Units("g/hr", "Grams per hour",  Category.MASS_FLOW) { it.divide(BigDecimal(3_600_000), context) }
val PoundPerSecond = Units("lb/s", "Pounds per second",  Category.MASS_FLOW) { PoundMass.standardize(it) }
val PoundPerMinute = Units("lb/min", "Pounds per minute",  Category.MASS_FLOW) {PoundPerSecond.standardize(it).divide(BigDecimal(60), context) }
val PoundPerHour = Units("lb/hr", "Pounds per hour",  Category.MASS_FLOW) {PoundPerSecond.standardize(it).divide(BigDecimal(3600), context) }
val OuncePerSecond = Units("oz/s", "Ounces per second",  Category.MASS_FLOW) { Ounce.standardize(it) }
val OuncePerMinute = Units("oz/min", "Ounces per minute",  Category.MASS_FLOW) {OuncePerSecond.standardize(it).divide(BigDecimal(60), context) }
val OuncePerHour = Units("oz/hr", "Ounces per hour",  Category.MASS_FLOW) {OuncePerSecond.standardize(it).divide(BigDecimal(3600), context) }

val MassFlowRates = arrayOf(
    KilogramPerSecond, KilogramPerMinute, KilogramPerHour,
    GramPerSecond, GramPerMinute, GramPerHour,
    PoundPerSecond, PoundPerMinute, PoundPerHour,
    OuncePerSecond, OuncePerMinute, OuncePerHour
)
// endregion

// region Moments / Torques
val KilonewtonMeter = Units("kN⋅m", "Kilonewton-meters",  Category.MOMENT) { it * Kilo }
val NewtonCentimeter = Units("N⋅cm", "Newton-centimeters",  Category.MOMENT) { it * BigDecimal("0.01") }
val NewtonMillimeter = Units("N⋅mm", "Newton-millimeters",  Category.MOMENT) { it * BigDecimal("0.001") }
val KilogramForceMeter = Units("kg⋅m", "Kilogram-meters",  Category.MOMENT) { it * EARTH_GRAVITY }
val KilogramForceCentimeter = Units("kg⋅cm", "Kilogram-centimeters",  Category.MOMENT) { it * EARTH_GRAVITY * BigDecimal("0.01") }
val KilogramForceMillimeter = Units("kg⋅mm", "Kilogram-millimeters",  Category.MOMENT) { it * EARTH_GRAVITY * BigDecimal("0.001") }
val FootPound = Units("ft⋅lb", "Foot-pounds",  Category.MOMENT) { PoundForce.standardize(it) * Foot.standardize(BigDecimal(1)) }
val FootKip = Units("ft⋅kip", "Thousand Foot-pounds",  Category.MOMENT) { Kips.standardize(it) * Foot.standardize(BigDecimal(1)) }
val InchPound = Units("in⋅lb", "Inch-pounds",  Category.MOMENT) { PoundForce.standardize(it) * Inch.standardize(BigDecimal(1)) }
val InchKip = Units("in⋅kip", "Thousand Inch-pounds",  Category.MOMENT) { Kips.standardize(it) * Inch.standardize(BigDecimal(1)) }

val Moments = arrayOf(
    KilonewtonMeter, NewtonMeter, NewtonCentimeter, NewtonMillimeter,
    KilogramForceMeter, KilogramForceCentimeter, KilogramForceMillimeter,
    FootPound, FootKip, InchPound, InchKip
)
// endregion

// region Power
val Kilowatt = Units("kW", "Kilowatts",  Category.POWER) { it * Kilo }
val Megawatt = Units("MW", "Megawatts",  Category.POWER) { it * Mega }
val Gigawatt = Units("GW", "Gigawatts",  Category.POWER) { it * Giga }
val ErgPerSecond = Units("erg/s", "Ergs per second",  Category.POWER) { it * BigDecimal("1E-7") }
val CaloriePerSecond = Units("cal/s", "Calories per second",  Category.POWER) { it * BigDecimal("4.1868") }

val BtuPerSecond = Units("BTU/s", "BTUs per second",  Category.POWER) { Btu.standardize(it) }
val BtuPerMinute = Units("BTU/min", "BTUs per minute",  Category.POWER) { Btu.standardize(it).divide(BigDecimal(60), context) }
val BtuPerHour = Units("BTU/hr", "BTUs per hour",  Category.POWER) { Btu.standardize(it).divide(BigDecimal(3600), context) }
val TonOfRefrigeration = Units("TR", "Tons of refrigeration",  Category.POWER) { BtuPerHour.standardize(it) * BigDecimal(12_000) }
val HorsePower = Units("HP", "Horsepower",  Category.POWER) { FootPound.standardize(it) * BigDecimal(550) }
val MetricHorsePower = Units("PS", "Metric horsepower",  Category.POWER) { KilogramForce.standardize(it) * BigDecimal(75) }

val Powers = arrayOf(
    Watt, Kilowatt, Megawatt, Gigawatt, ErgPerSecond, CaloriePerSecond,
    BtuPerSecond, BtuPerMinute, BtuPerHour, TonOfRefrigeration,
    HorsePower, MetricHorsePower
)
// endregion

// region Pressure
val KiloPascal = Units("kPa", "Kilopascals",  Category.PRESSURE) { it * Kilo } 
val MegaPascal = Units("MPa (N/mm²)", "Megapascals",  Category.PRESSURE) { it * Mega } 
val GigaPascal = Units("GPa", "Gigapascals",  Category.PRESSURE) { it * Giga } 
val KilogramPerSquareCentimeter = Units("kg/cm²", "Kilograms per square centimeter",  Category.PRESSURE) { it * EARTH_GRAVITY } 
val GramPerSquareCentimeter = Units("gm/cm²", "Grams per square centimeter",  Category.PRESSURE) { it * EARTH_GRAVITY * BigDecimal(10) } 
val DynePerSquareCentimeter = Units("gm/cm²", "Dynes per square centimeter",  Category.PRESSURE) { it.divide(BigDecimal(10), context) }
val Bar = Units("bar", "Bars",  Category.PRESSURE) { it * BigDecimal(100_000) } 
val Atmosphere = Units("atm", "Atmospheres",  Category.PRESSURE) { it * BigDecimal(101_325) } 
val PoundPerSquareInch = Units("psi", "Pounds per square inch",  Category.PRESSURE) { PoundForce.standardize(it).divide(SquareInch.standardize(BigDecimal(1)), context)}
val KipPerSquareInch = Units("ksi", "Thousand Pounds per square inch",  Category.PRESSURE) { Kips.standardize(it).divide(SquareInch.standardize(BigDecimal(1)), context)}
val PoundPerSquareFoot = Units("psf", "Pounds per square foot",  Category.PRESSURE) { PoundForce.standardize(it).divide(SquareFoot.standardize(BigDecimal(1)), context)}
// Water column pressure: density (ρ) * length * g
// ρH₂O @ 60F = 998.98kg/m^2
// ρHg @ 0C = 13595.1kg/m^2
val InchOfWater = Units("inH₂O", "Inchs of water",  Category.PRESSURE) { it * BigDecimal("998.98") * Inch.standardize(BigDecimal(1)) * EARTH_GRAVITY }
val FootOfWater = Units("ftH₂O", "Feets of water",  Category.PRESSURE) { it * BigDecimal("998.98") * Foot.standardize(BigDecimal(1)) * EARTH_GRAVITY }
val InchOfMercury = Units("inHg", "Inchs of mercury",  Category.PRESSURE) { it * BigDecimal("13595.1") * Inch.standardize(BigDecimal(1)) * EARTH_GRAVITY }
val MillimeterOfMercury = Units("mmHg", "Millimeters of mercury",  Category.PRESSURE) { it * BigDecimal("13595.1") * Millimeter.standardize(BigDecimal(1)) * EARTH_GRAVITY }

val Pressures = arrayOf(
    Pascal, KiloPascal, MegaPascal, GigaPascal, KilogramPerSquareCentimeter,
    GramPerSquareCentimeter, DynePerSquareCentimeter, Bar, Atmosphere,
    PoundPerSquareInch, KipPerSquareInch, PoundPerSquareFoot, InchOfWater,
    FootOfWater, InchOfMercury, MillimeterOfMercury
)
// endregion

// region Speed
val MeterPerMinute = Units("m/min", "Meters per minute",  Category.SPEED) { it.divide(BigDecimal(60), context) }
val CentimeterPerSecond = Units("cm/s", "Centimeters per second",  Category.SPEED) { it.divide(BigDecimal(100), context) }
val CentimeterPerMinute = Units("cm/s", "Centimeters per minute",  Category.SPEED) { it.divide(BigDecimal(6000), context) }
val InchPerSecond = Units("in/s", "Inches per second",  Category.SPEED) { Inch.standardize(it) }
val InchPerMinute = Units("in/min", "Inches per minute",  Category.SPEED) { Inch.standardize(it).divide(BigDecimal(60), context) }
val FootPerSecond = Units("ft/s", "Feet per second",  Category.SPEED) { Foot.standardize(it) }
val FootPerMinute = Units("ft/min", "Feet per minute",  Category.SPEED) { Foot.standardize(it).divide(BigDecimal(60), context) }
val YardPerSecond = Units("yd/s", "Yards per second",  Category.SPEED) { Yard.standardize(it) }
val YardPerMinute = Units("yd/min", "Yards per minute",  Category.SPEED) { Yard.standardize(it).divide(BigDecimal(60), context) }
val MilePerHour = Units("mph", "Miles per hour",  Category.SPEED) { Mile.standardize(it).divide(BigDecimal(3600), context) }
val KilometerPerHour = Units("kph", "Kilometers per hour",  Category.SPEED) { it.divide(BigDecimal("3.6"), context) }

val Speeds = arrayOf(
    MeterPerSecond, MeterPerMinute, CentimeterPerSecond, CentimeterPerMinute,
    InchPerSecond, InchPerMinute, FootPerSecond, FootPerMinute, YardPerSecond,
    YardPerMinute, MilePerHour, KilometerPerHour
)
// endregion

// region Stiffness / Uniform Load
val NewtonPerCentimeter = Units("N/cm", "Newtons per centimeter",  Category.STIFFNESS) { it * BigDecimal(100) }
val NewtonPerMillimeter = Units("N/mm (kN/m)", "Newtons per millimeter",  Category.STIFFNESS) { it * Kilo }
val KilonewtonPerMillimeter = Units("kN/mm", "Kilonewtons per millimeter",  Category.STIFFNESS) { it * Mega }
val KilogramPerMeter = Units("kgf/m", "Kilograms per meter",  Category.STIFFNESS) { it * EARTH_GRAVITY }
val KilogramPerMillimeter = Units("kgf/mm", "Kilograms per millimeter",  Category.STIFFNESS) { it * EARTH_GRAVITY * Kilo }
val PoundPerInch = Units("lbf/in", "Pounds per inch",  Category.STIFFNESS) { PoundForce.standardize(it).divide(Inch.standardize(BigDecimal(1)), context) }
val PoundPerFoot = Units("lbf/ft", "Pounds per foot",  Category.STIFFNESS) { PoundForce.standardize(it).divide(Foot.standardize(BigDecimal(1)), context) }
val KipPerInch = Units("kip/in", "Thousand pounds per inch",  Category.STIFFNESS) { Kips.standardize(it).divide(Inch.standardize(BigDecimal(1)), context) }
val KipPerFoot = Units("kip/ft", "Thousand pounds per foot",  Category.STIFFNESS) { Kips.standardize(it).divide(Foot.standardize(BigDecimal(1)), context) }

val Stiffnesses = arrayOf(
    NewtonPerMeter, NewtonPerCentimeter, NewtonPerMillimeter,
    KilonewtonPerMillimeter, KilogramPerMeter, KilogramPerMillimeter,
    PoundPerInch, PoundPerFoot, KipPerInch, KipPerFoot
)
val UniformLoads = arrayOf(
    NewtonPerMeter, KilogramPerMeter, PoundPerInch, PoundPerFoot, KipPerInch, KipPerFoot
)
// endregion

// region Temperatures
class TemperatureUnits(
    symbol: String, name: String, standardize: (BigDecimal) -> BigDecimal, val fromStandard: (BigDecimal) -> BigDecimal
) : Units(
    symbol, name, Category.TEMPERATURE, standardize
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

val Centigrade = TemperatureUnits("°C" ," Degrees Centigrade", { BigDecimal("273.15") + it }, { it - BigDecimal("273.15") })
val Fahrenheit = TemperatureUnits("°F" ," Degrees Fahrenheit", { (BigDecimal("459.67") + it) / BigDecimal("1.8") }, { (it * BigDecimal("1.8")) - BigDecimal("459.67") })
val Rankine = TemperatureUnits("°R" ," Degrees Rankine", { it / BigDecimal("1.8") }, { it * BigDecimal("1.8") })

val Temperatures = arrayOf(Centigrade, Fahrenheit, Kelvin, Rankine)
// endregion

// region Time
val Millisecond = Units("ms", "Milliseconds",  Category.TIME) { it.divide(Kilo, context) }
val Microsecond = Units("μs", "Microseconds",  Category.TIME) { it.divide(Mega, context) }
val Nanosecond = Units("ns", "Nanoseconds",  Category.TIME) { it.divide(Giga, context) }
val Minute = Units("m", "Minutes",  Category.TIME) { it * BigDecimal(60) }
val Hour = Units("hr", "Hours",  Category.TIME) { Minute.standardize(it) * BigDecimal(60) }
val Day = Units("d", "Days",  Category.TIME) { Hour.standardize(it) * BigDecimal(24) }
val Year = Units("yr", "Years",  Category.TIME) { Day.standardize(it) * BigDecimal(365.25) }
val Week = Units("wk", "Weeks",  Category.TIME) { Day.standardize(it) * BigDecimal(7) }
val Month = Units("mo", "Months",  Category.TIME) { Year.standardize(it) / BigDecimal(12) }
val Decade = Units("dec", "Decades",  Category.TIME) { Year.standardize(it) * BigDecimal(10) }
val Century = Units("cen", "Centuries",  Category.TIME) { Year.standardize(it) * BigDecimal(100) }

val Times = arrayOf(
    Nanosecond, Microsecond, Millisecond, Second, Minute, Hour,
    Day, Week, Month, Year, Decade, Century
)
// endregion

// region Volume
val Liter = Units("L", "Liters",  Category.VOLUME) { it.divide(BigDecimal(1_000), context) }
val Deciliter = Units("dL", "Deciliters",  Category.VOLUME) { it.divide(BigDecimal(10_000), context) }
val CubicCentimeter = Units("CC/mL", "Centimeters cubed",  Category.VOLUME) { it.divide(Mega, context) }
val CubicMillimeter = Units("mm³", "Millimeters cubed",  Category.VOLUME) { it.divide(Giga, context) }
val CubicInch = Units("in³", "Inchs cubed",  Category.VOLUME) { Inch.standardize(BigDecimal(1)).pow(3) * it }
val CubicFoot = Units("ft³", "Feet cubed",  Category.VOLUME) { Foot.standardize(BigDecimal(1)).pow(3) * it }
val CubicYard = Units("yd³", "Yards cubed",  Category.VOLUME) { Yard.standardize(BigDecimal(1)).pow(3) * it }
val AcreFoot = Units("acre⋅ft", "Acre-feet",  Category.VOLUME) { CubicFoot.standardize(it) * BigDecimal(43_560) }
val Gallon = Units("gal", "Gallons",  Category.VOLUME) { CubicInch.standardize(it) * BigDecimal(231) }
val WetBarrel = Units("bbl (wet)", "Barrels (wet)",  Category.VOLUME) { Gallon.standardize(it) * BigDecimal("31.5") }
val WetQuart = Units("qt (wet)", "Quarts (wet)",  Category.VOLUME) { Gallon.standardize(it).divide(BigDecimal(4),
    context) }
val WetPint = Units("pt (wet)", "Pints (wet)",  Category.VOLUME) { Gallon.standardize(it).divide(BigDecimal(8),
    context) }
val Cup = Units("cu", "Cups",  Category.VOLUME) { Gallon.standardize(it).divide(BigDecimal(16), context) }
val FluidOunce = Units("fl oz", "Fluid ounces",  Category.VOLUME) { Gallon.standardize(it).divide(BigDecimal(128),
    context) }
val Tablespoon = Units("tbsp", "Tablespoons",  Category.VOLUME) { FluidOunce.standardize(it).divide(BigDecimal(2),
    context) }
val Teaspoon = Units("tsp", "Teaspoons",  Category.VOLUME) { FluidOunce.standardize(it).divide(BigDecimal(6),
    context) }
val DryPint = Units("pt (dry)", "Pints (dry)",  Category.VOLUME) { CubicInch.standardize(it) * BigDecimal("33.6003125") }
val DryQuart = Units("qt (dry)", "Quarts (dry)",  Category.VOLUME) { DryPint.standardize(it) * BigDecimal(2) }
val Peck = Units("pk", "Pecks",  Category.VOLUME) { DryQuart.standardize(it) * BigDecimal(8) }
val Bushel = Units("bu", "Bushel",  Category.VOLUME) { Peck.standardize(it) * BigDecimal(4) }
val DryBarrel = Units("bbl (dry)", "Barrels (dry)",  Category.VOLUME) { CubicInch.standardize(it) * BigDecimal(7056) }

val Volumes = arrayOf(
    CubicMeter, Liter, Deciliter, CubicCentimeter, CubicMillimeter,
    CubicInch, CubicFoot, CubicYard, AcreFoot,
    Gallon, WetBarrel, WetQuart, WetPint, Cup, FluidOunce, Tablespoon, Teaspoon,
    DryPint, DryQuart, Peck, Bushel, DryBarrel,
)
// endregion

// region Volumetric Flow Rates
val CubicMeterPerMinute = Units("m³/min", "Meters cubed per minute",  Category.VOLUMETRIC_FLOW) { it.divide(BigDecimal(60), context)}
val CubicMeterPerHour = Units("m³/hr", "Meters cubed per hour",  Category.VOLUMETRIC_FLOW) { it.divide(BigDecimal(3600), context)}
val LiterPerSecond = Units("L/s", "Liters per second",  Category.VOLUMETRIC_FLOW) { it.divide(BigDecimal(1000), context)}
val LiterPerMinute = Units("L/min", "Liters per minute",  Category.VOLUMETRIC_FLOW) { it.divide(BigDecimal(60_000), context)}
val LiterPerHour = Units("L/hr", "Liters per hour",  Category.VOLUMETRIC_FLOW) { it.divide(BigDecimal(3_600_000), context)}
val CubicFootPerSecond = Units("ft³/s", "Foots cubed per second",  Category.VOLUMETRIC_FLOW) { CubicFoot.standardize(it) }
val CubicFootPerMinute = Units("ft³/min", "Foots cubed per minute",  Category.VOLUMETRIC_FLOW) { CubicFoot.standardize(it).divide(BigDecimal(60), context) }
val CubicFootPerHour = Units("ft³/hr", "Foots cubed per hour",  Category.VOLUMETRIC_FLOW) { CubicFoot.standardize(it).divide(BigDecimal(3600), context) }
val GallonPerMinute = Units("gal/min", "Gallons per minute",  Category.VOLUMETRIC_FLOW) { Gallon.standardize(it).divide(BigDecimal(60), context) }
val GallonPerHour = Units("gal/hr", "Gallons per hour",  Category.VOLUMETRIC_FLOW) { Gallon.standardize(it).divide(BigDecimal(3600), context) }
val BarrelPerHour = Units("bbl/hr", "Barrels per hour",  Category.VOLUMETRIC_FLOW) { WetBarrel.standardize(it).divide(BigDecimal(3600), context) }

val VolumetricFlows = arrayOf(
    CubicMeterPerSecond, CubicMeterPerMinute, CubicMeterPerHour,
    LiterPerSecond, LiterPerMinute, LiterPerHour,
    CubicFootPerSecond, CubicFootPerMinute, CubicFootPerHour,
    GallonPerMinute, GallonPerHour, BarrelPerHour
)
// endregion

