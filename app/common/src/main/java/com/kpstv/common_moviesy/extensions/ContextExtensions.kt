package com.kpstv.common_moviesy.extensions

import android.content.Context
import android.content.res.Resources
import android.graphics.Typeface
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.*
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

fun Context.colorFrom(@ColorRes color: Int) =
    ContextCompat.getColor(this, color)

fun Context.drawableFrom(@DrawableRes value: Int) =
    ContextCompat.getDrawable(this, value)

fun Context.loadFont(@FontRes id: Int): Typeface? {
    try {
        return ResourcesCompat.getFont(this, id)
    } catch (e: Resources.NotFoundException) {
    }
    return null
}

fun Context.toPx(dp: Float) : Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()

@ColorInt
fun Context.getColorAttr(@AttrRes id: Int, @ColorInt fallbackColor: Int = 0): Int {
    if (theme == null) {
        return fallbackColor
    }
    val typedValue = TypedValue()
    theme?.resolveAttribute(id, typedValue, true)
    return typedValue.data
}