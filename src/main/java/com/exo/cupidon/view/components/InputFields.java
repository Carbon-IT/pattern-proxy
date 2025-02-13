// com.exo.cupidon.vue.components.InputFields.java
package com.exo.cupidon.view.components;

import javax.swing.*;
import java.awt.*;

public class InputFields extends JPanel {

    private final JTextField senderField, recipientField, messageField;

    public InputFields() {
        super(new GridLayout(4, 2));

        senderField = new JTextField();
        recipientField = new JTextField();
        messageField = new JTextField();

        add(new JLabel("Expéditeur:"));
        add(senderField);
        add(new JLabel("Destinataire:"));
        add(recipientField);
        add(new JLabel("Message:"));
        add(messageField);
    }

    public String getSenderName() {
        return senderField.getText();
    }

    public String getRecipientName() {
        return recipientField.getText();
    }

    public String getMessage() {
        return messageField.getText();
    }

    public void clearMessageField() {
        messageField.setText("");
    }
}