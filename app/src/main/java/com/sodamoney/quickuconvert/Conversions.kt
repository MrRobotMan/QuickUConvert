package com.sodamoney.quickuconvert

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.delete
import androidx.compose.foundation.text.input.insert
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import kotlin.math.min

private val FORMAT_SYMBOLS  = DecimalFormatSymbols()
private val DEC_SEP = FORMAT_SYMBOLS.decimalSeparator
private val GROUP_SEP = FORMAT_SYMBOLS.groupingSeparator

// On paste of values, illegal characters may exist but these can be useful
// in plain text. i.e. `1 234.456 789` for increased legibility. Remove them and continue.
private val REMOVABLE = Regex("${Regex.escape(GROUP_SEP.toString())}|\\s|_")

// Valid inputs match the following regex.
//^-?                                             Start of string and optional `-`
// (\d*${Regex.escape(DEC_SEP.toString())}?\d*)   Zero or more digits, decimal separator, and then zero or more digits.
// ([Ee][-+]?\d*)?                                Exponent "symbol" followed by optional + or - and zero or more digits
// $ end of string
//
// All digits are optional so characters can be entered which will lead to possible issues with
// converting to BigDecimal. This error will be caught and handle in parseUserInput.
internal val VALID_INPUT = Regex("^-?\\d*${Regex.escape(DEC_SEP.toString())}?\\d*([Ee][-+]?\\d*)?$")
private val WHITESPACE = Regex("\\s")

fun parseUserInput(text: String): BigDecimal? {
    return try {
        BigDecimal(text.replace(GROUP_SEP.toString(), "").replace(DEC_SEP, '.'))
    } catch (_: NumberFormatException) {
        null
    }
}

fun resetValues(states: Array<TextFieldState>, items: Array<out Units>) {
    states.withIndex().forEach {
        val value = if (it.index == 0) {
            "1"
        } else if (it.index < items.size) {
            convertedOrInvalid(BigDecimal.ONE, items[0], items[it.index])
        } else {
            ""
        }
        it.value.setTextAndPlaceCursorAtEnd(value)
    }
}

fun updateValues(index: Int, value: BigDecimal, items: Array<out Units>, states: Array<TextFieldState>) {
    for ((ind, state) in states.withIndex()) {
        if (ind == index) continue
        if (ind >= items.size) break
        state.setTextAndPlaceCursorAtEnd(convertedOrInvalid(value, items[index], items[ind]))
    }
}

fun convertedOrInvalid(value: BigDecimal, from: Units, to: Units): String {
    val converted =  try {
        from.convertTo(value, to)
    } catch (_: IllegalConversionException) {
        return "Invalid"
    }
    val numberFormat = NumberFormat.getNumberInstance()
    if (numberFormat !is DecimalFormat) {
        return numberFormat.format(converted)
    }
    val absConv = converted.abs().toDouble()
    when {
        converted.compareTo(BigDecimal.ZERO) == 0 -> return "0"
        // No commas added here. Taken care of in the output transformation.
        absConv < 1E5 && absConv > 1E-4 -> numberFormat.applyPattern("0.###")
        else -> {
            numberFormat.applyPattern("0.####E0")

        }
    }
    return numberFormat.format(converted)
}

class GroupingsOutputTransformation() : OutputTransformation {
    override fun TextFieldBuffer.transformOutput() {
        val text = asCharSequence()
        val end = text.length
        val signOffset = if (text.isNotEmpty() && text[0] == '-') 1 else 0
        val decimalIndex = text.indexOf(DEC_SEP).let {if (it == -1)  end else it}
        val exponentIndex = text.indexOf('E').let { if (it == -1)
            text.indexOf('e').let {inner -> if (inner == -1) end else inner } else it
        }
        // Start position is the furthest left of '.' and 'E', offset 3 to the first comma
        var index = min(decimalIndex,exponentIndex) - 3
        // Insert right to left for ease
        while (index > signOffset) {
            insert(index, GROUP_SEP.toString())
            index -= 3
        }
    }
}

class GroupingsInputTransformation(val onBadPaste: (String) -> Unit) : InputTransformation {
    @OptIn(ExperimentalFoundationApi::class)
    override fun TextFieldBuffer.transformInput() {
        val isPasted = changes.changeCount == 1 && changes.getRange(0).length > 1
        val chars = asCharSequence()
        val text = if (isPasted) {
            // Delete group separator from the buffer
            chars.withIndex().reversed().forEach {
                if (it.value == GROUP_SEP || WHITESPACE.matches(it.value.toString())) {
                    delete(it.index, it.index + 1)
                }
            }
            // Delete group separator from the string
            chars.replace(REMOVABLE, "")
        } else {
            chars.toString()
        }
        if (!VALID_INPUT.matches(text)) {
            revertAllChanges()
            if (isPasted) {
                onBadPaste(text)
                }
            }
        }
    }

