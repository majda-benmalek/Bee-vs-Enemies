package Perso.Ennemi;

public class Frelon extends Ennemis {
    private boolean dead;
    private static final int degats = 50;

    public Frelon() {
        super(100, degats, false);
    }

    public String toString() {
        if (this.isEmpoisonne() && this.getPv() < 100 / 3) {
            // orange
            return "\u001B[38;5;166m" + "F" + "\u001B[0m";
        } else if (this.isEmpoisonne()) {
            // Violet
            return "\u001B[38;5;100m" + "F" + "\u001B[0m";
        } else if (this.getPv() < 100 / 3) {
            // rouge
            return "\u001B[38;5;88m" + "F" + "\u001B[0m";
        } else {
            return "F";
        }
    }

}
