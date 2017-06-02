package model;
import model.AbstractPiece;

/**
 * Created by Jean Multigner et Delphine Collin
 */

public class Pion extends AbstractPiece {
    public Pion(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        if (xFinal == getX()) {

            if (getY() == 6 && getCouleur() == Couleur.BLANC) {
                return (Math.abs(yFinal - getY()) <= 2) && yFinal < getY();
            }
            if (getY() != 6 && getCouleur() == Couleur.BLANC) {
                return (Math.abs(yFinal - getY()) == 1) && yFinal < getY();
            }
            if (getY() == 1 && getCouleur() == Couleur.NOIR) {
                return (Math.abs(yFinal - getY()) <= 2) && yFinal > getY();
            }
            if (getY() != 1 && getCouleur() == Couleur.NOIR) {
                return (Math.abs(yFinal - getY()) == 1) && yFinal > getY();
            }


        } else {
            return false;
        }
        return false;
    }
}

