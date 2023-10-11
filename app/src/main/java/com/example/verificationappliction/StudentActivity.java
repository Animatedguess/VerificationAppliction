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

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import org.w3c.dom.Document;

import java.util.HashMap;

public class StudentActivity extends AppCompatActivity {

    private EditText name;
    private EditText age;
    private EditText gmail;
    private EditText password;
    private EditText percentage;
    private Button saveButton;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        AwesomeValidation awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();


        name=findViewById(R.id.sumitName);
        age=findViewById(R.id.SumitAge);
        gmail=findViewById(R.id.sumitGmail);
        password=findViewById(R.id.Sumitpassword);
        percentage=findViewById(R.id.SumitPercentage);
        saveButton=findViewById(R.id.saveButton);

        awesomeValidation.addValidation(this,R.id.SumitAge,"[1-9]$",R.string.invalid_age);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getName = name.getText().toString();
                String getGmail= gmail.getText().toString();
                String getPassword = password.getText().toString();
                String getPercentage = percentage.getText().toString();
                String getAge = age.getText().toString();
                HashMap<String,Object> hashMap = new HashMap<>();
                hashMap.put("name",getName);
                hashMap.put("age",getAge);
                hashMap.put("gmail",getGmail);
                hashMap.put("password",getPassword);
                hashMap.put("percentage",getPercentage);


                databaseReference.child("Users").child(getName).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(StudentActivity.this, "Data added successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(StudentActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });



                Intent intent = new Intent(StudentActivity.this,pathActivity.class);
                startActivity(intent);
            }
        });
    }
}