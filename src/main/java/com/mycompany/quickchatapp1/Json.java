/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchatapp1;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Student
 */
public class Json {
    //Stores messages into a JSON file
    public static void storeMessage(Message message){

        //A Gson object is created
        Gson gson =
                new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try(FileWriter writer =
                new FileWriter("Messages.json", true)){

            //Convert message object into JSON
            gson.toJson(message, writer);

            //A new line is created after each message
            writer.write(System.lineSeparator());

            System.out.println(
                    "Message stored in JSON successfully.");

        }
        catch(IOException e){

            System.out.println(
                    "Error storing message: "
                    + e.getMessage());
        }
    }
}
