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
    DRY_VOLUME,
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
    VOL_FLOW,
    WET_VOLUME;


    fun baseUnits(): String {
        return when (this) {
            ACCELERATION -> "m/s²"
            AREA -> "m²"
            DENSITY -> "kg/m³"
            DRY_VOLUME -> "m³"
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
            VOL_FLOW -> "m³/hr"
            WET_VOLUME -> "m³"
        }
    }
}
