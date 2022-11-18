package be.intecbrussel.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageServiceTest {

    MessageService messageService = new MessageService();


    @Test
    void getAll() {
        List<String> expected = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            String formattedText = "Message: {" + "\n" +
                    "From: " + "sender" + i + "@mail.be" + "\n" +
                    "To: " + "receiver" + i + "@mail.be" + "\n" +
                    "Header: " + "header " + i + "\n" +
                    "Body" + "body " + i + "\n" + "}";
            expected.add(formattedText);
        }

        var actual = messageService.getAll();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getByFrom() {
        List<String> expected = new LinkedList<>();
                String formattedText = "Message: {" + "\n" +
                "From: " + "sender" + 7 + "@mail.be" + "\n" +
                "To: " + "receiver" + 7 + "@mail.be" + "\n" +
                "Header: " + "header " + 7 + "\n" +
                "Body" + "body " + 7 + "\n" + "}";
                expected.add(formattedText);

                List<String> actual = messageService.getByFrom("sender7@mail.be");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void getByTo() {
        List<String> expected = new LinkedList<>();
        String formattedText = "Message: {" + "\n" +
                "From: " + "sender" + 7 + "@mail.be" + "\n" +
                "To: " + "receiver" + 7 + "@mail.be" + "\n" +
                "Header: " + "header " + 7 + "\n" +
                "Body" + "body " + 7 + "\n" + "}";
        expected.add(formattedText);

        var actual = messageService.getByTo("receiver7@mail.be");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sendShouldFailWhenNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> messageService.send("", "receiver", "header", "body"));
    }

}