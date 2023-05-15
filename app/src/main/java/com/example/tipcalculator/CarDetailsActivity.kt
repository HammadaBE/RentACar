package com.example.tipcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.concurrent.TimeUnit

class CarDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_details)

        val tvCarTitle: TextView = findViewById(R.id.tv_car_title)
        val tvDailyPrice: TextView = findViewById(R.id.tv_daily_price)
        val tvStartDate: TextView = findViewById(R.id.tv_start_date)
        val tvEndDate: TextView = findViewById(R.id.tv_end_date)
        val btnCalculate: Button = findViewById(R.id.btn_calculate)
        val tvTotalAmount: TextView = findViewById(R.id.tv_total_amount)
        val btnSave: Button = findViewById(R.id.btn_save)
        var days =0
        lateinit var sharedPreferencesHelper: SharedPreferencesHelper

        // Get data from the previous activity
        val carTitle = intent.getStringExtra("car_title")
        val dailyPrice = intent.getDoubleExtra("daily_price", 0.0)

        tvCarTitle.text = carTitle
        tvDailyPrice.text = "Daily Price: $${dailyPrice}"

        val builder = MaterialDatePicker.Builder.dateRangePicker()
        builder.setTitleText("Select a date range")
        val picker = builder.build()

        sharedPreferencesHelper = SharedPreferencesHelper(this)

        tvStartDate.setOnClickListener {
            picker.show(supportFragmentManager, picker.toString())
        }

        tvEndDate.setOnClickListener {
            picker.show(supportFragmentManager, picker.toString())
        }

        picker.addOnPositiveButtonClickListener { dateRange ->
            val startDate = LocalDate.ofEpochDay(TimeUnit.MILLISECONDS.toDays(dateRange.first))
            val endDate = LocalDate.ofEpochDay(TimeUnit.MILLISECONDS.toDays(dateRange.second))
            tvStartDate.text = startDate.toString()
            tvEndDate.text = endDate.toString()
        }

        btnCalculate.setOnClickListener {
            val startDateString = tvStartDate.text.toString()
            val endDateString = tvEndDate.text.toString()

            if (startDateString.isNotEmpty() && endDateString.isNotEmpty()) {
                val startDate = LocalDate.parse(startDateString)
                val endDate = LocalDate.parse(endDateString)

                // Calculate the number of days between the start and end dates
                days = ChronoUnit.DAYS.between(startDate, endDate).toInt()

                // Calculate the total amount based on the number of days and daily price
                val totalAmount = days * dailyPrice
                tvTotalAmount.text = "Total Amount: $${totalAmount}"
            }
        }

        btnSave.setOnClickListener {
            val bookingDetails = "Car: ${tvCarTitle.text}, Days: ${days}, Total Amount: ${tvTotalAmount.text}"
            sharedPreferencesHelper.saveBooking(bookingDetails)

            // Start BookingListActivity
            val intent = Intent(this, BookingListActivity::class.java)
            startActivity(intent)
        }

    }
}
