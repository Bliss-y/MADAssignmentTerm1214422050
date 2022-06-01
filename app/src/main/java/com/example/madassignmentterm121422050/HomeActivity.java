package com.example.madassignmentterm121422050;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Purpose : displays user details and acts as portal to other pages
 *
 */

public class HomeActivity extends AppCompatActivity {
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        TextView userDisplay = findViewById(R.id.usernameDisplay);

        //get intent contents and display them
        username = intent.getStringExtra("username");
        userDisplay.setText(username);

        TextView passwordDisplay = findViewById(R.id.passwordDisplay);
        passwordDisplay.setText(intent.getStringExtra("password"));

        //display the date in formatted manner
        TextView dateDisplay = findViewById(R.id.dateDisplay);
        dateDisplay.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        //portal button to diceRoller game
        Button dice = findViewById(R.id.diceRoll_btn);
        dice.setOnClickListener(v -> goDiceRoll()
        );

        //portal button to quiz game
        Button quiz = findViewById(R.id.quiz_btn);
        quiz.setOnClickListener(v -> goQuiz()
        );

        //portal to saves reader with appropriate files
        findViewById(R.id.quiz_saves_btn).setOnClickListener(v -> goSavesReader("save_quiz"));
        findViewById(R.id.dice_roll_saves_btn).setOnClickListener(v -> goSavesReader(username+"_diceRoll"));
    }

    //Creates intent of dice activity and passes in the username
    public void goDiceRoll() {
        Intent intent = new Intent(this, DiceRollActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);

    }

    //Creates the intent for quizz activity
    public void goQuiz() {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);

    }

    //Creates the intent for saves reader activity with appropriate filename
    public void goSavesReader(String type) {
        Intent intent = new Intent(this, SavesReader.class);
        intent.putExtra("filename",type);
        startActivity(intent);
    }

}