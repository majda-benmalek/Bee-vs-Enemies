package Model.Diff;

import Model.HoneyException;
import Model.IllegalPosException;
import Model.Joueur;
import Model.PartieG;
import Perso.Bee.Abeille;
import Perso.Bee.Butineuse;
import Perso.Bee.Sniper;
import Perso.Bee.Venimeuse;
import Perso.Ennemi.Araignee;
import Perso.Ennemi.Chenille;
import Perso.Ennemi.Frelon;
import Perso.Filet;

import java.util.Random;

import static Model.Map.placeBee;

public class Difficile extends Difficulte {
    private static final String d = "Difficile";
    private static final diff di = diff.D;
    private static final int ligne = 7;
    private static final Filet[] filet = new Filet[ligne];
    private static Joueur j;
    private static PartieG partie;

    public Difficile(Joueur jo, PartieG p) {
        super(di, ligne, new int[] { 3, 6, 3, 6, 6 }, filet, d,  200);
        partie = p;
        for (int i = 0; i < filet.length; i++) {
            filet[i] = new Filet(i, partie);
            filet[i].setI(i);
        }
        j = jo;
        j.setAbeille(0, new Sniper());
        j.setAbeille(1, new Butineuse(partie));
        j.setAbeille(2, new Venimeuse());
    }

    public void poser(String beeType, int row, int column) throws IllegalPosException, HoneyException {
        Abeille bee;
        if (validerTypeAbeille(beeType)) {
            System.out.println(
                    "\u001B[31mVous ne pouvez poser que des abeilles snipers et des butineuses et des venimeuses.\u001B[0m");
            throw new IllegalPosException(
                    "Vous ne pouvez poser que des abeilles snipers et des butineuses et des venimeuses.");
        }
        switch (beeType) {
            case "S":
                bee = new Sniper();
                if (partie.getMap().posLegal(row, column)) {
                    if (j.getMiel() < bee.getCout()) {
                        System.out.println("Vous n'avez pas assez de miel pour poser cette abeille.");
                        partie.getTour().run();
                    } else {
                        placeBee(bee, row, column);
                    }
                } else {
                    throw new IllegalPosException("Position invalide. Veuillez choisir une autre position:");
                    // poser(beeType,row,column);
                }
                break;
            case "B":
                bee = new Butineuse(partie);
                if (partie.getMap().posLegal(row, column)) {
                    if (j.getMiel() < bee.getCout()) {
                        System.out.println("Vous n'avez pas assez de miel pour poser cette abeille.");
                        partie.getTour().run();
                    } else {
                        placeBee(bee, row, column);
                    }
                } else {
                    System.out.println("\u001B[31mPosition invalide. Veuillez choisir une autre position:\u001B[0m");
                    throw new IllegalPosException("Position invalide. Veuillez choisir une autre position:");
                    // poser(beeType,row,column);
                }
                break;
            case "V":
                bee = new Venimeuse();
                if (partie.getMap().posLegal(row, column)) {
                    if (j.getMiel() < bee.getCout()) {
                        partie.getTour().run();
                        System.out.println("Vous n'avez pas assez de miel pour poser cette abeille.");
                        throw new HoneyException("Vous n'avez pas assez de miel pour poser cette abeille.");

                    } else {
                        placeBee(bee, row, column);
                    }
                } else {
                    System.out.println("\u001B[31mPosition invalide. Veuillez choisir une autre position:\u001B[0m");
                    throw new IllegalPosException("Position invalide. Veuillez choisir une autre position:");
                    // poser(beeType,row,column);
                }
                break;
        }
    }

    // <QUESTION> RAJOUTER PLUS DE COMBISNAISON??
    public void poserEnnemis() {
        if (PartieG.isMarathon()) {
            poserEnnemisMarathon();
        } else {


        if (this.getVague()[partie.getTour().nbVague - 1] > 0) {
            Random rr = new Random();
            int entier1 = rr.nextInt(this.getVague()[partie.getTour().nbVague - 1]) + 1;
            int combinaison1 = rr.nextInt(4);
            System.out.print("\n");
            System.out.print("\n");
            switch (combinaison1) {
                case 0:
                    for (int i = 0; i < entier1; i++) {
                        Chenille c = new Chenille();
                        partie.getMap().initialise(c);
                        this.getVague()[partie.getTour().nbVague - 1]--;
                    }
                    break;
                case 1:
                    for (int i = 0; i < entier1; i++) {
                        Araignee a = new Araignee();
                        partie.getMap().initialise(a);
                        this.getVague()[partie.getTour().nbVague - 1]--;
                    }
                    break;
                case 2:
                    for (int i = 0; i < entier1 / 3; i++) {
                        Frelon f = new Frelon();
                        partie.getMap().initialise(f);
                        this.getVague()[partie.getTour().nbVague - 1]--;
                    }
                    break;
                case 3:
                    for (int i = 0; i < entier1 / 3; i++) {
                        Chenille c = new Chenille();
                        Araignee a = new Araignee();
                        Frelon f = new Frelon();
                        partie.getMap().initialise(c);
                        partie.getMap().initialise(a);
                        partie.getMap().initialise(f);
                        this.getVague()[partie.getTour().nbVague - 1] -= 3;
                    }
                    break;
                default:
                    break;
            }
        }
        }
    }


    public static boolean validerTypeAbeille(String beeType) {
        return !beeType.equals("S") && !beeType.equals("B") && !beeType.equals("V");
    }

   public void poserEnnemisMarathon() {
       Random rr = new Random();
       int entier1 = rr.nextInt(3) + 1;
       int combinaison1 = rr.nextInt(4);
       switch (combinaison1) {
           case 0:
               for (int i = 0; i < entier1; i++) {
                   Chenille c = new Chenille();
                   partie.getMap().initialise(c);
               }
               break;
           case 1:
               for (int i = 0; i < entier1; i++) {
                   Araignee a = new Araignee();
                   partie.getMap().initialise(a);
               }
               break;
           case 2:
               for (int i = 0; i < entier1 / 3; i++) {
                   Frelon f = new Frelon();
                   partie.getMap().initialise(f);
               }
               break;
           case 3:
               for (int i = 0; i < entier1 / 3; i++) {
                   Chenille c = new Chenille();
                   Araignee a = new Araignee();
                   Frelon f = new Frelon();
                   partie.getMap().initialise(c);
                   partie.getMap().initialise(a);
                   partie.getMap().initialise(f);
               }
               break;
           default:
               break;
       }
   }


}
