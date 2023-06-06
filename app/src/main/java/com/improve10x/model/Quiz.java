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

}
