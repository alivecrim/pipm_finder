package ru.issreshetnev.power;

import ru.issreshetnev.power.bl.*;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main extends JFrame{

    public static void main(String[] args) {
        MainWindowController uiController = new MainWindowController();
        SwingUtilities.invokeLater(uiController::show);
    }
}
