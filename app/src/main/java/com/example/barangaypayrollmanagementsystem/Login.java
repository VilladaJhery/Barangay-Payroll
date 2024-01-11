package com.example.barangaypayrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private TextView Tlogin;
    EditText euser,epass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        euser = (EditText)findViewById(R.id.Euser);
        epass = (EditText)findViewById(R.id.Epass);
        Tlogin = (TextView) findViewById(R.id.Tlogin);
        Tlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openDashboard(); }
        });

    }

    public void openDashboard (){

        String txtuser = euser.getText().toString();
        String txtpass = epass.getText().toString();
        String user = "admin";
        String pass = "Villada123";


        if(user.equals(txtuser) && pass.equals(txtpass)) {
            Intent intent = new Intent(this, Options.class);
            startActivity(intent);
        }else {
            Toast.makeText(Login.this,"Wrong Username & Password",Toast.LENGTH_LONG).show();
        }

    }

}