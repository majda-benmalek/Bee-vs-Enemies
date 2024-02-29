package view.Controller;

import view.View.Plateau;
import view.Model;

public class PlateauController {
    private Model model;

    public PlateauController(Model m) {
        this.model = m;
        for (int i = 0; i < Plateau.rows; i++) {
            for (int j = 0; j < Plateau.cols; j++) {
                new CaseController(Plateau.getCases()[i][j], model);
            }
        }
    }
}
