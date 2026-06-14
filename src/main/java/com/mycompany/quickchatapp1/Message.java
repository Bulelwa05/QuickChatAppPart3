/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchatapp1;
import java.util.Random;

/**
 *
 * @author Student
 */
public class Message {

 //This class handles all message functionalities such as validation, message creation, hashing and storing the counts
    private String recipient;
    private String message;
    private String messageID;
    private int messageNumber;

    // This counter keeps track of how many messages are sent
    private static int totalMessages = 0;

    //A constructor is created
    public Message(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
        this.messageNumber = ++totalMessages;
        this.messageID = generateMessageID();
    }

    //This method checks that message ID is not more than 10 digits
    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }

    // This method checks recipient number format
    public boolean checkRecipientCell() {
        return recipient.startsWith("+") && recipient.length() <= 13;
    }

    //This method generates a random 10-digit message ID
    private String generateMessageID() {
        Random rand = new Random();
        long number = (long)(Math.random() * 10000000000L);
        return String.valueOf(number);
    }

    //This method creates the message hash
    public String createMessageHash() {
        String[] words = message.split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        String firstTwo = messageID.length() >= 2 ? messageID.substring(0, 2) : "00";

        return firstTwo + ":" + messageNumber + ":" + firstWord + lastWord;
    }

    //This method handles sending messages
    public String sendMessage(int choice) {
        // If statement is created to decide if the message entered is less than 250 characters
        if (message.length() > 250) {
            return "Please enter a message of less than 250 characters.";
        }
      
        if (choice == 1) {
            return "Message successfully sent."; //If user's input matches the if statment then this becomes output
        } else if (choice == 2) {
            return "Press 0 to delete the message."; // If user's input matches the else-if statment then this becomes output
        } else {
            Json.storeMessage(this); //Message is stored in JSON
            return "Message successfully stored.";
        }
    }

    //This method returns message details
    public String printMessageDetails() {
        return "Message ID: " + messageID +
               "Message Hash: " + createMessageHash() +
               "Recipient: " + recipient +
               "Message: " + message;
    }

    //This method returns the total messages sent
    public int returnTotalMessages() {
        return totalMessages;
    }

    //Getters are created to return the messageID and the message
    public String getMessageID() {
        return messageID;
    }

    public String getMessage() {
        return message;
    }
    
    //this getter returns recipient number
    public String getRecipient() {
        return recipient;
    }

    //This getteer returns the message hash
    public String getMessageHash() {
        return createMessageHash();
    }
}
