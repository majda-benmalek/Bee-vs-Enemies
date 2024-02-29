package Perso.Bee;

import Perso.Ennemi.Ennemis;
import Perso.Entite;

public class Venimeuse extends Abeille {
    private static final int dgt = 10;
    private static final int cout = 50;

    public Venimeuse() {
        super(50, dgt, cout, false);
    }

    // l'abeille venimeuse inflige un premier degat puis marque son ennemie et
    // inflige des dgt constant pendant 3 tour
    // ajouter au ennemi un attribut boolean venin, if (venin) pv-=3 a chaque tour
    public void attaque(Entite e) {
        if (!this.getImmobilise()) {
            e.setPv(e.getPv() - dgt);
            ((Ennemis) e).setEmpoisonne(((Ennemis) e).getNbTourPoison() < 3);
            if (e.getPv() < 0) {
                e.setPv(0);
            }
        } else {
            System.out.println("L'abeille est immobilisée");
        }
    }

    public String toString() {
        if (this.getImmobilise() && this.getPv() < 50 / 3) {
            // orange
            return "\u001B[35m" + "V" + "\u001B[0m";
        } else if (this.getImmobilise()) {
            // Violet
            return "\u001B[38;5;57m" + "V" + "\u001B[0m";
        } else if (this.getPv() < 50 / 3) {
            // rouge
            return "\u001B[31m" + "V" + "\u001B[0m";
        } else {
            return "V";
        }
    }

}
