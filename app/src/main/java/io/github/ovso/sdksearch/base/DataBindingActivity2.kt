package io.github.ovso.sdksearch.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class DataBindingActivity2<T : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int
) : AppCompatActivity() {

    @Suppress("RemoveExplicitTypeArguments")
    protected val binding: T by lazy {
        DataBindingUtil.setContentView<T>(this, layoutResId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {
        val owner = this@DataBindingActivity2
        with(binding) {
            lifecycleOwner = owner
            executePendingBindings()
        }
    }
}