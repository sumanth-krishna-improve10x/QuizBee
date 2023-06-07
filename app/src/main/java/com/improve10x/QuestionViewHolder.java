package com.improve10x;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.quizbee.databinding.QuestionItemBinding;

public class QuestionViewHolder extends RecyclerView.ViewHolder {
    public QuestionItemBinding binding;
    public QuestionViewHolder(QuestionItemBinding questionItemBinding) {
        super(questionItemBinding.getRoot());
        binding = questionItemBinding;
    }
}
