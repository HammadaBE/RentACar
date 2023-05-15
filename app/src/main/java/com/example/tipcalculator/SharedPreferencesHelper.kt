package com.example.tipcalculator

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class SharedPreferencesHelper(context: Context) {
    private val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun saveBooking(booking: String) {
        val bookings = getBookings().toMutableSet()
        bookings.add(booking)

        with(sharedPreferences.edit()) {
            putStringSet("bookings", bookings)
            apply()
        }
    }

    fun getBookings(): Set<String> {
        return sharedPreferences.getStringSet("bookings", emptySet()) ?: emptySet()
    }

    fun removeBooking(booking: String) {
        val bookings = getBookings().toMutableSet()
        bookings.remove(booking)

        with(sharedPreferences.edit()) {
            putStringSet("bookings", bookings)
            apply()
        }
    }
}
