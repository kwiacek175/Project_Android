package com.example.tax_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IncomeTaxCalculatorActivity : AppCompatActivity() {

    private lateinit var editTextIncome: EditText
    private lateinit var spinnerTaxRate: Spinner
    private lateinit var editTextTaxCreditChildren: EditText
    private lateinit var editTextTaxCreditDependent: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var textViewResult: TextView
    private lateinit var goToMainButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.income_tax_calculator_activity)

        // Inicjalizacja pól tekstowych, spinnera, przycisku i pola wynikowego
        editTextIncome = findViewById(R.id.editTextIncome)
        spinnerTaxRate = findViewById(R.id.spinnerTaxRate)
        editTextTaxCreditChildren = findViewById(R.id.editTextTaxCreditChildren)
        editTextTaxCreditDependent = findViewById(R.id.editTextTaxCreditDependent)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        textViewResult = findViewById(R.id.textViewResult)
        goToMainButton = findViewById(R.id.buttonGoToMain)

        // Obsługa kliknięcia przycisku "Oblicz"
        buttonCalculate.setOnClickListener {
            calculateTax()
        }

        goToMainButton.setOnClickListener {
            // Przejdź do ekranu menu głównego
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun calculateTax() {
        val income = editTextIncome.text.toString().toDoubleOrNull()
        val taxRateString = spinnerTaxRate.selectedItem.toString()
        val taxRatePercentage = taxRateString.removeSuffix("%").toDoubleOrNull()
        val taxRate: Double? = taxRatePercentage?.div(100)
        val taxCreditChildren = editTextTaxCreditChildren.text.toString().toIntOrNull()
        val taxCreditDependent = editTextTaxCreditDependent.text.toString().toIntOrNull()

        if (income != null && taxRate != null && taxCreditChildren != null && taxCreditDependent != null) {
            val taxAmount = calculateTaxAmount(income, taxRate, taxCreditChildren, taxCreditDependent)
            textViewResult.text = String.format("Podatek dochodowy: %.2f", taxAmount)
        } else {
            textViewResult.text = "Wprowadź poprawne dane"
        }
    }


    private fun calculateTaxAmount(
        income: Double,
        taxRate: Double,
        taxCreditChildren: Int,
        taxCreditDependent: Int
    ): Double {
        val taxableIncome = income - taxCreditChildren - (taxCreditDependent * 500)
        val taxAmount = taxableIncome * taxRate
        return taxAmount
    }
}
