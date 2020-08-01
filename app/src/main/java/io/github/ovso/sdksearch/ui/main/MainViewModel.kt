package io.github.ovso.sdksearch.ui.main

import androidx.lifecycle.MutableLiveData
import com.orhanobut.logger.Logger
import io.github.ovso.sdksearch.base.DisposableViewModel

typealias Log = Logger

class MainViewModel : DisposableViewModel() {
    private val _isClearVisible = MutableLiveData(false)
    val isClearVisible = _isClearVisible

    fun onTextChanged(text: CharSequence) {
        Log.d("onTextChanged = $text")
        _isClearVisible.value = text.isNotEmpty()
    }
}