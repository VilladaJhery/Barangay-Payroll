package com.example.barangaypayrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class DoneList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> id, name, amount, dateR;
    DatabaseHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done_list);

        DB = new DatabaseHelper(this);
        id = new ArrayList<>();
        name = new ArrayList<>();
        amount = new ArrayList<>();
        dateR = new ArrayList<>();
        recyclerView = findViewById(R.id.list);
        adapter = new MyAdapter(this,id,name,amount,dateR);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }
    private void displaydata() {

        Cursor cursor = DB.getdata();
        if(cursor.getCount() == 0){
            Toast.makeText(DoneList.this,"No Entry Exists",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                amount.add(cursor.getString(2));
                dateR.add(cursor.getString(3));
            }
        }
    }

}