package view.View;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

import view.View.Utile.RoundBtn;

public class Regles extends JPanel {
    private final static JButton retour = new JButton("Retour");
    private final static JTextArea text = new JTextArea();
    private final static JTextArea text2 = new JTextArea();
    private final static JButton suivant = new JButton("Suivant");

    public Regles() {
        super();

        String res1 = """
                Le but du jeu est de protéger votre ruche des ennemis. Faites face aux vagues d'ennemis qui arrivent, récoltez du miel pour améliorer vos abeilles, et posez des abeilles pour défendre votre ruche.
                Par rapport à la difficulté choisie, la taille de la zone a defendre et le nombre d'ennemis par vague varient.
                Le type d'abeille aussi varie en fonction de la difficulté choisie.
                Le prix des abeilles sont de:
                    Abeille sniper (jete des pierres sur ses ennemis) : 25 miel
                    Abeille butineuse (vous permet de recolter du miel 5 miel a chaque tour) : 30 miel
                    Abeille venimeuse (envenime ses ennemis et inflige 5 degats de plus chaque seconde) : 50 miel
                    \s
                    Deux mode de jeu existe:\s
                        -Le mode normal: Un nombre limité de vague avec un nombre prédéfinis de vagues. Soyez tactiques pour les reposser!
                        Trois mode de difficulté:
                            -Facile: 3 vagues.
                            -Moyen: 4 vagues.
                            -Difficile: 5 vagues.
                        -Le mode marathon: Sans limites d'ennemis. Faites de votre mieux pour protéger votre ruche pendant 30 tours!
                    """;
        String res2 = """
                Le jeu se joue a la souris et au clavier.
                Pour poser une abeille, cliquez sur la cas ou vous souhaitez la poser, un fenetre s'affichera alors et vous pourrez entrer le type d'abeille que vous souhaitez poser.(S,B,V)
                au dessus de la zone de jeu, vous pouvez voir le nombre de miel que vous possedez, le nombre de vagues restantes, le nombre de tours dans le mode marathon, la difficulté choisie et votre nom.
                Pour suivant le jeu, cliquez sur le bouton suivant.
                Pour revenir au menu, cliquez sur le bouton retour.
                Pour jouer cliquez sur suivant.

                    """;
        // retourS
        text.setText(res1);
        text.setFont(text.getFont().deriveFont(25));
        text.setEditable(false);
        text.getCaret().deinstall(text);
        text.setLineWrap(true);
        text.setFocusable(false);
        text.setWrapStyleWord(true);
        text.setBounds(0, 0, 400, 300);

        // TUTO
        text2.setText(res2);
        text2.setFont(text2.getFont().deriveFont(25));
        text2.setEditable(false);
        text2.getCaret().deinstall(text2);
        text2.setLineWrap(true);
        text2.setWrapStyleWord(true);
        text2.setBounds(0, 0, 400, 300);
        text2.setFocusable(false);

        RoundBtn roundBtn = new RoundBtn(50);
        Dimension dim = new Dimension(200, 50);
        Font font = new Font("Arial", Font.PLAIN, 15);

        // EDIT BOUTON RETOUR
        retour.setText("Retour");
        retour.setFont(font);
        retour.setPreferredSize(dim);
        retour.setBorder(roundBtn);
    

        // EDIT BOUTON SUIVANT
        suivant.setText("Suivant");
        suivant.setFont(font);
        suivant.setPreferredSize(dim);
        suivant.setBorder(roundBtn);


        this.add(suivant);
        this.add(text);
        this.add(text2);
        this.add(retour);
    }

    public static void addRetourListener(ActionListener listener) {
        retour.addActionListener(listener);
        retour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                retour.setForeground(new Color(255, 242, 0));
                retour.setBackground(new Color(36, 36, 36));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                retour.setForeground(new Color(36, 36, 36));
                retour.setBackground(new Color(255, 242, 0));
            }
        });
    }

    public static void addSuivantListener(ActionListener listener) {
        suivant.addActionListener(listener);
        suivant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                suivant.setForeground(new Color(255, 242, 0));
                suivant.setBackground(new Color(36, 36, 36));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                suivant.setForeground(new Color(36, 36, 36));
                suivant.setBackground(new Color(255, 242, 0));
            }
        });
    }

    public static JButton getRetour() {
        return retour;
    }

    public static JButton getSuivant() {
        return suivant;
    }
}
