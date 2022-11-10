package com.example.sharedpreferenceapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Integer mCount = 0;
    private TextView mCountTextView;

    private SharedPreferences mSharedPref;
    private final String sharedProfile = "com.example.sharedpreferenceapp";
    private String KEY = "COUNT_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSharedPref = getSharedPreferences(sharedProfile, MODE_PRIVATE);
        mCount = mSharedPref.getInt(KEY,0);
        mCountTextView = findViewById(R.id.tv_count);
        mCountTextView.setText(mCount.toString());
        findViewById(R.id.btn_increment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCount  > 0){
                    mCount--;
                    mCountTextView.setText(mCount.toString());
                    saveCount();
                }
            }
        });


        findViewById(R.id.btn_decrement).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                mCountTextView.setText(mCount.toString());
                saveCount();
            }
        });


    }
    private void saveCount(){
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putInt(KEY,mCount);
        editor.apply();
    }
}
