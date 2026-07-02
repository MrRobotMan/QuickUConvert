package com.sodamoney.quickuconvert

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.DragHandle
import androidx.compose.material.icons.filled.Feedback
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.SettingsBrightness
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    repo: SettingsRepository,
    onThemeChange: (ThemeMode) -> Unit = {},
    onBack: () -> Unit
) {
    var themeMode by remember { mutableStateOf(repo.themeMode) }
    var selectedCategory by remember { mutableStateOf(AllUnits.keys.first()) }
    var unitPrefs by remember(selectedCategory) { mutableStateOf(repo.getUnitPrefs(selectedCategory)) }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            SectionLabel("Theme")

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = when (themeMode) {
                        ThemeMode.LIGHT  -> "Light"
                        ThemeMode.SYSTEM -> "System Default"
                        ThemeMode.DARK   -> "Dark"
                    },
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(1f)
                )
                ThreePositionSwitch(
                    selected = themeMode,
                    onSelect = { themeMode = it; repo.themeMode = it; onThemeChange(it) }
                )
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

            SectionLabel("Unit visibility & order")

            var catExpanded by remember { mutableStateOf(false) }
            Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
                OutlinedButton(onClick = { catExpanded = true }) {
                    Text(selectedCategory.name.lowercase().replaceFirstChar { it.uppercase() })
                    Spacer(Modifier.width(4.dp))
                    Icon(
                        imageVector = arrow_drop_down,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
                DropdownMenu(
                    expanded = catExpanded,
                    onDismissRequest = { catExpanded = false }
                ) {
                    AllUnits.keys.forEach { cat ->
                        DropdownMenuItem(
                            text = { Text(cat.name.lowercase().replaceFirstChar { it.uppercase() }) },
                            onClick = {
                                selectedCategory = cat
                                unitPrefs = repo.getUnitPrefs(cat)
                                catExpanded = false
                            }
                        )
                    }
                }
            }

            ReorderableUnitList(
                units = unitPrefs,
                onReorder = { from, to ->
                    val list = unitPrefs.toMutableList().also { it.add(to, it.removeAt(from)) }
                    unitPrefs = list
                    repo.saveUnitPrefs(selectedCategory, list)
                },
                onToggle = { idx, visible ->
                    val list = unitPrefs.toMutableList().also { it[idx] = it[idx].copy(visible = visible) }
                    unitPrefs = list
                    repo.saveUnitPrefs(selectedCategory, list)
                }
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

            SectionLabel("Support")

            OutlinedButton(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(FEEDBACK_FORM_URL))
                    context.startActivity(intent)
                },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Feedback,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text("Request feature / report issue")
            }

            Spacer(Modifier.height(16.dp))
        }
    }
}

private const val FEEDBACK_FORM_URL =
    "https://docs.google.com/forms/d/e/1FAIpQLSen7yNw3E_autrxvBm0icjCFQH975TyqmW-kVeje6OW75uPgw/viewform?usp=dialog"

@Composable
private fun ThreePositionSwitch(
    selected: ThemeMode,
    onSelect: (ThemeMode) -> Unit,
    modifier: Modifier = Modifier
) {
    val orderedModes = listOf(ThemeMode.LIGHT, ThemeMode.SYSTEM, ThemeMode.DARK)
    val selectedIndex = orderedModes.indexOf(selected)

    val trackWidth = 148.dp
    val trackHeight = 44.dp
    val thumbDiameter = 40.dp
    val padDp = 2.dp

    val density = LocalDensity.current
    val maxOffsetPx = with(density) { (trackWidth - thumbDiameter - padDp * 2).toPx() }
    val padPx = with(density) { padDp.toPx() }

    // Animatable drives snap animations; dragX overrides it while dragging.
    val thumbXAnim = remember { Animatable(selectedIndex * maxOffsetPx / 2f) }
    var isDragging by remember { mutableStateOf(false) }
    var dragX by remember { mutableFloatStateOf(0f) }

    val scope = rememberCoroutineScope()
    val onSelectUpdated = rememberUpdatedState(onSelect)

    // Display position: direct during drag, animated otherwise.
    val displayX = if (isDragging) dragX else thumbXAnim.value

    val draggableState = rememberDraggableState { delta ->
        dragX = (dragX + delta).coerceIn(0f, maxOffsetPx)
    }

    Box(
        modifier = modifier
            .width(trackWidth)
            .height(trackHeight)
            .clip(RoundedCornerShape(50))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .draggable(
                state = draggableState,
                orientation = Orientation.Horizontal,
                onDragStarted = { _ ->
                    dragX = thumbXAnim.value
                    isDragging = true
                },
                onDragStopped = { _ ->
                    val snappedIndex = (dragX / maxOffsetPx * 2).roundToInt().coerceIn(0, 2)
                    onSelectUpdated.value(orderedModes[snappedIndex])
                    // Sync animatable to current drag position before handing off.
                    thumbXAnim.snapTo(dragX)
                    isDragging = false
                    thumbXAnim.animateTo(snappedIndex * maxOffsetPx / 2f)
                }
            )
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    val zone = (offset.x / size.width * 3).toInt().coerceIn(0, 2)
                    onSelectUpdated.value(orderedModes[zone])
                    scope.launch { thumbXAnim.animateTo(zone * maxOffsetPx / 2f) }
                }
            }
    ) {
        // Thumb
        Box(
            modifier = Modifier
                .size(thumbDiameter)
                .offset {
                    IntOffset(
                        x = (displayX + padPx).roundToInt(),
                        y = padPx.roundToInt()
                    )
                }
                .shadow(3.dp, CircleShape)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            // Show icon for the zone the thumb is currently over during drag.
            val displayIndex = (displayX / maxOffsetPx * 2).roundToInt().coerceIn(0, 2)
            val icon = when (orderedModes[displayIndex]) {
                ThemeMode.LIGHT  -> Icons.Default.LightMode
                ThemeMode.SYSTEM -> Icons.Default.SettingsBrightness
                ThemeMode.DARK   -> Icons.Default.DarkMode
            }
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
private fun SectionLabel(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelMedium,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 4.dp)
    )
}

