package com.example.lifecycleexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.commit
import com.example.lifecycleexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LIFECYCLE_TAG, "MainActivity: onCreate(${savedInstanceState.str()})")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragmentContainerView, FirstFragment(byUser = true), "firstFragment")
            }
        }
        binding.buttonFindFragments.setOnClickListener {
            val firstIsFound = supportFragmentManager.findFragmentByTag("firstFragment") != null
            val secondIsFound = supportFragmentManager.findFragmentByTag("secondFragment") != null
            val text = when {
                firstIsFound && secondIsFound -> "found first and second"
                firstIsFound -> "found first"
                secondIsFound -> "found second"
                else -> "found nothing"
            }
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
        binding.buttonShowDialog.setOnClickListener {
            AlertDialog.Builder(this).setTitle("Title").setMessage("Message")
                .setPositiveButton("positive") { dialog, _ -> dialog.dismiss() }
                .setNegativeButton("negative") { dialog, _ -> dialog.cancel() }
                .setOnCancelListener {
                    Log.d(LIFECYCLE_TAG, "Dialog: canceled()")
                }
                .setOnDismissListener {
                    Log.d(LIFECYCLE_TAG, "Dialog: dismissed()")
                }
                .show()
        }
        binding.buttonFinishActivity.setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(LIFECYCLE_TAG, "MainActivity: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LIFECYCLE_TAG, "MainActivity: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LIFECYCLE_TAG, "MainActivity: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LIFECYCLE_TAG, "MainActivity: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFECYCLE_TAG, "MainActivity: onDestroy()")
    }

    override fun onBackPressed() {
        val entryCount = supportFragmentManager.backStackEntryCount
        Log.d(LIFECYCLE_TAG, "MainActivity: onBackPressed(), backStackEntryCount=$entryCount")
        if (entryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            Toast.makeText(this, "Back stack is empty", Toast.LENGTH_SHORT).show()
            super.onBackPressed()
        }
    }
}