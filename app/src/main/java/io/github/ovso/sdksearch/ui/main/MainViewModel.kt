package io.github.ovso.sdksearch.ui.main

import androidx.lifecycle.MutableLiveData
import io.github.ovso.sdksearch.base.DisposableViewModel

class MainViewModel : DisposableViewModel() {
    private val _isClearVisible = MutableLiveData(false)
    val isClearVisible = _isClearVisible
    val searchText = MutableLiveData<CharSequence>()
    fun onTextChanged(text: CharSequence) {
        _isClearVisible.value = text.isNotEmpty()
    }

    fun onSearchClearClick() {
        searchText.value = ""
    }
}