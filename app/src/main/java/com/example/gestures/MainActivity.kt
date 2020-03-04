package com.example.gestures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activity_main.setOnTouchListener{_, m: MotionEvent ->
            handleTouch(m)
            true
        }
    }

    fun cToF()
    {
        if(inputText.text.isNotEmpty()) {
            val tempValue = inputText.text.toString().toFloat()
            val celsiusValue = (tempValue * 9f / 5f ) + 32
            outPutText.text = celsiusValue.toString()
        }else{
            outPutText.text = "No Value"
        }
    }

    fun fToC()
    {
        if(inputText.text.isNotEmpty()) {
            val tempValue = inputText.text.toString().toFloat()
            val celsiusValue = (tempValue - 32f) * (5f / 9f)
            outPutText.text = celsiusValue.toString()
        }else{
            outPutText.text = "No Value"
        }
    }

    fun feetToMeter()
    {
        if(inputText.text.isNotEmpty()) {
            val tempValue = inputText.text.toString().toFloat()
            val celsiusValue = tempValue / 3.281f
            outPutText.text = celsiusValue.toString()
        }else{
            outPutText.text = "No Value"
        }
    }

    fun meterToFeet()
    {
        if(inputText.text.isNotEmpty()) {
            val tempValue = inputText.text.toString().toFloat()
            val celsiusValue = tempValue * 3.281f
            outPutText.text = celsiusValue.toString()
        }else{
            outPutText.text = "No Value"
        }
    }

    fun resetMode()
    {
        inputText.clearComposingText()
    }

    private fun handleTouch(m: MotionEvent){
        val pointerCount = m.pointerCount

        for(i in 0 until pointerCount)
        {
            val x = m.getX(i)
            val y = m.getY(i)
            val id = m.getPointerId(i)
            val action = m.actionMasked
            val actionIndex = m.actionIndex


            when(action){
                MotionEvent.ACTION_DOWN -> cToF()
                MotionEvent.ACTION_UP -> fToC()
                MotionEvent.ACTION_POINTER_DOWN -> feetToMeter()
                MotionEvent.ACTION_POINTER_UP -> meterToFeet()
                MotionEvent.ACTION_MOVE -> resetMode()
            }

        }
    }
}
