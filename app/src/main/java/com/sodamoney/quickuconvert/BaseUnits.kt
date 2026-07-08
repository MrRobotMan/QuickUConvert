package com.sodamoney.quickuconvert

import java.math.BigDecimal

/*
 * Copyright 2026 David Weiss
 *
 * Collection of Base Units to be used.
 */

val EARTH_GRAVITY = BigDecimal("9.80665") // m/s^2
val SPEED_OF_LIGHT= BigDecimal(299_792_458) // m/s
val Bit = Units("bit", "Bits", Category.DIGITAL_STORAGE) { it }
val Meter = Units("m", "Meters", Category.LENGTH) { it }
val Second = Units("s", "Seconds", Category.TIME) { it }
val Kilogram = Units("kg", "Kilograms", Category.MASS) { it }
val Kelvin = TemperatureUnits("K", "Kelvin", { it }, { it })
val Newton = Units("N", "Newton", Category.FORCE) { it }
val MeterPerSecondSquared = Units("m/s²", "Meters per second squared", Category.ACCELERATION) { it }
val SquareMeter = Units("m²", "Square meters", Category.AREA) { it }
val CubicMeter = Units("m³", "Meters cubed", Category.VOLUME) { it }
val KilogramPerCubicMeter = Units("kg/m³", "Kilograms per meter cubed", Category.DENSITY) { it }
val Joule = Units("J", "Joules", Category.ENERGY) { it }
val KilogramPerSecond = Units("kg/s", "Kilograms per second", Category.MASS_FLOW) { it }
val NewtonMeter = Units("N⋅m", "Newton-meters", Category.MOMENT) { it }
val Watt = Units("W", "Watts", Category.POWER) { it }
val Pascal = Units("Pa", "Pascals", Category.PRESSURE) { it }
val MeterPerSecond = Units("m/s", "Meters per second", Category.SPEED) { it }
val NewtonPerMeter = Units("N/m", "Newtons per meter", Category.STIFFNESS) { it }
val CubicMeterPerSecond = Units("m³/s", "CubicMeters per second", Category.VOLUMETRIC_FLOW) { it }

