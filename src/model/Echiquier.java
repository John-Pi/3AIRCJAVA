package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Johnpi on 01/06/2017.
 */
public class Echiquier implements BoardGames {

    public Jeu jeuBlanc;
    public Jeu jeuNoir;
    public Jeu jeuCourant;
    public Jeu jeuNonCourant;
    private String message;

    public Echiquier() {
        jeuBlanc = new Jeu(Couleur.BLANC);
        jeuNoir = new Jeu(Couleur.NOIR);
        jeuCourant = jeuBlanc;
        jeuNonCourant = jeuNoir;
    }


    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        if (isMoveOk(xInit, yInit, xFinal, yFinal)) {
            jeuCourant.move(xInit, yInit, xFinal, yFinal);
            if (jeuNonCourant.isPieceHere(xFinal, yFinal)) {
                jeuNonCourant.capture(xFinal, yFinal);
            }
            return true;
        } else {
            this.setMessage("move non OK");
            return false;
        }

    }

    public List<PieceIHMs> getPiecesIHM() {
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

    private void setMessage(String message1) {
        message = message1;
    }

    @Override
    public Couleur getColorCurrentPlayer() {
        if (jeuCourant == jeuBlanc) {
            return Couleur.BLANC;
        } else {
            return Couleur.NOIR;
        }
    }

    @Override
    public Couleur getPieceColor(int x, int y) {
        return jeuCourant.getPieceColor(x, y);
    }

    public String toString() {
        return jeuBlanc.toString() + "" + jeuNoir.toString();
    }

    public void switchJoueur() {
        if (jeuCourant == jeuBlanc) {
            jeuCourant = jeuNoir;
            jeuNonCourant = jeuBlanc;
        } else {
            jeuCourant = jeuBlanc;
            jeuNonCourant = jeuNoir;
        }
    }

    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
        if (jeuCourant.isMoveOk(xInit, yInit, xFinal, yFinal, true, true)) {
            if (!somethingOnRoad(xInit, yInit, xFinal, yFinal)) {
                if (!jeuCourant.isPieceHere(xFinal, yFinal)) {
                    setMessage("Move Ok");
                    return true;
                }

            }

        }
        setMessage("Move non Ok");
        return false;
    }

    private boolean somethingOnRoad(int xInit, int yInit, int xFinal, int yFinal) {
        boolean thereIsOne = false;

        //Si on est pas un cavalier
        if (!jeuCourant.getPieceName(xInit, yInit).equals("Cavalier")) {
            //Déplacement horizontal
            if (yInit == yFinal && xInit != xFinal) {
                if (xInit < xFinal) {
                    for (int i = 1; i < xFinal - xInit; i++) {
                        if (jeuCourant.isPieceHere(xInit + i, yFinal) || jeuNonCourant.isPieceHere(xInit + i, yFinal)) {
                            thereIsOne = true;
                        }
                    }
                } else {
                    for (int i = 1; i < xInit - xFinal; i++) {
                        if (jeuCourant.isPieceHere(xFinal + i, yFinal) || jeuNonCourant.isPieceHere(xFinal + i, yFinal)) {
                            thereIsOne = true;
                        }
                    }
                }
            } else if (yInit != yFinal && xInit == xFinal) { //Déplacement vertical
                if (yInit < yFinal) {
                    for (int i = 1; i < yFinal - yInit; i++) {
                        if (jeuCourant.isPieceHere(xFinal, yInit + i) || jeuNonCourant.isPieceHere(xFinal, yInit + i)) {
                            thereIsOne = true;
                        }
                    }
                } else {
                    for (int i = 1; i < yInit - yFinal; i++) {
                        if (jeuCourant.isPieceHere(xFinal, yFinal + i) || jeuNonCourant.isPieceHere(xFinal, yFinal + i)) {
                            thereIsOne = true;
                        }
                    }
                }
                //Test particulier pour pion
                if ((jeuCourant.getPieceName(xInit, yInit).equals("Pion")) && (jeuNonCourant.isPieceHere(xFinal, yFinal))) {
                    thereIsOne = true;
                }
            } else {
                //Déplacement diagonale restant uniquement
                if (xFinal - xInit > 0 && yFinal - yInit < 0) {
                    for (int i = 1; i < xFinal - xInit; i++) {
                        if (jeuCourant.isPieceHere(xInit + i, yInit - i) || jeuNonCourant.isPieceHere(xInit + i, yInit - i)) {
                            thereIsOne = true;
                        }
                    }
                } else if (xFinal - xInit < 0 && yFinal - yInit < 0) {
                    for (int i = 1; i < xInit - xFinal; i++) {
                        if (jeuCourant.isPieceHere(xInit - i, yInit - i) || jeuNonCourant.isPieceHere(xInit - i, yInit - i)) {
                            thereIsOne = true;
                        }
                    }
                } else if (xFinal - xInit < 0 && yFinal - yInit > 0) {
                    for (int i = 1; i < xInit - xFinal; i++) {
                        if (jeuCourant.isPieceHere(xInit - i, yInit + i) || jeuNonCourant.isPieceHere(xInit - i, yInit + i)) {
                            thereIsOne = true;
                        }
                    }
                } else {
                    for (int i = 1; i < xFinal - xInit; i++) {
                        if (jeuCourant.isPieceHere(xInit + i, yInit + i) || jeuNonCourant.isPieceHere(xInit + i, yInit + i)) {
                            thereIsOne = true;
                        }
                    }
                }
            }
        }


        return thereIsOne;
    }

}
