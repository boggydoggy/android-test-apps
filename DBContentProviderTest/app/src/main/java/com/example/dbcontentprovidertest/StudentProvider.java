package com.example.dbcontentprovidertest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StudentProvider extends ContentProvider {
    public StudentDBManager dbManager = null;

    @Override
    public boolean onCreate() {
        dbManager = StudentDBManager.getInstance(getContext());
        return true;
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] contentValues) {
        return dbManager.insertAll(contentValues);
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        return dbManager.query(strings, s, strings1,null, null, s1);
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        long rowId = dbManager.insert(contentValues);
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return dbManager.delete(s, strings);
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return dbManager.update(contentValues, s, strings);
    }
}
