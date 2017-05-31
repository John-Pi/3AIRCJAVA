package model;

/**
 * Created by Johnpi on 31/05/2017.
 */
public class Tour extends AbstractPiece {

    Tour(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }


    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        return (xFinal != getX() && yFinal == getY() || xFinal == getX() && yFinal != getY())
                && (coord.coordonnees_valides(xFinal,yFinal));

    }

}