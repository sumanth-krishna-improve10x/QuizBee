package com.improve10x;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.improve10x.quizbee.R;
import com.improve10x.quizbee.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpBtn();
    }

    private void setUpBtn() {
        binding.startBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this,QuestionActivity.class);
            startActivity(intent);
        });
    }
}