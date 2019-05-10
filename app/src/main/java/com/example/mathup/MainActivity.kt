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
    lateinit private var mWelcomeMessage: TextView
    lateinit private var mUsername: String
    private var mNumStars: Int = 0 //just temp init val. Gets updated by a file read

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun initCardList(): ArrayList<subjectCard> {
            //Setting up list of subject cards. This should allow for easy scaling going forward
            val subjectCardList = ArrayList<subjectCard>()
            subjectCardList.add(subjectCard("Addition", "2+2=?"))
            subjectCardList.add(subjectCard("Subtraction", "10-8=?"))
//            subjectCardList.add(subjectCard("Shapes", "Circle"))
            subjectCardList.add(subjectCard("Time", "11:52 P.M."))
            return subjectCardList
        }

        fun mainActivityView() {
            //function for creating main activity View
            var subjectCardList = initCardList() //list of subject cards

            //setting up recyclerView and adding cards
            mRecyclerView = findViewById(R.id.recyclerView)
            mRecyclerView.setHasFixedSize(false)
            mLayoutManager = LinearLayoutManager(this)
            mAdapter = subjectCardAdapter(subjectCardList, this)

            mRecyclerView.layoutManager = mLayoutManager
            mRecyclerView.adapter = mAdapter

            mNumStars = 25 //temp while working on app
            mUsername = "Ryan" //initializing this temporarily while working on app. Will switch to a file read
            mWelcomeMessage = findViewById(R.id.welcome_message)
            mWelcomeMessage.setText("Hello " + mUsername + ". So far you have " + mNumStars + "⭐️s! Let's keep going!")
        }

        fun firstBootView() {} //Setup later for to setup first boot view

        //TODO if statement determining whether or not this is the first time the app is starting up

        mainActivityView()

    }
}
