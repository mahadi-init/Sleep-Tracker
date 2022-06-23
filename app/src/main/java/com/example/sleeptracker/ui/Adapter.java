package com.example.sleeptracker.ui;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sleeptracker.databinding.CardviewBinding;
import com.example.sleeptracker.model.Record;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private final ArrayList<Record> recordArrayList;

    public Adapter(ArrayList<Record> recordArrayList) {
        this.recordArrayList = recordArrayList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private final CardviewBinding binding;

        public ViewHolder(@NonNull CardviewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(CardviewBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @SuppressLint({"SetTextI18n", "ClickableViewAccessibility"})
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Record record = recordArrayList.get(position);
        holder.binding.date.setText(record.getDate());
        holder.binding.wakeup.setText("Wakeup : " + record.getWakeup());
        holder.binding.sleep.setText("Sleep : " + record.getSleep());
    }

    @Override
    public int getItemCount() {
        return recordArrayList.size();
    }
}
