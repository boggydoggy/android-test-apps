package com.example.dbcontentprovidertest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentDBManager extends SQLiteOpenHelper {
    static final String DB_STUDENTS = "Students.db";
    static final String TABLE_STUDENTS = "Students";
    static final int DB_VERSION = 2;
    Context context = null;
    private static StudentDBManager dbManager = null;

    public static StudentDBManager getInstance(Context context) {
        if(dbManager == null) {
            dbManager = new StudentDBManager(context, DB_STUDENTS, null, DB_VERSION);
        }

        return dbManager;
    }

    private StudentDBManager(Context context, String dbName, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbName, factory, version);
        this.context = context;
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS " + TABLE_STUDENTS + "(" + "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "number TEXT, " +
                "name TEXT, " +
                "department TEXT, " +
                "age TEXT, " +
                "grade INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i < i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS );
        }
    }

    public long insert(ContentValues addRowValue) {
        return getWritableDatabase().insert(TABLE_STUDENTS, null, addRowValue);
    }

    public int insertAll(ContentValues[] values) {
        SQLiteDatabase db = getWritableDatabase();

        db.beginTransaction();

        for(ContentValues contentValues: values) {
            db.insert(TABLE_STUDENTS, null, contentValues);
        }

        db.setTransactionSuccessful();
        db.endTransaction();

        return values.length;
    }

    public Cursor query(String[] column, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return getReadableDatabase().query(TABLE_STUDENTS, column, selection, selectionArgs, groupBy, having, orderBy);
    }

    public int update(ContentValues updateRowValue,String whereClause, String[] whereArgs){
        return getWritableDatabase().update(TABLE_STUDENTS,updateRowValue,whereClause,whereArgs);
    }

    public int delete(String whereClause, String[] whereArgs){
        return getWritableDatabase().delete(TABLE_STUDENTS,whereClause,whereArgs);
    }
}
