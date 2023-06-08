package com.improve10x;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.api.QuizApi;
import com.improve10x.api.QuizServiceApi;
import com.improve10x.model.Questions;
import com.improve10x.model.Quiz;
import com.improve10x.quizbee.databinding.ActivityQuestionBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionActivity extends BaseActivity {

    public ArrayList<Questions> questionList = new ArrayList<>();
    public ActivityQuestionBinding binding;
    public QuestionAdapter questionAdapter;
    int currentPosition = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //getSupportActionBar().setTitle("Question");
        getQuestion();
        setUpAdapter();
        setUpQuestionRv();
        setupNxtBtn();
        setUpPerviousBtn();
    }

    private void onBindData(Questions questions) {
        currentPosition = questions.getNumber();
        binding.questionsTxt.setText(questions.getQuestion());
        binding.radioBtn1.setText(questions.getAnswers().get(0));
        binding.radioBtn2.setText(questions.getAnswers().get(1));
        binding.radioBtn3.setText(questions.getAnswers().get(2));
        binding.radioBtn4.setText(questions.getAnswers().get(3));
    }

    private void setUpPerviousBtn() {

    }

    private void setupNxtBtn() {
        binding.nxtBtn.setOnClickListener(v -> {
            currentPosition++;
            Questions questions = questionList.get(currentPosition-1);
            onBindData(questions);
        });
    }



    private void getQuestion() {
        QuizApi quizApi = new QuizApi();
        QuizServiceApi quizServiceApi = quizApi.createQuizServiceApi();
        Call<List<Quiz>> call = quizServiceApi.getQuestions();
        call.enqueue(new Callback<List<Quiz>>() {
            @Override
            public void onResponse(Call<List<Quiz>> call, Response<List<Quiz>> response) {
                List<Quiz> quizzes = response.body();
                questionAdapter.setData(quizzes.get(0).getQuestions());
                questionList = quizzes.get(0).getQuestions();
                onBindData(questionList.get(0));
                Toast.makeText(QuestionActivity.this, "Got Question", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Quiz>> call, Throwable t) {
                Toast.makeText(QuestionActivity.this, "Failed to get Question", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setUpAdapter() {
        questionAdapter = new QuestionAdapter();
        questionAdapter.setData(questionList);
        questionAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void OnItemClicked(Questions questions) {

                onBindData(questions);
            }
        });
    }

    private void setUpQuestionRv() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.questionsRv.setLayoutManager(layoutManager);
        binding.questionsRv.setAdapter(questionAdapter);
    }
}