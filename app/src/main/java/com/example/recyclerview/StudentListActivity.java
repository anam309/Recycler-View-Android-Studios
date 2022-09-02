package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class StudentListActivity extends AppCompatActivity {
    RecyclerView recyclerview;
    ArrayList<Students> studentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.recyclerview);
        studentArrayList=initStudentList();
        initRecyclerView();
    }

    private ArrayList<Students> initStudentList() {
        ArrayList<Students> studentArrayList = new ArrayList<>();
        Students student1=new Students("Anam","0000");
        Students student2=new Students("Shahzad","1111");
        Students student3=new Students("Ahsan","2222");
        Students student4=new Students("Faizan","3333");
        Students student5=new Students("Hamna","4444");
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(student3);
        studentArrayList.add(student4);
        studentArrayList.add(student5);

        return studentArrayList;

    }

    private void initRecyclerView() {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerview.setAdapter(recyclerViewAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewAdapter.setData(studentArrayList);
    }
}