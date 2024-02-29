package Model;

import Perso.Bee.Abeille;
import Perso.Bee.Butineuse;
import Perso.Bee.Sniper;
import Perso.Bee.Venimeuse;
import Perso.Ennemi.Ennemis;
import Perso.Entite;

import java.util.Random;

public class Map {
    private final int ligne;
    private final static int colonne = 13;// 12
    private static Entite[][] terrain;
    private static PartieG partie;

    // maj de la map
    public Map(PartieG p) {
        partie = p;
        this.ligne = partie.getDifficulte().getLigne();
        terrain = new Entite[this.ligne][colonne];
    }

    // GETTERS
    public Entite[][] getTerrain() {
        return terrain;
    }

    public int getLigne() {
        return ligne;
    }

    public static int getColonne() {
        return colonne;
    }

    // Verifie si la position est legal
    // EXCEPTION THROW
    public boolean posLegal(int i, int j) {
        return rowLegal(i) && columnLegal(j) && terrain[i][j] == null;
    }

    public boolean rowLegal(int r) {
        return r < ligne && r >= 0;
    }

    public boolean columnLegal(int c) {
        return c < colonne && c >= 0;
    }

    public void avancer() {
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                if (terrain[i][j] instanceof Ennemis) {
                    if (rowLegal(terrain[i][j].getJ() - 1)) {
                        if (terrain[i][j - 1] instanceof Abeille) {
                            terrain[i][j].attaque(terrain[i][j - 1]);
                        }
                    }
                    if (posLegal(i, terrain[i][j].getJ() - 1)) {
                        terrain[i][j].setJ(j - 1);
                        terrain[i][j - 1] = terrain[i][j];
                        terrain[i][j] = null;
                    }
                }
            }
        }
    }

    public void maj() {
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                if (terrain[i][j] != null && terrain[i][j].getMort()) {
                    terrain[i][j] = null;
                }
            }
        }
        this.avancer();
    }

    public void affiche() {
        String lettre = "   A B C D E F G H";
        System.out.println(lettre);
        String l = "";
        for (int i = 0; i < ligne; i++) {
            if (partie.getDifficulte().getFilet()[i].isUsed()) {
                l += i + "  ";
            } else {
                l += partie.getDifficulte().getFilet()[i] + "" + i;
            }
            for (int j = 0; j < colonne; j++) {
                if (terrain[i][j] != null && !terrain[i][j].getMort()) {
                    l += " " + terrain[i][j].toString();
                    l += "";
                } else {
                    l += "  ";
                }
            }
            System.out.println(l);
            l = "";
        }
    }

    public void initialise(Entite e) {
        Random r = new Random();
        int i = r.nextInt(ligne);
        while (!posLegal(i, colonne - 1)) {
            i = r.nextInt(ligne);
        }
        e.setI(i);
        e.setJ(colonne - 1);
        // J'ajoute ici les petits nouveau en même temps que je set leurs positions
        terrain[e.getI()][e.getJ()] = e;
    }

    // ennemis présents sur une ligne
    public Ennemis EnnemisPresentL(int i) {
        for (int j = 0; j < colonne; j++) {
            if (terrain[i][j] instanceof Ennemis) {
                return (Ennemis) terrain[i][j];
            }
        }
        return null;
    }

    // ennemis présents sur une map
    public boolean ennemisPresentM() {
        for (int i = 0; i < ligne; i++) {
            if (EnnemisPresentL(i) != null) {
                return true;
            }
        }
        return false;
    }

    // Si on caste en Ennemis bah l'entité ne meurt pas
    public Entite ennemisPresentC(int i) {
        if (terrain[i][0] instanceof Ennemis) {
            return terrain[i][0];
        }
        return null;

    }

    public static void placeBee(Abeille bee, int row, int column) {
        partie.getJoueur().setMiel(partie.getJoueur().getMiel() - bee.getCout());
        bee.setI(row);
        bee.setJ(column);
        terrain[row][column] = bee;
        String beeType = "";
        if (bee instanceof Sniper) {
            beeType = "sniper";
        } else if (bee instanceof Butineuse) {
            beeType = "butineuse";
        } else if (bee instanceof Venimeuse) {
            beeType = "venimeuse";
        }
        System.out.println(
                "Vous avez posé une abeille " + beeType + " à la ligne " + row + " et à la colonne " + column + ".");
    }
}
