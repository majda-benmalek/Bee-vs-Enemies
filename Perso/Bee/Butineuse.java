package Perso.Bee;

import Model.PartieG;
import Perso.Entite;

public class Butineuse extends Abeille {
    private final static int dgt = 0;
    private final static int cout = 30;
    private PartieG partie;

    public Butineuse(PartieG p) {
        super(150, dgt, cout, false);
        this.partie = p;
    }

    @Override
    public void attaque(Entite e){
        if(!this.getImmobilise()) {
            partie.getJoueur().setMiel(partie.getJoueur().getMiel() + 5);
        }
    }

    public String toString() {
        if (this.getImmobilise() && this.getPv() < 150 / 3) {
            return "\u001B[38;5;228m" + "B" + "\u001B[0m";
        } else if (this.getImmobilise()) {
            return "\u001B[38;5;197m" + "B" + "\u001B[0m";
        } else if (this.getPv() < 150 / 3) {
            return "\u001B[38;5;202m" + "B" + "\u001B[0m";
        } else {
            return "B";
        }
    }

}
