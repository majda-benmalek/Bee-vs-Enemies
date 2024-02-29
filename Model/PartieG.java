package Model;

import java.util.Timer;

import Model.Diff.Difficile;
import Model.Diff.Difficulte;

public class PartieG {
    public static boolean enCours = true;
    private TourG t;
    private final Joueur j;
    private Difficulte difficulte;
    private Map map;
    private static boolean marathon;
    private Timer timer;

    public PartieG(Joueur jo) {
        this.j = jo;

    }

    // Getter et setter
    public void setDifficulte(Difficulte d) {
        if (marathon) {
            System.out.println("\u001B[35mVous avez choisi le mode marathon.\u001B[0m");
            j.setMiel(300);
            difficulte = new Difficile(j, this);
        } else {
            difficulte = d;
            j.setMiel(difficulte.getMiel());
        }
        map = new Map(this);
        t = new TourG(map, j, difficulte);
        this.timer = new Timer();
        jouer();

    }

    public Difficulte getDifficulte() {
        return difficulte;
    }

    public static void setMarathon(boolean m) {
        marathon = m;
    }

    public boolean getMarathon() {
        return marathon;
    }

    public TourG getTour() {
        return t;
    }

    public void setTour(TourG t) {
        this.t = t;
    }

    public void setMap(Map m) {
        map = m;
    }

    public Joueur getJoueur() {
        return j;
    }

    public Map getMap() {
        return map;
    }

    public static boolean isMarathon() {
        return marathon;
    }

    public void jouer() {
        if (enCours) {
            try {
                System.out.println("\u001B[35mVous avez choisi la difficulté " + difficulte.getD()
                        + ".\u001B[0m");
            } catch (NullPointerException e) {
                System.out.println("Au revoir!");
                enCours = false;
            }
        }
        timer.scheduleAtFixedRate(t, 2000, 3000);

    }


}
