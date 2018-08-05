package com.meowingtons.network.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.meowingtons.network.Authenticator
import com.meowingtons.network.api.AuthApi
import com.meowingtons.network.di.scope.AuthenticatorScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
(includes = [OkHttpClientModule::class])
class AuthModule {

    @Provides
    fun authenticator(authApi: AuthApi): Authenticator{
        return Authenticator(authApi)
    }

    @AuthenticatorScope
    @Provides
    fun authApi(retrofit: Retrofit) : AuthApi {
        return retrofit.create(AuthApi::class.java)
    }

    @AuthenticatorScope
    @Provides
    fun retrofit(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory): Retrofit{
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://shikimori.org/oauth")
                .addConverterFactory(gsonConverterFactory)
                .build()
    }

    @Provides
    fun gson() : Gson{
        return GsonBuilder().create()
    }

    @Provides
    fun gsonConverterFactory(gson: Gson): GsonConverterFactory{
        return GsonConverterFactory.create(gson)
    }
}