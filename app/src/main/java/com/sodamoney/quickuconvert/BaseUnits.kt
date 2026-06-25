package com.sodamoney.quickuconvert

/*
 * Copyright 2026 David Weiss
 *
 * Collection of Base Units to be used.
 */

const val GRAVITATIONAL_ACCELERATION = 9.80655 // m/s^2
const val SPEED_OF_LIGHT = 299_792_458 // m/s

val Meter = Units("Meter", R.string.meter,  "m", {it}, category=Category.LENGTH)
val Second = Units("Second", R.string.second,  "s", {it}, category=Category.LENGTH)
val Kilogram = Units("Kilogram", R.string.kilogram,  "kg", {it}, category=Category.LENGTH)
val Kelvin = TemperatureUnits("Kelvin", R.string.kelvin,  "K", {it}, fromStandard = {it})
//val AMP = Units("Amp", R.string.amp,  "A", {it}, category = Category.CURRENT)
//val Candela = Units("Candela", R.string.candela,  "cs", {it}, category=Category.LENGTH)
//val MOL = Units("Mol", R.string.mol,  "mol", {it}, category=Category.LENGTH)
