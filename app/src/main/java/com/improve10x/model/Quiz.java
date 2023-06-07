package com.improve10x.model;

import com.google.gson.annotations.SerializedName;
import com.improve10x.model.Module;

import java.util.ArrayList;

public class Quiz {

    @SerializedName("_id")
    private String id;
    @SerializedName("module")
    private Module module;
    @SerializedName("questions")
    private ArrayList<Questions> questions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public ArrayList<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Questions> questions) {
        this.questions = questions;
    }
}
