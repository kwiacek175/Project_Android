package com.example.tax_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var buttonIncomeTaxCalculator: Button
    private lateinit var buttonEMICalculator: Button
    private lateinit var buttonLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        // Inicjalizacja przycisków
        buttonIncomeTaxCalculator = findViewById(R.id.buttonIncomeTaxCalculator)
        buttonEMICalculator = findViewById(R.id.buttonEMICalculator)
        buttonLogout = findViewById(R.id.buttonLogout)

        // Obsługa kliknięcia przycisku "Kalkulator podatku dochodowego"
        buttonIncomeTaxCalculator.setOnClickListener {
            val intent = Intent(this, IncomeTaxCalculatorActivity::class.java)
            startActivity(intent)
        }

        // Obsługa kliknięcia przycisku "Kalkulator EMI"
        buttonEMICalculator.setOnClickListener {
            val intent = Intent(this, EMICalculatorActivity::class.java)
            startActivity(intent)
        }

        // Obsługa kliknięcia przycisku "Wyloguj"
        buttonLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
