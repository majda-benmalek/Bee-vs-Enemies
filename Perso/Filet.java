package Perso;

import Model.PartieG;
import Perso.Ennemi.Ennemis;

public class Filet {
    private boolean use;
    private int i;
    private PartieG partie;

    public Filet(int i,PartieG partie){
        this.partie = partie;
        this.i = i;
        this.use = false;
    }

    public boolean isUsed() {
        return use;
    }

    public void use() {
        this.use = true;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String toString() {
        return "f";
    }

    public void tuerSurUneLigne(int i) {
        if (partie.getMap().ennemisPresentC(i) != null) {
            for (Entite e : partie.getMap().getTerrain()[i]) {
                if (e instanceof Ennemis) {
                    e.mortSubite();
                    this.use();
                }
            }
        }
    }

}