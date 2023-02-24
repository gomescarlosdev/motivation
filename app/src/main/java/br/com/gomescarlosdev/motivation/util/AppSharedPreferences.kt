package br.com.gomescarlosdev.motivation.util

import android.content.Context

class AppSharedPreferences(context: Context) {

    private val appSharedPreferences =
        context.getSharedPreferences(MotivationConstants.KEY.MOTIVATION, Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {
        appSharedPreferences.edit().putString(key, value).apply()
    }

    fun getStoredString(key: String): String {
        return appSharedPreferences.getString(key, "") ?: ""
    }
}