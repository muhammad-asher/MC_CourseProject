package com.example.mc_courseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {

    Button buttonrepo,buttonmainactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        buttonrepo=(Button) findViewById(R.id.buttonrepo);
        buttonmainactivity=(Button) findViewById(R.id.btnMainActivity);

        buttonrepo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 openWebPage("https://github.com/AbdullahrRehman");
                //openWebPage("https://github.com/muhammad-asher/MC_CourseProject");

            }
        });

        buttonmainactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }


}