
package launcher.localLauncher;

import java.awt.Dimension;
import java.util.Observer;

import javax.swing.JFrame;

import controler.ChessGame;
import controler.ChessGameControlers;
import controler.controlerLocal.ChessGameControler;

import vue.ChessGameGUI;



/**
 * @author francoise.perrin
 * Lance l'exÃ©cution d'un jeu d'Ã©chec en mode graphique.
 * La vue (ChessGameGUI) observe le modÃ¨le (ChessGame)
 * les Ã©changes passent par le contrÃ´leur (ChessGameControlers)
 *
 */
public class LauncherGUI {

    /**
     * @param args
     */
    public static void main(String[] args) {

        ChessGame chessGame;
        ChessGameControler chessGameControler;
        JFrame frame;
        Dimension dim;

        dim = new Dimension(700, 700);

        chessGame = new ChessGame();
        chessGameControler = new ChessGameControler(chessGame);

        frame = new ChessGameGUI("Jeu d'échec", chessGameControler,  dim);
        chessGame.addObserver((Observer) frame);
        frame.setTitle("Jeu d'échec");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(600, 10);
        frame.pack();
        frame.setVisible(true);
    }
}