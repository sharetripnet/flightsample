package net.sharetrip.flightsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.sharetrip.flight.booking.FlightBookingActivity
import net.sharetrip.flight.history.FlightHistoryActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FlightBookingActivity.openFlightSearchService(this, "MyBl", "my_bl_user_token")
        FlightHistoryActivity.openFlightHistoryService(this, "MyBl", "my_bl_user_token")
    }
}
