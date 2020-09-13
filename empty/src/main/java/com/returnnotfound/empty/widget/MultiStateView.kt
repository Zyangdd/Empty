package com.returnnotfound.empty.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import com.returnnotfound.empty.R

class MultiStateView : MotionLayout {
    private var state: State = State.CONTENT
    private var loadingViewLayoutId: Int = R.layout.view_state_loading
    private var emptyViewLayoutId = R.layout.view_state_empty
    private var errorViewLayoutId = R.layout.view_state_error

    private lateinit var loadingView: View
    private lateinit var emptyView: View
    private lateinit var errorView: View

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        internalUpdateState(state)
    }

    private fun init(attrs: AttributeSet?) {
        val inputArr = context.obtainStyledAttributes(attrs, R.styleable.MultiStateView)
        val indexState = inputArr.getInt(
            R.styleable.MultiStateView_state, 0
        )
        state = getStateValueByIndex(indexState)
        loadingViewLayoutId = inputArr.getResourceId(
            R.styleable.MultiStateView_loadingLayout, loadingViewLayoutId
        )
        emptyViewLayoutId = inputArr.getResourceId(
            R.styleable.MultiStateView_emptyLayout, emptyViewLayoutId
        )
        errorViewLayoutId = inputArr.getResourceId(
            R.styleable.MultiStateView_errorLayout, errorViewLayoutId
        )
        inputArr.recycle()
    }

    fun update(state: State) {
        internalUpdateState(state)
        this.state = state
    }

    fun setLoadingView(layoutId: Int) {
        internalSetLoadingView(layoutId)
        this.loadingViewLayoutId = layoutId
    }

    fun setEmptyView(layoutId: Int) {
        internalSetEmptyView(layoutId)
        this.emptyViewLayoutId = layoutId
    }

    fun setErrorView(layoutId: Int) {
        internalSetErrorView(layoutId)
        this.errorViewLayoutId = layoutId
    }

    fun getViewByState(state: State): View {
        return when (state) {
            State.CONTENT -> this
            State.LOADING -> loadingView
            State.EMPTY -> emptyView
            State.ERROR -> errorView
        }
    }

    private fun internalUpdateState(state: State) {
        removeAllStateView()
        when (state) {
            State.LOADING -> {
                if (!isLoadingViewInitialized()) {
                    internalSetLoadingView(loadingViewLayoutId)
                }
                addView(loadingView)
            }
            State.EMPTY -> {
                if (!isEmptyViewInitialized()) {
                    internalSetEmptyView(emptyViewLayoutId)
                }
                addView(emptyView)
            }
            State.ERROR -> {
                if (!isErrorViewInitialized()) {
                    internalSetErrorView(errorViewLayoutId)
                }
                addView(errorView)
            }
            else -> {
            }
        }
    }

    private fun removeAllStateView() {
        removeLoadingView()
        removeEmptyView()
        removeErrorView()
    }

    private fun removeLoadingView() {
        if (isLoadingViewAdded()) {
            removeView(loadingView)
        }
    }

    private fun removeEmptyView() {
        if (isEmptyViewAdded()) {
            removeView(emptyView)
        }
    }

    private fun removeErrorView() {
        if (isErrorViewAdded()) {
            removeView(errorView)
        }
    }

    private fun internalSetLoadingView(layoutId: Int): View {
        removeLoadingView()
        loadingView = LayoutInflater.from(context).inflate(layoutId, this, false)
        return loadingView
    }

    private fun internalSetEmptyView(layoutId: Int): View {
        removeEmptyView()
        emptyView = LayoutInflater.from(context).inflate(layoutId, this, false)
        return emptyView
    }

    private fun internalSetErrorView(layoutId: Int): View {
        removeErrorView()
        errorView = LayoutInflater.from(context).inflate(layoutId, this, false)
        return errorView
    }

    override fun generateDefaultLayoutParams(): LayoutParams {
        val result = LayoutParams(0, 0)
        result.topToTop = LayoutParams.PARENT_ID
        result.bottomToBottom = LayoutParams.PARENT_ID
        result.startToStart = LayoutParams.PARENT_ID
        result.endToEnd = LayoutParams.PARENT_ID
        return result
    }

    private fun isLoadingViewAdded(): Boolean {
        return isLoadingViewInitialized() && isViewAdded(loadingView)
    }

    private fun isEmptyViewAdded(): Boolean {
        return isEmptyViewInitialized() && isViewAdded(emptyView)
    }

    private fun isErrorViewAdded(): Boolean {
        return isErrorViewInitialized() && isViewAdded(errorView)
    }

    private fun isLoadingViewInitialized(): Boolean {
        return this::loadingView.isInitialized
    }

    private fun isEmptyViewInitialized(): Boolean {
        return this::emptyView.isInitialized
    }

    private fun isErrorViewInitialized(): Boolean {
        return this::errorView.isInitialized
    }

    private fun isViewAdded(view: View): Boolean {
        return indexOfChild(view) >= 0
    }

    // State
    enum class State {
        CONTENT, LOADING, EMPTY, ERROR
    }

    private fun getStateValueByIndex(index: Int): State {
        return State.values()[index]
    }
}