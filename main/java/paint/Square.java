package paint;

import java.awt.Graphics;
import java.awt.Point;
import org.json.simple.JSONObject;

/**
 *
 * @author samah
 */
public class Square extends AbstractShape {
    
    private int length;
    private Point[] arrayofborderPointes= new Point[4];
    public Square(Point p, int length) {
        super(p);
        this.length=length;
    }

    public int getLength() {
        return this.length;
    }
    
     @Override
    public Point[] getBorderPointes() {
        return this.arrayofborderPointes;
    }
    
    public void setBorderPointes()
    {
          arrayofborderPointes[0]=this.getPosition();
       arrayofborderPointes[1]=new Point(this.getPosition().x+this.length,this.getPosition().y);
       arrayofborderPointes[2]=new Point((this.getPosition().x+this.length),(this.getPosition().y+this.length));
       arrayofborderPointes[3]=new Point(this.getPosition().x,(this.getPosition().y+this.length));        
   
         
    }
    
    public void resize (Point p)
    {
        
        
        
        
        
        
    }
    
     
    
    
    
    
    
    
    
    @Override
    public void draw(Graphics canvas) {
    
        canvas.setColor(getColor());
        canvas.drawRect((int)getPosition().getX(),(int)getPosition().getY(),this.length,this.length);
        canvas.setColor(getFillColor());
        canvas.fillRect((int)getPosition().getX(),(int)getPosition().getY(),this.length,this.length);
    }

    @Override
    public boolean contains(Point point) {
      int x1=(int) this.getPosition().getX();
      int y1=(int) this.getPosition().getY();
    if ((int)point.getX() >= x1 && (int)point.getX() <= x1+length )
    {
        if ((int)point.getY() >= y1 && (int)point.getY() <= y1+length)
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
