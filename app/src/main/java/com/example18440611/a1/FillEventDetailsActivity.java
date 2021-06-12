package com.example18440611.a1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example18440611.a1.dto.Event;
import com.example18440611.a1.util.DBUtil;
import com.example18440611.a1.util.DateTimeUtil;

import java.sql.Time;
import java.time.LocalDate;

public class FillEventDetailsActivity extends AppCompatActivity {

    private DBUtil dbUtil;
    private EditText eventName;
    private EditText eventDescription;
    private EditText eventLocation;
    private TimePicker eventStartTime;
    private TimePicker eventEndTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_event_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dbUtil = DBUtil.getInstance(this);

        eventName = findViewById(R.id.eventName);
        eventDescription = findViewById(R.id.eventDescription);
        eventLocation = findViewById(R.id.eventLocation);
        eventStartTime = findViewById(R.id.startTime);
        eventEndTime = findViewById(R.id.endTime);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Event event = new Event();

                event.setEventName(eventName.getText().toString());
                event.setDescription(eventDescription.getText().toString());
                event.setLocation(eventLocation.getText().toString());

                LocalDate eventDate = DateTimeUtil.parse(getIntent().getStringExtra(Event.EVENT_DATE));
                event.setDate(eventDate);

                event.setStartTime(getTime(eventStartTime));
                event.setEndTime(getTime(eventEndTime));

                if (event.isValid() && dbUtil.createEvent(event)) {
                    Toast.makeText(FillEventDetailsActivity.this, "Event Added.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }

            }
        });

    }

    private Time getTime(TimePicker timePicker) {
        return new Time(timePicker.getHour(), timePicker.getMinute(), 0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
