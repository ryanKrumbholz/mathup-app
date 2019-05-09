package com.example.mathup

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Adapter
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit private var mRecyclerView: RecyclerView
    lateinit private var mAdapter: ExampleAdapter
    lateinit private var mLayoutManager: RecyclerView.LayoutManager
    lateinit private var mText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun initCardList(): ArrayList<ExampleCard> {
            val exampleCardList = ArrayList<ExampleCard>()
            exampleCardList.add(ExampleCard("Addition", "2+2=?"))
            exampleCardList.add(ExampleCard("Subtraction", "10-8=?"))
            exampleCardList.add(ExampleCard("Time", "11:52 P.M."))
            return exampleCardList
        }

        fun MainActivity.test() {return}


        fun createView() {
            var exampleCardList = initCardList()

            mRecyclerView = findViewById(R.id.recyclerView)
            mRecyclerView.setHasFixedSize(true)
            mLayoutManager = LinearLayoutManager(this)
            mAdapter = ExampleAdapter(exampleCardList, this)

            mRecyclerView.layoutManager = mLayoutManager
            mRecyclerView.adapter = mAdapter

            mText = findViewById(R.id.welcome_message)
            mText.setText("Hello Ryan! So far you have 25 ⭐️ stars! Let's keep going!")
        }



        createView()

    }
}
