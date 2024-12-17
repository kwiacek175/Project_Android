package com.example.tax_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EMICalculatorActivity : AppCompatActivity() {
    private lateinit var loanAmountEditText: EditText
    private lateinit var interestRateEditText: EditText
    private lateinit var loanTermEditText: EditText
    private lateinit var feesEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var resultTextView2: TextView
    private lateinit var goToMainButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emi_calculator_activity)

        loanAmountEditText = findViewById(R.id.editTextLoanAmount)
        interestRateEditText = findViewById(R.id.editTextInterestRate)
        loanTermEditText = findViewById(R.id.editTextLoanTerm)
        feesEditText = findViewById(R.id.editTextFees)
        calculateButton = findViewById(R.id.buttonCalculateEMI)
        resultTextView = findViewById(R.id.textViewResult)
        resultTextView2 = findViewById(R.id.textViewResult2)
        goToMainButton = findViewById(R.id.buttonGoToMain)

        calculateButton.setOnClickListener {
            calculateEMI()
        }

        goToMainButton.setOnClickListener {
            // Przejdź do ekranu menu głównego
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun calculateEMI() {
        val loanAmount = loanAmountEditText.text.toString().toDoubleOrNull()
        val interestRate = interestRateEditText.text.toString().toDoubleOrNull()
        val loanTerm = loanTermEditText.text.toString().toIntOrNull()
        val fees = feesEditText.text.toString().toDoubleOrNull()

        if (loanAmount != null && interestRate != null && loanTerm != null && fees != null) {

            val monthlyInterest = interestRate / 12 / 100
            val totalLoanAmount = loanAmount + fees
            val emi = calculateEMI(totalLoanAmount, monthlyInterest, loanTerm)

            resultTextView.text = String.format("Rata miesięcnza: %.2f", emi)
            resultTextView2.text = String.format("Całkowita płatność: %.2f", emi * loanTerm)
        } else {
            resultTextView.text = "Wprowadź poprawne dane"
            resultTextView2.text = ""
        }
    }

    private fun calculateEMI(loanAmount: Double, monthlyInterest: Double, loanTerm: Int): Double {
        val emiNumerator = loanAmount * monthlyInterest * Math.pow((1 + monthlyInterest), loanTerm.toDouble())
        val emiDenominator = Math.pow((1 + monthlyInterest), loanTerm.toDouble()) - 1
        return emiNumerator / emiDenominator
    }
}
