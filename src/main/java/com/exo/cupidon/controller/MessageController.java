// com.exo.cupidon.controller.MessageController.java
package com.exo.cupidon.controller;

import com.exo.cupidon.message.IMessageService;
import com.exo.cupidon.model.Message;
import com.exo.cupidon.model.User;
import com.exo.cupidon.view.UIManager;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class MessageController {
    private final IMessageService messageService;
    private final UIManager uiManager;

    public MessageController(IMessageService messageService, UIManager uiManager) {
        this.messageService = messageService;
        this.uiManager = uiManager;
    }

    public void sendMessage(String senderName, String recipientName, String message) {
        if (senderName.isEmpty() || recipientName.isEmpty() || message.isEmpty()) {
            uiManager.showError("Veuillez remplir tous les champs.");
            return;
        }

        User sender = new User(senderName);
        User recipient = new User(recipientName);
        try {
            messageService.sendMessage(sender, recipient, message);
            updateView();
        } catch (Exception e) {
            uiManager.showError(e.getMessage());
        }
    }

    private void updateView() {
        List<Message> messages = messageService.getMessages();
        uiManager.clearMessages();
        for (Message msg: messages) {
            uiManager.addMessage("%s %s envoie à %s: %s\n".formatted(
                    msg.createdAt().format(DateTimeFormatter.ofPattern("hh:mm:ss")),
                    msg.sender().name(),
                    msg.recipient().name(),
                    msg.message()
            ));
        }
        uiManager.clearMessageField();
    }
}