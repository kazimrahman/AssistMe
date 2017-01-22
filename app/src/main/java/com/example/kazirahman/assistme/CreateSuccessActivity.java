package com.example.kazirahman.assistme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CreateSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_success);
    }

    public void onFinishCreate(View vew){
        Intent intent = new Intent(this, ChooseActivity.class);
        startActivity(intent);

    }
}
