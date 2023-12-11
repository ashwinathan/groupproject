package com.example.groupproject


import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View


class DrawingView(context: Context, attrs: AttributeSet) : View(context, attrs) {


    private var bitmap1: Bitmap? = null
    private var bitmap2: Bitmap? = null
    private var bitmap3: Bitmap? = null


    init {
        bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.red_train)
        bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.green_train)
        bitmap3 = BitmapFactory.decodeResource(resources, R.drawable.yellow_train)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawBitmap(bitmap1!!, 50f, 1000f, null)
        canvas.drawBitmap(bitmap2!!, 400f, 1000f, null)
        canvas.drawBitmap(bitmap3!!, 750f, 1000f, null)
    }
}

