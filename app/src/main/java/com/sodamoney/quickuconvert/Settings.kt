package com.sodamoney.quickuconvert

import android.content.SharedPreferences
import androidx.core.content.edit

enum class ThemeMode { SYSTEM, LIGHT, DARK }

data class UnitPref(val symbol: String, val visible: Boolean)

val AllUnits: Map<Category, Array<out Units>> = mapOf(
    Category.ACCELERATION to Accelerations,
    Category.FORCE        to Forces,
    Category.TEMPERATURE  to Temperatures,
    Category.TIME         to Times,
    Category.LENGTH       to Lengths,
    Category.AREA         to Areas,
)

class SettingsRepository(private val prefs: SharedPreferences) {

    var themeMode: ThemeMode
        get() = ThemeMode.valueOf(
            prefs.getString(KEY_THEME, ThemeMode.SYSTEM.name) ?: ThemeMode.SYSTEM.name
        )
        set(value) = prefs.edit { putString(KEY_THEME, value.name) }

    fun getUnitPrefs(category: Category): List<UnitPref> {
        val all = AllUnits[category] ?: return emptyList()
        val allSyms = all.map { it.symbol }
        val hidden = hiddenSymbols(category)
        val order = orderedSymbols(category)
        val ordered = if (order.isEmpty()) allSyms else {
            val known = order.toSet()
            order + allSyms.filter { it !in known }
        }
        return ordered.map { UnitPref(it, it !in hidden) }
    }

    fun saveUnitPrefs(category: Category, unitPrefs: List<UnitPref>) {
        prefs.edit {
            putString(orderKey(category), unitPrefs.joinToString(",") { it.symbol })
            putString(hiddenKey(category), unitPrefs.filter { !it.visible }.joinToString(",") { it.symbol })
        }
    }

    fun visibleUnits(category: Category): Array<out Units> {
        val all = AllUnits[category] ?: return emptyArray()
        val visibleSyms = getUnitPrefs(category).filter { it.visible }.map { it.symbol }
        return visibleSyms.mapNotNull { sym -> all.find { it.symbol == sym } }.toTypedArray()
    }

    private fun orderedSymbols(category: Category): List<String> =
        prefs.getString(orderKey(category), null)
            ?.split(",")?.filter { it.isNotEmpty() } ?: emptyList()

    private fun hiddenSymbols(category: Category): Set<String> =
        prefs.getString(hiddenKey(category), null)
            ?.split(",")?.filter { it.isNotEmpty() }?.toSet() ?: emptySet()

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
