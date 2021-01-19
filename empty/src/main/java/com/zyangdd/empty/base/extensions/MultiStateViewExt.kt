package com.zyangdd.empty.base.extensions

import com.zyangdd.empty.common.ViewState
import com.zyangdd.empty.widget.MultiStateView

fun MultiStateView.updateState(state: ViewState) {
    when (state) {
        ViewState.CONTENT -> update(MultiStateView.State.CONTENT)
        ViewState.LOADING -> update(MultiStateView.State.LOADING)
        ViewState.EMPTY -> update(MultiStateView.State.EMPTY)
        ViewState.ERROR -> update(MultiStateView.State.ERROR)
    }
}