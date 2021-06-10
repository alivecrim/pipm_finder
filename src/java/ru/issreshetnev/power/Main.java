package ru.issreshetnev.power;

import javax.swing.*;

public class Main extends JFrame{

    public static void main(String[] args) {
        MainWindowController uiController = new MainWindowController();
        SwingUtilities.invokeLater(uiController::show);
    }
}
