package Game;

import GameObjects.Cards.Card;
import PlayerActions.Attack;
import PlayerActions.PlayCard;
import PlayerActions.PlayerDraggableAction;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {

    private int mouse_x,mouse_y;
    private boolean isInBoard;

    private Point targetObjectStartingPoint;

    private Component target;
    private GameState gs;
    private Card targetObject;


    public MouseHandler(Component c,GameState gs){
        target=c;
        mouse_x=0;
        mouse_y=0;
        targetObject = null;
        this.gs = gs;
    }


    public int getMouse_x() {
        return mouse_x;
    }

    public int getMouse_y() {
        return mouse_y;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        targetObject=gs.getObjectMap().getObjectAt(e.getX(),e.getY());
        if(targetObject!=null) {
            Point objectLocation=targetObject.getLocation();
            targetObjectStartingPoint = new Point(objectLocation.x, objectLocation.y);
            if (gs.getBoard().isWithinBounds(targetObjectStartingPoint.x, targetObjectStartingPoint.y))
                isInBoard = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(targetObject!=null) {
            PlayerDraggableAction action;
            if(!isInBoard)
                action = new PlayCard(targetObject,targetObjectStartingPoint,e.getPoint(),gs);
            else
                action = new Attack();
        gs.handlePlayerAction(action);
        }
        isInBoard = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouse_x=e.getX();
        mouse_y=e.getY();
        target.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouse_x=e.getX();
        mouse_y=e.getY();
        target.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        if(targetObject != null && !isInBoard){
            targetObject.getLocation().move(e.getPoint().x,e.getPoint().y);
        }
        target.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouse_x=e.getX();
        mouse_y=e.getY();
        target.repaint();
    }


}
