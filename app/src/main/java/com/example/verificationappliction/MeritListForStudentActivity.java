package com.example.verificationappliction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MeritListForStudentActivity extends AppCompatActivity {

    private TextView textView;
    private List<Post> list;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merit_list_for_student);
        textView= findViewById(R.id.text);

        FirebaseDatabase.getInstance().getReference().child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s = "";
                list = new ArrayList<>();
                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    s = s + "\n" + "Name : " + snapshot1.child("name").getValue().toString()+"\n" +
                            "Age : " + snapshot1.child("age").getValue().toString()+"\n" +
                            "Gmail Id : " + snapshot1.child("gmail").getValue().toString()+"\n" +
                            "Password : " + snapshot1.child("password").getValue().toString()+"\n" +
                            "Percentage : " + snapshot1.child("percentage").getValue().toString()+"\n\n";
                    Post post = snapshot1.getValue(Post.class);
                    list.add(post);
                }
                textView.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}