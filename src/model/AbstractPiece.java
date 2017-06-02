package model;

/**
 * Created by Jean Multigner et Delphine Collin
 * 
 * Cette classe abstraite implémente toutes les comportements communs des pices.
 * Seule isMove() doit etre implementee selon la piece
 * 
 */
public abstract class AbstractPiece implements Pieces {
    Coord coord;
    private final Couleur couleur;
    private boolean isCaptured;

    AbstractPiece(Couleur couleur, Coord coord) {
        this.couleur = couleur;
        this.coord = coord;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.coord.toString();
    }

    @Override
    /*
    * Cette methode sort la piece capturee de l'echiquier en positionnant son
    * x et y a -1
    * @return true si la piece est capturee
    */
    public boolean capture() {
        isCaptured = true;
        this.coord.x =-1;
        this.coord.y = -1;
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

    /*
    * @return true si le deplacement est effectue
    */
    @Override
    public boolean move(int xFinal, int yFinal) {
        coord.x = xFinal;
        coord.y = yFinal;
        return true;
    }
  
    /**
     *
     * @param xFinal
     * @param yFinal
     * @param isCatchOk
     * @param isCastlingPossible
     * @return true si dplacement legal en fonction des algo de déplacement specifique de chaque piece
     */

    @Override
    public abstract boolean isMoveOk(int xFinal,
                                     int yFinal,
                                     boolean isCatchOk,
                                     boolean isCastlingPossible);
}

