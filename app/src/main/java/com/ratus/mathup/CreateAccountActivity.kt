package com.ratus.mathup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mathup.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.analytics.FirebaseAnalytics


class CreateAccountActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var username : String
    private lateinit var email : String
    private lateinit var pword : String
    private lateinit var pwordVerif: String
    private val TAG = "MainActivity"
    private lateinit var usernameField : EditText
    private lateinit var emailField : EditText
    private lateinit var pwordField : EditText
    private lateinit var pwordVerifField : EditText
    private lateinit var completeBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {

        //TODO Add more requirements for accounts (IE: Check if username is unique, Toast for email already in use, etc)
        //TODO Add verification page?

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        auth = FirebaseAuth.getInstance()


        initUI()

        completeBtn.setOnClickListener {
            clickHandler()
        }

    }

    fun createAcc() {
        auth.createUserWithEmailAndPassword(email,pword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "createUserWithEmail:success")
                    auth.currentUser?.sendEmailVerification()
                    Toast.makeText(baseContext, "Please verify your account by clicking the link we sent to " +
                            "your email address",
                        Toast.LENGTH_SHORT).show()
                    finish()
                }
                else {
                    Log.d(TAG, "createUserWithEmail:failure")
                }
            }
        var profileUpdates = UserProfileChangeRequest.Builder().setDisplayName(username).build()
        auth.currentUser?.updateProfile(profileUpdates)
    }

    fun doPwordsMatch() : Boolean {
        return pword.equals(pwordVerif)
    }

    fun isNotEmpty() : Boolean {
        return (username != "" || email != "" || pword != "" || pwordVerif != "")
    }

    fun meetRequirements() : Boolean {
        if (isNotEmpty() && doPwordsMatch() && (username.length <= 15) && (pword.length >= 6)) {
            return true
        }
        else {
            if (!isNotEmpty()) {
                Toast.makeText(baseContext, "One or more fields are empty.",
                    Toast.LENGTH_SHORT).show()
            }
            if (!doPwordsMatch()) {
                Toast.makeText(baseContext, "Passwords do not match.",
                    Toast.LENGTH_SHORT).show()
            }
            if (username.length > 15) {
                Toast.makeText(baseContext, "Username is greater than 15 characters.",
                    Toast.LENGTH_SHORT).show()
            }
            if (pword.length < 6) {
                Toast.makeText(baseContext, "Password is less than 6 characters.",
                    Toast.LENGTH_SHORT).show()
            }
            return false
        }
    }

    fun initUI() {
        usernameField = findViewById(R.id.username) as EditText
        emailField = findViewById(R.id.email) as EditText
        pwordField = findViewById(R.id.pword) as EditText
        pwordVerifField = findViewById(R.id.pwordVerif) as EditText

        completeBtn = findViewById(R.id.signup)
    }

    fun getUIData() {
        username = usernameField.text.toString()
        email = emailField.text.toString()
        pword = pwordField.text.toString()
        pwordVerif = pwordVerifField.text.toString()
    }

    fun clickHandler() {
        getUIData()
        if (meetRequirements()) {
            createAcc()
        }
        else {
            Toast.makeText(baseContext, "Account doesn't meet requirements",
                Toast.LENGTH_SHORT).show()
        }
    }
}
