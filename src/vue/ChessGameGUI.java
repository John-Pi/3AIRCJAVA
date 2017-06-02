package vue;

import controler.ChessGameControlers;
import model.PieceIHM;
import tools.ChessImageProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.util.List;

/**
 * Created by Johnpi on 02/06/2017.
 */
public class ChessGameGUI extends JFrame implements MouseListener, MouseMotionListener, Observer {


    private Dimension dim;
    private ChessGameControlers chessGameControler;
    private String s;
    private JLayeredPane layeredPane;
    private JPanel chessBoard;
    private JLabel piece;

    public ChessGameGUI(String s, ChessGameControlers chessGameControler, Dimension dim) {
        this.s = s;
        this.chessGameControler = chessGameControler;
        this.dim = dim;
        createBoard();

    }

    private void createBoard() {
        //  Use a Layered Pane for this this application
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(dim);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);

        //Add a chess board to the Layered Pane

        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout(new GridLayout(8, 8));
        chessBoard.setPreferredSize(dim);
        chessBoard.setBounds(0, 0, dim.width, dim.height);

        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel(new BorderLayout());
            chessBoard.add(square);

            int row = (i / 8) % 2;
            if (row == 0)
                square.setBackground(i % 2 == 0 ? Color.BLACK : Color.white);
            else
                square.setBackground(i % 2 == 0 ? Color.white : Color.BLACK);
        }


    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void update(Observable o, Object arg) {
        List<PieceIHM> pieceIHM = (List<PieceIHM>) arg;
        JLabel piece = null;
        JPanel panel = null;

        for (PieceIHM p : pieceIHM) {
            piece = new JLabel(new ImageIcon(ChessImageProvider.getImageFile(p.getNamePiece(), p.getCouleur())));
            panel = (JPanel) chessBoard.getComponent(p.getX() + p.getY() * 8);
            panel.removeAll();
            panel.add(piece);
        }

        chessBoard.revalidate();
        chessBoard.repaint();
    }
}
