package Perso.Bee;

import Perso.Entite;

public class Sniper extends Abeille {
    private final static int dgt = 20;
    private final static int cout = 25;

    public int getCout() {
        return cout;
    }

    public Sniper() {
        super(100, dgt, cout, false);
    }

    @Override
    public String toString() {
        if (this.getImmobilise() && this.getPv() < 100 / 3) {
            // orange
            return "\u001B[35m" + "S" + "\u001B[0m";
        } else if (this.getImmobilise()) {
            // Violet
            return "\u001B[38;5;57m" + "S" + "\u001B[0m";
        } else if (this.getPv() < 100 / 3) {
            // rouge
            return "\u001B[31m" + "S" + "\u001B[0m";
        } else {
            return "S";
        }
    }

    public void attaque(Entite e) {
        if (!this.getImmobilise()) {
            e.setPv(e.getPv() - dgt);
            if (e.getPv() < 0) {
                e.setPv(0);
            }
        } else {
            System.out.println("L'abeille est immobilisée");
        }
    }
}