@Composable
private fun ReorderableUnitList(
    units: List<UnitPref>,
    onReorder: (from: Int, to: Int) -> Unit,
    onToggle: (index: Int, visible: Boolean) -> Unit
) {
    val rowHeightDp = 56.dp
    val rowHeightPx = with(LocalDensity.current) { rowHeightDp.toPx() }
    val scope = rememberCoroutineScope()

    var draggingSymbol by remember { mutableStateOf<String?>(null) }
    val dragOffset = remember { Animatable(0f) }

    val draggingIdx = draggingSymbol?.let { sym ->
        units.indexOfFirst { it.symbol == sym }.takeIf { it >= 0 }
    }
    val targetIdx = draggingIdx?.let { di ->
        (di + (dragOffset.value / rowHeightPx).roundToInt()).coerceIn(0, units.lastIndex)
    }
    val targetIdxState = rememberUpdatedState(targetIdx)
    val draggingIdxState = rememberUpdatedState(draggingIdx)

    Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
        units.forEachIndexed { idx, unit ->
            key(unit.symbol) {
                val lifted = unit.symbol == draggingSymbol
                val shiftTarget = when {
                    targetIdx == null || draggingIdx == null -> 0f
                    else -> {
                        val di = draggingIdx; val ti = targetIdx
                        when {
                            di < ti && idx in (di + 1)..ti -> -rowHeightPx
                            di > ti && idx in ti until di  ->  rowHeightPx
                            else -> 0f
                        }
                    }
                }
                val animShift by animateFloatAsState(targetValue = shiftTarget, label = "shift")
                val elevation by animateFloatAsState(targetValue = if (lifted) 8f else 0f, label = "elevation")

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(rowHeightDp)
                        .zIndex(if (lifted) 1f else 0f)
                        .graphicsLayer {
                            translationY = if (lifted) dragOffset.value else animShift
                            shadowElevation = elevation
                        }
                        .background(
                            if (lifted) MaterialTheme.colorScheme.surfaceContainerHighest
                            else MaterialTheme.colorScheme.surface
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.DragHandle,
                        contentDescription = "Drag to reorder",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier
                            .size(24.dp)
                            .pointerInput(unit.symbol) {
                                detectDragGesturesAfterLongPress(
                                    onDragStart = {
                                        draggingSymbol = unit.symbol
                                        scope.launch { dragOffset.snapTo(0f) }
                                    },
                                    onDrag = { change, delta ->
                                        change.consume()
                                        scope.launch { dragOffset.snapTo(dragOffset.value + delta.y) }
                                    },
                                    onDragEnd = {
                                        val ti = targetIdxState.value
                                        val di = draggingIdxState.value
                                        scope.launch {
                                            if (ti != null && di != null && ti != di) {
                                                onReorder(di, ti)
                                                // Rest position moved by (ti - di) rows; compensate
                                                // so the settle animation starts from the same
                                                // visual spot instead of jumping.
                                                dragOffset.snapTo(dragOffset.value - (ti - di) * rowHeightPx)
                                            }
                                            dragOffset.animateTo(0f)
                                            draggingSymbol = null
                                        }
                                    },
                                    onDragCancel = {
                                        scope.launch {
                                            dragOffset.animateTo(0f)
                                            draggingSymbol = null
                                        }
                                    }
                                )
                            }
                    )
                    Spacer(Modifier.width(16.dp))
                    Text(
                        text = unit.symbol,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.weight(1f)
                    )
                    Switch(
                        checked = unit.visible,
                        onCheckedChange = { onToggle(idx, it) }
                    )
                }
            }
        }
    }
}
