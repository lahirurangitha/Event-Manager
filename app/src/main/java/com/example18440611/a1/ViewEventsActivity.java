package com.example18440611.a1;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.example18440611.a1.dto.Event;
import com.example18440611.a1.util.DBUtil;

public class ViewEventsActivity extends AppCompatActivity {

    private DBUtil dbUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_events);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbUtil = DBUtil.getInstance(this);


        ArrayAdapter<Event> arrayAdapter = new ArrayAdapter<>(this, R.layout.content_list_element, dbUtil.getEvents());

        ListView listView = findViewById(R.id.eventsListView);
        ColorDrawable primary = new ColorDrawable(this.getResources().getColor(R.color.colorPrimary));
        listView.setDivider(primary);
        listView.setDividerHeight(1);
        listView.setAdapter(arrayAdapter);
//        for (Event event : dbUtil.getEvents()) {
//            TextView textView = new TextView(this);
//            textView.setText(event.getId() + " :" + event.getEventName());
//            listView.add
//            listView.addView(textView);
//        }

    }


}
