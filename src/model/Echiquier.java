package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Johnpi on 01/06/2017.
 */
public class Echiquier implements BoardGames {

    public Jeu jeuBlanc;
    public Jeu jeuNoir;
    public Jeu jeuCourant = jeuBlanc;
    public Jeu jeuNonCourant ;
    private String message ;
    public Echiquier() {
        jeuBlanc = new Jeu(Couleur.BLANC);
        jeuNoir = new Jeu(Couleur.NOIR);

    }


    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        if (isMoveOk(xInit,yInit,xFinal,yFinal)){
            jeuCourant.move(xInit,yInit,xFinal,yFinal);
            return true;
        }
        return false;
    }
    public List<PieceIHMs> getPiecesIHM(){
        List<PieceIHMs> list = new LinkedList<PieceIHMs>();
        list.addAll(jeuBlanc.getPiecesIHM());
        list.addAll(jeuNoir.getPiecesIHM());
        return list;
    }
    @Override
    public boolean isEnd() {
        return false;
    }

    @Override
    public String getMessage() {
        return message;
    }

    private void setMessage(String message1){
        message = message1 ;
    }

    @Override
    public Couleur getColorCurrentPlayer() {
        if (jeuCourant == jeuBlanc){
            return Couleur.BLANC;
        }
        else {
            return Couleur.NOIR;
        }
    }

    @Override
    public Couleur getPieceColor(int x, int y) {
        return jeuCourant.getPieceColor(x,y);
        }

    public String toString(){
        return jeuBlanc.toString()+"" +jeuNoir.toString();
    }
    public void switchJoueur(){
        if (jeuCourant == jeuBlanc ){
            jeuCourant = jeuNoir;
            jeuNonCourant = jeuBlanc;
        }
        else {
            jeuCourant = jeuBlanc;
            jeuNonCourant = jeuNoir;
        }
    }
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal){
        return (jeuCourant.isMoveOk(xInit,yInit, xFinal,yFinal,true,true));
    }

}
