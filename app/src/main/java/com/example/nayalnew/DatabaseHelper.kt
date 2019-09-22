package com.example.nayalnew

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

const val DATABASE_NAME = "MyDB"
const val TABLE_NAME = "Users"
const val COL_FIRST_NAME = "First_name"
const val COL_LAST_NAME = "Last_name"
const val COL_NUMBER = "Number"
const val COL_ID = "ID"
const val COL_EMAIL = "Email"
const val COL_PASS = "Password"

class DatabaseHelper (var context: Context):SQLiteOpenHelper(context,DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE "+ TABLE_NAME +"("+
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_FIRST_NAME + " TEXT,"+
                COL_LAST_NAME + " TEXT,"+
                COL_NUMBER + " INTEGER,"+
                COL_EMAIL + " EMAIL,"+
                COL_PASS + " PASSWORD)";
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    fun insertData (user :User):Long{
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_FIRST_NAME,user.first_name)
        cv.put(COL_LAST_NAME,user.last_name)
        cv.put(COL_NUMBER,user.number)
        cv.put(COL_EMAIL, user.email)
        cv.put(COL_PASS, user.password)

        val result = db.insert(TABLE_NAME,null,cv)
        return result


    }
}

