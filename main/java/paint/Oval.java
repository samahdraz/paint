package paint;

import java.awt.Graphics;
import java.awt.Point;
import org.json.simple.JSONObject;

/**
 *
 * @author samah
 */
public class Oval extends AbstractShape {
    
    private int radius1,radius2;
    private Point[] arrayofborderPointes= new Point[4];
    public Oval(Point p, int radius1, int radius2) {
        super(p);
        this.radius1=radius1;
        this.radius2=radius2;
    }
    
    
    @Override
    public Point[] getBorderPointes() {
        return this.arrayofborderPointes;
    }
    
    public void setBorderPointes(){
         
         arrayofborderPointes[0]=this.getPosition();
       arrayofborderPointes[1]=new Point(this.getPosition().x+this.radius1*2,this.getPosition().y);
       arrayofborderPointes[2]=new Point((this.getPosition().x+this.radius1*2),(this.getPosition().y+this.radius2*2));
       arrayofborderPointes[3]=new Point(this.getPosition().x,(this.getPosition().y+this.radius2*2));        
   
        
    }
    
    public void resize (Point p)
    {
        
        
        
        
        
    }
    
    
   
    
    
    public int getRadius1() {
        return this.radius1;
    }

    public int getRadius2() {
        return this.radius2;
    }
    
    
    @Override
    public void draw(Graphics canvas) {
        
        canvas.setColor(getColor());
        canvas.drawOval((int)getPosition().getX(),(int)getPosition().getY(), 2*radius1, 2*radius2);
        canvas.setColor(getFillColor());
        canvas.fillOval((int)getPosition().getX(),(int)getPosition().getY(), 2*radius1, 2*radius2);
        
    
    }
    public double checkpoint(double h, double k, double x,
                             double y, double a, double b)
    {
 
        // checking the equation of
        // ellipse with the given point
        double p = ((double)Math.pow((x - h), 2)
                    / (double)Math.pow(a, 2))
                   + ((double)Math.pow((y - k), 2)
                      / (double)Math.pow(b, 2));
 
        return p;
    }
    
    
    
    @Override
    public boolean contains(Point point) {
       int x1=(int) this.getPosition().getX();
       int y1=(int) this.getPosition().getY();
      int xCenter= x1+ radius1;
      int yCenter= y1+ radius2;
      return (checkpoint(xCenter,yCenter, point.x, point.y, radius1, radius2) <= 1);
    }

    @Override
    public void moveTo(Point point) {
    
      int xdifference = (int)this.getDraggingPoint().getX()- (int)this.getPosition().getX();
        int ydifference = (int)this.getDraggingPoint().getY()- (int)this.getPosition().getY();
     this.setPosition(new Point((int)point.getX()-xdifference,(int)point.getY()-ydifference));
   
    
    }

   
    
}
