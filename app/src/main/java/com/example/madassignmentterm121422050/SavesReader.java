package com.example.madassignmentterm121422050;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @purpose:- Reads and displays the contents of a text file
 */
public class SavesReader extends AppCompatActivity {
    //get the UI elements
    TextView title;
    TextView body;
    String filename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saves_reader);

        title = findViewById(R.id.saveTitle);
        body = findViewById(R.id.saveText);

        //add extension to the filename
        filename = getIntent().getStringExtra("filename") + ".txt";

        //set the title ui to display the file name
        title.setText(filename);


        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //reads the file and displays the contents
    void readFile() throws IOException {
        FileInputStream fis = openFileInput(filename);
        //BufferedReader wraps the texts in the file making it easier to read
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(fis));
        StringBuilder textBody = new StringBuilder();

        String line;
        while((line = buffReader.readLine()) != null) {

            textBody.append(line).append("\n");
        }

        // get the body UI element to display the inner contents of the page
        body.setText(textBody.toString());
        //after the flie has been read close the file
        fis.close();
    }

}