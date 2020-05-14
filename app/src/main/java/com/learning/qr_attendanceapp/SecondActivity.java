package com.learning.qr_attendanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class SecondActivity extends AppCompatActivity {

    TextView textView1,textView2,textView3;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView1=findViewById(R.id.textView2);
        textView2=findViewById(R.id.textView3);
        textView3=findViewById(R.id.textView4);
        imageView=findViewById(R.id.imageView3);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();

            textView1.setText(personName);
            textView2.setText(personEmail);
            textView3.setText(personId);
            Glide.with(this).load(String.valueOf(personPhoto)).into(imageView);
        }
    }
}
