package model;

/**
 *
 * @author nrmv4488
 */
public class Reine extends AbstractPiece{

    public Reine(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        boolean ret = false;
        if(Coord.coordonnees_valides(xFinal, yFinal)== true){
            if( Math.abs(xFinal - getX()) == Math.abs(yFinal - getY())                    //diagonales
                    || xFinal == getX() && yFinal != getY()             //seuls les y changent
                    || xFinal != getX() && yFinal == getY()           // seuls les x changent
                    || Math.abs(xFinal - this.coord.x)== 1 && Math.abs(yFinal - this.coord.y)== 1       //se déplace d'une seule case
                    || Math.abs(xFinal - this.coord.x)== 0 && Math.abs(yFinal - this.coord.y)== 1
                    || Math.abs(xFinal - this.coord.x)== 1 && Math.abs(yFinal - this.coord.y)== 0){
                ret = true;
            }
        }
        return ret;
    }
}
