package com.hencoder.hencoderpracticelayout1.sample

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

class Sample01SquareImageView : android.support.v7.widget.AppCompatImageView {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var measuredWidth = measuredWidth
        var measuredHeight = measuredHeight
        if (measuredWidth > measuredHeight) {
            measuredWidth = measuredHeight
        } else {
            measuredHeight = measuredWidth
        }
        setMeasuredDimension(measuredWidth, measuredHeight)
    }
}