package model;

import tools.ChessPiecesFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Johnpi on 31/05/2017.
 */
public class Jeu implements Game{
    private  Couleur couleur;
    private List<Pieces> listPiece;

    public Jeu(Couleur couleur) {
        this.couleur = couleur;
        listPiece = new ArrayList<>();
        listPiece = ChessPiecesFactory.newPieces(couleur);
    }

    @Override
    public String toString() {
        String desc = "";
        for (Pieces piece:listPiece){
            desc = desc+piece.toString();
        }
        return desc;
    }

    @Override
    public boolean isPieceHere(int x, int y) {
        return false;
    }

    @Override
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        return false;
    }

    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        return false;
    }

    @Override
    public boolean capture(int xCatch, int yCatch) {
        return false;
    }
}
