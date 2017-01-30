package com.example.kazirahman.assistme;

import android.app.Application;

/**
 * Created by haroon on 1/30/2017.
 */

public class assistMeConstants extends Application{
    private String url = "http://192.168.42.254:1234/AssistMe/";

    public String geturl() {
        return url;
    }

    public void seturl(String someVariable) {
        this.url = someVariable;
    }

}
