package com.example.itzel.recyclerview

import android.content.Context

import android.support.v7.widget.RecyclerView

import android.view.LayoutInflater

import android.view.View

import android.view.ViewGroup

import kotlinx.android.synthetic.main.wordlist_item.view.*

import java.util.*


class WordListAdapter(context: Context, private val wordList: LinkedList<String>) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {

        // Inflate an item view.

        val itemView = inflater.inflate(R.layout.wordlist_item, parent, false)

        return WordViewHolder(itemView)

    }



    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {

        // Retrieve the data for that position.

        val mCurrent = wordList[position]

        // Add the data to the view holder.

        holder.wordItemView.text = mCurrent

    }


override fun getItemCount(): Int{
    return wordList.size
}

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {



        val wordItemView = itemView.word



        init {

            itemView.setOnClickListener(this)

        }



        override fun onClick(v: View) {


            wordItemView.text = "Clicked! " + wordItemView.text

        }

    }

}