package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Students> studentArrayList=new ArrayList<Students>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Students student=studentArrayList.get(position);
        StudentViewHolder studentViewHolder= (StudentViewHolder) holder;

        studentViewHolder.student_name.setText(student.getName());
        studentViewHolder.student_phone.setText(student.getPhone());
        studentViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "name is "+student.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }
    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView student_name,student_phone;


        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            student_name = itemView.findViewById(R.id.studentname);
            student_phone=itemView.findViewById(R.id.studentphone);
        }
    }

    public void setData(ArrayList<Students>studentArrayList){
        this.studentArrayList=studentArrayList;
        notifyDataSetChanged();

    }


}
