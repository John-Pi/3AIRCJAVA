package model;

/**
 * Created by Jean Multigner et Delphine Collin
 * 
 * Cette interface répertorie tout les comportements 
 * attendus d'une pièce
 * 
 */
public interface Pieces {

    /**
     *
     * @return OK si la piece a le droit de capturer la piece qui se trouve 
    * aux coordonnées finales. 
     */

    public boolean capture();

    
    /**
     *
     * @return la couleur de la piece
     */

    public Couleur getCouleur();

    /**
     *
     * @return le nom de la piece
     */

    public String getName();

    /**
     *
     * @return l'indice de la colonne ou est positionnee la piece
     */

    public int getX();

    /**
     *
     * @return l'indice de la  ligne ou est positionnee la piece
     */

    public int getY();

    /**
     *
     * @param xFinal
     * @param yFinal
     * @param isCatchOk
     * @param isCastlingPossible
     * @return true si déplacement légal en fonction du mouvement specifique 
     * de chaque pièce
     */

    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible);

    /**
     *
     * @param xFinal
     * @param yFinal
     * @return true si deplacement effectif
     */

    public boolean move(int xFinal, int yFinal);

}

