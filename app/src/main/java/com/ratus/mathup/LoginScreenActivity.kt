package com.ratus.mathup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mathup.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginScreenActivity: AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private var userStatus : Boolean = false
    private lateinit var email : String
    private lateinit var pword : String
    private lateinit var loginBtn : Button
    private lateinit var sighBtn : Button
    private val TAG = "MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_acitivty)

        auth = FirebaseAuth.getInstance()

        //Todo build rest of login class
    }

    public override fun onStart() {

        super.onStart()
        val currentUser = auth.currentUser

        loginBtn = findViewById(R.id.login)
        sighBtn = findViewById(R.id.signup)

        loginBtn.setOnClickListener {
            email = findViewById<EditText>(R.id.username).text.toString()
            pword = findViewById<EditText>(R.id.pword).text.toString()
            passwordSignIn(email, pword)
        }
        sighBtn.setOnClickListener { createAccount() }

        if (currentUser != null) {
            mainActivity()
        }
        else {
            passwordSignIn(email, pword)
        }

    }


    fun passwordSignIn(email : String, password : String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "passwordSignIn:success")
                    val user = auth.currentUser
                    mainActivity()
                }
                else {
                    Log.d(TAG, "passwordSignIn:failed")
                    Toast.makeText(baseContext, "Incorrect Username or Password.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun mainActivity() {
    }

    fun createAccount() {

    }


}
