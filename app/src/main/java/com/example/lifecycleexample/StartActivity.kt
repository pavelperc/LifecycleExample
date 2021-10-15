package com.example.lifecycleexample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.lifecycleexample.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LIFECYCLE_TAG, "StartActivity: onCreate(${savedInstanceState.str()})")
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonGoToFragmentActivity.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        
    }

    override fun onStart() {
        super.onStart()
        Log.d(LIFECYCLE_TAG, "StartActivity: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LIFECYCLE_TAG, "StartActivity: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LIFECYCLE_TAG, "StartActivity: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LIFECYCLE_TAG, "StartActivity: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFECYCLE_TAG, "StartActivity: onDestroy()")
    }
}