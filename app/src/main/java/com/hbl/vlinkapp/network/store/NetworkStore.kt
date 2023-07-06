package com.hbl.hblaccountopeningapp.network.store

import android.app.Application
import com.hbl.hblaccountopeningapp.network.timeoutInterface.IOnConnectionTimeoutListener
open class NetworkStore : Application(), IOnConnectionTimeoutListener {

    override fun onConnectionTimeout() {}

    companion object {
        private val consumerStore: NetworkStore? = null

        //    APIInterface globalBaseUrl = RetrofitBuilder.INSTANCE.getRetrofitInstance(GlobalClass.applicationContext, RetrofitEnums.URL_HBL);
        val instance: NetworkStore?
            get() = consumerStore ?: NetworkStore()
    }

   /* //:TODO post getLogin
    fun getLogin(
        url: RetrofitEnums?,
        loginRequest: LoginRequest?,
        loginCallBack: LoginCallBack
    ) {
        var privateInstanceRetrofit: APIInterface? =
            GlobalClass.applicationContext?.let { RetrofitBuilder.getRetrofitInstance(it,    url!!, Config.API_CONNECT_TIMEOUT) }
        privateInstanceRetrofit?.getLogin(loginRequest)!!.enqueue(LoginBaseHR(loginCallBack))
    }
*/
   /* fun printDocs(
        url: RetrofitEnums?,
        printdoc: RequestBody,
        trackingid: RequestBody,
        cnic: RequestBody,
        mysisno: RequestBody,
        cifno: RequestBody,
        identifier: RequestBody,
        callback: PrintDocCallBack
    ) {
        var privateInstanceRetrofit: APIInterface? =
            GlobalClass.applicationContext?.let { RetrofitBuilder.getRetrofitInstance(it,  url!!, Config.API_CONNECT_TIMEOUT) }
        privateInstanceRetrofit?.printDocs(printdoc,trackingid,cnic,mysisno,cifno,identifier)
            ?.enqueue(PrintDocsHR(callback))
    }


    //:TODO getTrackingID
    fun getKonnectTrackingID(
        url: RetrofitEnums?,
        trackingIDRequest: TrackingIDRequest?,
        callback: KonnectTrackingIDCallBack
    ) {
        var privateInstanceRetrofit: APIInterface? =
            GlobalClass.applicationContext?.let { RetrofitBuilder.getRetrofitInstance(it,  url!!, Config.API_CONNECT_TIMEOUT) }
        privateInstanceRetrofit?.getKonnectTrackingID(trackingIDRequest?.brcode)?.enqueue(KonnectTrackingIDHR(callback))
    }*/


}