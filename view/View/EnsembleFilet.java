package view.View;

import java.awt.*;
import javax.swing.*;
import Perso.Filet;
import view.Model;

public class EnsembleFilet extends JPanel {
    public JPanel Filet;
    public Model model;
    public Case[] f=new Case[Plateau.rows]  ;
    public EnsembleFilet(int i, Model model) {
        this.setBackground(new Color(0, 128, 0));
        this.model = model;
        this.Filet = new JPanel();
        this.Filet.setLayout(new BoxLayout(this.Filet, BoxLayout.Y_AXIS));
        for (int j = 0; j < i; j++) {
            f[j]=new Case(j);
            //Case f = new Case(j);
            this.Filet.add(f[j]);
        }
        this.add(this.Filet);
        this.setVisible(true);
    }

    public void update() {
        for (Filet filet : model.partie.getDifficulte().getFilet()) {
            if (filet.isUsed()) {
                int ligne = filet.getI();
                f[ligne].update();
            }
        }
    }

}
