package view;

import view.Controller.Controller;
import view.View.View;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Model m = new Model();
        View v = new View(m);
        SwingUtilities.invokeLater(() -> new Controller(m, v));
    }
}
