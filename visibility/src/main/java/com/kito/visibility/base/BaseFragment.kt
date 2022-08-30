package com.kito.visibility.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    private var _binding: T? = null
    protected val binding: T get() = _binding!!
    abstract fun getLayoutId(): Int

    /**
     * Add listener, event for view like click listener
     */
    open fun addEvent() {}

    /**
     * Add observers for livedata
     */
    open fun addObservers() {}

    /**
     * Setup the initialize state for views, like set adapter for recycle view
     */
    open fun setUpViews() {}

    /**
     * Init data if need, like call api
     */
    open fun addData() {}
    open fun addOnCreateView() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        _binding!!.lifecycleOwner = viewLifecycleOwner
        addOnCreateView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addEvent()
        addObservers()
        setUpViews()
        addData()
    }

    override fun onPause() {
        super.onPause()
        if (isRemoving) {
            binding.unbind()
        }
    }
}