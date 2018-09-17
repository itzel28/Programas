package com.example.itzel.recyclerview

import android.os.Bundle

import android.support.design.widget.FloatingActionButton

import android.support.v7.app.AppCompatActivity

import android.support.v7.widget.LinearLayoutManager

import android.view.View

import kotlinx.android.synthetic.main.activity_main.*

import java.util.*




class MainActivity : AppCompatActivity() {



    private var wordListAdapter: WordListAdapter? = null

    private val wordList = LinkedList<String>()



    public override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        for (i in 0..19) {

            wordList.addLast("Word " + i)

        }



        // Create an wordListAdapter and supply the data to be displayed.

        wordListAdapter = WordListAdapter(this, wordList)

        // Connect the wordListAdapter with the recycler view.

        recyclerview!!.adapter = wordListAdapter

        // Give the recycler view a default layout manager.

        recyclerview!!.layoutManager = LinearLayoutManager(this)



        // Add a floating action click handler for creating new entries.

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton

        fab.setOnClickListener {

            val wordListSize = wordList.size

            // Add a new word to the wordList.

            wordList.addLast("+ Word " + wordListSize)

            // Notify the wordListAdapter, that the data has changed.

            recyclerview!!.adapter.notifyItemInserted(wordListSize)

            // Scroll to the bottom.

            recyclerview!!.smoothScrollToPosition(wordListSize)

        }

    }

}