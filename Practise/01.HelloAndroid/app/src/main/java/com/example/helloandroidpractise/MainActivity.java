package com.example.helloandroidpractise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.helloandroidpractise.R;
import com.example.helloandroidpractise.my_classes.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String PERSON_KEY = "com.example.helloandroidpractise.PERSON_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendPersonInfo(View view) {
        EditText personNameEditText = findViewById(R.id.nameEditText);
        EditText personAgeEditText = findViewById(R.id.ageEditText);

        String personName = personNameEditText.getText().toString();
        Integer personAge = Integer.parseInt(personAgeEditText.getText().toString());

        Person person = new Person(personName, personAge);

        Intent intent = new Intent(this, PersonInfoActivity.class);
        intent.putExtra(PERSON_KEY, person);

        startActivity(intent);
    }

}
