package src;

import javax.swing.*;
import java.awt.*;

public class InterfaceGraphique implements Runnable {

    private final Jeu jeu;
    private boolean maximized;
    private JFrame frame;

    public InterfaceGraphique(Jeu jeu) {
        this.jeu = jeu;
        maximized = false;
    }

    @Override
    public void run() {
        frame = new JFrame("Sokoban");
        frame.add(new NiveauGraphique(jeu));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }

    public void toggleFullscreen() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        if (maximized) {
            device.setFullScreenWindow(null);
            maximized = false;
        } else {
            device.setFullScreenWindow(frame);
            maximized = true;
        }
    }

}
