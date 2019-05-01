package com.example.helloandroidpractise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.helloandroidpractise.my_classes.Person;

public class PersonInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);

        Intent intent = getIntent();
        Person person = intent.getParcelableExtra(MainActivity.PERSON_KEY);

        TextView personNameTextView = findViewById(R.id.nameDisplayTextView);
        TextView personAgeTextView= findViewById(R.id.ageDisplayTextView);

        personNameTextView.setText(person.getName());
        personAgeTextView.setText(person.getAge().toString());
    }
}
