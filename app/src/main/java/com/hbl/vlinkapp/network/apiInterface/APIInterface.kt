package com.hbl.hblaccountopeningapp.network.apiInterface


import com.hbl.hblaccountopeningapp.network.models.request.base.*
import com.hbl.hblaccountopeningapp.network.models.response.base.*
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface APIInterface {
  /*  @POST("m/login")
    fun getLogin(@Body loginRequest: LoginRequest?): Call<LoginResponse>

    @Multipart
    @POST("m/documentPrint")
    fun printDocs(
        @Part("printdoc\"; filename=\"hbl.pdf\" ") file: RequestBody?,
        @Part("trackingid") trackingid: RequestBody?,
        @Part("cnic") cnic: RequestBody?,
        @Part("mysisno") mysisno: RequestBody?,
        @Part("cifno") cifno: RequestBody?,
        @Part("identifier") identifier: RequestBody?
    ): Call<PrintDocsResponse>

    @GET("tracking/{branchCode}")
    fun getKonnectTrackingID(@Path("branchCode") branchCode: String?): Call<KonnectTrackingIDResponse>

*/

    companion object {
        const val HEADER_TAG = "@"
        const val HEADER_POSTFIX = ": "
        const val HEADER_TAG_PUBLIC = "public"
    }
}