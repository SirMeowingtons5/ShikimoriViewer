package com.meowingtons.network.di.component

import com.meowingtons.network.Authenticator
import com.meowingtons.network.di.module.AuthenticatorModule
import com.meowingtons.network.di.scope.AuthenticatorScope
import dagger.Component

@AuthenticatorScope
@Component(modules = [AuthenticatorModule::class])
interface AuthenticatorComponent {
    fun getAuthenticator(): Authenticator
}