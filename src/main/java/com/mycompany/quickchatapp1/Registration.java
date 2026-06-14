/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchatapp1;

/**
 *
 * @author Student
 */

public class Registration {
    private String username;
    private String password;
    private String phoneNumber;

    //This method sets the values on left to right so we are able to use them later in the program
    public Registration(String username, String password, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    //This method ensures that the username is entered correctly and outputs a return message
    public String validateUsername() {
        if (username.contains("_") && username.length() <= 5) {
            return "Username successfully captured.";
        } else {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters long.";
        }
    }

    //This method ensures that the password is entered correctly and outputs a return message
    public String validatePassword() {
        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()].*");

        if (password.length() >= 8 && hasUpper && hasNumber && hasSpecial) {
            return "Password successfully captured.";
        } else {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
    }

    //This method ensures that the phone number entered is entered correctly and outputs a message
    public String validatePhoneNumber() {
        if (phoneNumber.startsWith("+27") && phoneNumber.length() <= 13) {
            return "Cell phone number successfully added.";
        } else {
            return "Cell phone number incorrectly formatted or does not contain an international code.";
        }
    }

    //Getters are used so that the login class can use the username and the password and output them
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
