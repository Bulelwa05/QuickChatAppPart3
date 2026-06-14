/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchatapp1;

/**
 *
 * @author Student
 */
public class Login {
    private String registeredUsername;
    private String registeredPassword;

    //This method  stores the registered username and password
    public Login(String registeredUsername, String registeredPassword) {
        this.registeredUsername = registeredUsername;
        this.registeredPassword = registeredPassword;
    }

    //This method check if the username and password entered in the Registration match with the login
    public boolean loginUser(String username, String password) {
        return username.equals(registeredUsername) && password.equals(registeredPassword);
    }

    //This method determines whether the user entered the correct details by outputting the appropriate message
    public String returnLoginStatus(String username, String password, String firstName, String lastName) {
        if (loginUser(username, password)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    }
