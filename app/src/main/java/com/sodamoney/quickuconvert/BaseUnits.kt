package com.sodamoney.quickuconvert

import java.math.BigDecimal

/*
 * Copyright 2026 David Weiss
 *
 * Collection of Base Units to be used.
 */

val EARTH_GRAVITY = BigDecimal("9.80665") // m/s^2
val SPEED_OF_LIGHT= BigDecimal(299_792_458) // m/s
val Bit = Units("bit", Category.DIGITAL_STORAGE) { it }
val Meter = Units("m", Category.LENGTH) { it }
val Second = Units("s", Category.TIME) { it }
val Kilogram = Units("kg", Category.MASS) { it }
val Kelvin = TemperatureUnits("K", { it }, { it })
//val AMP = Units("A", Category.CURRENT) { it }
//val Candela = Units("cs", Category.BRIGHTNESS) { it }
//val MOL = Units("mol", Category.AMOUNT) { it }
val Newton = Units("N", Category.FORCE) { it }
val MeterPerSecondSquared = Units("m/s²", Category.ACCELERATION) { it }
val SquareMeter = Units("m²", Category.AREA) { it }
val CubicMeter = Units("m³", Category.VOLUME) { it }
val KilogramPerCubicMeter = Units("kg/m³", Category.DENSITY) { it }
val Joule = Units("J", Category.ENERGY) { it }
val KilogramPerSecond = Units("kg/s", Category.MASS_FLOW) { it }
val NewtonMeter = Units("N⋅m", Category.MOMENT) { it }
val Watt = Units("W", Category.POWER) { it }
val Pascal = Units("Pa", Category.PRESSURE) { it }
val MeterPerSecond = Units("m/s", Category.SPEED) { it }
val NewtonPerMeter = Units("N/m", Category.STIFFNESS) { it }
val CubicMeterPerSecond = Units("m³/s", Category.VOLUMETRIC_FLOW) { it }

