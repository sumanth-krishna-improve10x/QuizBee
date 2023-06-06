package com.improve10x.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuizApi {

    public QuizServiceApi createQuizServiceApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://crudcrud.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        QuizServiceApi quizServiceApi = retrofit.create(QuizServiceApi.class);
        return quizServiceApi;
    }
}
