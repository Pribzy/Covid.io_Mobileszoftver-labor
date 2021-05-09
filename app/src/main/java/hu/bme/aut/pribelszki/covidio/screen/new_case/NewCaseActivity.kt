package hu.bme.aut.pribelszki.covidio.screen.new_case

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import hu.bme.aut.pribelszki.covidio.R

class NewCaseActivity : SimpleNavActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigator.add(NewCaseFragment())
    }
}