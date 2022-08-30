package com.kito.visibility.base

import android.app.Dialog
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.updatePadding
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kito.visibility.R
import com.kito.visibility.dp

abstract class BaseRoundBottomSheetDialog<T : ViewDataBinding>(
    private val topLeftRadius: Float = 16.dp,
    private val topRightRadius: Float = 16.dp,
    private val bottomLeftRadius: Float = 0.dp,
    private val bottomRightRadius: Float = 0.dp,
    private val leftOffset: Int = 0.dp.toInt(),
    private val rightOffset: Int = 0.dp.toInt(),
    private val bottomOffset: Int = 0.dp.toInt()
) : BottomSheetDialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.DialogStyle)
    }

    private var _binding: T? = null
    protected lateinit var binding: T
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        _binding!!.lifecycleOwner = viewLifecycleOwner
        binding = _binding!!
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addEvent()
        addObservers()
        setUpViews()
        addData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.apply {
            setOnShowListener {
                findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet)!!.apply {
                    val cornerDrawable = GradientDrawable()
                    //Round the corner of dialog
                    cornerDrawable.cornerRadii = floatArrayOf(
                        topLeftRadius, topLeftRadius,
                        topRightRadius, topRightRadius,
                        bottomRightRadius, bottomRightRadius,
                        bottomLeftRadius, bottomLeftRadius
                    )
                    background = cornerDrawable
                    // set offset to the edge
                    updatePadding(leftOffset, 0, rightOffset, bottomOffset)
                }
            }
            behavior.apply {
                state = BottomSheetBehavior.STATE_EXPANDED
//                this.isDraggable = false
            }
        }
        return dialog
    }
}

fun showBottomSheetDialog(fragmentManager: FragmentManager, dialog: BottomSheetDialogFragment) {
    dialog.show(fragmentManager, null)
}

fun View.updateMargin(block: ViewGroup.MarginLayoutParams.() -> Unit) {
    val params = layoutParams as ViewGroup.MarginLayoutParams
    block(params)
    layoutParams = params
}