package com.example.lifecycleexample

import android.util.Log
import androidx.lifecycle.ViewModel

class SecondFragmentViewModel : ViewModel() {
    init {
        Log.d(LIFECYCLE_TAG, "SecondFragmentViewModel: init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(LIFECYCLE_TAG, "SecondFragmentViewModel: onCleared()")
    }
}