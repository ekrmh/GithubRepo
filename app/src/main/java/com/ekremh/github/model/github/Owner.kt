package com.ekremh.github.model.github

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Owner (
	@SerializedName("id") val id : Int,
	@SerializedName("login") val login : String,
	@SerializedName("avatar_url") val avatarUrl : String
) : Serializable