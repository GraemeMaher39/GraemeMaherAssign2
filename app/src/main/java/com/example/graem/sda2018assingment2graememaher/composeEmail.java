package com.example.graem.sda2018assingment2graememaher;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class composeEmail extends AppCompatActivity {
    public static final String TO_FIELD =   "To"; // String created to contain To field
    public static final String SUB_FIELD = "Sub";// String created to contain Subject field
    public static final String COMPOSE_FIELD ="Compose"; // String created to contain Compose field
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_email);    //set view to correct layout activity_compose_email
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    public void onClickEmailSend(View view){
        Intent backToMain = new Intent(this, MainActivity.class);
        EditText editTextTo = findViewById(R.id.editText); // Set editTextTo to the user input in the to field
        EditText editTextSubject = findViewById(R.id.editText2); // Set editTextSubject to the user input in the  Subject field
        EditText editTextCompose = findViewById(R.id.editText3);  // Set editTextCompose to the user input in the body field
        String to = editTextTo.getText().toString();              //Set String to , to editTextTo
        String sub = editTextSubject.getText().toString();         //Set String sub , to editTextSubject
        String compose = editTextCompose.getText().toString();      //Set String compose, to editTextCompose
        backToMain.putExtra(TO_FIELD, to);
        backToMain.putExtra(SUB_FIELD,sub);
        backToMain.putExtra(COMPOSE_FIELD,compose);
        startActivity(backToMain);                     //Start activity
    }
}
