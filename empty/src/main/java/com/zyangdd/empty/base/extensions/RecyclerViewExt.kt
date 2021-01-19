package com.zyangdd.empty.base.extensions

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.zyangdd.empty.widget.GridPreLoadLayoutManager
import com.zyangdd.empty.widget.LinearPreLoadLayoutManager
import com.zyangdd.empty.widget.OnSnapPositionChangeListener
import com.zyangdd.empty.widget.SnapOnScrollListener

fun RecyclerView.setup(
    spanCount: Int = 3,
    orientation: Int = RecyclerView.VERTICAL,
    layoutManagerType: LayoutManagerType = LayoutManagerType.LINEAR,
    hasFixedSize: Boolean = true,
    reverseLayout: Boolean = false
) {
    this.layoutManager = when (layoutManagerType) {
        LayoutManagerType.GRID -> GridLayoutManager(
            context, spanCount, orientation, reverseLayout
        )
        LayoutManagerType.LINEAR_PRELOAD -> LinearPreLoadLayoutManager(
            context, orientation, reverseLayout
        )
        LayoutManagerType.GRID_PRELOAD -> GridPreLoadLayoutManager(
            context, spanCount, orientation, reverseLayout
        )
        else -> LinearLayoutManager(context, orientation, reverseLayout)
    }
    this.clipToPadding = false
    this.setHasFixedSize(hasFixedSize)
}

fun RecyclerView.attachSnapHelperWithListener(
    snapHelper: SnapHelper,
    behavior: SnapOnScrollListener.Behavior = SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL,
    onSnapPositionChangeListener: OnSnapPositionChangeListener
) {
    snapHelper.attachToRecyclerView(this)
    val snapOnScrollListener =
        SnapOnScrollListener(snapHelper, behavior, onSnapPositionChangeListener)
    addOnScrollListener(snapOnScrollListener)
}

fun SnapHelper.getSnapPosition(recyclerView: RecyclerView): Int {
    val layoutManager = recyclerView.layoutManager ?: return RecyclerView.NO_POSITION
    val snapView = findSnapView(layoutManager) ?: return RecyclerView.NO_POSITION
    return layoutManager.getPosition(snapView)
}

enum class LayoutManagerType {
    LINEAR, LINEAR_PRELOAD, GRID, GRID_PRELOAD
}