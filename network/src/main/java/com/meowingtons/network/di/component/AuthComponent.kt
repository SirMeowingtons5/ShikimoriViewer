package com.meowingtons.network.di.component

import com.meowingtons.network.api.AuthApi
import com.meowingtons.network.di.module.AuthModule
import com.meowingtons.network.di.scope.AuthenticatorScope
import dagger.Component

@AuthenticatorScope
@Component (modules = [AuthModule::class])
interface AuthComponent{
    fun getAuthApi() : AuthApi
}