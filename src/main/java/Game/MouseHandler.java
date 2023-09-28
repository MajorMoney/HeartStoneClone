package Game;

import GUI.GamePanel;
import GUI.SelectingArrow;
import GameObjects.Cards.Card;
import PlayerActions.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {

    private boolean isInBoard;

    private Point targetObjectStartingPoint;

    private GamePanel target;
    private GameState gs;
    private Card targetObject;


    public MouseHandler(GamePanel gp, GameState gs) {
        target = gp;
        targetObject = null;
        this.gs = gs;
    }



    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        targetObject = (Card) gs.getObjectMap().getObjectAt(e.getX(), e.getY());
        if (targetObject != null) {
            Point objectLocation = targetObject.getLocation();
            targetObjectStartingPoint = new Point(objectLocation.x, objectLocation.y);
            if (gs.getBoard().isWithinBounds(targetObjectStartingPoint.x, targetObjectStartingPoint.y)){
                isInBoard = true;
                target.setSelectingArrow(new SelectingArrow(targetObject.getLocation()));
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (targetObject != null) {
            PlayerDraggableAction action;
            if (!isInBoard)
                action = new PlayCard(targetObject, targetObjectStartingPoint, e.getPoint(), gs);
            else
                action = new SelectTarget();
            gs.handlePlayerAction(action);
        }
        isInBoard = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (targetObject != null ) {
            if(!isInBoard) {
                targetObject.getLocation().move(e.getX(), e.getY());
            }
            else{
                target.getSelectingArrow().setEnd(e.getPoint());
            }
        }
        target.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        target.repaint();
    }


}
