package com.kito.visibility.util

import android.content.Context

object SPUtils {
    private const val SHARED_PREFERENCES_NAME = "kito"

    fun putInt(context: Context?, keyWord: String, value: Int) {
        context?.let {
            val sharedPreferences =
                it.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putInt(keyWord, value)
            editor.apply()
        }
    }

    fun putString(context: Context?, keyWord: String, value: String) {
        context?.let {
            val sharedPreferences =
                it.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString(keyWord, value)
            editor.apply()
        }
    }

    fun putFloat(context: Context?, keyWord: String, value: Float) {
        context?.let {
            val sharedPreferences =
                it.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putFloat(keyWord, value)
            editor.apply()
        }
    }

    fun putBoolean(context: Context?, keyWord: String, value: Boolean) {
        context?.let {
            val sharedPreferences =
                it.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean(keyWord, value)
            editor.apply()
        }
    }

    fun putLong(context: Context?, keyWord: String, value: Long) {
        context?.let {
            val sharedPreferences =
                it.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putLong(keyWord, value)
            editor.apply()
        }
    }

    fun getInt(context: Context?, keyWord: String, defaultValue: Int): Int {
        context?.let {
            val sharedPreferences =
                it.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
            return sharedPreferences?.getInt(keyWord, defaultValue) ?: defaultValue
        }
        return defaultValue
    }

    fun getString(context: Context?, keyWord: String, defaultValue: String): String {
        context?.let {
            val sharedPreferences =
                it.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
            return sharedPreferences?.getString(keyWord, defaultValue) ?: defaultValue
        }
        return defaultValue
    }

    fun getFloat(context: Context?, keyWord: String, defaultValue: Float): Float {
        context?.let {
            val sharedPreferences =
                it.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
            return sharedPreferences?.getFloat(keyWord, defaultValue) ?: defaultValue
        }
        return defaultValue
    }

    fun getBoolean(context: Context?, keyWord: String, defaultValue: Boolean): Boolean {
        context?.let {
            val sharedPreferences =
                it.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
            return sharedPreferences?.getBoolean(keyWord, defaultValue) ?: defaultValue
        }
        return defaultValue
    }

    fun getLong(context: Context?, keyWord: String, defaultValue: Long): Long {
        context?.let {
            val sharedPreferences =
                it.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
            return sharedPreferences?.getLong(keyWord, defaultValue) ?: defaultValue
        }
        return defaultValue
    }
    fun deleteSP(context: Context?, keyWord: String) {
        context?.let {
            val sharedPreferences =
                it.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
            sharedPreferences.edit().remove(keyWord).commit()
        }
    }
}