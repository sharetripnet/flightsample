package net.sharetrip.flightsample

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.sharetrip.flight.FlightHomeActivity
import net.sharetrip.flight.STPartnerUserTokenValidationListener
import java.util.Locale

class MainActivity : AppCompatActivity(), STPartnerUserTokenValidationListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val config = resources.configuration
        val lang = "bn_BD" // your language code
        val locale = Locale(lang)
        Locale.setDefault(locale)
        config.locale = locale

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            createConfigurationContext(config)
        resources.updateConfiguration(config, resources.displayMetrics)

        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tvOpenSDK).setOnClickListener {
            Log.d("locale", locale.displayName)
            FlightHomeActivity.openFlightSearchService(this, "MyBl", "$2b$10$" + "I6MLQnV73jwkiYMl/iX14.4byykXcUheTuzLalfsYHULmdBUQszNS", this)
            //FlightHistoryActivity.openFlightHistoryService(this, "MyBl", "my_bl_user_token")
        }
    }

    override fun response(isValid: Boolean, token: String) {
        if (!isValid)
            FlightHomeActivity.updateUserToken(this, token)
    }
}
