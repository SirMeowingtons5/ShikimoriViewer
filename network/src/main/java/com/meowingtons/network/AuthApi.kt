package com.meowingtons.network

import com.meowingtons.network.model.AccessToken
import retrofit2.Call
import retrofit2.http.*


interface AuthApi {
    @POST("/token")
    @Headers("User-Agent: ShikimoriViewer")
    fun getAccessToken(@FieldMap params : Map<String, String>) : Call<AccessToken>

    @POST ("/token")
    @Headers("User-Agent: ShikimoriViewer")
    fun refreshAccessToken(@FieldMap params : Map<String, String>) : Call<AccessToken>
}
