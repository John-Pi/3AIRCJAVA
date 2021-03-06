package model;

/**
 * @author Jean Multigner et Delphine Collin
 */
public class Fou extends AbstractPiece {

    public Fou(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        if(Coord.coordonnees_valides(xFinal, yFinal)) {
            if(Math.abs(xFinal - this.getX()) == Math.abs(yFinal - this.getY())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
