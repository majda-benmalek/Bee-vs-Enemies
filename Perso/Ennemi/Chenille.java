package Perso.Ennemi;

public class Chenille extends Ennemis {
    private boolean dead;
    private static final int degats = 25;

    public Chenille() {
        super(100, degats, false);
    }

    public String toString() {
        if (this.isEmpoisonne() && this.getPv() < 100 / 3) {
            // orange
            return "\u001B[38;5;166m" + "C" + "\u001B[0m";
        } else if (this.isEmpoisonne()) {
            // vert chelou
            return "\u001B[38;5;100m" + "C" + "\u001B[0m";
        } else if (this.getPv() < 100 / 3) {
            // Rouge
            return "\u001B[38;5;88m" + "C" + "\u001B[0m";
        } else {
            return "C";
        }
    }

}
