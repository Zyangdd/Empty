package com.zyangdd.empty.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zyangdd.empty.AppConstants
import com.zyangdd.empty.common.*
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel : ViewModel() {
    private val disposables = CompositeDisposable()

    private val _showProgress = SingleLiveEvent<Boolean>()
    val showProgress: LiveData<Boolean> = _showProgress

    private val _showMessage = SingleLiveEvent<String>()
    val showMessage: LiveData<String> = _showMessage

    private val _showMessageRes = SingleLiveEvent<Int>()
    val showMessageRes: LiveData<Int> = _showMessageRes

    private val _showError = SingleLiveEvent<AppError>()
    val showError: LiveData<AppError> = _showError

    private val _showErrorRes = SingleLiveEvent<AppError>()
    val showErrorRes: LiveData<AppError> = _showErrorRes

    private val _refreshState = MutableLiveData<RefreshState>()
    val refreshState: LiveData<RefreshState> = _refreshState

    private val _loadMoreState = MutableLiveData<LoadMoreState>()
    val loadMoreState: LiveData<LoadMoreState> = _loadMoreState

    private val _viewState = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = _viewState

    // Loading
    protected fun showProgress() {
        _showProgress.value = true
    }

    protected fun hideProgress() {
        _showProgress.value = false
    }

    // Message
    protected fun showMessage(message: String) {
        _showMessage.value = message
    }

    protected fun showMessage(messageRes: Int) {
        _showMessageRes.value = messageRes
    }

    // Error
    protected fun showError(appError: AppError) {
        _showError.value = appError
    }

    protected fun showError() {
        _showError.value = AppError()
    }

    protected fun showErrorRes(appError: AppError) {
        _showErrorRes.value = appError
    }

    protected fun showErrorRes() {
        _showErrorRes.value = AppError()
    }

    // Refresh
    protected fun showRefresh() {
        _refreshState.value = RefreshState.SHOW
    }

    protected fun hideRefresh() {
        _refreshState.value = RefreshState.HIDE
    }

    protected fun enableRefresh() {
        _refreshState.value = RefreshState.ENABLE
    }

    protected fun disableRefresh() {
        _refreshState.value = RefreshState.DISABLE
    }

    // LoadMore
    protected fun loadMoreEnable() {
        _loadMoreState.value = LoadMoreState.ENABLE
    }

    protected fun loadMoreDisable() {
        _loadMoreState.value = LoadMoreState.DISABLE
    }

    protected fun loadMoreComplete() {
        _loadMoreState.value = LoadMoreState.COMPLETE
    }

    protected fun loadMoreError() {
        _loadMoreState.value = LoadMoreState.ERROR
    }

    protected fun loadMoreEnd() {
        _loadMoreState.value = LoadMoreState.END
    }

    // ViewState
    protected fun showViewStateContent() {
        _viewState.value = ViewState.CONTENT
    }

    protected fun showViewStateEmpty() {
        _viewState.value = ViewState.EMPTY
    }

    protected fun showViewStateError() {
        _viewState.value = ViewState.ERROR
    }

    protected fun showViewStateLoading() {
        _viewState.value = ViewState.LOADING
    }

    // handle load more common
    protected fun handleLoadMoreCommon(newData: List<Any>) {
        if (newData.size < AppConstants.PER_PAGE) {
            loadMoreEnd()
        } else {
            loadMoreComplete()
        }
    }

    //
    fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}