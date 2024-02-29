package Model;

import java.util.Arrays;

import Perso.Bee.Abeille;

public class Joueur {
    // un tableau d'abeille pour definir les abeilles qu'il a le droit d'utiliser
    // un nombre de miel == int
    // int niveau
    private final Abeille[] Abeilles;
    private int miel;
    private String name;

    public Joueur() {
        this.miel = 1000;
        this.Abeilles = new Abeille[3];
    }

    public void setAbeille(int i, Abeille a) {
        this.Abeilles[i] = a;
    }

    public Abeille[] getAbeilles() {
        return Abeilles;
    }

    public int getMiel() {
        return miel;
    }

    public void setMiel(int m) {
        this.miel = m;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Joueur [Abeilles=" + Arrays.toString(Abeilles) + ", miel=" + miel + ", name=" + name + "]";
    }

    public void setNom(String nom) {
        this.name = nom;
    }
}
