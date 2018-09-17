package com.example.itzel.twoactivitieslifecycle

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private var mMessageEditText: EditText? = null


    private var mReplyHeadTextView: TextView? = null


    private var mReplyTextView: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



        Log.d(LOG_TAG, "-------")

        Log.d(LOG_TAG, "onCreate")


        mMessageEditText = findViewById<View>(R.id.editText_main) as EditText

        mReplyHeadTextView = findViewById<View>(R.id.text_header_reply) as TextView

        mReplyTextView = findViewById<View>(R.id.text_message_reply) as TextView


        if (savedInstanceState != null) {

            val isVisible = savedInstanceState.getBoolean("reply_visible")


            if (isVisible) {

                mReplyHeadTextView!!.visibility = View.VISIBLE



                mReplyTextView!!.text = savedInstanceState.getString("reply_text")

                mReplyTextView!!.visibility = View.VISIBLE

            }

        }

    }

    fun launchSecondActivity(view: View) {

        Log.d(LOG_TAG, "Button clicked!")



        val intent = Intent(this, SecondActivity::class.java)

        val message = mMessageEditText!!.text.toString()



        intent.putExtra(EXTRA_MESSAGE, message)

        startActivityForResult(intent, TEXT_REQUEST)

    }


    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)



        if (requestCode == TEXT_REQUEST) {

            if (resultCode == Activity.RESULT_OK) {

                val reply = data!!.getStringExtra(SecondActivity.EXTRA_REPLY)

                mReplyHeadTextView!!.visibility = View.VISIBLE

                mReplyTextView!!.text = reply

                mReplyTextView!!.visibility = View.VISIBLE

            }

        }

    }


    override fun onStart() {

        super.onStart()

        Log.d(LOG_TAG, "onStart")

    }



    /**

     * Lifecycle callback for restart.

     */

    public override fun onRestart() {

        super.onRestart()

        Log.d(LOG_TAG, "onRestart")

    }



    /**

     * Lifecycle callback for resume.

     */

    public override fun onResume() {

        super.onResume()

        Log.d(LOG_TAG, "onResume")

    }



    /**

     * Lifecycle callback for pause.

     */

    public override fun onPause() {

        super.onPause()

        Log.d(LOG_TAG, "onPause")

    }



    /**

     * Lifecycle callback for stop.

     */

    public override fun onStop() {

        super.onStop()

        Log.d(LOG_TAG, "onStop")

    }



    /**

     * Lifecycle callback for destroy.

     */

    public override fun onDestroy() {

        super.onDestroy()

        Log.d(LOG_TAG, "onDestroy")

    }



    /**

     * Save the instance state if the activity is restarted (for example, on device rotation.)

     * Here you save the contents of the reply text, and whether the reply is visible.

     *

     * @param outState The state data.

     */

    override fun onSaveInstanceState(outState: Bundle?) {

        super.onSaveInstanceState(outState)



        // If the heading is visible, we have a message that needs to be saved.

        // Otherwise we're still using default layout.

        if (mReplyHeadTextView!!.visibility == View.VISIBLE) {

            outState!!.putBoolean("reply_visible", true)

            outState.putString("reply_text", mReplyTextView!!.text.toString())

        }



    }



    companion object {

        // Class name for Log tag

        private val LOG_TAG = MainActivity::class.java.simpleName

        // Unique tag required for the intent extra

        val EXTRA_MESSAGE = "com.example.android.twoactivitieslifecycle.extra.MESSAGE"

        // Unique tag for the intent reply

        val TEXT_REQUEST = 1

    }

}