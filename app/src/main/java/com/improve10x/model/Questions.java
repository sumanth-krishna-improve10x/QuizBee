package com.improve10x.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Questions {
    private String number;
    private String questions;
    private ArrayList<String> answers;
    @SerializedName( "correct_answer")
    private Integer  correct_answer;
}
