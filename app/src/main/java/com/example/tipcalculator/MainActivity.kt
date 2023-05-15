package com.example.tipcalculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private  val LOG_TAG = MainActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    private fun validateUserInput(username: String, password: String): Boolean {
        if(username=="khalil" && password=="1234" ){
            return true
        }
        return username.isNotEmpty() && password.isNotEmpty()
    }

    fun launchChooseOptionActivity(view: View) {
        val usernameEditText = findViewById<EditText>(R.id.editTextUsername)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)

        val username = usernameEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        if (validateUserInput(username, password)) {
            // If validation is successful, navigate to the second activity
            val intent = Intent(this, ChooseOptionActivity::class.java)
            startActivity(intent)
        } else {
            // Show an error message if the input is not valid
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
        }
    }


}