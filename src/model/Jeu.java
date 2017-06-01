package model;

import tools.ChessPiecesFactory;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by Johnpi on 31/05/2017.
 */
public class Jeu implements Game {
    private Couleur couleur;
    private List<Pieces> listPiece;

    public Jeu(Couleur couleur) {
        this.couleur = couleur;

        listPiece = ChessPiecesFactory.newPieces(couleur);
    }

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
        return (findPiece(x, y) != null);
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
        return false;
    }


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

}
