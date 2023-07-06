package com.hbl.hblaccountopeningapp.network.ResponseHandlers.callbacks

import com.hbl.hblaccountopeningapp.network.models.response.base.*
import retrofit2.Callback

interface BoolCallBack {
    fun BoolSuccess(response: BaseResponse)
    fun BoolFailure(response: BaseResponse)
}