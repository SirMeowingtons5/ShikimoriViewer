package com.meowingtons.network

import android.content.res.Resources
import com.meowingtons.network.api.AuthApi
import com.meowingtons.network.di.component.DaggerAuthComponent
import com.meowingtons.network.di.scope.AuthenticatorScope
import com.meowingtons.network.model.AccessToken


class Authenticator(val authApi: AuthApi){
    init {
    }
    fun getAccessToken(authorizationCode: String): AccessToken?{
        val params = hashMapOf<String, String>()
        params["grant_type"] = "authorization_code"
        params["client_id"] = Resources.getSystem().getString(R.string.client_id)
        params["client_secret"] = Resources.getSystem().getString(R.string.client_secret)
        params["code"] = authorizationCode
        params["redirect_uri"] = Resources.getSystem().getString(R.string.redirect_uri)
        return authApi.getAccessToken(params).execute().body()
    }
    fun getRefreshToken(refreshToken: String): AccessToken?{
        val params = hashMapOf<String, String>()
        params["grant_type"] = "refresh_token"
        params["client_id"] = Resources.getSystem().getString(R.string.client_id)
        params["client_secret"] = Resources.getSystem().getString(R.string.client_secret)
        params["refresh_token"] = refreshToken
        return authApi.refreshAccessToken(params).execute().body()
    }
}
