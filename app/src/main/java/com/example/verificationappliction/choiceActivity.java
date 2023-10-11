package com.example.verificationappliction;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class choiceActivity extends AppCompatActivity {
    private TextView StudentText;
    private TextView FacultyText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        StudentText=findViewById(R.id.student);
        FacultyText=findViewById(R.id.facutly);
        StudentText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choiceActivity.this,StudentActivity.class);
                startActivity(intent);
            }
        });
        FacultyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choiceActivity.this,FacultyActivity.class);
                startActivity(intent);
            }
        });
    }
}