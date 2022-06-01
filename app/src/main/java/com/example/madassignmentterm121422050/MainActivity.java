/**
 * @purpose : Login Page of the app checks if user is valid and logs the user in.
 * */

package com.example.madassignmentterm121422050;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

//     array of objects of class User with username and password
    private final User[] users =
    {
        new User("admin", "admin"),
        new User("user1", "user1"),
        new User("user2", "user2")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //login button
        Button loginBtn = findViewById(R.id.log_in_btn);
        loginBtn.setOnClickListener(v->login());
    }

    //checks the user provided credentials with all the saved User objects in the users array
    public void login() {

        //x,y username and password fields of the ui
        EditText x = findViewById(R.id.username);
        EditText y = findViewById(R.id.password);

        //get the username and password from the x and y
        String username = x.getText().toString();
        String password = y.getText().toString();

        //loops for all the users in the array and checks if the userlogin credentials are valid
        for(User u : this.users) {
            if(username.equals(u.getName()) && u.checkPassword(password)){
                    Intent intent = new Intent(this, HomeActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);
                    return;
            }
        }
        //error box
        TextView error = findViewById(R.id.error_msg);
        //if user enters wrong
        error.setText("wrong");
    }


}
