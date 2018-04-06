package com.faisal.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.faisal.test.adapter.ItemClickListener;
import com.faisal.test.adapter.StudentAdapter;
import com.faisal.test.model.Student;
import com.faisal.test.util.ViewUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener<Student> {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new StudentAdapter(this, this));
        recyclerView.setHasFixedSize(true);
        if(getStudentAdapter()!=null)
        {
            Student student = new Student(1,"asdas","A+");
            Student student1 = new Student(2,"ghfgh","B+");
            Student student2 = new Student(3,"asfhhfgdas","C+");
            Student student3 = new Student(4,"asdgfghgfas","D+");

            List<Student> studentList= new ArrayList<>();
            studentList.add(student);
            studentList.add(student1);
            studentList.add(student2);
            studentList.add(student3);
            getStudentAdapter().addItems(studentList);


        }
    }

    @Override
    public void onItemClick(View view, Student item) {

        switch (view.getId()) {
            case R.id.buttonPress:
                Toast.makeText(this, "Button Click", Toast.LENGTH_LONG).show();
                break;

        }
    }

    private StudentAdapter getStudentAdapter() {
        RecyclerView.Adapter adapter = ViewUtils.getAdapter(recyclerView);
        return adapter == null ? null : (StudentAdapter) adapter;
    }
}
