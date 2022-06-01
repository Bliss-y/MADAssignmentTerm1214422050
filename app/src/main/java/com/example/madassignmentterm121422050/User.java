/**
 * PURPOSE : user class with username and passwords and checks if password matches
 */

package com.example.madassignmentterm121422050;

public class User {
    private String username;
    private String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //returns the username of the object
    public String getName() {
        return this.username;
    }

    // if the string matches the password of that object then return true
    public boolean checkPassword(String password) {
        if(password.equals(this.password)) {
            return true;
        }
        return false;
    }

}
