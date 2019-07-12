package com.ratus.mathup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.example.mathup.R

class MainActivity : AppCompatActivity() {
    lateinit private var mRecyclerView: androidx.recyclerview.widget.RecyclerView
    lateinit private var mAdapter: SubjectCardAdapter
    lateinit private var mLayoutManager: androidx.recyclerview.widget.RecyclerView.LayoutManager
    lateinit private var mWelcomeMessage: TextView
    lateinit private var mUsername: String
    private var mNumStars: Int = 0 //just temp init val. Gets updated by a file read

    override fun onCreate(savedInstanceState: Bundle?) {
        //TODO Setup login screen for app and integrate with firebase

        fun initCardList(): ArrayList<SubjectCard> {
            //Setting up list of subject cards. This should allow for easy scaling going forward
            val subjectCardList = ArrayList<SubjectCard>()
            subjectCardList.add(
                SubjectCard(
                    "Addition",
                    "2+2=?",
                    arrayOf("Ones", "Tens", "Mixed", "Hundreds", "Mixed")
                )
            )
            subjectCardList.add(
                SubjectCard(
                    "Subtraction",
                    "10-8=?",
                    arrayOf("Ones", "Tens", "Mixed", "Hundreds", "Mixed")
                )
            )
            subjectCardList.add(SubjectCard("Time", "11:52 P.M."))
            subjectCardList.add(
                SubjectCard(
                    "Multiplication",
                    "4*4=?",
                    arrayOf("Ones", "Tens", "Mixed", "Hundreds", "Mixed")
                )
            )
            subjectCardList.add(
                SubjectCard(
                    "Division",
                    "32/4=?",
                    arrayOf("Ones", "Tens", "Mixed", "Hundreds", "Mixed")
                )
            )
            return subjectCardList
        }

        fun mainActivityView() {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            //function for creating main activity View
            var subjectCardList = initCardList() //list of subject cards

            //setting up recyclerView and adding cards
            mRecyclerView = findViewById(R.id.recyclerView)
            mRecyclerView.setHasFixedSize(false)
            mLayoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
            mAdapter = SubjectCardAdapter(subjectCardList, this)

            mRecyclerView.layoutManager = mLayoutManager
            mRecyclerView.adapter = mAdapter

            mNumStars = 25 //temp while working on app
            mUsername = "Ryan" //initializing this temporarily while working on app. Will switch to a file read
            mWelcomeMessage = findViewById(R.id.welcome_message)
            mWelcomeMessage.setText("Hello " + mUsername + ". So far you have " + mNumStars + "⭐️s! Let's keep going!")
        }

        fun loginActivityView() {
            var intent: Intent = Intent(this, LoginScreenActivity::class.java)
            startActivity(intent)
        }

        //TODO build lambda for this var
        var loggedIn = true


        if (loggedIn) {
            mainActivityView()
        }
        else {
            loginActivityView()
        }

    }
}
