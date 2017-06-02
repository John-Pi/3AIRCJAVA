package model;

import launcher.localLauncher.LauncherCmdLine;

/**
 * Created by Johnpi on 31/05/2017.
 */
public class test {
    public static void main(String[] args){
        Pieces tour1 = new Tour(Couleur.BLANC ,new Coord(1,1));
        System.out.println(tour1.toString());
        System.out.println(tour1.isMoveOk(2,2,true,true));
        Pieces fou = new Fou(Couleur.BLANC, new Coord(1, 1));
        System.out.println(fou.toString());
        System.out.println(fou.isMoveOk(2, 2, true, true));
        Game jeu1 = new Jeu(Couleur.BLANC);
        System.out.println(jeu1.toString());
        BoardGames echec = new Echiquier();
        System.out.println(echec.toString());
        Pieces pion = new Pion(Couleur.BLANC,new Coord(3,2));
        System.out.println(pion.isMoveOk(3,1,true,true));

    }
}
