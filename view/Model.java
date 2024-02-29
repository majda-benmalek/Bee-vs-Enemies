package view;

import Model.Joueur;
import Model.PartieG;

public class Model {
    public PartieG partie;
    private Joueur j = new Joueur();

    public Model() {
        this.partie = new PartieG(j);
    }

    public PartieG getPartie() {
        return this.partie;
    }

    public void setPartie(PartieG p) {
        this.partie = p;
    }

    public Joueur getJoueur() {
        return this.j;
    }

    public void setJoueur(Joueur joueur) {
        this.j = joueur;
    }
}
