// com.exo.cupidon.vue.UIManager.java
package com.exo.cupidon.view;

import com.exo.cupidon.controller.MessageController;
import com.exo.cupidon.view.components.InputFields;
import com.exo.cupidon.view.components.MessageArea;
import com.exo.cupidon.view.components.SendButton;

import javax.swing.*;
import java.awt.*;

public class UIManager {

    private final JFrame frame;
    private final MessageArea messageArea;
    private final InputFields inputFields;
    private MessageController controller;

    public UIManager() {
        frame = new JFrame("Application de Rencontre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        messageArea = new MessageArea();
        inputFields = new InputFields();

        SendButton sendButton = new SendButton("Envoyer", e ->
                controller.sendMessage(
                        inputFields.getSenderName(),
                        inputFields.getRecipientName(),
                        inputFields.getMessage())
        );

        frame.add(messageArea, BorderLayout.CENTER);
        frame.add(inputFields, BorderLayout.SOUTH);
        frame.add(sendButton, BorderLayout.EAST);

        frame.setVisible(true);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public void clearMessages() {
        messageArea.clear();
    }

    public void addMessage(String message) {
        messageArea.appendMessage(message);
    }

    public void clearMessageField() {
        inputFields.clearMessageField();
    }

    public void setController(MessageController controller) {
        this.controller = controller;
    }
}