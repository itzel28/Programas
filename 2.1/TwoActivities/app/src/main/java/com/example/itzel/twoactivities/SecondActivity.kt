package com.example.itzel.twoactivities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent = intent
        var message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)

        if(savedInstanceState != null)
        {
            val reply = savedInstanceState.getString(EXTRA_REPLY)
            editText_second.setText(reply)
            message = savedInstanceState.getString(AlarmClock.EXTRA_MESSAGE)
        }
        text_message.text = message

    }

    fun returnReply(view: View) {
        val reply = editText_second.text.toString()

        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(Activity.RESULT_OK, replyIntent)
        finish()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (outState != null) {
            outState.putString(EXTRA_REPLY, editText_second.text.toString())
            outState.putString(AlarmClock.EXTRA_MESSAGE, text_message.text.toString())
        }
    }

    companion object {
        var EXTRA_REPLY = "EXTRA_REPLY"
    }
}
