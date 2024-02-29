package view.View;

import view.Model;
import view.View.Utile.RoundBtn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DiffChoice extends JPanel {

    private static JLabel text;

    private static JCheckBox facile;
    private static JCheckBox moyen;
    private static JCheckBox difficile;
    private static JButton valider;
    private JPanel panel;
    public static JLabel erreurLabel;
    static {
        erreurLabel= new JLabel();
        erreurLabel.setText("Veuillez choisir une difficulté.");
        erreurLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        erreurLabel.setHorizontalAlignment(JButton.CENTER);
        erreurLabel.setVerticalAlignment(JButton.CENTER);
        erreurLabel.setForeground(Color.RED);
    }

    private Model model;

    public DiffChoice(Model m) {
        super();
        this.model = m;
        this.scrollRectToVisible(new Rectangle(100, 200, 100, 200));
        this.setLayout((new FlowLayout(FlowLayout.CENTER, 100, 200)));
        //TITRE
        text = new JLabel();
        text.setFont(new Font("Arial", Font.PLAIN, 20));
        text.setText("Choisissez la difficulté du jeu:");
        text.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        text.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        //FACILE
        facile = new JCheckBox("Facile");
        facile.setFont(new Font("Arial", Font.PLAIN, 20));
        facile.setPreferredSize(new Dimension(200, 100));
        facile.setMargin(new Insets(10, 10, 10, 10));
        facile.setHorizontalAlignment(JButton.CENTER);
        facile.setBackground(new Color(255, 242, 0));
        facile.setVerticalAlignment(JButton.CENTER);
        facile.setSelected(false);
        //MOYEN
        moyen = new JCheckBox("Moyen");
        moyen.setFont(new Font("Arial", Font.PLAIN, 20));
        moyen.setPreferredSize(new Dimension(200, 100));
        moyen.setMargin(new Insets(10, 10, 10, 10));
        moyen.setHorizontalAlignment(JButton.CENTER);
        facile.setBackground(new Color(255, 242, 0));
        moyen.setVerticalAlignment(JButton.CENTER);
        moyen.setSelected(false);
        //DIFFICILE
        difficile = new JCheckBox("Difficile");
        difficile.setFont(new Font("Arial", Font.PLAIN, 20));
        difficile.setPreferredSize(new Dimension(200, 100));
        difficile.setMargin(new Insets(10, 10, 10, 10));
        difficile.setHorizontalAlignment(JButton.CENTER);
        facile.setBackground(new Color(255, 242, 0));
        difficile.setVerticalAlignment(JButton.CENTER);
        difficile.setSelected(false);


        //BOUTON VALIDER
        RoundBtn roundBtn = new RoundBtn(50);
        Dimension dim = new Dimension(200, 80);
        Insets insets = new Insets(10, 10, 10, 10);
        Font font = new Font("Arial", Font.PLAIN, 20);
        
        valider = new JButton();
        valider.setText("Valider");
        valider.setFont(font);
        valider.setPreferredSize(dim);
        valider.setMargin(insets);
        valider.setBorder(roundBtn);
        valider.setHorizontalAlignment(JButton.CENTER);
        valider.setVerticalAlignment(JButton.CENTER);





        panel = new JPanel();
        panel.add(text);
        panel.add(facile);
        panel.add(moyen);
        panel.add(difficile);

        this.add(panel);
        this.add(valider);

    }


    public static void addFacileListener(ActionListener listener) {
        facile.addActionListener(listener);
    }

    public static void addMoyenListener(ActionListener listener) {
        moyen.addActionListener(listener);
    }

    public static void addDifficileListener(ActionListener listener) {
        difficile.addActionListener(listener);
    }

    public static void addValiderListener(ActionListener listener) {
        valider.addActionListener(listener);
        valider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                valider.setForeground(new Color(255, 242, 0));
                valider.setBackground(new Color(36, 36, 36));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                valider.setForeground(new Color(36, 36, 36));
                valider.setBackground(new Color(255, 242, 0));
            }
        });
    }

    public static JButton getValider() {
        return valider;
    }

    public static JCheckBox getFacile() {
        return facile;
    }

    public static JCheckBox getMoyen() {
        return moyen;
    }

    public static JCheckBox getDifficile() {
        return difficile;
    }




}
