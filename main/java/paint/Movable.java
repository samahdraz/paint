package paint;

import java.awt.Point;

/**
 *
 * @author samah
 */
public interface Movable {
    
     public void setDraggingPoint(java.awt.Point point);
     
     public java.awt.Point getDraggingPoint();
     
     public boolean contains(java.awt.Point point);
     
     public void moveTo(java.awt.Point point);
     
     public Point[] getBorderPointes();
     
     public void setBorderPointes();
      
     public void resize (Point p); 
}
