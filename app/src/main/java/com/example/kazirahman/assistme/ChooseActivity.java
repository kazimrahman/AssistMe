package com.example.kazirahman.assistme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseActivity extends AppCompatActivity {

    Button choose, create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        choose = (Button)findViewById(R.id.choose_task);
        create = (Button)findViewById(R.id.create_task);

    }
    public void goToFind(View view)
    {
        Intent intent = new Intent(this, TaskListActivity.class);
        startActivity(intent);
    }
    public void goToCreate(View view)
    {
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }
}
