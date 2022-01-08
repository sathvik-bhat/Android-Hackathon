package com.knightnight.login_and_stuff.SQL

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.knightnight.login_and_stuff.model.User

import java.security.AccessControlContext

class DatabaseHelper(context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {

    companion object {
        // Database Version
        private val DATABASE_VERSION = 1
        // Database Name
        private val DATABASE_NAME = "UserManager.db"
        // User table name
        private val TABLE_USER = "user"
        // User Table Columns names
        private val COLUMN_USER_ID = "user_id"
        private val COLUMN_USER_NAME = "user_name"
        private val COLUMN_USER_EMAIL = "user_email"
        private val COLUMN_USER_PASSWORD = "user_password"}

    private val CREATE_USER_TABLE = ("CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")")

    private val DROP_USER_TABLE="DROP TABLE IF EXISTS $TABLE_USER"

    //when we create an obj of this class, this executes
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_USER_TABLE)
    }
    //.execSQL ke andar sql command jaega as string
    override fun onUpgrade(db: SQLiteDatabase, OldVersion: Int, NewVersion: Int) {
        //if table exists, drop it
        db.execSQL(DROP_USER_TABLE)

        //now we create tables again
        onCreate(db)
    }
    fun addUser(user: User)
    {
        val database=this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_USER_NAME,user.name)
        values.put(COLUMN_USER_EMAIL,user.email)
        values.put(COLUMN_USER_PASSWORD,user.pwd)
        //here we insert a new row:
        database.insert(TABLE_USER,null,values)
        database.close()
    }
    fun updateUser(user: User)
    {
        val database=this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_USER_NAME,user.name)
        values.put(COLUMN_USER_EMAIL,user.email)
        values.put(COLUMN_USER_PASSWORD,user.pwd)

        //here we update the row
        database.update(TABLE_USER,values,"$COLUMN_USER_ID = ?", arrayOf(user.id.toString()))
        database.close()
    }
    fun deleteUser(user: User)
    {
        val database = this.writableDatabase

        //delete user record
        database.delete(TABLE_USER,"$COLUMN_USER_ID=?", arrayOf(user.id.toString()))
        database.close()
    }
    fun CheckUser(mail: String): Boolean
    {
        val columns = arrayOf(COLUMN_USER_ID)
        val database = this.readableDatabase

        //selection condition:
        val selection="$COLUMN_USER_EMAIL=?"

        //selection argument
        val selectionArg= arrayOf(mail)

        val cursor =database.query(TABLE_USER,
            columns,
            selection,
            selectionArg,
            null,
            null,
            null)

        val countcursor = cursor.count
        cursor.close()
        database.close()
        if(countcursor>0)
            return true
        return false
    }
    fun CheckUserfull(mail: String,pwd:String):Boolean
    {
        val columns = arrayOf(COLUMN_USER_ID)
        val database = this.readableDatabase

        //selection condition:
        val selection="$COLUMN_USER_EMAIL=? AND $COLUMN_USER_PASSWORD=?"

        //selection argument
        val selectionArg= arrayOf(mail,pwd)

        val cursor =database.query(TABLE_USER,
            columns,
            selection,
            selectionArg,
            null,
            null,
            null)

        val countcursor = cursor.count
        cursor.close()
        database.close()
        if(countcursor>0)
            return true
        return false
    }
}