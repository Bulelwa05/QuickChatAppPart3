/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestingClasses;

import com.mycompany.quickchatapp1.Registration;
import com.mycompany.quickchatapp1.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class TestingQuickChatApp1 {
    
    // The correct user name is tested
    @Test
    public void testCorrectUsername() {
        Registration reg = new Registration("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        //This method comapres the two values (actual , expected) and they do match so the program continues to run
        assertEquals("Username successfully captured.", reg.validateUsername());
    }

    // The incorrect username is tested
    @Test
    public void testIncorrectUsername() {
        Registration reg = new Registration("kyle!!!!!!!", "Passw0rd!", "08966553");
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters long.", reg.validateUsername());
    }

    // The correct password is tested
    @Test
    public void testCorrectPassword() {
        Registration reg = new Registration("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Password successfully captured.", reg.validatePassword());
    }

    //The incorrect password is tested
    @Test
    public void testIncorrectPassword() {
        Registration reg = new Registration("kyle!!!!!!!", "Password!", "088966553");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", reg.validatePassword());
    }

    //The correct phone number is tested
    @Test
    public void testCorrectPhoneNumber() {
        Registration reg = new Registration("kyl_1", "Ch&&sec@ke99!", "+2783896897");
        assertEquals("Cell phone number successfully added.", reg.validatePhoneNumber());
    }

    //The incorrect phone number is tested
    @Test
    public void testIncorrectPhoneNumber() {
        Registration reg = new Registration("kyle!!!!!!!", "Passw0rd!", "08966553");
        assertEquals("Cell phone number incorrectly formatted or does not contain an international code.", reg.validatePhoneNumber());
    }

    // The login is tested
    @Test
    public void testSuccessfulLogin() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!");
        assertEquals("Welcome Kyle Smith, it is great to see you again.",
            login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith"));
    }

    @Test
    public void testFailedLogin() {
        Login login = new Login("kyl_1", "Passw0rd!");
        assertEquals("Username or password incorrect, please try again.",
            login.returnLoginStatus("wrongUser", "wrongPass", "Kyle", "Smith"));
    }
    
    }


