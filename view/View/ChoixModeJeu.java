package view.View;

import view.Model;
import view.View.Utile.RoundBtn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChoixModeJeu extends JPanel {
    private static JCheckBox normal;
    private static JCheckBox marathon;
    private static JButton valider;
    private static JTextField nomJoueur;
    private Model model;
    private JPanel panel=new JPanel();
    public static JLabel erreurLabel;
    static {
        erreurLabel= new JLabel();
        erreurLabel.setText("Veuillez choisir une difficulté.");
        erreurLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        erreurLabel.setHorizontalAlignment(JButton.CENTER);
        erreurLabel.setVerticalAlignment(JButton.CENTER);
        erreurLabel.setForeground(Color.RED);
    }

    public ChoixModeJeu(Model m) {
        super();
        this.model = m;
        this.scrollRectToVisible(new Rectangle(100, 200, 100, 200));
        this.setLayout((new FlowLayout(FlowLayout.CENTER, 100, 200)));
        //NORMAL
        normal = new JCheckBox("Normal");
        normal.setFont(new Font("Arial", Font.PLAIN, 20));
        normal.setPreferredSize(new Dimension(200, 100));
        normal.setMargin(new Insets(10, 10, 10, 10));
        normal.setHorizontalAlignment(JButton.CENTER);
        normal.setVerticalAlignment(JButton.CENTER);
        normal.setSelected(false);
        //MARATHON
        marathon = new JCheckBox("Marathon");
        marathon.setFont(new Font("Arial", Font.PLAIN, 20));
        marathon.setPreferredSize(new Dimension(200, 100));
        marathon.setMargin(new Insets(10, 10, 10, 10));
        marathon.setHorizontalAlignment(JButton.CENTER);
        marathon.setVerticalAlignment(JButton.CENTER);
        marathon.setSelected(false);

        //Bouton valider
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

        //CHOIX NOM
        nomJoueur = new JTextField();
        nomJoueur.setPreferredSize(new Dimension(200, 100));
        nomJoueur.setFont(new Font("Arial", Font.PLAIN, 20));
        nomJoueur.setHorizontalAlignment(JTextField.CENTER);
        nomJoueur.setText("Nom du joueur");
        nomJoueur.setMargin(new Insets(10, 10, 10, 10));
        nomJoueur.setVisible(true);
        nomJoueur.setEditable(true);
        nomJoueur.setEnabled(true);
        nomJoueur.setOpaque(true);


        String nom = nomJoueur.getText();
        model.getJoueur().setNom(nom);


        panel.add(nomJoueur);
        panel.add(normal);
        panel.add(marathon);

        this.add(panel);
        this.add(valider);

    }

    public static JCheckBox getNormal() {
        return normal;
    }

    public static JCheckBox getMarathon() {
        return marathon;
    }

    public static JButton getValider() {
        return valider;
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



    public static JTextField getNomJoueur() {
        return nomJoueur;
    }



}
