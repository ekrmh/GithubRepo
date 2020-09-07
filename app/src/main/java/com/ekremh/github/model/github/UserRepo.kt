package com.ekremh.github.model.github

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserRepo (
	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("owner") val owner : Owner,
	@SerializedName("open_issues_count") val openIssuesCount : Int,
	@SerializedName("stargazers_count") val stargazersCount : Int,
	var isFavorite: Boolean = false
) : Serializable