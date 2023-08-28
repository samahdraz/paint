package paint;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author samah
 */
public class Rectangle extends AbstractShape {
    
    private int width,height;
    private Point[] arrayofborderPointes= new Point[4];

    @Override
    public Point[] getBorderPointes() {
        return this.arrayofborderPointes;
    }

    public void setBorderPointes() {
       arrayofborderPointes[0]=this.getPosition();
       arrayofborderPointes[1]=new Point(this.getPosition().x+this.width,this.getPosition().y);
       arrayofborderPointes[2]=new Point((this.getPosition().x+this.width),(this.getPosition().y+this.height));
       arrayofborderPointes[3]=new Point(this.getPosition().x,(this.getPosition().y+this.height));        
    }
    
    public void resize (Point p)
    {
        
        
        
        
    }
    
    
       
    
    
    public Rectangle(Point p, int width, int height) {
        super(p);
        this.width=width;
        this.height=height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
    
    
    
    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(getColor());
        canvas.drawRect((int)getPosition().getX(),(int)getPosition().getY(),this.width,this.height);
        canvas.setColor(getFillColor());
        canvas.fillRect((int)getPosition().getX(),(int)getPosition().getY(),this.width,this.height);
    
    }   

    @Override
    public boolean contains(Point point) {
      int x1=(int) this.getPosition().getX();
      int y1=(int) this.getPosition().getY();
    if ((int)point.getX() >= x1 && (int)point.getX() <= x1+width )
    {
        if ((int)point.getY() >= y1 && (int)point.getY() <= y1+height)
            return true;
    }
       return false;
    }

    @Override
    public void moveTo(Point point) {
       
        int xdifference = (int)this.getDraggingPoint().getX()- (int)this.getPosition().getX();
        int ydifference = (int)this.getDraggingPoint().getY()- (int)this.getPosition().getY();
     this.setPosition(new Point((int)point.getX()-xdifference,(int)point.getY()-ydifference));
   
 
    }

    
    
}
