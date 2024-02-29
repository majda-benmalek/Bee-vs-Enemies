package Perso;

public class Entite {
    private int pv;
    private final int dgt;
    private boolean mort = false; 
    private int i;
    private int j;

    public Entite(int pv, int dgt) {
        this.pv = pv;
        this.dgt = dgt;

    }

    public void attaque(Entite e) {
        e.pv -= this.dgt;
        if (e.pv < 0) {
            e.setPv(0);
        }
    }

    public int getPv() {
        return this.pv;
    }

    public void setPv(int n) {
        this.pv = n;
        if (this.pv <= 0) {
            this.pv = 0;
            this.mort = true;
        }
    }

    public boolean getMort() {
        return this.mort;
    }

    public void mortSubite() {
        this.mort = true;
        this.pv = 0;
    }

    public int getI() {
        return this.i;
    }

    public int getJ() {
        return this.j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public void setI(int i) {
        this.i = i;
    }

}
