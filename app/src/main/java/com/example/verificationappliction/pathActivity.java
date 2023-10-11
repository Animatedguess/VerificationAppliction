package com.example.verificationappliction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pathActivity extends AppCompatActivity {

    private TextView pathText;
    private Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);
        pathText=findViewById(R.id.path_ID);
        checkButton=findViewById(R.id.checkButton);
        pathText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pathActivity.this,TierActivity.class);
                startActivity(intent);
            }
        });
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pathActivity.this,MeritListForFaculty.class);
                startActivity(intent);
            }
        });
    }
}