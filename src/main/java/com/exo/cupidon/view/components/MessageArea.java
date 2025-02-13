// com.exo.cupidon.vue.components.MessageArea.java
package com.exo.cupidon.view.components;

import javax.swing.*;
import java.awt.*;

public class MessageArea extends JScrollPane {

    private final JTextArea textArea;

    public MessageArea() {
        super();
        textArea = new JTextArea();
        textArea.setEditable(false);
        setViewportView(textArea);
        setPreferredSize(new Dimension(400, 300));
    }

    public void clear() {
        textArea.setText("");
    }

    public void appendMessage(String message) {
        textArea.append(message);
    }
}