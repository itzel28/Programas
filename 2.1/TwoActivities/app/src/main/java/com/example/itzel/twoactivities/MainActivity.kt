package com.example.itzel.twoactivities

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val MessageEditText: EditText? = null
    private val ReplyHeadTextView: TextView? = null
    private val ReplyTextView: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")

        val intent = Intent(this, SecondActivity::class.java)
        val message = editText_main!!.text.toString()

        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                val reply = data!!.getStringExtra(SecondActivity.EXTRA_REPLY)

                text_header_reply!!.visibility = View.VISIBLE

                text_message_reply!!.text = reply
                text_message_reply!!.visibility = View.VISIBLE
            }
        }
    }
    companion object {
        private val LOG_TAG = MainActivity::class.java.simpleName
        val EXTRA_MESSAGE = "EXTRA_MESSAGE"
        var TEXT_REQUEST = 1
    }
}
