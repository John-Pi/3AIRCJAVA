package model;
import model.AbstractPiece;

/**
 * Created by Johnpi on 31/05/2017.
 */

public class Pion extends AbstractPiece {
    public Pion(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        if(Couleur.BLANC == this.getCouleur()){
            return yFinal < getY() && xFinal == getX();
        }
        else{
            return yFinal > getY() && xFinal == getX();
        }
    }
}
