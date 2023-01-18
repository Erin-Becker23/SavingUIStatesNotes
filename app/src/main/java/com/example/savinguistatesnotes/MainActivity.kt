package com.example.savinguistatesnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var numDisplay: TextView

    var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        numDisplay = findViewById(R.id.text_value)


        numDisplay.text = num.toString()

        button.setOnClickListener{
            num++
            numDisplay.text = num.toString()
        }




    }



    //saves UI state | saves numbers displayed
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("Saved_number", numDisplay.text.toString())
        outState.putInt("Current_value", num)
    }
    //gives us saved numbers
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        numDisplay.text = savedInstanceState.getString("Saved_number") //needs to be Saved_number bc that is what it is paired w/ and what saves
        num = savedInstanceState.getInt("Current_value") //saves so that it continues counting on diff UI
    }

}