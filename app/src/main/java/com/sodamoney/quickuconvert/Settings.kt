package com.sodamoney.quickuconvert

import android.content.SharedPreferences
import androidx.core.content.edit

enum class ThemeMode { SYSTEM, LIGHT, DARK }

data class UnitPref(val symbol: String, val visible: Boolean)
data class CatPref(val name: String, val visible: Boolean)

val AllUnits: Map<Category, Array<out Units>> = mapOf(
    Category.ACCELERATION    to Accelerations,
    Category.AREA            to Areas,
    Category.DENSITY         to Densities,
    Category.DIGITAL_STORAGE to DigitalStorage,
    Category.ENERGY          to Energies,
    Category.FORCE           to Forces,
    Category.LENGTH          to Lengths,
    Category.MASS            to Masses,
    Category.MASS_FLOW       to MassFlowRates,
    Category.MOMENT          to Moments,
    Category.TEMPERATURE     to Temperatures,
    Category.TIME            to Times,
    Category.VOLUME          to Volumes,
)

class SettingsRepository(private val prefs: SharedPreferences) {

    var themeMode: ThemeMode
        get() = ThemeMode.valueOf(
            prefs.getString(KEY_THEME, ThemeMode.SYSTEM.name) ?: ThemeMode.SYSTEM.name
        )
        set(value) = prefs.edit { putString(KEY_THEME, value.name) }

    fun getUnitPrefs(category: Category): List<UnitPref> {
        val allUnits = AllUnits[category] ?: return emptyList()
        val allSymbols = allUnits.map { it.symbol }
        val hidden = hiddenSymbols(category)
        val order = orderedSymbols(category)
        val ordered = if (order.isEmpty()) allSymbols else {
            val known = order.toSet()
            order + allSymbols.filter { it !in known }
        }
        return ordered.map { UnitPref(it, it !in hidden) }
    }

    fun getCatPrefs(): List<CatPref> {
        val hidden = hiddenCategories()
        return AllUnits.keys.map { CatPref(it.name, it !in hidden) }
    }

    fun saveUnitPrefs(category: Category, unitPrefs: List<UnitPref>, catPrefs: List<CatPref>) {
        prefs.edit {
            // Assumes all symbols are unique. Better to go by name. TODO add name field to class
            putString(orderKey(category), unitPrefs.joinToString(",") { it.symbol })
            putString(
                hiddenKey(category),
                unitPrefs.filter { !it.visible }.joinToString(",") { it.symbol })
            putString("HiddenCategories", catPrefs.joinToString(",") { it.name })
        }
    }

    fun visibleUnits(category: Category): Array<out Units> {
        val all = AllUnits[category] ?: return emptyArray()
        val visibleSymbols = getUnitPrefs(category).filter { it.visible }.map { it.symbol }
        return visibleSymbols.mapNotNull { sym -> all.find { it.symbol == sym } }.toTypedArray()
    }

    fun visibleCategories() : Array<Category> {
        return getCatPrefs().filter { it.visible }.map { Category.valueOf(it.name) }.toTypedArray()
    }

    private fun orderedSymbols(category: Category): List<String> =
        prefs.getString(orderKey(category), null)
            ?.split(",")?.filter { it.isNotEmpty() } ?: emptyList()

    private fun hiddenSymbols(category: Category): Set<String> =
        prefs.getString(hiddenKey(category), null)
            ?.split(",")?.filter { it.isNotEmpty() }?.toSet() ?: emptySet()

    private fun hiddenCategories(): Set<Category> =
        prefs.getString("HiddenCategories", null)?.split(",")?.filter { it.isNotEmpty() }
            ?.map { Category.valueOf(it) }?.toSet() ?: emptySet()

    private fun orderKey(cat: Category) = "unit_order_${cat.name}"
    private fun hiddenKey(cat: Category) = "unit_hidden_${cat.name}"

    var hasSeenIntro: Boolean
        get() = prefs.getBoolean(KEY_INTRO_SEEN, false)
        set(value) = prefs.edit { putBoolean(KEY_INTRO_SEEN, value) }

    companion object {
        private const val KEY_THEME = "theme_mode"
        private const val KEY_INTRO_SEEN = "intro_seen"
        const val PREFS_NAME = "quickconvert_settings"
    }
}
