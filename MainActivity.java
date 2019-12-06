package com.example.henri.pwsm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;

public class MainActivity extends AppCompatActivity  implements  validator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        validate v = new validate();

        pwsm passwordStrengthMeater = new pwsm(this, v);

        setContentView(passwordStrengthMeater);

    }

    @Override
    public int validate(String s) {
        return 0;
    }
}
