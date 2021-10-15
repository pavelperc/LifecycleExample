package com.example.lifecycleexample

import android.os.Bundle


const val LIFECYCLE_TAG = "Lifecycle"

fun Bundle?.str() = if (this == null) "null" else "savedInstanceState"