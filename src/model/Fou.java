package model;

/**
 * @author nrmv4488
 */
public class Fou extends AbstractPiece {

    public Fou(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        boolean ret = false;
        if (Coord.coordonnees_valides(xFinal, yFinal) == true) {
            if (xFinal - this.coord.x == yFinal - this.coord.y) {
                return true;
            }
        }
        return ret;
    }
}
