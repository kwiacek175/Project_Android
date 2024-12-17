package com.example.tax_calculator

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var database: Database
    private lateinit var db: SQLiteDatabase


    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        database = Database(this)
        db = database.writableDatabase


        // Inicjalizacja pól tekstowych i przycisków
        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonRegister = findViewById(R.id.buttonRegister)

        // Obsługa kliknięcia przycisku "Zaloguj"
        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            // Sprawdzenie poprawności danych logowania
            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Sprawdzenie czy użytkownik istnieje w bazie danych
                val query = "SELECT * FROM ${Database.TABLE_LOGIN} WHERE ${Database.COLUMN_USERNAME} = ? AND ${Database.COLUMN_PASSWORD} = ?"
                val cursor = db.rawQuery(query, arrayOf(username, password))
                if (cursor.moveToFirst()) {
                    // Przejdź do głównego ekranu aplikacji
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish() // Zakończ bieżącą aktywność (LoginActivity)
                } else {
                    // Wyświetl komunikat o niepoprawnych danych logowania
                    Toast.makeText(this, "Niepoprawna nazwa użytkownika lub hasło", Toast.LENGTH_SHORT).show()
                }
                cursor.close()
            } else {
                // Wyświetl komunikat o niepoprawnych danych logowania
                Toast.makeText(this, "Niepoprawna nazwa użytkownika lub hasło", Toast.LENGTH_SHORT).show()
            }
        }



        // Obsługa kliknięcia przycisku "Zarejestruj się"
        buttonRegister.setOnClickListener {
            // Przejdź do ekranu rejestracji
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}
