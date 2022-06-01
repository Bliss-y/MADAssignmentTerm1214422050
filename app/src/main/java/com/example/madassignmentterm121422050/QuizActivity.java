package com.example.madassignmentterm121422050;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Purpose: - quiz game that displays questions and takes answer inputs. check if answer is correct and displayes score
 */
public class QuizActivity extends AppCompatActivity {

    //creating array of objects of Question
    Question[] questions = {
        new Question("Who is President of Nepal?", "bidhya devi bhandari"),
        new Question("Who is Prime Minister of Nepal?", "sher bahadur deuba"),
        new Question("How many provinces are there in Nepal?(write in number)", "7"),
        new Question("How many districts are there in Nepal?(write in number)", "77"),
        new Question("How many countries are there in the World?(write in number)", "193"),
        new Question("How many bones does a baby has?(write in number)", "300"),
        new Question("How many fingers does a person have?(write in number)", "20"),
        new Question("How many nails does a person have?(write in number)", "20"),
        new Question("How many letters are there in english Alphabets?(write in number)", "26"),
        new Question("How many letters are there in nepali Alphabets?(write in number)", "37")
    };

    //store global variable score and question number
    private int score = 0;
    private int questionNumber=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //display the first question
        viewQuestion();

        //set onclick listener for submit button
        (findViewById(R.id.next_btn)).setOnClickListener(v -> checkAnswer());

    }

    //checks answer and updates score then updates question number and changes the question
    public void checkAnswer() {
        String answer =((EditText)findViewById(R.id.get_answer)).getText().toString();
        if(answer.equals(this.questions[questionNumber].getAnswer())){
            this.score++;
            updateScore();
        }
        this.questionNumber++;

        //if all the questions have been displayed go to save activity
        if(this.questionNumber > this.questions.length-1) {
            saveUser();
            return;
        }
        //change question
        viewQuestion();

    }

    //displays the questions according to the question number and resets the answer feild
    public void viewQuestion() {

        if(this.questionNumber > this.questions.length-1) {
            return;
        }
        ((TextView)findViewById(R.id.questionDisplay)).setText(this.questions[this.questionNumber].getQuestion());
        ((EditText)findViewById(R.id.get_answer)).setText("");
    }


    //updates and displays score

    public void updateScore() {
        if(this.questionNumber > this.questions.length-1) {
            return;
        }
        ((TextView)findViewById(R.id.scoreDisplay)).setText("Score: "+score);
    }

    //creates intent to quizSave activity and passes score
    public void saveUser() {
        Intent intent = new Intent(this, QuizSaveActivity.class);
        intent.putExtra("score", ""+this.score);
        startActivity(intent);
        return;
    }





}

