package com.improve10x;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.model.Questions;
import com.improve10x.quizbee.databinding.QuestionItemBinding;

import java.util.List;


public class QuestionAdapter extends RecyclerView.Adapter<QuestionViewHolder> {

    private List<Questions> questions;
    private int quizId;

    OnItemActionListener onItemActionListener;

    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }

    void setData(List<Questions> questions){
        this.questions = questions;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        QuestionItemBinding binding = QuestionItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        QuestionViewHolder questionViewHolder = new QuestionViewHolder(binding);
        return questionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Questions question = questions.get(position);
        holder.binding.questionTxt.setText(String.valueOf(question.getNumber()));
        holder.binding.getRoot().setOnClickListener(v -> {
            onItemActionListener.OnItemClicked(question);
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
}
