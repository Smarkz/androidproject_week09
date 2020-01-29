package com.example.test2;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseHelper instance;

    public static final String DATABASE_NAME = "UserInfo.db";
    public static final String TABLE_NAME = "UserInfoData_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Age";
    public static final String COL_4 = "Height";
    public static final String COL_5 = "Weight";

    //the databse table and the column names are given

    private static final String SQL_DELETE_ENTRIES=
            "DROP TABLE IF EXISTS" + DatabaseHelper.TABLE_NAME;


    public DatabaseHelper (Context context){
        super (context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }
//the constructor

    static public synchronized DatabaseHelper getInstance(Context context){
        if (instance == null){
            instance = new DatabaseHelper(context);
        }
        return instance;
    }

    public void onCreate(SQLiteDatabase db){
      db.execSQL(String.format("create table%s(ID INTEGER PRIMARY KEY AUTOINCREMENT , Name TEXT, Age INTEGER, Height INTEGER, Weight INTEGER)", TABLE_NAME));
    }
    //the passed query will be executed and then the table will be created

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(String.format("DROP TABLE IF EXISTS%s", TABLE_NAME));
        onCreate(db);
    }

}
