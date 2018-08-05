package com.meowingtons.network.api

import com.meowingtons.network.model.AccessToken
import retrofit2.Call
import retrofit2.http.*


interface AuthApi {
    @FormUrlEncoded
    @POST("/oauth/token")
    @Headers("User-Agent: ShikimoriViewer")
    fun getAccessToken(@FieldMap params : Map<String, String>) : Call<AccessToken>

    @FormUrlEncoded
    @POST ("/oauth/token")
    @Headers("User-Agent: ShikimoriViewer")
    fun refreshAccessToken(@FieldMap params : Map<String, String>) : Call<AccessToken>
}
