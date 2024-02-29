package view.View;

import view.Controller.MenuController;
import view.Model;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    static JFrame frame;

    public static CardLayout cardLayout = new CardLayout();
    public static JPanel cards = new JPanel(cardLayout);
    private final Model model;
    private ImageIcon icons=new ImageIcon("Ressources/back.jpg");

    public View(Model m) {
        super("BeeDefense");
        this.model = m;
        frame = this;
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1700, 900);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);
        Menu menu = new Menu();
        cards.add(menu, "menu");
        new MenuController(model);
        cardLayout.show(cards, "menu");
        Timer timer = new Timer(900, e -> {
            SwingUtilities.updateComponentTreeUI(frame);
        });
        timer.start();

        this.add(cards);
    }

}