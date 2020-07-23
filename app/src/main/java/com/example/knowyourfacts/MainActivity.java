package com.example.knowyourfacts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;

    Button readLater;
    int reqCode = 12345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager = findViewById(R.id.viewPager);
        readLater = findViewById(R.id.readLater);

        FragmentManager fm = getSupportFragmentManager();
        al = new ArrayList<Fragment>();
        al.add(new Frag1());
        al.add(new Frag2());
        al.add(new Frag3());

        adapter = new MyFragmentPagerAdapter(fm,al);

        vPager.setAdapter(adapter);

        readLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, 300);

                Intent intent = new Intent(MainActivity.this,ScheduledNotificationReceiver.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        MainActivity.this, reqCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager am = (AlarmManager)getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),pendingIntent);
            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences("page", MODE_PRIVATE).edit();
        editor.putInt("page", vPager.getCurrentItem());
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("page", MODE_PRIVATE);

        int page = sh.getInt("page",0);
        vPager.setCurrentItem(page);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_previous:
                if (vPager.getCurrentItem() > 0){
                    int previousPage = vPager.getCurrentItem() -1;
                    vPager.setCurrentItem(previousPage, true);
                }
                return true;
            case R.id.action_random:
                Random randomno = new Random();
                vPager.setCurrentItem(randomno.nextInt(3), true);
                return true;
            case R.id.action_next:
                int max = vPager.getChildCount();
                if (vPager.getCurrentItem() < max -1){
                    int nextPage = vPager.getCurrentItem() +1;
                    vPager.setCurrentItem(nextPage, true);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}