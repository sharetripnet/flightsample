package net.sharetrip.flightsample

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.sharetrip.flightrevamp.FlightMainActivity
import net.sharetrip.flightrevamp.STPartnerUserTokenValidationListener
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

            //stg
            FlightMainActivity.openFlightSearchService(this, "MyBl", "$2b$10$" + "YXBj02rxOJHMEWkV/Da64.sBJvbAWWng2X4tPgV16WAc8nb/BDr3i", this)

            //prod
//            FlightMainActivity.openFlightSearchService(this, "MyBl", "$2b$10$" + "EO8u6KbU6wu1mcCXIqw07.uNGB1pxv4oRX/.HeAE3e5ByTt5uSaWa", this)
        }
    }

    override fun response(isValid: Boolean, token: String) {
        if (!isValid)
            FlightMainActivity.updateUserToken(this, token)
    }
}
