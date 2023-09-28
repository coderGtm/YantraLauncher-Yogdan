package com.coderGtm.ylTester

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator

fun getOutputColor(clr: String): Int {
    return Color.parseColor(clr)
}
fun vibrate(millis: Long? = 100, context: Context) {
    if (millis == null) {
        throw RuntimeException("Invalid usage. 'vibe' command takes only 1 argument: time to vibrate in milliseconds.")
        return
    }
    val v = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        v.vibrate(VibrationEffect.createOneShot(millis, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
        v.vibrate(millis)
    }
}