package com.example.madassignmentterm121422050;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @purpose: Asks for user input and saves the score of quiz to a file
 */
public class QuizSaveActivity extends AppCompatActivity {
    private static final String FILE_NAME = "save_quiz.txt";
    String username;
    String score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_save);
        score = getIntent().getStringExtra("score");
        TextView message = findViewById(R.id.message);

        //display the message to the user
        message.setText("You scored "+score+"\nWrite your name to save your score!!");

        findViewById(R.id.save_file_btn_quiz).setOnClickListener(v -> newfile());

    }

    //appends to file || creates new file if no file exists
    public void newfile(){
        username = ((EditText)findViewById(R.id.get_user)).getText().toString();
        String a = "\n"+username + " scored " + score + " on " + new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        try (FileOutputStream fos = openFileOutput(FILE_NAME, MODE_PRIVATE | MODE_APPEND)) {
            fos.write(a.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //return to the quiz game
            Intent intent = new Intent(this, QuizActivity.class);
            startActivity(intent);
        }

    }

}