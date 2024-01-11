package com.example.barangaypayrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editname,editAmount,editDate;
    Button btnReserve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        editname = (EditText)findViewById(R.id.ename);
        editAmount = (EditText)findViewById(R.id.eAmount);
        editDate = (EditText)findViewById(R.id.edate);
        btnReserve = (Button) findViewById(R.id.btnreserve);
        AddData();

    }

    public void AddData(){
        btnReserve = (Button) findViewById(R.id.btnreserve);
        btnReserve.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                String txtName = editname.getText().toString();
                String txtType = editAmount.getText().toString();
                String txtDate = editDate.getText().toString();

                boolean isInserted =  myDb.insertData(txtName,txtType,txtDate);
                if(isInserted =  true){
                    Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                    editname.setText("");
                    editAmount.setText("");
                    editDate.setText("");

                }else{
                    Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}