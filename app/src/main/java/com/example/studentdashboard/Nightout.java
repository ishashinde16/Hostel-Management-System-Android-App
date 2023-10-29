package com.example.studentdashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Nightout extends AppCompatActivity {

    Button leave_date, return_date;
    private TextView leavetext, returntext;
    Calendar mycal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nightout);

        leave_date = findViewById(R.id.leave_date);
        return_date = findViewById(R.id.return_date);
        leavetext=findViewById(R.id.leave_text);
        returntext=findViewById(R.id.return_text);

        leave_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });



        return_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog2();
            }
        });




    }

    private void openDialog2() {

        DatePickerDialog dialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                returntext.setText(String.valueOf(year)+"."+String.valueOf(month +1)+"."+String.valueOf(dayOfMonth));
            }
        }, 2023, 0, 15);
        dialog.show();

    }

    private void openDialog() {

        DatePickerDialog dialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                leavetext.setText(String.valueOf(year)+"."+String.valueOf(month +1)+"."+String.valueOf(dayOfMonth));
            }
        }, 2023, 0, 15);
        dialog.show();

    }
}