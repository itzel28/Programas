package com.example.itzel.droidcafe2

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

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


    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.action_order -> {

                displayToast(getString(R.string.action_order_message))

                return true

            }

            R.id.action_status -> {

                displayToast(getString(R.string.action_status_message))

                return true

            }

            R.id.action_favorites -> {

                displayToast(getString(R.string.action_favorites_message))

                return true

            }

            R.id.action_contact -> {

                displayToast(getString(R.string.action_contact_message))

                return true

            }

        }

        return super.onOptionsItemSelected(item)

    }


    fun showDonutOrder(view: View) {

        showFoodOrder(getString(R.string.donut_order_message))

    }


    fun showIceCreamOrder(view: View) {

        showFoodOrder(getString(R.string.ice_cream_order_message))

    }


    fun showFroyoOrder(view: View) {

        showFoodOrder(getString(R.string.froyo_order_message))

    }


    fun showFoodOrder(message: String) {

        Toast.makeText(applicationContext, message,

                Toast.LENGTH_SHORT).show()

        val intent = Intent(this, OrderActivity::class.java)

        startActivity(intent)

    }



    fun displayToast(message: String) {

        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()

    }



}