package com.zyangdd.empty.common

import com.zyangdd.empty.R

data class AppError(
    var code: Int = 0,
    var title: String = "Error",
    var message: String = "Whoop\nSomething went wrong!",
    var titleRes: Int = R.string.error,
    var messageRes: Int = R.string.error_message_common,
)