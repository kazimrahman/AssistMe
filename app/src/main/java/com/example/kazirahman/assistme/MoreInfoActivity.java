package com.example.kazirahman.assistme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MoreInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
    }

    public void onSubmit(View view){
        Intent i = new Intent(this, CreateSuccessActivity.class);
        startActivity(i);

    }
}
