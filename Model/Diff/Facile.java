package Model.Diff;

import Model.*;
import Perso.Bee.Abeille;
import Perso.Bee.Sniper;
import Perso.Ennemi.Chenille;
import Perso.Filet;

import static Model.Map.placeBee;

public class Facile extends Difficulte {
    private static final String d = "Facile";
    private static final diff di = diff.F;
    private static final int ligne = 3;
    private static final Filet[] filet = new Filet[ligne];
    private Joueur j;
    private PartieG partie;

    public Facile(Joueur jo, PartieG p) {
        super(di, ligne, new int[] { 1, 2, 3 }, filet, d,  100);
        partie = p;
        for (int i = 0; i < filet.length; i++) {
            filet[i] = new Filet(i, partie);
        }
        j = jo;

        j.setAbeille(0, new Sniper());
    }

    public void poser(String beeType, int row, int column)
            throws IllegalPosException, HoneyException, IllegalBeeException {
        Abeille bee = new Sniper();
        if (!beeType.equals("S")) {
            partie.getTour().run();
            System.out.println("\u001B[31mVous ne pouvez poser que des abeilles snipers.\u001B[0m");
            throw new IllegalBeeException("Vous ne pouvez poser que des abeilles snipers.");
        }
        if (partie.getMap().posLegal(row, column)) {
            if (j.getMiel() < bee.getCout()) {
                partie.getTour().run();
                System.out.println("\u001B[31mVous n'avez pas assez de miel pour poser cette abeille.\u001B[0m");
                throw new HoneyException("Vous n'avez pas assez de miel pour poser cette abeille.");
            } else {
                placeBee(bee, row, column);

            }
        } else {
            System.out.println("\u001B[31mPosition invalide. Veuillez choisir une autre position.\u001B[0m");
            throw new IllegalPosException("Position invalide. Veuillez choisir une autre position:");
        }
    }

    public void poserEnnemis() {
        if (this.getVague()[partie.getTour().nbVague - 1] > 0) {
            Chenille c = new Chenille();
            partie.getMap().initialise(c);
            this.getVague()[partie.getTour().nbVague - 1]--;
        }
    }


}
