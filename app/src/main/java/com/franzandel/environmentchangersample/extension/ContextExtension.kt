package com.franzandel.environmentchangersample.extension

import android.content.Context
import android.content.Intent

/**
 * Created by Franz Andel on 15/12/20.
 * Android Engineer
 */

fun Context.goTo(clazz: Class<*>, bundle: (Intent.() -> Unit)? = null) {
    Intent(this, clazz).run {
        bundle?.invoke(this)
        startActivity(this)
    }
}