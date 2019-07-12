package com.ratus.mathup

import android.content.Intent
import android.os.Bundle
import android.util.Log
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_acitivty)

        auth = FirebaseAuth.getInstance()

        //Todo build rest of login class
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
//            switchActivity()
        }
        else {
//            passwordSignIn(email,pword)
        }

    }


    fun passwordSignIn(email : String, password : String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
//                    Log.d(TAG, "passwordSignIn:success")
                    val user = auth.currentUser
                    switchActivity()
                }
                else {
                    Toast.makeText(baseContext, "Incorrect Username or Password.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun switchActivity() {
        var intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}
