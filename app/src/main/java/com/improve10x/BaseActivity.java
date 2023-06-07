package com.improve10x;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.improve10x.api.QuizApi;
import com.improve10x.api.QuizServiceApi;
import com.improve10x.quizbee.R;

public class BaseActivity extends AppCompatActivity {

    protected QuizServiceApi quizServiceApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpQuizApiService();
    }

    private void setUpQuizApiService() {
        QuizApi quizApi = new QuizApi();
        quizServiceApi = quizApi.createQuizServiceApi();


    }
}