package com.example.tipcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tipcalculator.databinding.ActivityChooseOptionBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log
import android.widget.Toast



class ChooseOptionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooseOptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Call the fetchCars function when appropriate, e.g., after the activity is created
        fetchCars()
    }

    fun launchSecondActivity(view: View) {
        // If validation is successful, navigate to the second activity
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
    fun launchBookingListActivity(view: View) {
        // If validation is successful, navigate to the second activity
        val intent = Intent(this, BookingListActivity::class.java)
        startActivity(intent)
    }

    private fun fetchCars() {
        val apiService = ApiClient.retrofit.create(MyApiService::class.java)
        val call = apiService.getAllCars()

        call.enqueue(object : Callback<List<Car>> {
            override fun onResponse(call: Call<List<Car>>, response: Response<List<Car>>) {
                if (response.isSuccessful) {
                    // Handle successful response
                    val cars = response.body()

                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<List<Car>>, t: Throwable) {
                // Log the error for debugging purposes
                Log.e("ChooseOptionActivity", "Error fetching cars", t)

                // Display a Toast with an error message
                Toast.makeText(this@ChooseOptionActivity, "Error fetching cars. Please try again later.", Toast.LENGTH_LONG).show()
            }
        })
    }
}

