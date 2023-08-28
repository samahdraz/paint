
package paint;

import java.awt.Graphics;
import java.awt.Point;
import static java.lang.Math.abs;
import org.json.simple.JSONObject;

/**
 *
 * @author samah
 */
public class Triangle extends AbstractShape {
    
    private Point p2,p3;
    private int [] xPoints , yPoints;
    private Point[] arrayofborderPointes= new Point[3];
    public Triangle(Point p, Point p2, Point p3) {
        super(p);
        this.p2=p2;
        this.p3=p3;  
        
        
    }

    public Point getP2() {
        return this.p2;
    }

    public Point getP3() {
        return this.p3;
    }

     @Override
    public Point[] getBorderPointes() {
        return this.arrayofborderPointes;
    }
    
    
    public void setBorderPointes()
    {
          arrayofborderPointes[0]=this.getPosition();
       arrayofborderPointes[1]=this.p2;
       arrayofborderPointes[2]=this.p3;
    }
    
    
    
    public void resize (Point p)
    {
        
        
        
        
        
    }
    
    
    
    
    
    @Override
    public void draw(Graphics canvas) {
        xPoints = new int []{(int)getPosition().getX(),(int)this.p2.getX(),(int)this.p3.getX()};
        yPoints = new int []{(int)getPosition().getY(),(int)this.p2.getY(),(int)this.p3.getY()};
        canvas.setColor(getColor());
        canvas.drawPolygon(xPoints, yPoints, 3);
        canvas.setColor(getFillColor());
        canvas.fillPolygon(xPoints, yPoints, 3);
    }
    
    
    
    double area(int x1, int y1, int x2, int y2,int x3, int y3)
    {
       return abs((x1*(y2-y3) + x2*(y3-y1)+x3*(y1-y2))/2.0);
    }
    @Override
    public boolean contains(Point point) {
        int x1,y1,x2,y2,x3,y3;
        x1=(int)this.getPosition().getX();
        y1=(int)this.getPosition().getY();
        x2=(int)this.p2.getX();
        y2=(int)this.p2.getY();
        x3=(int)this.p3.getX();
        y3=(int)this.p3.getY();
        
   double area = area (x1, y1, x2, y2, x3, y3);
   double area1 = area ((int)point.getX(),(int)point.getY(), x2, y2, x3, y3);
   double area2 = area (x1, y1,(int)point.getX(),(int)point.getY(),x3, y3);
   double area3 = area (x1, y1, x2, y2,(int)point.getX(),(int)point.getY());
   
  return (area == area1 + area2 + area3);
   
   
    }
     
    @Override
    public void moveTo(Point p) {
    /*int x1difference =  (int)this.getDraggingPoint().getX()-(int)this.getPosition().getX();
    int y1difference = (int)this.getDraggingPoint().getY()-(int)this.getPosition().getY();
    int x2difference =  (int)this.getDraggingPoint().getX()-(int)p2.getX();
    int y2difference =  (int)this.getDraggingPoint().getY()-(int)p2.getY();
    int x3difference = (int)this.getDraggingPoint().getX()-(int)p3.getX();
    int y3difference =  (int)this.getDraggingPoint().getY()-(int)p3.getY();
         this.setPosition(new Point((int)point.getX()-x1difference,(int)point.getY()-y1difference));
     p2.x=(int)point.getX()-x2difference;
     p2.y=(int)point.getY()-y2difference;
     p3.x=(int)point.getX()-x3difference;
     p3.y=(int)point.getY()-y3difference;*/
    
      Point dragpoint=this.getDraggingPoint();
        Point f=new Point(this.getPosition().x-dragpoint.x,this.getPosition().y-dragpoint.y);
        Point s=new Point(this.p2.x-dragpoint.x,this.p2.y-dragpoint.y);
        Point t=new Point(this.p3.x-dragpoint.x,this.p3.y-dragpoint.y);
        
        this.setPosition(new Point(p.x+f.x,p.y+f.y));
        this.p2=new Point(p.x+s.x,p.y+s.y);
        this.p3=new Point(p.x+t.x,p.y+t.y);
    
    }

   
    

    
    
}
