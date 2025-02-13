package com.exo.cupidon.message;

import com.exo.cupidon.model.Message;
import com.exo.cupidon.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageService implements IMessageService {

    private final List<Message> messages = new ArrayList<>();

    @Override
    public void sendMessage(User sender, User recipient, String message) {
        messages.add(new Message(sender, recipient, message, LocalDateTime.now()));
    }

    @Override
    public List<Message> getMessages() {
        return messages;
    }
}
