package com.nsbm.projectlms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ScheduleActivity extends AppCompatActivity {

    CalendarView calendarView;
    TextView date;
    TextView date1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        calendarView = findViewById(R.id.calendarView);
        date = findViewById(R.id.date);
        date1 = findViewById(R.id.date1);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {

                String todayDate1 = "Industry Preparation Training";
                String todayDate2 = "Mobile Application Development";
                String todayDate3 = "Study Leave";
                String todayDate4 = "No Activities";
                String todayDate5 = "9:00 - 12:00";
                String todayDate6 = "9:30 - 16:30";
                String todayDate7 = "13:30 - 16:30";
                String todayDate8 = "EXAMS";
                String todayDate9 = "14:00 - 17:00";

                int day = dayOfMonth;


                if(day == 1 || day == 5 || day == 6 || day == 7 || day == 8)
                {
                    Log.d("date", todayDate1);
                    date.setText(todayDate1);
                    date1.setText(todayDate6);

                }else if (day == 2 || day == 9)
                {
                    Log.d("date", todayDate2);
                    date.setText(todayDate2);
                    date1.setText(todayDate9);
                }
                else if (day == 12 || day == 13 || day == 14 || day == 15 || day == 16 || day == 17 || day == 18 || day == 19 || day == 20)
                {
                    Log.d("date", todayDate3);
                    date.setText(todayDate3);
                    date1.setText(null);
                }
                else if (day == 21 || day == 23 || day == 26 || day == 28 || day == 30)
                {
                    Log.d("date", todayDate8);
                    date.setText(todayDate8);
                    date1.setText(todayDate7);
                }else
                {
                    Log.d("date", todayDate4);
                    date.setText(todayDate4);
                    date1.setText(null);
                }

            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_schedule);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_course:
                    startActivity(new Intent(getApplicationContext(), CourseActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;

                case R.id.bottom_exams:
                    startActivity(new Intent(getApplicationContext(), ExamActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;

                case R.id.bottom_schedule:
                    return true;
            }
            return false;
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.logout){
            Intent intent1 = new Intent(this, LoginActivity.class);
            startActivity(intent1);
            Toast.makeText(this, "Successfully Logout", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.profile){
            Intent intent2 = new Intent(this, ProfileActivity.class);
            startActivity(intent2);
        }
        return true;
    }
}