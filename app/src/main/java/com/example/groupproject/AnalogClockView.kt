package com.example.groupproject


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import java.util.*
import kotlin.math.cos
import kotlin.math.sin


class AnalogClockView(context: Context, attrs: AttributeSet) : View(context, attrs) {


    private val paint = Paint()
    private val paintHand= Paint()
    private val calendar = Calendar.getInstance()
    private var timeDisplay: TextView? = null


    init {
        paint.color = Color.BLACK
        paintHand.color=Color.WHITE
        paint.strokeWidth = 5f
        paint.isAntiAlias = true
    }


    companion object{
        var daytime = false
        var evening = false
    }


    fun setTimeDisplay(textView: TextView) {
        timeDisplay = textView
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        calendar.timeInMillis = System.currentTimeMillis()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val second = calendar.get(Calendar.SECOND)
        if (hour<16) {
            daytime= true

        } else {
            evening= true
        }


        timeDisplay?.text = String.format("%02d:%02d:%02d", hour, minute, second)

        val centerX = width / 2f
        val centerY = height / 2f
        val radius = Math.min(centerX, centerY) - 20f


        canvas.drawCircle(centerX, centerY, radius, paint)

        drawHand(canvas, centerX, centerY, (hour + minute / 60f) * 30f, radius * 0.5f)
        drawHand(canvas, centerX, centerY, minute * 6f, radius * 0.7f)
        drawHand(canvas, centerX, centerY, second * 6f, radius * 0.9f)

        paint.textSize = 40f
        paint.textAlign = Paint.Align.CENTER
        for (i in 1..12) {
            val numberX = centerX + radius * 0.85f * sin(Math.toRadians((i * 30).toDouble())).toFloat()
            val numberY = centerY - radius * 0.85f * cos(Math.toRadians((i * 30).toDouble())).toFloat()
            canvas.drawText(i.toString(), numberX, numberY + paint.textSize / 3, paint)
        }

        postInvalidateDelayed(1000)
    }


    private fun drawHand(canvas: Canvas, cx: Float, cy: Float, angle: Float, length: Float) {
        val radians = Math.toRadians(angle.toDouble())
        val startX = cx + length * sin(radians).toFloat()
        val startY = cy - length * cos(radians).toFloat()
        canvas.drawLine(cx, cy, startX, startY, paintHand)
    }
}

