package com.example.yaniv.wildout4;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private String TAG = this.getClass().getSimpleName();

    private static final String DATABASE_NAME = "clb_db";
    private static final int DATABASE_VERSION = 1;

    // TABLE NAMES
    private static final String TABLE_CLB = "club";

    /* Keys for Table Clubs */
    private static final String KEY_CODE = "code";
    private static final String KEY_NAME = "name";
    private static final String KEY_REGION = "region";
    private static final String KEY_AGE = "age";
    private static final String KEY_GENRE = "genre";
    private static final String KEY_IMAGE = "image";
    //private static final String KEY_ADDRESS = "age";
    //"CREATE TABLE IF NOT EXISTS FOOD(Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price VARCHAR, image BLOB)"
    /*
    String CREATE_TABLE_CALL =
            "CREATE TABLE " + TABLE_CLB + "("
                    + KEY_CODE + " INTEGER AUTO_INCREMENT,"
                    + KEY_NAME + " TEXT,"
                    + KEY_REGION + " TEXT,"
                    + KEY_AGE + " TEXT"
                    + KEY_GENRE + " TEXT "
                    + ")";
    */
    String CREATE_TABLE_CALL = "CREATE TABLE " + TABLE_CLB + "("
            + KEY_CODE + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_NAME + " TEXT,"
            + KEY_REGION + " TEXT,"
            + KEY_AGE + " TEXT,"
            + KEY_GENRE + " TEXT,"
            + KEY_IMAGE + " BLOB"
            + ")";

    String DROP_TABLE_CALL = "DROP TABLE IF EXISTS " + TABLE_CLB;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //db.execSQL("DROP TABLE IF EXISTS "+DATABASE_NAME);
        db.execSQL(DROP_TABLE_CALL);
        Log.v(TAG, "CREATE TABLE CALL: " + CREATE_TABLE_CALL);
        db.execSQL(CREATE_TABLE_CALL);

        //createClub();


    }
    public void drop(){
        SQLiteDatabase db = getWritableDatabase();
        Log.v(TAG, "CREATE TABLE CALL: " + CREATE_TABLE_CALL);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLB);
        onCreate(db);
    }

    public long insertData(String name, String region, String age, String genre, byte[] img){
        long c;

        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_REGION, region);
        values.put(KEY_AGE, age);
        values.put(KEY_GENRE, genre);
        values.put(KEY_IMAGE, img);

        c = database.insert(TABLE_CLB, null, values);
        database.close();
        return c;

    }
    /* Method to create a Club */
    public long createClub(Club clb) {
        long c;

        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, clb.getName());
        values.put(KEY_REGION, clb.getRegion());
        values.put(KEY_AGE, clb.getAge());
        values.put(KEY_GENRE, clb.getGenre());
        values.put(KEY_IMAGE, clb.getImg());
        c = database.insert(TABLE_CLB, null, values);
        database.close();
        return c;

    }

    /* Method for fetching record from Database */
    public ArrayList<Club> getAllClub() {
        String query = "SELECT * FROM " + TABLE_CLB;
        ArrayList<Club> club = new ArrayList<Club>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor c = database.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
            while (c.moveToNext()) {

                String name = c.getString(c.getColumnIndex(KEY_NAME));
                String region = c.getString(c.getColumnIndex(KEY_REGION));
                String age = c.getString(c.getColumnIndex(KEY_AGE));
                String genre =c.getString(c.getColumnIndex(KEY_GENRE));
                byte[] img = c.getBlob(c.getColumnIndex(KEY_IMAGE));

                Club clb = new Club();
                clb.setName(name);
                clb.setRegion(region);
                clb.setAge(age);
                clb.setGenre(genre);
                clb.setImg(img);
                //Log.v("DBHelper: ", "Name: " + name);
                //Log.v("DBHelper: ", "Region: " + region);
                //Log.v("DBHelper: ", "Age: " + age);
                //Log.v("DBHelper: ", "Genre: " + genre);
                club.add(clb);
            }
        }

        return club;

    }
/* This method is used to get a single record from Database.
   I have given an example, you have to do something like this. */


    public ArrayList<Club> getAllClubs2motherfucjer(){
        ArrayList<Club> club = new ArrayList<Club>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM " + TABLE_CLB , null);
        if (c.moveToFirst()) {
            while ( !c.isAfterLast() ) {
                //club.add( c.getString( c.getColumnIndex()) );
                Club clb = new Club();
                clb.setName(c.getString(c.getColumnIndex(KEY_NAME)));
                clb.setRegion(c.getString(c.getColumnIndex(KEY_REGION)));
                clb.setAge(c.getString(c.getColumnIndex(KEY_AGE)));
                clb.setGenre(c.getString(c.getColumnIndex(KEY_GENRE)));
                clb.setImg(c.getBlob(c.getColumnIndex(KEY_IMAGE)));
                club.add(clb);
                c.moveToNext();
            }

            }
            return club;
        }











    public Club getClubByName(String Name)
    {
        String query = "SELECT * FROM " + TABLE_CLB+ " WHERE "+ KEY_NAME + " = " +Name;
        Club clb = new Club();
        SQLiteDatabase database = getReadableDatabase();
        Cursor c = database.rawQuery(query, null);

        if (c.getCount() > 0) {

            c.moveToFirst();
            int code = c.getInt(c.getColumnIndex(KEY_CODE));
            Name = c.getString(c.getColumnIndex(KEY_NAME));
            String region = c.getString(c.getColumnIndex(KEY_REGION));
            String age = c.getString(c.getColumnIndex(KEY_AGE));
            String genre =c.getString(c.getColumnIndex(KEY_GENRE));
            byte[] img = c.getBlob(c.getColumnIndex(KEY_IMAGE));

            clb.setName(Name);
            clb.setRegion(region);
            clb.setAge(age);
            clb.setGenre(genre);
            clb.setImg(img);

            Log.v("DBHelper: ", "Name: " + Name);
            Log.v("DBHelper: ", "Region: " + region);
            Log.v("DBHelper: ", "Age: " + age);
            Log.v("DBHelper: ", "Genre: " + genre);


        }
        return clb;
    }


    public ArrayList<Club> getProperClub(String _region, String _genre, String _age) {
        String query = "SELECT * FROM " + TABLE_CLB +
                " Where "
                + KEY_REGION + " = " + _region +
                " AND "
                + KEY_AGE + " = " +  _age +
                " AND "
                + KEY_GENRE + " = " + _genre;
        ArrayList<Club> club = new ArrayList<Club>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor c = database.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
            while (c.moveToNext()) {

                String name = c.getString(c.getColumnIndex(KEY_NAME));
                String region = c.getString(c.getColumnIndex(KEY_REGION));
                String age = c.getString(c.getColumnIndex(KEY_AGE));
                String genre =c.getString(c.getColumnIndex(KEY_GENRE));
                byte[] img = c.getBlob(c.getColumnIndex(KEY_IMAGE));

                Club clb = new Club();
                clb.setName(name);
                clb.setRegion(region);
                clb.setAge(age);
                clb.setGenre(genre);
                clb.setImg(img);

                Log.v("DBHelper: ", "Name: " + name);

                Log.v("DBHelper: ", "Region: " + region);
                Log.v("DBHelper: ", "Age: " + age);
                Log.v("DBHelper: ", "Genre: " + genre);

                club.add(clb);
            }
        }

        return club;
    }
}
