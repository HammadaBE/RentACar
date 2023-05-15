package com.example.tipcalculator



import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView

class BookingListAdapter(
    private val sharedPreferencesHelper: SharedPreferencesHelper,
    context: Context,
    bookings: ArrayList<String>
) : ArrayAdapter<String>(context, 0, bookings) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val booking = getItem(position) ?: ""


        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_booking, parent, false)

        val tvBooking = view.findViewById<TextView>(R.id.tv_booking)
        val btnRemoveBooking = view.findViewById<Button>(R.id.btn_remove_booking)

        tvBooking.text = booking

        btnRemoveBooking.setOnClickListener {
            sharedPreferencesHelper.removeBooking(booking)
            remove(booking)
        }

        return view
    }
}

