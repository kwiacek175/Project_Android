package com.example.tax_calculator

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {

    private lateinit var database: Database
    private lateinit var db: SQLiteDatabase


    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextConfirmPassword: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var checkBoxTerms: CheckBox
    private lateinit var buttonRegister: Button
    private lateinit var goToLoginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_activity)

        database = Database(this)
        db = database.writableDatabase


        // Inicjalizacja pól tekstowych, pola wyboru i przycisku
        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPhone = findViewById(R.id.editTextPhone)
        checkBoxTerms = findViewById(R.id.checkBoxTerms)
        buttonRegister = findViewById(R.id.buttonRegister)
        goToLoginButton = findViewById(R.id.buttonBackToLogin)

        // Obsługa kliknięcia przycisku "Zarejestruj"
        buttonRegister.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()
            val confirmPassword = editTextConfirmPassword.text.toString()
            val email = editTextEmail.text.toString()
            val phone = editTextPhone.text.toString()
            val termsAccepted = checkBoxTerms.isChecked

            // Sprawdzenie poprawności wprowadzonych danych rejestracji
            if (validateRegistrationData(username, password, confirmPassword, email, phone, termsAccepted)) {
                // Dodaj dane do bazy danych
                val values = ContentValues()
                values.put(Database.COLUMN_USERNAME, username)
                values.put(Database.COLUMN_PASSWORD, password)
                db.insert(Database.TABLE_LOGIN, null, values)

                values.clear()
                values.put(Database.COLUMN_USERNAME, username)
                values.put(Database.COLUMN_EMAIL, email)
                values.put(Database.COLUMN_PHONE, phone)
                db.insert(Database.TABLE_REGISTRATION, null, values)

                // Wyświetl komunikat o sukcesie
                Toast.makeText(this, "Rejestracja zakończona sukcesem", Toast.LENGTH_SHORT).show()

                // Zakończ bieżącą aktywność (RegistrationActivity) i przejdź do ekranu logowania
                finish()
            }
        }


        goToLoginButton.setOnClickListener {
            // Przejdź do ekranu menu głównego
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateRegistrationData(
        username: String,
        password: String,
        confirmPassword: String,
        email: String,
        phone: String,
        termsAccepted: Boolean
    ): Boolean {
        // Sprawdzenie warunków poprawności wprowadzonych danych rejestracji
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "Wszystkie pola muszą być wypełnione", Toast.LENGTH_SHORT).show()
            return false
        }

        if (password != confirmPassword) {
            Toast.makeText(this, "Hasła nie pasują do siebie", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!termsAccepted) {
            Toast.makeText(this, "Musisz zaakceptować warunki użytkowania", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!isValidEmail(email)) {
            Toast.makeText(this, "Nieprawidłowy format adresu e-mail", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!isValidPhone(phone)) {
            Toast.makeText(this, "Nieprawidłowy format numeru telefonu", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
        return email.matches(emailRegex)
    }

    private fun isValidPhone(phone: String): Boolean {
        val phoneRegex = Regex("\\d{9}")
        return phone.matches(phoneRegex)
    }

}
