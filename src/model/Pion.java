package model;

import model.AbstractPiece;

/**
 * Created by Jean Multigner et Delphine Collin
 */

public class Pion extends AbstractPiece {
    public Pion(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        if (xFinal == getX()) {

            if (getY() == 6 && getCouleur() == Couleur.BLANC) {
                return (Math.abs(yFinal - getY()) <= 2) && yFinal < getY();
            }
            if (getY() != 6 && getCouleur() == Couleur.BLANC) {
                return (Math.abs(yFinal - getY()) == 1) && yFinal < getY();
            }
            if (getY() == 1 && getCouleur() == Couleur.NOIR) {
                return (Math.abs(yFinal - getY()) <= 2) && yFinal > getY();
            }
            if (getY() != 1 && getCouleur() == Couleur.NOIR) {
                return (Math.abs(yFinal - getY()) == 1) && yFinal > getY();
            }


        } else {
            return false;
        }
        return false;
    }

    public boolean canCapture(int xFinal, int yFinal) {
        if (getCouleur() == Couleur.BLANC) {
            if (yFinal < getY()) {
                return Math.abs(xFinal - this.getX()) == Math.abs(yFinal - this.getY()) && (xFinal - this.getX() == 1);
            }
            return false;
        } else {
            if (yFinal > getY()) {
                return Math.abs(xFinal - this.getX()) == Math.abs(yFinal - this.getY()) && (xFinal - this.getX() == 1);
            }
            return false;

        }
    }
}

