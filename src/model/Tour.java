package model;

/**
 * Created by Jean Multigner et Delphine Collin
 */
public class Tour extends AbstractPiece {

    public Tour(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }


    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        return (xFinal != getX() && yFinal == getY() || xFinal == getX() && yFinal != getY())
                && (coord.coordonnees_valides(xFinal,yFinal));

    }

}