package com.hencoder.hencoderpracticelayout1.common

import android.content.Context
import android.support.v7.widget.AppCompatSeekBar
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import com.hencoder.hencoderpracticelayout1.R
import com.hencoder.hencoderpracticelayout1.Utils

/**
 * 这个类是用来做 ImageView 外部的可调整框架的，不必关注
 */
class Common01AdjustablePanel : RelativeLayout {
    var parentLayout: FrameLayout? = null
    var heightBar: AppCompatSeekBar? = null
    var widthBar: AppCompatSeekBar? = null
    var bottomMargin: Float = Utils.dpToPixel(48f)
    var minWidth: Float = Utils.dpToPixel(80f)
    var minHeight: Float = Utils.dpToPixel(100f)

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        parentLayout = findViewById(R.id.parentLayout)
        widthBar = findViewById(R.id.widthBar)
        heightBar = findViewById(R.id.heightBar)
        val listener: OnSeekBarChangeListener = object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, percent: Int, b: Boolean) {
                val layoutParams = parentLayout!!.getLayoutParams() as LayoutParams
                layoutParams.width = (minWidth + (this@Common01AdjustablePanel.width
                        - minWidth) * widthBar!!.getProgress() / 100).toInt()
                layoutParams.height = (minHeight + (this@Common01AdjustablePanel.height
                        - bottomMargin - minHeight) * heightBar!!.getProgress() / 100).toInt()
                parentLayout!!.setLayoutParams(layoutParams)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        }
        widthBar!!.setOnSeekBarChangeListener(listener)
        heightBar!!.setOnSeekBarChangeListener(listener)
    }
}