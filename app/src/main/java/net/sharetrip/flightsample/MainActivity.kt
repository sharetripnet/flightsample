package net.sharetrip.flightsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.sharetrip.flight.booking.FlightBookingActivity
import net.sharetrip.flight.booking.STPartnerUserTokenValidationListener
import net.sharetrip.flight.history.FlightHistoryActivity

class MainActivity : AppCompatActivity(), STPartnerUserTokenValidationListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FlightBookingActivity.openFlightSearchService(this, "MyBl", "$2b$10$" + "G2h6ar4IHF2BdSuL6YdlR.a2RK/U4Ygcoof2oc0XZM52xf5DO387G", this)
        //FlightHistoryActivity.openFlightHistoryService(this, "MyBl", "my_bl_user_token")
    }

    override fun response(isValid: Boolean, token: String) {
        if (!isValid)
            FlightBookingActivity.updateUserToken(this, "valid_token")
    }
}
