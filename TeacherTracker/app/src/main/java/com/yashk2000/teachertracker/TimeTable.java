package com.yashk2000.teachertracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class TimeTable extends AppCompatActivity {
    private EditText from;
    private EditText to;
    private EditText des;
    public static String fromtime;
    public static String tillTime;
    public static String description;
    public static String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        Spinner spinner =  findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        // adding from time
        from = findViewById(R.id.editText);
        fromtime = from.getText().toString();
        to = findViewById(R.id.editText2);
        tillTime = from.getText().toString();
        des = findViewById(R.id.editText3);
        description = from.getText().toString();
        text = spinner.getSelectedItem().toString();

    }

    public void addToDB(View view) {
        Database db = new Database(this);
    }
}
