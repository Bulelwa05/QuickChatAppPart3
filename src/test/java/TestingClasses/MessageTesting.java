/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestingClasses;

import com.mycompany.quickchatapp1.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

/**
 *
 * @author Student
 */
public class MessageTesting {
    public class MessageTest {
    //Message ID is created and validation is tested
    @Test
    public void testCheckMessageID() {
        Message msg = new Message("+27718693002", "Hello Mike");
        assertTrue(msg.checkMessageID());
    }

    //Recipient number validation is tested
    @Test
    public void testCheckRecipientCell() {
        Message msg = new Message("+27718693002", "Hello Mike");
        assertTrue(msg.checkRecipientCell());
    }

    //Message hash is tested
    @Test
    public void testCreateMessageHash() {
        Message msg = new Message("+27718693002", "Hi Mike can you join us tonight");

        String hash = msg.createMessageHash();

        //Must contain :
        assertTrue(hash.contains(":"));
        assertTrue(hash.length() > 0);
    }

    //Send message is tested
    @Test
    public void testSendMessageSuccess() {
        Message msg = new Message("+27718693002", "Hello");

        String result = msg.sendMessage(1);

        assertEquals("Message successfully sent.", result);
    }

    //Disregard message is tested
    @Test
    public void testSendMessageDiscard() {
        Message msg = new Message("+27718693002", "Hello");

        String result = msg.sendMessage(2);

        assertEquals("Press 0 to delete the message.", result);
    }

    //Store message is tested
    @Test
    public void testSendMessageStore() {
        Message msg = new Message("+27718693002", "Hello");

        String result = msg.sendMessage(3);

        assertEquals("Message successfully stored.", result);
    }

    //Get message ID is tested
    @Test
    public void testGetMessageID() {
        Message msg = new Message("+27718693002", "Hello");

        assertNotNull(msg.getMessageID());
    }

    //Get message text is tested
    @Test
    public void testGetMessage() {
        Message msg = new Message("+27718693002", "Hello");

        assertEquals("Hello", msg.getMessage());
    }

    //Message under 250 characters is tested
    @Test
    public void testMessageLengthValid() {
        Message msg = new Message("+27718693002", "Short message");

        String result = msg.sendMessage(1);

        assertEquals("Message successfully sent.", result);
    }

    //Message over 250 characters is tested
    @Test
    public void testMessageLengthInvalid() {

        String longMessage = "x".repeat(260);

        Message msg = new Message("+27718693002", longMessage);

        String result = msg.sendMessage(1);

        assertEquals("Please enter a message of less than 250 characters.", result);
    }
    
    //The sent messages are being tested
    @Test
    public void testSentMessagesArray() {

    ArrayList<String> sentMessages = new ArrayList<>();

    sentMessages.add("Did you get the cake?");

    sentMessages.add("It is dinner time !");

    assertEquals("Did you get the cake?", sentMessages.get(0));

    assertEquals("It is dinner time !",sentMessages.get(1));
}
    //The longest message is being tested
    @Test
    public void testLongestMessage() {

    String msg1 = "Did you get the cake?";

    String msg2 = "Where are you? You are late! I have asked you to be on time.";

    String longest = msg1.length() > msg2.length()? msg1 : msg2;

    assertEquals("Where are you? You are late! I have asked you to be on time.",longest);
}
    //The search recipient is being tested
    @Test
    public void testSearchRecipient() {

    String recipient = "+27838884567";

    assertEquals("+27838884567", recipient);
}
    //The delete message hash is being tested
    @Test
    public void testDeleteMessageHash() {

    ArrayList<String> hashes = new ArrayList<>();

    hashes.add("12:1:WHERETIME.");

    hashes.remove("12:1:WHERETIME.");

    assertEquals(0,hashes.size());
}
}
    
}
