package com.example.yaniv.wildout4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView;



public class MainActivity extends AppCompatActivity {
    // these are the global variables
    Spinner classSpinner, divSpinner, ageSpinner;

    // string variable to store selected values
    String selectedClass, selectedGenre, selectedAge;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classSpinner = (Spinner) findViewById(R.id.geo_demo_spinner);
        divSpinner = (Spinner) findViewById(R.id.music_cattagory_spinner);
        ageSpinner = (Spinner) findViewById(R.id.age_spinner);
        final Button button = findViewById(R.id.submit_area);
        //============================= color of text ====================================//
     /*   super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wild_out);
         TextView textElement = (TextView) findViewById(R.id.submit_area);
        textElement.setTextColor(b29aea); //this is purpel color11 */
//==================================== color of text end ================================//

        // Class Spinner implementing onItemSelectedListener
        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedClass = parent.getItemAtPosition(position).toString();

                switch (selectedClass) {
                    case "NULL":
                        // assigning div item list defined in XML to the div Spinner
                        break;
                    case "Center":
                        // assigning div item list defined in XML to the div Spinner
                        divSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.music_cattagory)));
                        divSpinner.setVisibility(View.VISIBLE);
                        break;

                    case "North":
                        divSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.music_cattagory)));
                        divSpinner.setVisibility(View.VISIBLE);
                        break;

                    case "South":
                        divSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.music_cattagory)));
                        divSpinner.setVisibility(View.VISIBLE);
                        break;

                }

                //set divSpinner Visibility to Visible
                //divSpinner.setVisibility(View.VISIBLE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // can leave this empty
            }
        });

        // Div Spinner implementing onItemSelectedListener
        divSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /*
         <item>Rock</item>
        <item>Mainstream</item>
        <item>Techno</item>
        <item>Regatton</item>
        <item>Trap</item>
        <item>Trance</item>

            */

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedGenre = parent.getItemAtPosition(position).toString();
                switch (selectedGenre) {
                    case "NULL":
                        // assigning div item list defined in XML to the div Spinner
                        break;
                    case "Rock":
                        // assigning div item list defined in XML to the div Spinner
                        ageSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.age_spinner)));
                        ageSpinner.setVisibility(View.VISIBLE);
                        break;

                    case "Mainstream":
                        ageSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.age_spinner)));
                        ageSpinner.setVisibility(View.VISIBLE);
                        break;

                    case "Techno":
                        ageSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.age_spinner)));
                        ageSpinner.setVisibility(View.VISIBLE);
                        break;
                    case "Regatton":
                        ageSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.age_spinner)));
                        ageSpinner.setVisibility(View.VISIBLE);
                        break;
                    case "Trap":
                        ageSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.age_spinner)));
                        ageSpinner.setVisibility(View.VISIBLE);
                        break;
                    case "Trance":
                        ageSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.age_spinner)));
                        ageSpinner.setVisibility(View.VISIBLE);
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // can leave this empty
            }

        });

        ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /*
         <item>Rock</item>
        <item>Mainstream</item>
        <item>Techno</item>
        <item>Regatton</item>
        <item>Trap</item>
        <item>Trance</item>

            */

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedAge = parent.getItemAtPosition(position).toString();
                if (!selectedAge.equals("NULL")) {
                    button.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // can leave this empty
            }

        });
        //=============== submit button don't touch ============//

    }


    public void submit(View view) {
/*
      Toast.makeText(WildOutActivity.this, "\n Area: \t " + selectedClass +
                "\n Genre: \t" + selectedGenre +
                "\n Age: \t" + selectedAge, Toast.LENGTH_LONG).show();
                */
        Intent intent = new Intent(this, GridViewActivity.class);
        intent.putExtra("selectedRegion", selectedClass);
        intent.putExtra("selectedGenre", selectedGenre);
        intent.putExtra("selectedAge", selectedAge);
        startActivity(intent);

    }
}
