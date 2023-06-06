package com.improve10x;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.improve10x.quizbee.R;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        //getSupportActionBar().setTitle("Question");
    }
}