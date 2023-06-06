package com.improve10x.api;


import com.improve10x.model.Quiz;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuizServiceApi {
    @GET("api/479dd07f8c1d482e9219f7dcb48e25f4/renuTodo")
    Call<List<Quiz>> getQuestions();
}
