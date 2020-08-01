package io.github.ovso.sdksearch.ui.main

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.NavDestination
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

    fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination, arguments: Bundle?
    ) {
        searchText.value = ""
    }

}