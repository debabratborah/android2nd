package com.example.sqlapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class UserDAO(context: Context) {

    private val dbHelper = DatabaseHelper(context)

    fun insertUser(name: String, age: Int) {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_NAME, name)
            put(DatabaseHelper.COLUMN_AGE, age)
        }
        db.insert(DatabaseHelper.TABLE_NAME, null, values)
    }

    fun getAllUsers(): Cursor {
        val db: SQLiteDatabase = dbHelper.readableDatabase
        return db.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null)
    }
}
