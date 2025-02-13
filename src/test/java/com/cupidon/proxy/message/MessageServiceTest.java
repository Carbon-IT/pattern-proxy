package com.cupidon.proxy.message;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.exo.cupidon.message.MessageService;
import com.exo.cupidon.model.User;

public class MessageServiceTest {
    private MessageService messageService;
    private ByteArrayOutputStream outputStreamCaptor;

    @Before
    public void setUp() {
        messageService = new MessageService();
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testSendMessage() {
        User sender = new User("Alice", messageService);
        User recipient = new User("Bob", messageService);
        String message = "Hello, Bob!";

        messageService.sendMessage(sender, recipient, message);

        String expectedOutput = "Alice envoie à Bob: Hello, Bob!\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    public void testSendMessageWithEmptyMessage() {
        User sender = new User("Charlie", messageService);
        User recipient = new User("David", messageService);
        String message = "";

        messageService.sendMessage(sender, recipient, message);

        String expectedOutput = "Charlie envoie à David: \n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
