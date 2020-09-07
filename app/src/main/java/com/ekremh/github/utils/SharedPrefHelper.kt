package com.ekremh.github.utils

import android.content.SharedPreferences
import com.ekremh.github.model.github.Favorite
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken




class SharedPrefHelper(private val sharedPreferences: SharedPreferences, private val gson: Gson) {
    private val ID_LIST = "ID_LIST"

    fun addOFromList(id: String) {
        val ids = getList().toMutableList()

        ids.add(id)

        val editor = sharedPreferences.edit()
        editor.putString(ID_LIST, gson.toJson(ids))
        editor.apply()

    }

    fun removeFromList(id: String) {
        val ids = getList().toMutableList()

        ids.remove(id)

        val editor = sharedPreferences.edit()
        editor.putString(ID_LIST, gson.toJson(ids))
        editor.apply()

    }

    fun isFavorite(id: String): Boolean {
        val ids = getList()
        return ids.contains(id)
    }

    fun getList(): List<String>{
        val ids = mutableListOf<String>()

        val data = sharedPreferences.getString(ID_LIST, "")

        if (data != null && data.isNotEmpty()){
            val listType =
                object : TypeToken<List<String>>() {}.type
            ids.addAll(gson.fromJson<List<String>>(data, listType))
        }

        return  ids
    }

}