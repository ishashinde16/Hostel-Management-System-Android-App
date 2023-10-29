package com.example.studentdashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class Mess_Registration extends AppCompatActivity {

    String[] messnums={"Mess 1", "Mess 2", "Mess 3", "Mess 4"};

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess_registration);

        autoCompleteTextView=findViewById(R.id.auto_complete_text);
        adapterItems= new ArrayAdapter<String>(this,R.layout.list_mess, messnums);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                String item=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Mess_Registration.this, "Item: "+item, Toast.LENGTH_SHORT).show();
            }
        });
    }
}