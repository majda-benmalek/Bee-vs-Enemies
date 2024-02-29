package Perso.Ennemi;

import Perso.Bee.Abeille;
import Perso.Ennemi.Ennemis;
import Perso.Entite;

public class Araignee extends Ennemis {
    private boolean mort;
    private static final int degats = 10;

    public Araignee() {
        super(100, degats, false);
    }

    public void attaque(Entite a) {
        a.setPv(a.getPv() - degats);
        ((Abeille) a).setImmobilise(true);
        if (a.getPv() <= 0) {
            a.setPv(0);
        }
    }

    public String toString() {
        if (this.isEmpoisonne() && this.getPv() < 100 / 3) {
            // orange
            return "\u001B[38;5;166m" + "A" + "\u001B[0m";
        } else if (this.isEmpoisonne()) {
            // Violet
            return "\u001B[38;5;100m" + "A" + "\u001B[0m";
        } else if (this.getPv() < 100 / 3) {
            // rouge
            return "\u001B[38;5;88m" + "A" + "\u001B[0m";
        } else {
            return "A";
        }
    }
}
