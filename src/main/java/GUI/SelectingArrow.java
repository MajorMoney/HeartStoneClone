package GUI;

import java.awt.*;

public class SelectingArrow {

  private Point start, end;

  public SelectingArrow(Point startingPoint) {
    start = startingPoint;
    this.end = start;
  }

  public void setEnd(Point end) {
    this.end = end;
  }

  public void drawArrow(Graphics2D g2d) {

    // Set the color and stroke for the arrow
    g2d.setColor(Color.RED); // You can change the color
    g2d.setStroke(new BasicStroke(4)); // You can adjust the thickness

    // Calculate the angle of the arrow
    double angle = Math.atan2(end.y - start.y, end.x - start.x);

    // Calculate arrowhead coordinates
    int arrowSize = 20;
    int x1 = end.x - (int) (arrowSize * Math.cos(angle - Math.PI / 6));
    int y1 = end.y - (int) (arrowSize * Math.sin(angle - Math.PI / 6));
    int x2 = end.x - (int) (arrowSize * Math.cos(angle + Math.PI / 6));
    int y2 = end.y - (int) (arrowSize * Math.sin(angle + Math.PI / 6));

    // Draw the line
    g2d.drawLine(start.x, start.y, end.x, end.y);

    // Draw the arrowhead
    g2d.drawLine(end.x, end.y, x1, y1);
    g2d.drawLine(end.x, end.y, x2, y2);
  }
}
