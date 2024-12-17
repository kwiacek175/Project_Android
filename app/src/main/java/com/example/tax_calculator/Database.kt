package com.example.tax_calculator

import android.app.DownloadManager.COLUMN_ID
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "database.db"

        // Tabela dla danych logowania
        const val TABLE_LOGIN = "login"
        const val COLUMN_USERNAME = "username"
        const val COLUMN_PASSWORD = "password"

        // Tabela dla danych rejestracji
        const val TABLE_REGISTRATION = "registration"
        const val COLUMN_ID = "id"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_PHONE = "phone"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Tworzenie tabeli dla danych logowania
        val createLoginTable = "CREATE TABLE $TABLE_LOGIN ($COLUMN_USERNAME TEXT PRIMARY KEY, $COLUMN_PASSWORD TEXT)"
        db.execSQL(createLoginTable)

        // Tworzenie tabeli dla danych rejestracji
        val createRegistrationTable = "CREATE TABLE $TABLE_REGISTRATION ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_USERNAME TEXT, $COLUMN_EMAIL TEXT, $COLUMN_PHONE TEXT)"
        db.execSQL(createRegistrationTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Aktualizacja bazy danych (jeśli potrzebna)
        db.execSQL("DROP TABLE IF EXISTS $TABLE_LOGIN")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_REGISTRATION")
        onCreate(db)
    }
}
