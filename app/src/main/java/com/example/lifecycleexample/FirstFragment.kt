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
import com.example.lifecycleexample.databinding.FragmentFirstBinding


class FirstFragment @JvmOverloads constructor(byUser: Boolean = false) : Fragment() {

    private lateinit var viewModel: FirstFragmentViewModel
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    init {
        Log.d(LIFECYCLE_TAG, "FirstFragment: init(byUser=$byUser)")
    }

    override fun onInflate(context: Context, attrs: AttributeSet, savedInstanceState: Bundle?) {
        super.onInflate(context, attrs, savedInstanceState)
        Log.d(LIFECYCLE_TAG, "FirstFragment: onInflate()")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(LIFECYCLE_TAG, "FirstFragment: onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setRetainInstance(true)
        Log.d(LIFECYCLE_TAG, "FirstFragment: onCreate(${savedInstanceState.str()})")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(LIFECYCLE_TAG, "FirstFragment: onActivityCreated(${savedInstanceState.str()})")
        viewModel = ViewModelProvider(this).get(FirstFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(LIFECYCLE_TAG, "FirstFragment: onCreateView(${savedInstanceState.str()})")
        _binding = FragmentFirstBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(LIFECYCLE_TAG, "FirstFragment: onViewCreated()")
        binding.buttonGoToSecondFragment.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                addToBackStack("transaction1")
                replace(R.id.fragmentContainerView, SecondFragment(byUser = true), "secondFragment")
//                add(R.id.fragmentContainerView, SecondFragment(byUser = true), "secondFragment")
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(LIFECYCLE_TAG, "FirstFragment: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LIFECYCLE_TAG, "FirstFragment: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LIFECYCLE_TAG, "FirstFragment: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LIFECYCLE_TAG, "FirstFragment: onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d(LIFECYCLE_TAG, "FirstFragment: onDestroyView()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(LIFECYCLE_TAG, "FirstFragment: onDetach()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFECYCLE_TAG, "FirstFragment: onDestroy()")
    }
}