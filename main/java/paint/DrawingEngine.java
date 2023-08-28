package paint;

/**
 *
 * @author samah
 */
public interface DrawingEngine {
    
    public void addShape(Shape shape);
    public void removeShape(Shape shape);
    public Shape[] getShapes();
    public void refresh(java.awt.Graphics canvas);
    
  
}
