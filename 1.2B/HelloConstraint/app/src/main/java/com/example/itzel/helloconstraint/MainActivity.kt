package com.example.itzel.helloconstraint

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View;
import android.widget.TextView;
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    private var mCount = 0

    private var mShowCount: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mShowCount = findViewById<View>(R.id.show_count) as TextView
    }

    fun countUp(view: View) {

        mCount++

        if (mShowCount != null)

            mShowCount!!.setText(Integer.toString(mCount))

    }

    fun showToast(view: View) {

        val duration = Toast.LENGTH_LONG


        val toast = Toast.makeText(this, R.string.toast_button_toast, duration)

        toast.show()

    }
}
