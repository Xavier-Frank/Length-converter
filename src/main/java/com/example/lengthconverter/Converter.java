package com.example.lengthconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Collections;

public class Converter extends AppCompatActivity {
    private Spinner spinner, spinner2;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        //matching the variables to the control
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        editText = (EditText) findViewById(R.id.length);
        button = (Button) findViewById(R.id.convertbutton);

        //Loading the length
        String[] from = {"KM","M"};
        ArrayAdapter arrayAdapter = new ArrayAdapter <String>(this, R.layout.support_simple_spinner_dropdown_item, from);
        spinner.setAdapter(arrayAdapter);

        String[] to = {"KM", "M"};
        ArrayAdapter arrayAdapter2 = new ArrayAdapter <String>(this, R.layout.support_simple_spinner_dropdown_item,to);
        spinner2.setAdapter(arrayAdapter2);

        //mapping the button action
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double results;
                //declare length variable

                Double length= Double.parseDouble(editText.getText().toString());

                //getting text from spinner
                //KM to KM
                if (spinner.getSelectedItem().toString() == "KM" && spinner2.getSelectedItem().toString() == "KM")
                {
                    results = length * 1.0;
                    Toast.makeText(getApplicationContext(), results.toString(), Toast.LENGTH_LONG).show();
                }
                //M to M
                else if (spinner.getSelectedItem().toString() == "M" && spinner2.getSelectedItem().toString() == "M")
                {
                    results = length * 1.0;
                    Toast.makeText(getApplicationContext(), results.toString(), Toast.LENGTH_LONG).show();
                }
                //KM to M
                else if (spinner.getSelectedItem().toString() == "M" && spinner2.getSelectedItem().toString() == "KM")
                {
                    results = length / 1000;
                    Toast.makeText(getApplicationContext(), results.toString(), Toast.LENGTH_LONG).show();
                }
                //M to KM
                else if (spinner.getSelectedItem().toString() == "KM" && spinner2.getSelectedItem().toString() == "M")
                {
                    results = length * 1000;
                    Toast.makeText(getApplicationContext(), results.toString(), Toast.LENGTH_LONG).show();
                }



            }
        });




    }
}