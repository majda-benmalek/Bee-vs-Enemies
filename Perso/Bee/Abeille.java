package Perso.Bee;

import Perso.Entite;

public abstract class Abeille extends Entite {
    private int pv;
    private int dgt;
    private boolean mort = false; 
    private final int cout;
    private boolean immobilise;
    private int nbTourImmobilise;

    public Abeille(int pv, int dgt, int cout, boolean immobilise) {
        super(pv, dgt);
        this.immobilise = immobilise;
        this.cout = cout;
        this.nbTourImmobilise = 0;
        this.nbTourImmobilise = 0;
    }

    public void setImmobilise(boolean i) {
        immobilise = i;
    }

    public int getCout() {
        return this.cout;
    }

    public boolean getImmobilise() {
        return this.immobilise;
    }

    public abstract void attaque(Entite e);

    public int getNbTourImmobilise() {
        return nbTourImmobilise;
    }

    public int setNbTourImmobilise(int n) {
        return nbTourImmobilise = n;
    }
}
