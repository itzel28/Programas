package com.example.itzel.twoactivitieslifecycle

import android.app.Activity

import android.content.Intent

import android.support.v7.app.AppCompatActivity

import android.os.Bundle

import android.util.Log

import android.view.View

import android.widget.EditText

import android.widget.TextView


class SecondActivity : AppCompatActivity() {

    private var mReply: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)

        mReply = findViewById<View>(R.id.editText_second) as EditText

        val intent = intent

        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)

        val textView = findViewById<View>(R.id.text_message) as TextView

        if (textView != null) {

            textView.text = message

        }



        Log.d(LOG_TAG, "-------")

        Log.d(LOG_TAG, "onCreate")

    }

    fun returnReply(view: View) {

        // Get the reply message from the edit text.

        val reply = mReply!!.text.toString()

        val replyIntent = Intent()

        replyIntent.putExtra(EXTRA_REPLY, reply)

        setResult(Activity.RESULT_OK, replyIntent)



        Log.d(LOG_TAG, "End SecondaryActivity")



        finish()

    }

    override fun onStart() {

        super.onStart()

        Log.d(LOG_TAG, "onStart")

    }

    public override fun onRestart() {

        super.onRestart()

        Log.d(LOG_TAG, "onRestart")

    }

    public override fun onResume() {

        super.onResume()

        Log.d(LOG_TAG, "onResume")

    }


    public override fun onPause() {

        super.onPause()

        Log.d(LOG_TAG, "onPause")

    }


    public override fun onStop() {

        super.onStop()

        Log.d(LOG_TAG, "onStop")

    }


    public override fun onDestroy() {

        super.onDestroy()

        Log.d(LOG_TAG, "onDestroy")

    }



    companion object {


        val EXTRA_REPLY = "com.example.android.twoactivitieslifecycle.extra.REPLY"

        private val LOG_TAG = SecondActivity::class.java.simpleName

    }

}