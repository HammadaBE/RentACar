package com.example.tipcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bmwButton: ImageButton = findViewById(R.id.imageButtonBMW)
        val mercedesCButton: ImageButton = findViewById(R.id.imageButtonMercedesC)
        val daciaLoganButton: ImageButton = findViewById(R.id.imageButtonDaciaLogan)
        val daciaDusterButton: ImageButton = findViewById(R.id.imageButtonDaciaDuster)


        bmwButton.setOnClickListener {
            val carTitle = "BMW series 3"
            val dailyPrice = 40.0 // Replace with the daily price for this car

            val intent = Intent(this, CarDetailsActivity::class.java).apply {
                putExtra("car_title", carTitle)
                putExtra("daily_price", dailyPrice)
            }
            startActivity(intent)
        }

        mercedesCButton.setOnClickListener {
            val carTitle = "Mercedes Class C"
            val dailyPrice = 40.0 // Replace with the daily price for this car

            val intent = Intent(this, CarDetailsActivity::class.java).apply {
                putExtra("car_title", carTitle)
                putExtra("daily_price", dailyPrice)
            }
            startActivity(intent)
        }

        daciaLoganButton.setOnClickListener {
            val carTitle = "Dacia Logan"
            val dailyPrice = 20.0 // Replace with the daily price for this car

            val intent = Intent(this, CarDetailsActivity::class.java).apply {
                putExtra("car_title", carTitle)
                putExtra("daily_price", dailyPrice)
            }
            startActivity(intent)
        }

        daciaDusterButton.setOnClickListener {
            val carTitle = "Dacia Duster"
            val dailyPrice = 30.0 // Replace with the daily price for this car

            val intent = Intent(this, CarDetailsActivity::class.java).apply {
                putExtra("car_title", carTitle)
                putExtra("daily_price", dailyPrice)
            }
            startActivity(intent)
        }
    }
}
