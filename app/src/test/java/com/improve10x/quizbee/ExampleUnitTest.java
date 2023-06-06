package com.improve10x.quizbee;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.improve10x.model.Quiz;
import com.improve10x.api.QuizApi;
import com.improve10x.api.QuizServiceApi;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getQuestions() throws IOException {
        QuizApi quizApi = new QuizApi();
        QuizServiceApi quizServiceApi = quizApi.createQuizServiceApi();
        Call<List<Quiz>> call = quizServiceApi.getQuestions();
        List<Quiz> quiz = call.execute().body();
        assertNotNull(quiz);
        assertFalse(quiz.isEmpty());
        System.out.println(new Gson().toJson(quiz));
    }
}