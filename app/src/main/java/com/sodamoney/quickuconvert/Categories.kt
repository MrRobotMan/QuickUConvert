package com.sodamoney.quickuconvert

/*
 * Copyright 2026 David Weiss
 *
 * Unit conversion categories.
 */

enum class Category {
    ACCELERATION,
    AREA,
    DENSITY,
    DIGITAL_STORAGE,
    ENERGY,
    FORCE,
    LENGTH,
    MASS,
    MASS_FLOW,
    MOMENT,
    POWER,
    PRESSURE,
    SPEED,
    STIFFNESS,
    TEMPERATURE,
    TIME,
    UNIFORM_LOAD,
    VOLUME,
    VOLUMETRIC_FLOW,;


    fun baseUnits(): String {
        return when (this) {
            ACCELERATION -> "m/s²"
            AREA -> "m²"
            DENSITY -> "kg/m³"
            DIGITAL_STORAGE -> "bit"
            ENERGY -> "J"
            FORCE -> "N"
            LENGTH -> "m"
            MASS -> "kg"
            MASS_FLOW -> "kg/s"
            MOMENT -> "Nm"
            POWER -> "W"
            PRESSURE -> "Pa"
            SPEED -> "m/s"
            STIFFNESS -> "N/mm"
            TEMPERATURE -> "K"
            TIME -> "s"
            UNIFORM_LOAD -> "N/mm"
            VOLUMETRIC_FLOW -> "m³/hr"
            VOLUME -> "m³"
        }
    }

    fun format(): String {
        return this.name.splitToSequence("_").joinToString(" ") { part -> part.lowercase().replaceFirstChar {it.uppercase()} }
    }
}
