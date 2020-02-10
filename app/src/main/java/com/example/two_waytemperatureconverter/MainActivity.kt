package com.example.two_waytemperatureconverter

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    fun convertTemperature(view: View)
    {
        if(inPutText.text.isNotEmpty()) {
            val tempValue = inPutText.text.toString().toFloat()
            val celsiusValue = (tempValue - 32f) * (5f / 9f)
            CtextView.text = celsiusValue.toString()
        }else{
            CtextView.text = getString(R.string.no_value_string)
        }
    }

    fun convertTemperature2(view: View)
    {
        if(inPutText.text.isNotEmpty()) {
            val tempValue = inPutText.text.toString().toFloat()
            val FValue = (tempValue * (9f / 5f))+ 32f
            CtextView.text = FValue.toString()
        }else{
            CtextView.text = getString(R.string.no_value_string)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        val userText = inPutText.text
        outState?.putCharSequence("savedText", userText)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        val userText = savedInstanceState?.getCharSequence("savedText")
        inPutText.setText(userText)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
