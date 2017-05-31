package model;

import model.AbstractPiece;
import model.Coord;
import model.Couleur;

import static java.lang.Math.abs;

/**
 * Created by Johnpi on 31/05/2017.
 */
public class Cavalier extends AbstractPiece {
    Cavalier(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        if (xFinal != this.getX() && yFinal != getY()) {
            if (((xFinal - getX() == 3) && (yFinal - getY() == 1)
                    || (xFinal - getX() == 1) && (yFinal - getY() == 3))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}