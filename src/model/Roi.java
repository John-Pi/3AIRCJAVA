package model;
import java.lang.*;

/**
 *
 * @author Jean Multigner et Delphine Collin
 */
public class Roi extends AbstractPiece{

    public Roi(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
    boolean ret = false;
    if(Coord.coordonnees_valides(xFinal, yFinal)==true){
        if(Math.abs(xFinal - this.coord.x)== 1 && Math.abs(yFinal - this.coord.y)== 1
            || Math.abs(xFinal - this.coord.x)== 0 && Math.abs(yFinal - this.coord.y)== 1
            || Math.abs(xFinal - this.coord.x)== 1 && Math.abs(yFinal - this.coord.y)== 0){
            ret = true;
        }
    }
    return ret;
    }    
}
