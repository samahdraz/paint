package paint;

import java.awt.Graphics;
import java.awt.Point;
import org.json.simple.JSONObject;

/**
 *
 * @author samah
 */
public class Line extends AbstractShape {
    
    private Point p2;
    private Point[] arrayofborderPointes= new Point[2];
    public Line(Point p, Point p2) {
        super(p);
       this.p2=p2;
    }
    
    
     @Override
    public Point[] getBorderPointes() {
        return this.arrayofborderPointes;
    }
    
    public void setBorderPointes()
    {
       arrayofborderPointes[0]=this.getPosition();
       arrayofborderPointes[1]=this.p2;
       
         
    }
    public void resize (Point p)
    {
        
        this.p2=p;
        
        
    }
    
    public Point getP2() {
        return this.p2;
    }
    
    


          
    @Override
    public void draw(Graphics canvas) {
    
        canvas.setColor(getColor());
        canvas.drawLine((int)getPosition().getX(),(int)getPosition().getY(),(int)this.p2.getX(),(int)this.p2.getY() );
    }

    @Override
    public boolean contains(Point point) {
        int x1,y1,x2,y2;
        x1=(int)this.getPosition().getX();
        y1=(int)this.getPosition().getY();
        x2=(int)this.p2.getX();
        y2=(int)this.p2.getY();
        return (((int)point.getY()-y1)*(x2-x1))==((y2-y1)*((int)point.getX()-x1));
    }

    @Override
    public void moveTo(Point point) {
      
     
       int x1difference =  (int)this.getPosition().getX() - (int)this.getDraggingPoint().getX();
       int y1difference =  (int)this.getPosition().getY()- (int)this.getDraggingPoint().getY();
       int x2difference =  (int)p2.getX() - (int)this.getDraggingPoint().getX();
       int y2difference =  (int)p2.getY() - (int)this.getDraggingPoint().getY();
     
       this.setPosition(new Point((int)point.getX()+x1difference,(int)point.getY()+y1difference));
     p2.x=(int)point.getX()+x2difference;
     p2.y=(int)point.getY()+y2difference;
    
    
    }

    
    
}
