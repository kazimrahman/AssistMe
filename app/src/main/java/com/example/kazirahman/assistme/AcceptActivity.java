package com.example.kazirahman.assistme;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class AcceptActivity extends AppCompatActivity {
    TextView desc, time, location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        desc = (TextView)findViewById(R.id.accept_description);
        time = (TextView)findViewById(R.id.accept_time);
        location = (TextView)findViewById(R.id.accept_loc);
        //Bundle bundle = getIntent().getExtras();
        //String res = bundle.getString("task");

        String response = "";
        updateData ud = new updateData();
        try {
            response = ud.execute("http://192.168.42.202:1234/AssistMe/getTasks.php").get();

            if(response!= null) {
                String[] responses = response.split("<br>");
                Arrays.asList(responses);
            }
            //arrlist.add(response);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        desc.setText(response);//refer to from db
        //time.setText();
        //location.setText();
    }

    public void onDecline(View view){
        Intent intent = new Intent (getApplicationContext(), TaskListActivity.class);
        startActivity(intent);

    }

    public void onAccept(View view){
        Intent i = new Intent (getApplicationContext(), CompleteActivity.class);
        startActivity(i);

    }

    public class updateData extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection conn = null;

            try {
                URL url;
                url = new URL(params[0]);
                conn = (HttpURLConnection) url.openConnection();
                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    InputStream is = conn.getInputStream();
                    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                    StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
                    String line;
                    while ((line = rd.readLine()) != null) {
                        response.append(line);
                        response.append('\r');
                    }
                    rd.close();
                    return response.toString();
                } else {
                    InputStream err = conn.getErrorStream();

                }

                return "Done";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    conn.disconnect();
                }
            }
            return null;
        }
    }

}
