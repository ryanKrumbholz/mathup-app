package com.example.mathup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit private var mRecyclerView: RecyclerView
    lateinit private var mAdapter: subjectCardAdapter
    lateinit private var mLayoutManager: RecyclerView.LayoutManager
    lateinit private var mText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun initCardList(): ArrayList<subjectCard> {
            val exampleCardList = ArrayList<subjectCard>()
            exampleCardList.add(subjectCard("Addition", "2+2=?"))
            exampleCardList.add(subjectCard("Subtraction", "10-8=?"))
            exampleCardList.add(subjectCard("Time", "11:52 P.M."))
            return exampleCardList
        }

        fun MainActivity.test() {return}


        fun createView() {
            var exampleCardList = initCardList()

            mRecyclerView = findViewById(R.id.recyclerView)
            mRecyclerView.setHasFixedSize(true)
            mLayoutManager = LinearLayoutManager(this)
            mAdapter = subjectCardAdapter(exampleCardList, this)

            mRecyclerView.layoutManager = mLayoutManager
            mRecyclerView.adapter = mAdapter

            mText = findViewById(R.id.welcome_message)
            mText.setText("Hello Ryan! So far you have 25 ⭐️ stars! Let's keep going!")
        }



        createView()

    }
}
