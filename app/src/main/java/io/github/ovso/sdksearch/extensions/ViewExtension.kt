package io.github.ovso.sdksearch.extensions

import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("visible")
fun View.visible(visible: Boolean) {
    this.isVisible = visible
}

@BindingAdapter("invisible")
fun View.invisible(visible: Boolean) {
    this.isInvisible = visible
}