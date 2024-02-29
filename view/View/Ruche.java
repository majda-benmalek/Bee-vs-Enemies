package view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class Ruche extends JPanel {

    static ImageIcon img = new ImageIcon("Ressources/ruche.png");
    static JLabel label = new JLabel();


    public Ruche() {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(0, 128, 0));
        this.setSize(300, 300);
        img.setImage(img.getImage().getScaledInstance(250, 250, 50));
        label.setIcon(img);
        label.setSize(250, 250);
        this.add(label, BorderLayout.CENTER);

    }
    public static void addLabelClickListener(MouseAdapter listener) {
        label.addMouseListener(listener);
    }
}
