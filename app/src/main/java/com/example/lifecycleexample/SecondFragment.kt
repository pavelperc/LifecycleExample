package com.example.lifecycleexample

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.example.lifecycleexample.databinding.FragmentSecondBinding


class SecondFragment @JvmOverloads constructor(byUser: Boolean = false) : Fragment() {

    private lateinit var viewModel: SecondFragmentViewModel

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    init {
        Log.d(LIFECYCLE_TAG, "SecondFragment: init(byUser=$byUser)")
    }

    override fun onInflate(context: Context, attrs: AttributeSet, savedInstanceState: Bundle?) {
        super.onInflate(context, attrs, savedInstanceState)
        Log.d(LIFECYCLE_TAG, "SecondFragment: onInflate()")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(LIFECYCLE_TAG, "SecondFragment: onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setRetainInstance(true)
        Log.d(LIFECYCLE_TAG, "SecondFragment: onCreate(${savedInstanceState.str()})")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(LIFECYCLE_TAG, "SecondFragment: onActivityCreated(${savedInstanceState.str()})")
        viewModel = ViewModelProvider(this).get(SecondFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(LIFECYCLE_TAG, "SecondFragment: onCreateView()")
        _binding = FragmentSecondBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(LIFECYCLE_TAG, "SecondFragment: onViewCreated()")
        binding.buttonGoToFirstFragment.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                addToBackStack("transaction2")
                replace(R.id.fragmentContainerView, FirstFragment(byUser = true), "firstFragment")
//                add(R.id.fragmentContainerView, FirstFragment(byUser = true), "firstFragment")
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(LIFECYCLE_TAG, "SecondFragment: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LIFECYCLE_TAG, "SecondFragment: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LIFECYCLE_TAG, "SecondFragment: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LIFECYCLE_TAG, "SecondFragment: onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(LIFECYCLE_TAG, "SecondFragment: onDestroyView()")
        _binding = null
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(LIFECYCLE_TAG, "SecondFragment: onDetach()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFECYCLE_TAG, "SecondFragment: onDestroy()")
    }

}