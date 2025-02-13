// com.exo.cupidon.vue.components.SendButton.java
package com.exo.cupidon.view.components;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SendButton extends JButton {

    public SendButton(String label, ActionListener listener) {
        super(label);
        addActionListener(listener);
    }
}