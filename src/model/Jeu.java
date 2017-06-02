package model;

import tools.ChessPiecesFactory;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jean Multigner et Delphine Collin
 * 
 * 
 */
public class Jeu implements Game {
    private Couleur couleur;
    private List<Pieces> listPiece;

    /**
     *
     * @param couleur
     */
    public Jeu(Couleur couleur) {
        this.couleur = couleur;

        listPiece = ChessPiecesFactory.newPieces(couleur);
    }

    /*
    * Parcours la liste de piece
    * @return la piece qui se trouve aux coordonnées indiquees en parametre
    */
    private Pieces findPiece(int x, int y) {
        Pieces piece1 = null;
        for (Pieces piece : listPiece) {
            if (piece.getX() == x && piece.getY() == y) {
                piece1 = piece;
            }
        }
        return piece1;
    }


    @Override
    public String toString() {
        String desc = "";
        for (Pieces piece : listPiece) {
            desc = desc + " " + piece.toString();
        }
        return desc;
    }

    @Override
    public boolean isPieceHere(int x, int y) {
        if(findPiece(x, y) != null) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        Pieces piece = findPiece(xInit, yInit);
        if (piece != null) {
            if (piece.isMoveOk(xFinal, yFinal, true, true)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        ;
        Pieces piece = findPiece(xInit, yInit);
        if (piece != null) {


            piece.move(xFinal, yFinal);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean capture(int xCatch, int yCatch) {
        findPiece(xCatch, yCatch).capture();
        return true;
    }

    /**
     *
     * @return une vue de la liste des pieces en cours ne donnant que 
     * des acces en lecture sur des PieceIHM (type piece + couleur 
     * + liste de coordonnees)
     */
    public List<PieceIHMs> getPiecesIHM(){
        PieceIHMs newPieceIHM = null;
        List<PieceIHMs> list = new LinkedList<PieceIHMs>();
        for (Pieces piece : listPiece){
            if (piece.getX() != -1){
                newPieceIHM = new PieceIHM(piece);
                list.add(newPieceIHM);
            }
        }
        return list;
    }

    /**
     *
     * @param x
     * @param y
     * @return la couleur de la piece squi se trouve aux coordonnees indiquees
     */
    public Couleur getPieceColor(int x, int y) {
        Pieces piece ;
        piece = findPiece(x,y);
        if (piece != null){
            return piece.getCouleur();
        }
        else {
            return null;
        }
    }

    /**
     *
     * @param x
     * @param y
     * @return le nom de la piece qui se trouve aux coordonnees indiquees
     */
    public String getPieceName(int x, int y) {
        Pieces piece = findPiece(x, y);
        String nom = null;

        if(piece != null) {
            nom = piece.getName();
        }

        return nom;
    }
}

