package com.yashk2000.teachertracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class Database {
    private final DatabaseOpenHelper databaseOpenHelper;
    private static final String TAG = "DictionaryDatabase";

    //The columns we'll include in the dictionary table
    public static final String COL_FROM = "BeginningTime";
    public static final String COL_TO = "TillTime";
    public static final String COL_PERIOD = "Period";
    public static final String COL_DAY = "DAY";
    public static final String COL_TEACHER = "Teacher";

    private static final String DATABASE_NAME = "Timetable";
    private static final String FTS_VIRTUAL_TABLE = "FTS";
    private static final int DATABASE_VERSION = 1;

    public Database(Context context) {
        databaseOpenHelper = new DatabaseOpenHelper(context);
    }

    private static class DatabaseOpenHelper extends SQLiteOpenHelper {

        private final Context helperContext;
        private SQLiteDatabase mDatabase;

        private static final String FTS_TABLE_CREATE =
                "CREATE VIRTUAL TABLE " + FTS_VIRTUAL_TABLE +
                        " USING fts3 (" +
                        COL_FROM + ", " +
                        COL_TO + "," + COL_PERIOD + "," + COL_DAY + "," + COL_TEACHER + ")";

        DatabaseOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            helperContext = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            mDatabase = db;
            mDatabase.execSQL(FTS_TABLE_CREATE);
            addWord();
            Toast.makeText(helperContext, "hello", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + FTS_VIRTUAL_TABLE);
            onCreate(db);
        }

        public long addWord() {
            ContentValues initialValues = new ContentValues();
            initialValues.put(COL_FROM, TimeTable.fromtime);
            initialValues.put(COL_TO, TimeTable.tillTime);
            initialValues.put(COL_PERIOD, TimeTable.description);
            initialValues.put(COL_DAY, TimeTable.text);
            initialValues.put(COL_TEACHER, "Some name");
            Toast.makeText(helperContext, "sdgth", Toast.LENGTH_LONG).show();

            return mDatabase.insert(FTS_VIRTUAL_TABLE, null, initialValues);
        }
    }
}


