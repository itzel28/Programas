package com.example.itzel.implicitintents

import android.content.Intent

import android.net.Uri

import android.support.v4.app.ShareCompat

import android.support.v7.app.AppCompatActivity

import android.os.Bundle

import android.util.Log

import android.view.View

import android.widget.EditText


class MainActivity : AppCompatActivity() {

    private var mWebsiteEditText: EditText? = null
    private var mLocationEditText: EditText? = null
    private var mShareTextEditText: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        mWebsiteEditText = findViewById<View>(R.id.website_edittext) as EditText

        mLocationEditText = findViewById<View>(R.id.location_editext) as EditText

        mShareTextEditText = findViewById<View>(R.id.share_edittext) as EditText

    }


    fun openWebsite(view: View) {

        val url = mWebsiteEditText!!.text.toString()

        val webpage = Uri.parse(url)

        val intent = Intent(Intent.ACTION_VIEW, webpage)

        if (intent.resolveActivity(packageManager) != null) {

            startActivity(intent)

        } else {

            Log.d("ImplicitIntents", "Can't handle this intent!")

        }

    }


    fun openLocation(view: View) {

        val loc = mLocationEditText!!.text.toString()

        val addressUri = Uri.parse("geo:0,0?q=$loc")

        val intent = Intent(Intent.ACTION_VIEW, addressUri)

        if (intent.resolveActivity(packageManager) != null) {

            startActivity(intent)

        } else {

            Log.d("ImplicitIntents", "Can't handle this intent!")

        }

    }


    fun shareText(view: View) {

        val txt = mShareTextEditText!!.text.toString()

        ShareCompat.IntentBuilder

                .from(this)

                .setType("text/plain")

                .setChooserTitle("Share this text with: ")

                .setText(txt)

                .startChooser()

    }

}