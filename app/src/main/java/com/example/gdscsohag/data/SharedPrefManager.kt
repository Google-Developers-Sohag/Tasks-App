package com.example.gdscsohag.data

import android.content.Context
import android.content.SharedPreferences

object SharedPrefManager {
    private var sharedPreferences: SharedPreferences? = null
    private const val SHARED_PREFERENCE_NAME = "sharedPreference"
    private const val LOGIN_KEY = "loginKey"
    fun getInit(context: Context): SharedPreferences {
        sharedPreferences =
            context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)
        return sharedPreferences!!
    }

    var isLogin: Boolean
        get() = sharedPreferences?.getBoolean(LOGIN_KEY, false) == true
        set(value) {
            sharedPreferences?.edit()?.putBoolean(LOGIN_KEY, value)?.apply()
        }
}