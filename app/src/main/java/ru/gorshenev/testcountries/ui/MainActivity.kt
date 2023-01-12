package ru.gorshenev.testcountries.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.gorshenev.testcountries.R
import ru.gorshenev.testcountries.databinding.ActivityMainBinding
import ru.gorshenev.testcountries.ui.countries.CountriesFragment

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, CountriesFragment())
                .commit()
        }
    }
}