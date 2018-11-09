package com.example.graem.sda2018assingment2graememaher;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Assign2";

    /**Citations and references **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.buttonSend); // initialise button
        btn.setEnabled(false);                              //set button to disabled

        Intent intent = getIntent();
        String to = intent.getStringExtra(composeEmail.TO_FIELD);
        String sub = intent.getStringExtra(composeEmail.SUB_FIELD);
        String compose = intent.getStringExtra(composeEmail.COMPOSE_FIELD);
        TextView textView = findViewById(R.id.textViewEmailText);

        if (to==null && sub==null) // if to and sub are empty
        {
            textView.setText(""); //set textView textViewEmailText empty
        }else{
            textView.setText("To: "+to+"\n"+"Subject:"+sub+"\nCompose: "+compose);  // otherwise set to the contents of to, sub and compose
            btn.setEnabled(true);
        }



    }

    public void onClickCamera(View view){
        Intent cameraIntent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA); //Onclick event launch camera, Stack overflow
        startActivity(cameraIntent);
       Log.v(TAG, "Camera started");
    }


    public void onClickGalley(View view){
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI); //Onclick event launch Gallery, Stack overflow
        startActivity(galleryIntent);
        Log.v(TAG, "Gallery open");
    }
    public void onClickEmailCompose(View view){
        Intent emailComposeIntent = new Intent(this, composeEmail.class);// onclick intent compose email launch java cass composeEmail
        startActivity(emailComposeIntent);

    }

    public void onClickButtonSend(View view){           //Onclick event Send
        Log.i(TAG, "Button Pressed");
        Intent buttonIntent = getIntent();
        String to = buttonIntent.getStringExtra(composeEmail.TO_FIELD); // sets contents of to as TO_FIELD
        String sub = buttonIntent.getStringExtra(composeEmail.SUB_FIELD); // sets contents of sub as SUB_FIELD
        String compose = buttonIntent.getStringExtra(composeEmail.COMPOSE_FIELD); // sets contents of compose as COMPOSE_FIELD
        Intent email = new Intent(Intent.ACTION_SENDTO);
        email.setType("message/rfc822"); //opens only email apps - Stack OverFlow
        email.setData(Uri.parse("mailto:"+to)); // name or recipient
        email.putExtra(Intent.EXTRA_SUBJECT, sub); // Subject
        email.putExtra(Intent.EXTRA_TEXT,compose); //Content
        startActivity(Intent.createChooser(email, "Send Email")); // start activity
        Log.v(TAG, "Email Template Opened");
    }







    }
