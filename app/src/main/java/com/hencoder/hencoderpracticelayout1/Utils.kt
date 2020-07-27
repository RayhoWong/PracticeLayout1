package com.hencoder.hencoderpracticelayout1

import android.content.res.Resources

object Utils {
    fun dpToPixel(dp: Float): Float {
        val metrics = Resources.getSystem().displayMetrics
        return dp * metrics.density
    }
}