package net.sharetrip.flightsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.sharetrip.flight.FlightHomeActivity
import net.sharetrip.flight.STPartnerUserTokenValidationListener

class MainActivity : AppCompatActivity(), STPartnerUserTokenValidationListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FlightHomeActivity.openFlightSearchService(this, "MyBl", "$2b$10$" + "G2h6ar4IHF2BdSuL6YdlR.a2RK/U4Ygcoof2oc0XZM52xf5DO387G", this)
        //FlightHistoryActivity.openFlightHistoryService(this, "MyBl", "my_bl_user_token")
    }

    override fun response(isValid: Boolean, token: String) {
        if (!isValid)
            FlightHomeActivity.updateUserToken(this, "valid_token")
    }
}
