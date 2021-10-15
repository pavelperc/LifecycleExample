package com.example.lifecycleexample

import android.util.Log
import androidx.lifecycle.ViewModel

class FirstFragmentViewModel : ViewModel() {
    init {
        Log.d(LIFECYCLE_TAG, "FirstFragmentViewModel: init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(LIFECYCLE_TAG, "FirstFragmentViewModel: onCleared()")
    }
}