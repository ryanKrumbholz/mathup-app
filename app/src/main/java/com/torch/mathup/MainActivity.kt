package com.torch.mathup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.mathup.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.random.Random



class MainActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    lateinit private var recyclerView: androidx.recyclerview.widget.RecyclerView
    lateinit private var adapter: SubjectCardAdapter
    lateinit private var layoutManager: androidx.recyclerview.widget.RecyclerView.LayoutManager
    lateinit private var welcomeMessage: TextView
    private val database = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        database = FirebaseFirestore.getInstance()

        //TODO Get rid of TOAST color

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

        fun setupRecyclerView() {
            var subjectCardList = initCardList() //list of subject cards

            //setting up recyclerView and adding cards
            recyclerView = findViewById(R.id.recyclerView)
            recyclerView.setHasFixedSize(false)
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
            adapter = SubjectCardAdapter(subjectCardList, this)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter
        }

        fun makeWelcomeMessage() {
            //TODO Fix database read numStars read and username read

            welcomeMessage = findViewById(R.id.welcome_message)
            auth = FirebaseAuth.getInstance()

            var user = auth.currentUser
            val username = user?.displayName
            var numStars = 999

//            val docref = database.collection("users")
//                .document(username.toString())
//            docref.get().addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                   numStars = task.result?.get("num_stars").toString()
//
//                } else {
//                    task.exception
//
//                }
//            }

            welcomeMessage.setText("Hello " + username + ". So far you have " + numStars + "⭐️ stars! Let's keep going!")
        }

        fun mainActivityView() {
            setupRecyclerView()
            makeWelcomeMessage()
        }

        mainActivityView()

    }
}
