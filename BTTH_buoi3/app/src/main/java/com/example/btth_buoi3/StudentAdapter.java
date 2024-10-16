package com.example.btth_buoi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private final List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student currentItem = students.get(position);
        holder.bind(currentItem);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvFullname, tvGpa;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvID);
            tvFullname = itemView.findViewById(R.id.tvFullname);
            tvGpa = itemView.findViewById(R.id.tvGpa);
        }

        public void bind(Student student) {
            tvId.setText(student.getId());
            String fullName = student.getFullName().getFirst() + " " +
                    student.getFullName().getMidd() + " " +
                    student.getFullName().getLast();
            tvFullname.setText(fullName);
            tvGpa.setText(String.valueOf(student.getGpa()));
        }
    }
}
