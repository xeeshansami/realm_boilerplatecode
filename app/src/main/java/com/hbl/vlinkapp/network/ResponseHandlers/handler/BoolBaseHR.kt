package com.hbl.hblaccountopeningapp.network.ResponseHandlers.handler

import com.hbl.hblaccountopeningapp.network.ResponseHandlers.callbacks.BoolCallBack
import com.hbl.hblaccountopeningapp.network.models.response.base.BaseResponse

class BoolBaseHR(callBack: BoolCallBack) : BaseRH<BaseResponse>() {
    var callback: BoolCallBack = callBack
    override fun onSuccess(response: BaseResponse?) {
        response?.let { callback.BoolSuccess(it) }
    }

    override fun onFailure(response: BaseResponse?) {
        response?.let { callback.BoolFailure(it) }
    }
}