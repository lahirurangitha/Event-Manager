package com.example18440611.a1.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example18440611.a1.dto.Event;

import java.util.ArrayList;
import java.util.List;

public class DBUtil extends SQLiteOpenHelper {

    private static final String DB_NAME = "event_db";
    private static final String COL_NAME = "name";
    private static final String COL_DESCRIPTION = "description";
    private static final String COL_LOCATION = "location";
    private static final String COL_DATE = "date";
    private static final String COL_START_TIME = "startTime";
    private static final String COL_END_TIME = "endTime";
    private static final String COL_ID = "id";

    private DBUtil(Context context) {
        super(context, DB_NAME, null, 1);
    }

    public static DBUtil getInstance(Context context) {
        return new DBUtil(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE event(" +
                "id INTEGER primary key, " +
                "name TEXT NOT NULL, " +
                "description TEXT NOT NULL, " +
                "location TEXT NOT NULL, " +
                "date TEXT NOT NULL, " +
                "startTime TEXT NOT NULL, " +
                "endTime TEXT NOT NULL " +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS event");
    }

    public boolean createEvent(Event event) {
        System.out.println("DB: Create Event called");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, event.getEventName());
        contentValues.put(COL_DESCRIPTION, event.getDescription());
        contentValues.put(COL_LOCATION, event.getLocation());
        contentValues.put(COL_DATE, DateTimeUtil.convertToDisplay(event.getDate()));
        contentValues.put(COL_START_TIME, event.getStartTime().toString());
        contentValues.put(COL_END_TIME, event.getEndTime().toString());

        long result = db.insert("event", null, contentValues);


        System.out.println("DB: Create Event result [" + result + "]");

        return result != -1;
    }

    public List<Event> getEvents() {
        System.out.println("DB: get Event called");

        List<Event> events = new ArrayList<>();
        Cursor cursor = null;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            cursor = db.rawQuery("select * from event", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Event event = new Event();

                event.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COL_ID))));
                event.setEventName(cursor.getString(cursor.getColumnIndex(COL_NAME)));
                event.setDescription(cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION)));
                event.setLocation(cursor.getString(cursor.getColumnIndex(COL_LOCATION)));
                event.setDate(DateTimeUtil.parse(cursor.getString(cursor.getColumnIndex(COL_DATE))));
                event.setStartTime(DateTimeUtil.convertToTime(cursor.getString(cursor.getColumnIndex(COL_START_TIME))));
                event.setEndTime(DateTimeUtil.convertToTime(cursor.getString(cursor.getColumnIndex(COL_END_TIME))));

                events.add((event));
                cursor.moveToNext();
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return events;
    }

}
