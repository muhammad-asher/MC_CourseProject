package com.example.mc_courseproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseClass extends SQLiteOpenHelper {

    Context context;
    private static final String DatabaseName="MyNotes";
    private static final int DatabaseVersion=1;

    private static final String TableName="mynotes";
    private static final String ColumnId="id";
    private static final String ColumnTitle="title";
    private static final String ColumnDescription="description";


    public DatabaseClass(@Nullable Context context) {
        super(context, DatabaseName, null, DatabaseVersion);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

            String query= "CREATE TABLE " + TableName +
                    " (" + ColumnId + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ColumnTitle + " TEXT, " +
                    ColumnDescription + " TEXT);";

            db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TableName);
        onCreate(db);
    }

    void addNotes(String title, String description)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();

        cv.put(ColumnTitle,title);
        cv.put(ColumnDescription,description);

        long resultValue = db.insert(TableName,null,cv);

        if (resultValue ==-1)
        {
            Toast.makeText(context, "Data Not Added", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "Data Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }

}