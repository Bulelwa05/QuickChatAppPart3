/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchatapp1;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Student
 */
public class QuickChatApp1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // The user is asked to input first name
        System.out.println("Please enter your first name ");
        String firstName = scanner.nextLine();
        
        //The user is asked to input last name
        System.out.println("Please enter your last name");
        String lastName = scanner.nextLine();
        
        //The user is asked to input cell number
        System.out.print("Please enter cell phone number with +27: ");
        String phoneNumber = scanner.nextLine();
                
        //The user is asked to input username
        System.out.print("Please enter username: ");
        String username = scanner.nextLine();

        //The user is asked to input password
        System.out.print("Please enter password: ");
        String password = scanner.nextLine();

        // A registration object is created to ensure that the details entered are correct
        Registration reg = new Registration(username, password, phoneNumber);
        System.out.println(reg.validateUsername());
        System.out.println(reg.validatePassword());
        System.out.println(reg.validatePhoneNumber());

        // These messages get output if the user entered registration details correctly
        if (reg.validateUsername().equals("Username successfully captured.") &&
            reg.validatePassword().equals("Password successfully captured.") &&
            reg.validatePhoneNumber().equals("Cell phone number successfully added.")) {
            System.out.println("Registration successful.");

    //This is login input
    System.out.print("Please enter your username: ");
    String loginUsername = scanner.nextLine();

    System.out.print("Please enter your password: ");
    String loginPassword = scanner.nextLine();

    //A login object
    Login login = new Login(reg.getUsername(), reg.getPassword());

    // Login message
    String loginMessage = login.returnLoginStatus(
            loginUsername, loginPassword, firstName, lastName);

    System.out.println(loginMessage);

    //The code continues if the login from the useer is successful
    if (loginMessage.contains("great to see you again")) {

        System.out.println("Welcome to QuickChat.");

        //Asks how many messages user wants to send
        System.out.println("How many messages would you like to send?");
        int messageLimit = scanner.nextInt();
        scanner.nextLine();

        //Stores all sent messages
        ArrayList<Message> sentMessages = new ArrayList<>();

        //Stores all stored messages
        ArrayList<Message> storedMessages = new ArrayList<>();

        //Stores all disregarded messages
        ArrayList<Message> disregardedMessages = new ArrayList<>();

        //Stores all message hashes
        ArrayList<String> messageHashes = new ArrayList<>();

        //Stores all message IDs
        ArrayList<String> messageIDs = new ArrayList<>();

        //A loop is created for sending messages/recipient
        for (int i = 0; i < messageLimit; i++) {
            System.out.println("Enter recipient number:");
            String recipient = scanner.nextLine();

            System.out.println("Enter message:");
            String msg = scanner.nextLine();

            Message message = new Message(recipient, msg);
            //The Message option menu is created
            System.out.println("Choose an option:");
            System.out.println("1) Send Message");
            System.out.println("2) Disregard Message");
            System.out.println("3) Store Message");

            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println(message.sendMessage(choice));

            //If user chooses Send Message
            if (choice == 1) {
                sentMessages.add(message);
                messageHashes.add(message.getMessageHash());
                messageIDs.add(message.getMessageID());
                System.out.println(message.printMessageDetails());
            }

            //If user chooses Disregard Message
            else if (choice == 2) {
                disregardedMessages.add(message);
            }

            //If user chooses Store Message
            else if (choice == 3) {
                storedMessages.add(message);
                messageHashes.add(message.getMessageHash());
                messageIDs.add(message.getMessageID());
                System.out.println(message.printMessageDetails());
            }
        }
        
    //Stored Messages Menu
    System.out.println("\nStored Messages Menu");
    System.out.println("1. Display sender and recipient");
    System.out.println("2. Display longest stored message");
    System.out.println("3. Search Message ID");
    System.out.println("4. Search Recipient");
    System.out.println("5. Delete Message by Hash");
    System.out.println("6. Display Report");

    int storedChoice = scanner.nextInt();
    scanner.nextLine();
    
    // Option 1, This displays sender and recipient details for all stored messages
    if (storedChoice == 1) {
        for (Message stored : storedMessages) { //Loops through the stored messages
            System.out.println("Sender: Developer");
            System.out.println("Recipient: " + stored.getRecipient());
    }
    }
    // Option 2, this finds and displays the longest stored message
    else if (storedChoice == 2) {
            String longestMessage = "";
            for (Message stored : storedMessages) {
                if (stored.getMessage().length()> longestMessage.length()) { // Compares message lengths to find the longest one
                    longestMessage = stored.getMessage();
        }
    }

    System.out.println("Longest message: " + longestMessage);
}
    
    // Option 3, searchs for a message using the Message ID
    else if (storedChoice == 3) {
        System.out.println("Enter Message ID:");

    String searchID = scanner.nextLine();

    boolean found = false;

    for (Message stored : storedMessages) {
        if (stored.getMessageID().equals(searchID)) {
            System.out.println("Recipient: " + stored.getRecipient());
            System.out.println("Message: " + stored.getMessage());
            found = true;
        }
    }
    
    // A message is displayed if the message is not found
    if (!found) {
        System.out.println("Message ID not found.");
    }
}
    // Option 4: Search messages by recipient number
    else if (storedChoice == 4) {
        System.out.println("Enter recipient number:");

    String searchRecipient = scanner.nextLine();

    boolean found = false;

    // Loop through stored messages to find recipient matches
    for (Message stored : storedMessages) {
        if (stored.getRecipient().equals(searchRecipient)) {
            System.out.println(stored.getMessage()); // Display messages for that recipient
            found = true;
        }
    }
    
    // If no messages found for recipient
    if (!found) {
        System.out.println("No messages found for this recipient.");
    }
}
    // Option 5: Delete a message using message hash
    else if (storedChoice == 5) {
        System.out.println("Enter message hash:");

    String hashToDelete = scanner.nextLine();

    boolean deleted = false;

    // Loop through stored messages to find matching hash
    for (int i = 0; i < storedMessages.size(); i++) {
        if (storedMessages.get(i).getMessageHash().equals(hashToDelete)) { // Confirm deletion of message
            System.out.println("Message: \"" + storedMessages.get(i).getMessage()+ "\" successfully deleted.");

            // Remove message from array list
            storedMessages.remove(i);

            deleted = true;

            break;
        }
    }

    // If statement is declared if no matching hash is found
    if (!deleted) {
        System.out.println("Message hash not found.");
    }
}
    // Option 6, displays full the report of sent messages
    else if (storedChoice == 6) {

    System.out.println("\nMESSAGE REPORT");

    // Outputs the full message details
    for (Message sent : sentMessages) {
        System.out.println("Message Hash: " + sent.getMessageHash());
        System.out.println("Recipient: " + sent.getRecipient());
        System.out.println("Message: " + sent.getMessage());
        System.out.println("-------------------");
    }
}
}
    }
}
}



    

    

    

