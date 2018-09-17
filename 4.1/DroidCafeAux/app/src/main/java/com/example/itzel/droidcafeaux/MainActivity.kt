package com.example.itzel.droidcafeaux


import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*



/**

 * This app shows images used as buttons to launch a second activity

 * and displays a Toast message showing the delivery method chosen

 * for a Droid Cafe food order. It also shows how to set up

 * the options menu and floating action button.

 */

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


        val id = item.itemId

        return if (id == R.id.action_settings) {

            true

        } else super.onOptionsItemSelected(item)

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

}