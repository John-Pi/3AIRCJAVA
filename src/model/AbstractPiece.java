package model;

/**
 * Created by Johnpi on 31/05/2017.
 */
public abstract class AbstractPiece implements Pieces {
    Coord coord;
    private final Couleur couleur;
    private boolean isCaptured;

    AbstractPiece(Couleur couleur, Coord coord) {
        this.couleur = couleur;
        this.coord = coord;
    }

    public String toString(){
        return this.getName()+" "+this.coord.toString();
    }

    @Override
    public boolean capture() {
        isCaptured = true;
        move(-1,-1);
        return isCaptured;
    }

    @Override
    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public int getX() {
        return coord.x;
    }

    @Override
    public int getY() {
        return coord.y;
    }

    @Override
    public boolean move(int xFinal, int yFinal) {
        coord.x = xFinal;
        coord.y = yFinal;
        return true;
    }

    public abstract boolean isMoveOk(int xFinal,
                                     int yFinal,
                                     boolean isCatchOk,
                                     boolean isCastlingPossible);
}

