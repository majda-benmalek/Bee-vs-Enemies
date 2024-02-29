package Model.Diff;

import Model.IllegalPosException;
import Perso.Filet;
import Model.HoneyException;
import Model.IllegalBeeException;

public abstract class Difficulte {

    public enum diff {
        F, M, D
    }

    private final Filet[] filet;
    private final String d;
    private final diff di;
    private int[] vague;
    private final int ligne;
    private int miel;

    public Difficulte(diff d, int ligne, int[] vague, Filet[] filet, String nom, int miel) {
        this.di = d;
        this.ligne = ligne;
        this.vague = vague;
        this.filet = filet;
        this.d = nom;
        this.miel = miel;
    }

    // GETTERS
    public String getD() {
        return d;
    }

    public int[] getVague() {
        return vague;
    }

    public diff getDi() {
        return di;
    }

    public int getLigne() {
        return ligne;
    }

    public Filet[] getFilet() {
        return this.filet;
    }


    public int getMiel() {
        return miel;
    }

    public void setVague(int[] vague) {
        this.vague = vague;
    }

    public void setMiel(int miel) {
        this.miel = miel;
    }

    // Methodes utiliser dans les classes enfants
    public static int convertirLettreEnChiffre(String lettre) {
        int chiffre = -1;
        switch (lettre) {
            case "A" -> chiffre = 0;
            case "B" -> chiffre = 1;
            case "C" -> chiffre = 2;
            case "D" -> chiffre = 3;
            case "E" -> chiffre = 4;
            case "F" -> chiffre = 5;
            case "G" -> chiffre = 6;
            case "H" -> chiffre = 7;
            case "I" -> chiffre = 8;
            case "J" -> chiffre = 9;
            case "K" -> chiffre = 10;
            case "L" -> chiffre = 11;

            default ->
                System.out.println(
                        "\u001B[31mEntrée invalide. Veuillez entrer une lettre valide pour la colonne.\u001B[0m");
        }
        return chiffre;
    }

    public abstract void poser(String beeType, int row, int column)
            throws IllegalPosException, HoneyException, IllegalBeeException;

    public abstract void poserEnnemis();
    //public abstract void poserEnnemisMarathon() ;

}
