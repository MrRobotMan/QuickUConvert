package com.sodamoney.quickuconvert

/*
 * Copyright 2026 David Weiss
 *
 * Collection of Base Units to be used.
 */

const val EARTH_GRAVITY: Double = 9.80655 // m/s^2
const val SPEED_OF_LIGHT : Long= 299_792_458 // m/s
const val Kilo: Long = 1_000
const val Mega: Long = Kilo * Kilo
const val Giga: Long = Kilo * Mega

val bit = Units("bit", Category.DIGITAL_STORAGE) { it }
val Meter = Units("m", Category.LENGTH)  { it }
val Second = Units("s", Category.TIME) { it }
val Kilogram = Units("kg", Category.MASS) { it }
val Kelvin = TemperatureUnits("K", { it }, { it })
//val AMP = Units("A", Category.CURRENT) { it }
//val Candela = Units("cs", ategory.LENGTH) { it }
//val MOL = Units("mol", Category.LENGTH) { it }
val Newton = Units("N", Category.FORCE) { it }
val MeterPerSecondSquared = Units("m/s²", Category.ACCELERATION) { it }
val SquareMeter = Units("m²", Category.AREA) { it }
val CubicMeter = Units("m³", Category.VOLUME) { it }
val KilogramPerMeterCubed = Units("kg/m³", Category.DENSITY) { it }
