package Perso.Ennemi;

import Perso.Entite;

public class Ennemis extends Entite {
    private int pv;
    private boolean mort = false;
    private int degats;
    private boolean empoisonne = false;
    private int nbTourPoison;

    public Ennemis(int pv, int dgt, boolean empoisonne) {
        super(pv, dgt);
        this.empoisonne = empoisonne;
        this.nbTourPoison = 0;
    }

    public boolean isEmpoisonne() {
        return this.empoisonne;
    }

    public int getNbTourPoison() {
        return this.nbTourPoison;
    }

    public void setNbTourPoison(int nbTourPoison) {
        this.nbTourPoison = nbTourPoison;
    }

    public void setEmpoisonne(boolean empoisonne) {
        this.empoisonne = empoisonne;
    }


    public void attaque(Entite e) {
        e.setPv(e.getPv() - this.degats);
        if (e.getPv() < 0) {
            e.setPv(0);
        }
    }

    public void empoisonnement() {
        if (this.isEmpoisonne()) {
            this.setPv(this.getPv() - 3);
        }
    }
}
