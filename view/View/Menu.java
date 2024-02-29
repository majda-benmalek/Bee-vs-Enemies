package view.View;

import view.View.Utile.RoundBtn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
    private static JButton jouer;
    private static JLabel titre;
    private static JButton quitter;
    private static JButton regle;
    private JPanel panel = new JPanel();

    public Menu() {
        super();
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 150, 200);
        this.setLayout(layout);
        RoundBtn roundBtn = new RoundBtn(50);
        Dimension dim = new Dimension(200, 80);
        Insets insets = new Insets(10, 10, 10, 10);
        Font font = new Font("Arial", Font.PLAIN, 20);


        
        // TITRE
        titre = new JLabel("BeeDefense");
        titre.setFont(new Font("Arial", Font.PLAIN, 40));
        ImageIcon icon = new ImageIcon("Ressources/logo.png");
        icon.setImage(icon.getImage().getScaledInstance(90, 90, 90));
        titre.setIcon(icon);
        titre.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        titre.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        titre.setForeground(new Color(241, 209, 9, 255));

        // BOUTON JOUER
        jouer = new JButton();
        jouer.setText("Jouer");
        jouer.setFont(font);
        jouer.setPreferredSize(dim);
        jouer.setMargin(insets);
        jouer.setBorder(roundBtn);
        jouer.setHorizontalAlignment(JButton.CENTER);
        jouer.setVerticalAlignment(JButton.CENTER);

        // BOUTON REGLE
        regle = new JButton();
        regle.setText("Regles");
        regle.setFont(font);
        regle.setPreferredSize(dim);
        regle.setMargin(insets);
        regle.setBorder(roundBtn);
        regle.setHorizontalAlignment(JButton.CENTER);
        regle.setVerticalAlignment(JButton.CENTER);

        // BOUTON QUITTER
        quitter = new JButton();
        quitter.setText("Quitter");
        quitter.setFont(font);
        quitter.setPreferredSize(dim);
        quitter.setMargin(insets);
        quitter.setBorder(roundBtn);
        quitter.setHorizontalAlignment(JButton.CENTER);
        quitter.setVerticalAlignment(JButton.CENTER);

        panel.setLayout(new GridLayout(5, 1));
        panel.add(titre);
        panel.add(jouer);
        panel.add(regle);
        panel.add(quitter); 

        this.add(panel, BorderLayout.CENTER);

    }

    public static void addJouerListener(ActionListener listener) {
        jouer.addActionListener(listener);
        jouer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jouer.setForeground(new Color(255, 242, 0));
                jouer.setBackground(new Color(36, 36, 36));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jouer.setForeground(new Color(36, 36, 36));
                jouer.setBackground(new Color(255, 242, 0));
            }
        });
    }

    public static void addQuitterListener(ActionListener listener) {
        quitter.addActionListener(listener);
        quitter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                quitter.setForeground(new Color(255, 242, 0));
                quitter.setBackground(new Color(36, 36, 36));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                quitter.setForeground(new Color(36, 36, 36));
                quitter.setBackground(new Color(255, 242, 0));
            }
        });
    }

    public static void addReglesListener(ActionListener listener) {
        regle.addActionListener(listener);
        regle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                regle.setForeground(new Color(255, 242, 0));
                regle.setBackground(new Color(36, 36, 36));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                regle.setForeground(new Color(36, 36, 36));
                regle.setBackground(new Color(255, 242, 0));
            }
        });
    }

    public static JButton getJouer() {
        return jouer;
    }

}
