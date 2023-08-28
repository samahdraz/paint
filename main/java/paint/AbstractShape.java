package paint;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author samah
 */
public abstract class AbstractShape implements Shape, Movable{

    
    private Point p1;
    private Color borderColor;
    private Color fillColor;
    private Point draggingPoint;
    
    public AbstractShape (Point p)
    {
        this.p1=p;
    }
    
    @Override
    public void setPosition(Point position) {
        this.p1=position;
          }

    @Override
    public Point getPosition() {
        return this.p1;
          }

    @Override
    public void setColor(Color color) {
           this.borderColor=color;    
    }

    @Override
    public Color getColor() {
        return this.borderColor;
       }

    @Override
    public void setFillColor(Color color) {
          this.fillColor=color;    
    }

    @Override
    public Color getFillColor() {
        return this.fillColor;
    }

    @Override
    public Point getDraggingPoint()
    {
        return this.draggingPoint;
    }

    @Override
    public void setDraggingPoint(Point point)
    {
        this.draggingPoint=point;
    }
    
}
