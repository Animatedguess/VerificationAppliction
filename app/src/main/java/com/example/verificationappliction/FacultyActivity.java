package com.example.verificationappliction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class FacultyActivity extends AppCompatActivity {

    private EditText name;
    private EditText age;
    private EditText gmail;
    private EditText password;
    private EditText qualification;
    private Button ApplyButton;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        name=findViewById(R.id.sumitName2);
        age=findViewById(R.id.sumitAge);
        gmail=findViewById(R.id.sumitGmail2);
        password=findViewById(R.id.sumitpassword);
        qualification=findViewById(R.id.sumitDegree);
        ApplyButton=findViewById(R.id.ApplyButton);
        ApplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getName = name.getText().toString();
                String getGmail= gmail.getText().toString();
                String getAge = age.getText().toString();
                String getPassword = password.getText().toString();
                String getQuelification = qualification.getText().toString();


                HashMap<String,Object> hashMap = new HashMap<>();
                hashMap.put("name",getName);
                hashMap.put("age",getAge);
                hashMap.put("gmail",getGmail);
                hashMap.put("password",getPassword);
                hashMap.put("percentage",getQuelification);
                databaseReference.child("post").child(getName).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(FacultyActivity.this, "Data added successfully", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(FacultyActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });



                Intent intent = new Intent(FacultyActivity.this,MeritListForFaculty.class);
                startActivity(intent);
            }
        });

    }
}