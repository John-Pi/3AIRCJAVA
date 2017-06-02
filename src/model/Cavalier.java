package model;

import model.AbstractPiece;
import model.Coord;
import model.Couleur;

import static java.lang.Math.abs;

/**
 * Created by Johnpi on 31/05/2017.
 */
public class Cavalier extends AbstractPiece {
    public Cavalier(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        if(Coord.coordonnees_valides(xFinal, yFinal)) {
            if((Math.abs(xFinal - this.getX()) + Math.abs(yFinal - this.getY())) == 3) {
                if(Math.abs(xFinal - this.getX()) < 3 && Math.abs(yFinal - this.getY()) < 3) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}