package com.mouse.autotestexample

import android.content.Context
import android.content.SharedPreferences

class SharePerenceManager(val context: Context) {
    private val sharedPreferenceKey = "USER_DATA"

    var sharedPreference: SharedPreferences

    init {
        sharedPreference = context.getSharedPreferences(sharedPreferenceKey, Context.MODE_PRIVATE)
    }

    fun saveString(key: String, value: String) {
        sharedPreference.edit().putString(key, value).commit()
    }

    fun getString(key: String): String {
        return sharedPreference.getString(key, "") ?: ""
    }
}