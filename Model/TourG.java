package Model;

import Model.Diff.Difficulte;
import Perso.Bee.Abeille;
import Perso.Ennemi.Ennemis;

import java.util.TimerTask;

public class TourG extends TimerTask {
    public int nbVague = 1;
    public int nbTour = 0;
    private static Map map;
    private static Joueur j;
    private boolean perdu = false;
    private boolean gagne = false;
    public Difficulte difficulte;
    private int nbTourMar = 40;

    public TourG(Map m, Joueur jo, Difficulte d) {
        map = m;
        j = jo;
        this.difficulte = d;
    }

    public boolean isGagne() {
        return this.gagne;
    }

    public boolean isPerdu() {
        return this.perdu;
    }

    public int getNbTourMar() {
        return nbTourMar;
    }

    public Map getMap() {
        return map;
    }

    public void run() {
        if (PartieG.isMarathon()) {
            System.out.println("\u001B[4mTour numero: " + nbTour + ".\u001B[0m");
        }
        System.out.println("\u001B[4mNombre de vague : " + nbVague + ".\u001B[0m");
            ajout();
            attaque();
        nbTour++;
        map.affiche();
        if(PartieG.isMarathon()){
            gagnerMar();
        }else{
            gagner();
        }
        perdu();
        // Pour sortir du tour quand on a gagné ou perdu
        if (!PartieG.enCours) {
            return;
        }

        if (this.difficulte.getVague()[nbVague - 1] == 0 && !map.ennemisPresentM()
                && nbVague < this.difficulte.getVague().length) {
            nbVague++;
        }

        for (int i = 0; i < difficulte.getFilet().length; i++) {
            if (!difficulte.getFilet()[i].isUsed()) {
                difficulte.getFilet()[i].tuerSurUneLigne(i);
            }
        }
    }

    public void ruche() {
        j.setMiel(j.getMiel() + 20);
    }

    public void ajout() {
        if (PartieG.isMarathon()) {
            this.difficulte.poserEnnemis();
        } else {
            if (nbVague - 1 < this.difficulte.getVague().length) {
                this.difficulte.poserEnnemis();
            }
        }


    }

    public static void attaque() {
        for (int i = 0; i < map.getLigne(); i++) {
            for (int j = 0; j < Map.getColonne(); j++) {
                if (map.getTerrain()[i][j] instanceof Abeille) {
                    try {
                        Ennemis e = map.EnnemisPresentL(i);
                        map.getTerrain()[i][j].attaque(e);
                        if (e.getNbTourPoison() < 3) {
                            e.empoisonnement();
                            e.setNbTourPoison(e.getNbTourPoison() + 1);
                        }
                        // gere l'immobilisation de l'abeille
                        // Elle ne peut etre immobilisé que 3 tours
                        if (((Abeille) map.getTerrain()[i][j]).getImmobilise()) {
                            ((Abeille) map.getTerrain()[i][j])
                                    .setNbTourImmobilise(((Abeille) map.getTerrain()[i][j]).getNbTourImmobilise() + 1);
                            if (((Abeille) map.getTerrain()[i][j]).getNbTourImmobilise() == 3) {
                                ((Abeille) map.getTerrain()[i][j]).setImmobilise(false);
                                ((Abeille) map.getTerrain()[i][j]).setNbTourImmobilise(0);
                            }
                        }

                    } catch (NullPointerException ignored) {
                    }
                }
            }
        }
    }

    public void gagner() {
        if (nbVague == this.difficulte.getVague().length && !map.ennemisPresentM()
                && this.difficulte.getVague()[nbVague - 1] == 0) {
            System.out.println("Vous avez gagné!");
            PartieG.enCours = false;
            gagne = true;
        }

    }

    public void perdu() {
        for (int i = 0; i < map.getLigne(); i++) {
            if (this.difficulte.getFilet()[i].isUsed() && map.getTerrain()[i][0] instanceof Ennemis) {
                System.out.println("Vous avez perdu!");
                PartieG.enCours = false;
                perdu = true;
            }
        }
    }
    public void gagnerMar() {
        if (nbTour == nbTourMar ) {
            System.out.println("Vous avez gagné!");
            PartieG.enCours = false;
            gagne = true;
        }
    }



}
