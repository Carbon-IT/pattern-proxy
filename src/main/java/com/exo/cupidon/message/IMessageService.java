package com.exo.cupidon.message;

import com.exo.cupidon.model.Message;
import com.exo.cupidon.model.User;

import java.util.List;

public interface IMessageService {
    void sendMessage(User sender, User recipient, String message);

    List<Message> getMessages();
}
