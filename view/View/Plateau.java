package view.View;

import Model.Map;
import Perso.Bee.Abeille;
import Perso.Ennemi.Araignee;
import Perso.Ennemi.Chenille;
import Perso.Ennemi.Ennemis;
import Perso.Ennemi.Frelon;
import Perso.Entite;
import view.Model;
import Model.PartieG;

import javax.swing.*;
import java.awt.*;

public class Plateau extends JPanel {
    public static int rows;
    public static int cols;
    static Case[][] cases;
    JPanel c;
    private final Model model;

    public Plateau(Model m) {
        this.model = m;
        this.setBackground(new Color(0, 128, 0));
        rows = model.getPartie().getMap().getLigne();
        cols = Map.getColonne();
        c = new JPanel(new GridLayout(rows, cols));
        cases = new Case[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cases[i][j] = new Case(i, j);
                c.add(cases[i][j]);
            }
        }
        this.add(c);
        this.setVisible(true);

        Timer timer = new Timer(100, e -> {
            // Mettez à jour la vue ici
            SwingUtilities.updateComponentTreeUI(this);
            this.repaint();
            this.revalidate();
        });
        timer.start();
    }


    public static Case[][] getCases() {
        return cases;
    }

    public void afficheG() {

        Entite[][] t = model.getPartie().getMap().getTerrain();
        ImageIcon im = null;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (t[i][j] != null) {
                    if (t[i][j].getMort()) {
                        cases[i][j].update();
                    }
                    if (t[i][j] instanceof Ennemis) {
                        if (t[i][j] instanceof Chenille) {
                            im = new ImageIcon("Ressources/chenille.png");
                        } else if (t[i][j] instanceof Frelon) {
                            im = new ImageIcon("Ressources/frelon.png");
                        } else if (t[i][j] instanceof Araignee) {
                            im = new ImageIcon("Ressources/araignee3.png");
                            im.setImage(im.getImage().getScaledInstance(55, 55, 50));
                        }
                        cases[i][j].update(im);
                        if (((Ennemis) t[i][j]).isEmpoisonne()) {
                            cases[i][j].updateEtatEnnemi((Ennemis) t[i][j]);
                        }
                    }
                }else{
                    cases[i][j].update();
                }
                if (t[i][j] instanceof Abeille) {
                    if (((Abeille) t[i][j]).getImmobilise()) {
                        cases[i][j].updateEtatAbeille((Abeille) t[i][j]);
                    }
                }
            }
        }
        if(PartieG.isMarathon()){
            Miel.updateTour();
        }
        Miel.updateVague();
        this.repaint();
        this.revalidate();
    }
    }
