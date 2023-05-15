package com.example.tipcalculator


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class BookingListActivity : AppCompatActivity() {
    private lateinit var lvBookings: ListView
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    private lateinit var adapter: BookingListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_list)

        lvBookings = findViewById(R.id.lv_bookings)
        sharedPreferencesHelper = SharedPreferencesHelper(this)

        // Retrieve the saved booking details (e.g., using SharedPreferences or a local database)
        val bookingList = sharedPreferencesHelper.getBookings().toList()

        // Set up the BookingListAdapter for the ListView
        adapter = BookingListAdapter(sharedPreferencesHelper, this, ArrayList(bookingList))
        lvBookings.adapter = adapter

        val btnBack: Button = findViewById(R.id.btn_back)
        btnBack.setOnClickListener {
            val intent = Intent(this, ChooseOptionActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
