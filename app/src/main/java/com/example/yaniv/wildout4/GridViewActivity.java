package com.example.yaniv.wildout4;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Club> clubList;
    DatabaseHelper databaseHelper;
    Adaptor adapter;
    //SecondaryAdapter adapter;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        databaseHelper = new DatabaseHelper(GridViewActivity.this);

        Bundle extras = getIntent().getExtras();
        String region = extras.getString("selectedRegion");
        String genre = extras.getString("selectedGenre");
        String age = extras.getString("selectedAge");

        gridView = (GridView) findViewById(R.id.gridview);
        //byte[]b = {0};
        //Club clb= new Club("Fake Club", "North", "21", "Dubfake",b);
        //databaseHelper.createClub(clb);
        clubList = new ArrayList<Club>();

        //clubList = databaseHelper.getAllClub();
        clubList = databaseHelper.getAllClubs2motherfucjer();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!1"+clubList.toString());
        //For specific Clubs:
        //clubList = databaseHelper.getProperClub(region,genre,age);
       // adapter = new MyAdapter(MainActivity.this, employeeList);
        adapter = new Adaptor(GridViewActivity.this, clubList);

        //For Idan's grid:
        //adapter = new SecondaryAdapter(MainActivity.this, clubList);

        gridView.setAdapter(adapter);
    }
    /*
    @Override
    public void onResume(){
        super.onResume();
        clubList = databaseHelper.getAllClub();
        adapter = new ClubAdapter(MainActivity.this, clubList);
        gridView.setAdapter(adapter);

    }
    */

    public void openActivity2(){

        Intent intent = new Intent(this,AddActivity2.class);
        startActivity(intent);
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}