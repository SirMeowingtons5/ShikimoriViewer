package com.meowingtons.network

import android.content.res.Resources
import android.util.Log
import com.meowingtons.network.api.AuthApi
import com.meowingtons.network.model.AccessToken
import com.meowingtons.network.constants.*


class Authenticator(private val authApi: AuthApi){
    init {
    }
    suspend fun getAccessToken(authorizationCode: String): AccessToken?{
        val params = hashMapOf<String, String>()
        params["grant_type"] = "authorization_code"
        params["client_id"] = OauthCredentials.clientId
        params["client_secret"] = OauthCredentials.clientSecret
        params["code"] = authorizationCode
        params["redirect_uri"] = "app://com.meowingtons.shikimoriviewer/oauth"
        val res = authApi.getAccessToken(params).execute()

        return res.body()
    }
    suspend fun getRefreshToken(refreshToken: String): AccessToken?{
        val params = hashMapOf<String, String>()
        params["grant_type"] = "refresh_token"
        params["client_id"] = OauthCredentials.clientId
        params["client_secret"] = OauthCredentials.clientSecret
        params["refresh_token"] = refreshToken
        return authApi.refreshAccessToken(params).execute().body()
    }
}
