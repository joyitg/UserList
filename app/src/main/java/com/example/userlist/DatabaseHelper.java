package com.example.userlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 2/28/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String DATABASE_NAME = "UserTable.db";
    private static final String TABLE_NAME = "UserTable";
    private static final String COL1 = "ID";
    private static final String COL2 = "fname";
    private static final String COL3 = "lname";
    private static final String COL4 = "Gender";
    private static final String COL5 = "Country";
    private static final String COL6 = "State";
    private static final String COL7 = "hometown";
    private static final String COL8 = "phno";
    private static final String COL9 = "tele";
    private static final String COl10="dob";

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,  null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT,"+ COL3 +" TEXT,"+ COL4 +" TEXT,"+ COL5 +" TEXT,"+ COL6 +" TEXT,"+ COL7 +" TEXT,"+ COL8 +" TEXT,"+ COL9 +" TEXT,"+ COl10 +" String)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean addData(String item1, String s2, String string1, String toString1, String s1, String string, String toString, String s, String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item1);
        contentValues.put(COL3, s2);
        contentValues.put(COL4, string1);
        contentValues.put(COL5, toString1);
        contentValues.put(COL6, s1);
        contentValues.put(COL7, string);
        contentValues.put(COL8, toString);
        contentValues.put(COL9, s);
        contentValues.put(COl10, item);
        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns all the data from database
     * @return
     */
    public ArrayList<List> getData(){
        ArrayList<List> Ulist = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
      while (res.moveToFirst()){
            String id = res.getString(1);
            String Fname = res.getString(2);
            String Lname = res.getString(3);
            String gender = res.getString(4);
            String country = res.getString(5);
            String state = res.getString(6);
            String hometown = res.getString(7);
            String phno = res.getString(8);
            String tele = res.getString(9);
            String age = res.getString(10);

            List newList = new List(id, Lname, Fname, gender, age, country,state, hometown, phno, tele);
            Ulist.add(newList);
        }
        return Ulist;
    }
    /*public Cursor getData () {
        SQLiteDatabase db = this.getReadableDatabase();
        String buildSQL = "SELECT * FROM " + TABLE_NAME;

        Log.d(TAG, "getAllData SQL: " + buildSQL);


        return db.rawQuery(buildSQL, null);
    }*/

    /**
     * Returns only the ID that matches the name passed in

     */
    public Cursor getItemID(String number){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL8 + " = '" + number + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    /**
     * Updates the name field
     * @param newName
     * @param id
     * @param oldName
     */
    public void updateName(String newName, int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }

    /**
     * Delete from database

     */
    public void deleteName(int id, String fname, String lname, String gender, String country, String state, String hometown, String phno, String tele, String dob){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + fname + "'"
                +" AND " + COL3 + " = '" + lname + "'"
                +" AND " + COL4 + " = '" + gender + "'"
                +" AND " + COL5 + " = '" + country + "'"
                +" AND " + COL6 + " = '" + state + "'"
                +" AND " + COL7 + " = '" + hometown + "'"
                +" AND " + COL8 + " = '" + phno + "'"
                +" AND " + COL9 + " = '" + tele + "'"
                +" AND " + COl10 + " = '" + dob + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + fname + lname + gender + country + state + hometown + phno + tele + dob +" from database.");
        db.execSQL(query);
    }

}

