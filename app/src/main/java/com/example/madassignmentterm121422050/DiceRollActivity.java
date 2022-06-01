package com.example.madassignmentterm121422050;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * @purpose:- Simulate a dice roller game between two players and save the winner to a file
 */
public class DiceRollActivity extends AppCompatActivity {

    //prepare to get all the ui elements
    ImageView player1Dice;
    ImageView player2Dice;
    TextView player1;
    TextView player2;
    TextView player1Rolled;
    TextView player2Rolled;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll);

        //set ui elements to the variables
        player1Dice = findViewById(R.id.dice1);
        player2Dice = findViewById(R.id.dice2);
        player1Rolled = findViewById(R.id.rolled1);
        player2Rolled = findViewById(R.id.rolled2);
        player1 = findViewById(R.id.player1_get);
        player2 = findViewById(R.id.player2_get);

        //get username from intent
        username = getIntent().getStringExtra("username");

        findViewById(R.id.Roll_btn).setOnClickListener(v->{
            roll();
        });
    }

    public void roll() {
        // generate and store 2 random numbers
        int rolled1 = (int)(Math.random()*6 + 1);
        int rolled2 = (int)(Math.random()*6 + 1);

        //change the image to the image with the number that the players rolled from prev random number
        int imageResource1ID=getResources().getIdentifier("dice_"+rolled1, "drawable","com.example.madassignmentterm121422050");
        int imageResource2ID=getResources().getIdentifier("dice_"+rolled2, "drawable","com.example.madassignmentterm121422050");
        player1Dice.setImageResource(imageResource1ID);
        player2Dice.setImageResource(imageResource2ID);

        // Display what users scored in text
        player1Rolled.setText("Rolled: " + rolled1);
        player2Rolled.setText("Rolled: " + rolled2);


        //if the game is draw dont save
        if(rolled1==rolled2) {
            return;
        }
        //determine winner and call the newfile function on that player
        if (rolled1 > rolled2) {
            newfile(rolled1, player1.getText().toString());
        } else {
            newfile(rolled2, player2.getText().toString());
        }

    }
    // saves the file with the username and what they scored
    public void newfile(int roll, String winner){
        final String FILE_NAME = username+"_diceRoll.txt";
        String a ="\n"+ winner + " won by rolling " + roll;
        try (FileOutputStream fos = openFileOutput(FILE_NAME, MODE_PRIVATE | MODE_APPEND)) {
            fos.write(a.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }   finally {
            //display that the file has been saved no need to close file rightaway
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        }


    }
}