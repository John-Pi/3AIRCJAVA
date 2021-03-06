package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controler.controlerLocal.ChessGameControler;
import model.Coord;
import model.PieceIHM;
import tools.ChessImageProvider;
import tools.JPanelCustom;

public class ChessGameGUI extends JFrame implements MouseListener, MouseMotionListener, Observer {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JLayeredPane layeredPane;
    JPanel chessBoard;
    JLabel chessPiece;
    JLabel piece;
    JPanel panel;
    JPanelCustom pieceClicked;
    int xAdjustment;
    int yAdjustment;
    ChessGameControler controler;
    Component saveLocation;

    public ChessGameGUI(String frameName, ChessGameControler chessGameControler, Dimension dim) {
        Dimension boardSize = dim;
        this.controler = chessGameControler;
        //  Use a Layered Pane for this this application

        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);

        //Add a chess board to the Layered Pane

        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout(new GridLayout(8, 8));
        chessBoard.setPreferredSize(boardSize);
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

        for (int y = 0; y < 8; y++) {

            for (int x = 0; x < 8; x++) {
                JPanelCustom square = new JPanelCustom(new BorderLayout(), x, y);
                chessBoard.add(square);

                int row = y % 2;
                if (row == 0)
                    square.setBackground(((y * 8) + x) % 2 == 0 ? Color.black : Color.white);
                else
                    square.setBackground(((y * 8) + x) % 2 == 0 ? Color.white : Color.black);
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        chessPiece = null;
        Component c = chessBoard.findComponentAt(e.getX(), e.getY());


        if (c instanceof JPanelCustom)
            return;

        saveLocation =   c.getParent();
        this.pieceClicked = (JPanelCustom) c.getParent();

        if (!controler.isPlayerOK(pieceClicked.getCoord()))
            return;
        isPossible(pieceClicked.getCoord());
        Point parentLocation = c.getParent().getLocation();
        xAdjustment = parentLocation.x - e.getX();
        yAdjustment = parentLocation.y - e.getY();
        chessPiece = (JLabel) c;
        chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
        chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
        layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
    }

    //Move the chess piece around

    public void mouseDragged(MouseEvent me) {
        if (chessPiece == null) return;
        chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
    }

    //Drop the chess piece back onto the chess board

    public void mouseReleased(MouseEvent e) {
        recolor();
        if (chessPiece == null) return;


        Component c = chessBoard.findComponentAt(e.getX(), e.getY());

        if (c instanceof JLabel) {
            c = c.getParent();
        }
        this.controler.move(this.pieceClicked.getCoord(), ((JPanelCustom) c).getCoord());
            chessPiece.setVisible(false);
        


    }


    public void mouseClicked(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void update(Observable o, Object arg) {

        for (int i = 0; i < 8 * 8; i++) {
            this.panel = (JPanel) chessBoard.getComponent(i);
            this.panel.removeAll();
        }

        List<PieceIHM> list = (List<PieceIHM>) arg;

        for (PieceIHM pieceIHM : list) {
            this.piece = new JLabel(new ImageIcon(ChessImageProvider.getImageFile(pieceIHM.getNamePiece(), pieceIHM.getCouleur())));
            this.panel = (JPanel) chessBoard.getComponent(8 * pieceIHM.getY() + pieceIHM.getX());
            this.panel.add(this.piece);
            this.revalidate();
        }
    }

    public void isPossible(Coord coord) {
        JPanelCustom panneau;
        for (int i = 0; i < 8 * 8; i++) {
            panneau = (JPanelCustom) chessBoard.getComponent(i);
            if (controler.isMoveOk(coord.x, coord.y, panneau.getCoord().x, panneau.getCoord().y)) {
                panneau.setBackground(Color.cyan);
            }

        }
    }

    public void recolor() {
        int i = 0;
        JPanelCustom square;

        for (int y = 0; y < 8; y++) {

            for (int x = 0; x < 8; x++) {
                square = (JPanelCustom) chessBoard.getComponent(i);
                i++;


                int row = y % 2;
                if (row == 0)
                    square.setBackground(((y * 8) + x) % 2 == 0 ? Color.black : Color.white);
                else
                    square.setBackground(((y * 8) + x) % 2 == 0 ? Color.white : Color.black);
            }
        }
    }
}