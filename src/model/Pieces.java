package model;

/**
 * Created by Johnpi on 31/05/2017.
 */
public interface Pieces {


    public boolean capture();

    public Couleur getCouleur();

    public String getName();

    public int getX();

    public int getY();

    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible);

    public boolean move(int xFinal, int yFinal);

}

