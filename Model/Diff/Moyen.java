package Model.Diff;

import Model.*;
import Perso.Bee.Abeille;
import Perso.Bee.Butineuse;
import Perso.Bee.Sniper;
import Perso.Ennemi.Araignee;
import Perso.Ennemi.Chenille;
import Perso.Filet;

import java.util.Random;

import static Model.Map.placeBee;

public class Moyen extends Difficulte {
    private static final String d = "Moyen";
    private final static diff di = diff.M;
    private final static int ligne = 5;
    private final static Filet[] filet = new Filet[ligne];
    private static Joueur j;
    private static PartieG partie;

    public Moyen(Joueur jo, PartieG p) {
        super(di, ligne, new int[5], filet, d,  150);
        this.setVague(new int[] { 2, 4, 4, 6 });
        partie = p;
        for (int i = 0; i < filet.length; i++) {
            filet[i] = new Filet(i, partie);
            filet[i].setI(i);
        }
        j = jo;

        j.setAbeille(0, new Sniper());
        j.setAbeille(1, new Butineuse(partie));
    }

    public void poser(String beeType, int row, int column)
            throws IllegalPosException, HoneyException, IllegalBeeException {
        Abeille bee;
        if (!validerTypeAbeille(beeType) && beeType.equals("V")) {
            partie.getTour().run();
            System.out.println("\u001B[31mVous ne pouvez poser que des abeilles snipers et des butineuses.\u001B[0m");
            throw new IllegalBeeException("Vous ne pouvez poser que des abeilles snipers et des butineuses.");
        }
        switch (beeType) {
            case "S":
                bee = new Sniper();
                if (partie.getMap().posLegal(row, column)) {
                    if (j.getMiel() < bee.getCout()) {
                        partie.getTour().run();
                        System.out.println("Vous n'avez pas assez de miel pour poser cette abeille.");
                        throw new HoneyException("Vous n'avez pas assez de miel pour poser cette abeille.");
                    } else {
                        placeBee(bee, row, column);
                    }
                } else {
                    poser(beeType, row, column);
                    System.out.println("\u001B[31mPosition invalide. Veuillez choisir une autre position:\u001B[0m");
                    throw new IllegalPosException("Position invalide. Veuillez choisir une autre position:");
                }
                break;
            case "B":
                bee = new Butineuse(partie);
                if (partie.getMap().posLegal(row, column)) {
                    if (j.getMiel() < bee.getCout()) {
                        partie.getTour().run();
                        System.out.println("Vous n'avez pas assez de miel pour poser cette abeille.");
                        throw new HoneyException("Vous n'avez pas assez de miel pour poser cette abeille.");
                    } else {
                        placeBee(bee, row, column);
                    }
                } else {
                    poser(beeType, row, column);
                    System.out.println("\u001B[31mPosition invalide. Veuillez choisir une autre position:\u001B[0m");
                    throw new IllegalPosException("Position invalide. Veuillez choisir une autre position:");
                }
                break;
        }
    }

    public void poserEnnemis() {
        if (this.getVague()[partie.getTour().nbVague - 1] > 0) {
            Random r = new Random();
            int entier = r.nextInt(this.getVague()[partie.getTour().nbVague - 1]) + 1;
            int combinaison = r.nextInt(3);
            switch (combinaison) {
                case 0:
                    for (int i = 0; i < entier; i++) {
                        Chenille c = new Chenille();
                        partie.getMap().initialise(c);
                        this.getVague()[partie.getTour().nbVague - 1]--;
                    }
                    break;
                case 1:
                    for (int i = 0; i < entier; i++) {
                        Araignee a = new Araignee();
                        partie.getMap().initialise(a);
                        this.getVague()[partie.getTour().nbVague - 1]--;
                    }
                    break;
                case 2:
                    for (int i = 0; i < entier / 2; i++) {
                        Araignee a = new Araignee();
                        partie.getMap().initialise(a);
                        Chenille c = new Chenille();
                        partie.getMap().initialise(c);
                        this.getVague()[partie.getTour().nbVague - 1] -= 2;
                    }
                    break;
                default:
                    this.poserEnnemis();
                    this.poserEnnemis();
            }
        }
    }

//    @Override
//    public void poserEnnemisMarathon() {
//    }

    public static boolean validerTypeAbeille(String beeType) {
        return !beeType.equals("S") && !beeType.equals("B") && !beeType.equals("V");
    }
}
