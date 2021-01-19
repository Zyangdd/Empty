package com.zyangdd.empty.base.extensions

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.zyangdd.empty.common.RefreshState

fun SwipeRefreshLayout.initColorDefault() {
    setColorSchemeResources(
        android.R.color.holo_purple,
        android.R.color.holo_orange_light,
        android.R.color.holo_green_light,
        android.R.color.holo_blue_light
    )
}

fun SwipeRefreshLayout.updateState(refreshState: RefreshState) {
    when (refreshState) {
        RefreshState.ENABLE -> isEnabled = true
        RefreshState.DISABLE -> isEnabled = false
        RefreshState.SHOW -> isRefreshing = true
        RefreshState.HIDE -> isRefreshing = false
    }
}