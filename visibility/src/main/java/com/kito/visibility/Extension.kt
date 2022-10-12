package com.kito.visibility

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.ktx.BuildConfig

private const val TAG = "kito"

fun View.isVisible(): Boolean {
    return visibility  ==  View.VISIBLE
}
//test to remove abc

fun View.isInvisible(): Boolean {
    return  visibility == View.INVISIBLE
}

fun View.isGone(): Boolean {
    return visibility == View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun Any.logd(tag: String) {
    if (!BuildConfig.DEBUG) return
    if (this is String) {
        Log.d(tag, this)
    } else {
        Log.d(tag, this.toString())
    }
}

fun Context.showToast(text: String) {
    if (Looper.myLooper() == Looper.getMainLooper()) {
        Toast.makeText(this.applicationContext, text, Toast.LENGTH_SHORT).apply {
            setText(text)
            duration = Toast.LENGTH_SHORT
            show()
        }
    }
}

fun Context.isHaveConnect(activity: Activity): Boolean {
    var isOnline = false
    try {
        val manager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            manager.getNetworkCapabilities(manager.activeNetwork) // need ACCESS_NETWORK_STATE permission
        isOnline =
            capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    } catch (e: java.lang.Exception) {
        e.printStackTrace()
    }
    return isOnline
}

val Number.dp: Float
    get() {
        val scale = Resources.getSystem().displayMetrics.density
        return this.toFloat() * scale + 0.5f
    }
