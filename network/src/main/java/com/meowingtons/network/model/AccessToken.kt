package com.meowingtons.network.model

data class AccessToken(val access_token : String, val token_type : String,
                       val refresh_token : String, val expires_in : Int,
                       val created_at : Int)