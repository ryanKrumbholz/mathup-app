package com.ratus.mathup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mathup.R
import com.google.firebase.auth.FirebaseAuth

class LoginScreenActivity: AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var email : String
    private lateinit var pword : String
    private lateinit var loginBtn : Button
    private lateinit var sighBtn : Button
    private val TAG = "MainActivity"
    private lateinit var emailField : EditText
    private lateinit var pwordField : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_acitivty)

        auth = FirebaseAuth.getInstance()
    }

    public override fun onStart() {

        super.onStart()
        val currentUser = auth.currentUser
        initUI()

        loginBtn.setOnClickListener {
            getUIData()
        }

        sighBtn.setOnClickListener {
            createAccount()
        }

        if (currentUser != null) {
            mainActivity()
        }

    }

    fun passwordSignIn(email : String, password : String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "passwordSignIn:success")
                    mainActivity()
                }
                else {
                    Log.d(TAG, "passwordSignIn:failed")
                    Toast.makeText(baseContext, "Incorrect Username/Password.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun mainActivity() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun createAccount() {
        var intent = Intent(this, CreateAccountActivity::class.java)
        startActivity(intent)
    }

    fun initUI() {
        loginBtn = findViewById(R.id.login)
        sighBtn = findViewById(R.id.signup)
        emailField = findViewById(R.id.email) as EditText
        pwordField = findViewById(R.id.pword) as EditText
    }

    fun getUIData() {
        email = emailField.text.toString()
        pword = pwordField.text.toString()
        if (email == "" || pword == "") {
            passwordSignIn("null", "null")
        }
        else {
            passwordSignIn(email, pword)
        }
    }

}
