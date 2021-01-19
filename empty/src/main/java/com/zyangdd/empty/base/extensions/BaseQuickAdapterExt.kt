package com.zyangdd.empty.base.extensions

import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.zyangdd.empty.common.LoadMoreState

fun BaseQuickAdapter<*, *>.updateLoadMoreState(loadMoreState: LoadMoreState) {
    when (loadMoreState) {
        LoadMoreState.ENABLE -> loadMoreModule.isEnableLoadMore = true
        LoadMoreState.DISABLE -> loadMoreModule.isEnableLoadMore = false
        LoadMoreState.COMPLETE -> loadMoreModule.loadMoreComplete()
        LoadMoreState.END -> loadMoreModule.loadMoreEnd()
        LoadMoreState.ERROR -> loadMoreModule.loadMoreFail()
    }
}

fun BaseViewHolder.setSelected(isSelected: Boolean): BaseViewHolder {
    itemView.isSelected = isSelected
    return this
}

fun BaseViewHolder.setSelected(id: Int, isSelected: Boolean): BaseViewHolder {
    getView<ImageView>(id).isSelected = isSelected
    return this
}

fun BaseViewHolder.setTextHtml(viewId: Int, text: String): BaseViewHolder {
    getView<TextView>(viewId).setTextHtml(text)
    return this
}