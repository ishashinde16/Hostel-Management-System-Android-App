package com.example.studentdashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class laundry extends AppCompatActivity {

    private TextView text;
    private Button button;

    String[] timeIntervals = {
            "6:00-6:30", "6:30-7:00",
            "7:00-7:30", "7:30-8:00",
            "21:00-21:30", "21:30-22:00",
            "22:00-22:30", "22:30-23:00",
    };

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laundry);

        text = findViewById(R.id.show_text);
        button = findViewById(R.id.date_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        autoCompleteTextView=findViewById(R.id.auto_complete_text);
        adapterItems= new ArrayAdapter<String>(this,R.layout.list_mess, timeIntervals);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                String item=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(laundry.this, "Item: "+item, Toast.LENGTH_SHORT).show();
            }
        });
    }
       private void openDialog(){
            DatePickerDialog dialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                    text.setText(String.valueOf(year)+"."+String.valueOf(month +1)+"."+String.valueOf(dayOfMonth));
                }
            }, 2023, 0, 15);
            dialog.show();
        }


    }
