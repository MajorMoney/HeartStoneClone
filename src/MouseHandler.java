import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {

    private String msg;

    private int mouse_x,mouse_y;
    private Component target;
    private GameObjectMapper objectMap;

    private Point startingPoint;
    private Point targetObjectStartingPoint;
    private GameObject targetObject;


    public MouseHandler(Component c,GameObjectMapper objectMap){
        target=c;
        mouse_x=0;
        mouse_y=0;
        msg="";
        startingPoint=null;
        targetObject = null;
        this.objectMap = objectMap;
    }

    public String getMsg() {
        return msg;
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
        startingPoint = new Point(e.getX(),e.getY());
        targetObject=objectMap.getObjectAt(startingPoint.x,startingPoint.y);
        if(targetObject!=null)
            targetObjectStartingPoint = targetObject.getLocation();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("MouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouse_x=e.getX();
        mouse_y=e.getY();
        msg="Mouse Entered";
        target.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouse_x=e.getX();
        mouse_y=e.getY();
        msg="Mouse Exited";
        target.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        if(targetObject != null){
            targetObject.location.move(e.getPoint().x,e.getPoint().y);
        }
        target.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouse_x=e.getX();
        mouse_y=e.getY();
        msg="Moving mouse at "+mouse_x+","+mouse_y;
        target.repaint();
    }


}
