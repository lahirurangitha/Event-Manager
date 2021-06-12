package com.example18440611.a1;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example18440611.a1.dto.Event;
import com.example18440611.a1.util.DBUtil;

import java.util.List;

public class ViewEventsActivity extends AppCompatActivity {

    private DBUtil dbUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_events);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbUtil = DBUtil.getInstance(this);

        ListView listView = findViewById(R.id.eventsListView);
        List<Event> events = dbUtil.getEvents();
        if (events.isEmpty()) {
            events.add(new Event() {
                @Override
                public String toString() {
                    return "No events";
                }
            });
        }

        ArrayAdapter<Event> arrayAdapter = new ArrayAdapter<>(this, R.layout.content_list_element, events);

        ColorDrawable primary = new ColorDrawable(this.getResources().getColor(R.color.colorPrimary));
        listView.setDivider(primary);
        listView.setDividerHeight(1);
        listView.setAdapter(arrayAdapter);

    }


}
