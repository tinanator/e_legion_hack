package com.example.aq.ui.user.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.exceptions.OutOfDateRangeException;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.List;

class MyEventDay extends EventDay implements Parcelable {
    private String mNote;

    MyEventDay(Calendar day, int imageResource, String note) {
        super(day, imageResource);
        mNote = note;
    }

    String getNote() {
        return mNote;
    }

    private MyEventDay(Parcel in) {
        super((Calendar) in.readSerializable(), in.readInt());
        mNote = in.readString();
    }

    public static final Creator<MyEventDay> CREATOR = new Creator<MyEventDay>() {
        @Override
        public MyEventDay createFromParcel(Parcel in) {
            return new MyEventDay(in);
        }

        @Override
        public MyEventDay[] newArray(int size) {
            return new MyEventDay[size];
        }
    };

    @SuppressLint("RestrictedApi")
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(getCalendar());
        parcel.writeInt((Integer) getImageDrawable());
        parcel.writeString(mNote);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}

public class CalendarActivity extends AppCompatActivity {
    public static final String RESULT = "result";
    public static final String EVENT = "event";
    private static final int ADD_NOTE = 44;

    private CalendarView mCalendarView;
    private final List<EventDay> mEventDays = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        mCalendarView = (CalendarView) findViewById(R.id.calendarView);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNote();
            }
        });

        mCalendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
                previewNote(eventDay);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_NOTE && resultCode == RESULT_OK) {
            MyEventDay myEventDay = data.getParcelableExtra(RESULT);
            try {
                mCalendarView.setDate(myEventDay.getCalendar());
                ;
            } catch (OutOfDateRangeException e) {
                e.printStackTrace();
            }
            mEventDays.add(myEventDay);
            mCalendarView.setEvents(mEventDays);
        }
    }

    private void addNote() {
        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivityForResult(intent, ADD_NOTE);
    }

    private void previewNote(EventDay eventDay) {
        Intent intent = new Intent(this, NotePreviewActivity.class);
        if(eventDay instanceof MyEventDay){
            intent.putExtra(EVENT, (MyEventDay) eventDay);
        }
        startActivity(intent);
    }
}