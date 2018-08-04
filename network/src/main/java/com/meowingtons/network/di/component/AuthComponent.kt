package com.meowingtons.network.di.component

import com.meowingtons.network.AuthApi
import com.meowingtons.network.di.module.AuthModule
import dagger.Component

@Component (modules = [AuthModule::class])
interface AuthComponent{
    fun getAuthApi() : AuthApi
}