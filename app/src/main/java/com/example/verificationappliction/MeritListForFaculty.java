package com.example.verificationappliction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MeritListForFaculty extends AppCompatActivity {

    private TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merit_list_for_faculty);
        textView= findViewById(R.id.text2);
        FirebaseDatabase.getInstance().getReference().child("post").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s = "";
                ArrayList<Object> list = new ArrayList<>();
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