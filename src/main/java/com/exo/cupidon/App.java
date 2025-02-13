package com.exo.cupidon;

import com.exo.cupidon.controller.MessageController;
import com.exo.cupidon.message.MessageService;
import com.exo.cupidon.view.UIManager;

public class App {
    public static void main(String[] args) {
        MessageService service = new MessageService();
        UIManager ui = new UIManager();
        MessageController controller = new MessageController(service, ui);
        ui.setController(controller);
    }
}