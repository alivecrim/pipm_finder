package ru.issreshetnev.power;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopFind implements ActionListener {
    private final MakeFind makeFind;

    public StopFind(MakeFind l) {
        this.makeFind = l;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.makeFind.stopFind();
    }
}
