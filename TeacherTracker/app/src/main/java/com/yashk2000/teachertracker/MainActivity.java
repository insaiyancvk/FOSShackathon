package com.yashk2000.teachertracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void teacher(View view) {
        Intent intent = new Intent(this, Teacher.class);
        startActivity(intent);
    }

    public void student(View view) {
        Intent intent = new Intent(this, Student.class);
        startActivity(intent);
    }
}
