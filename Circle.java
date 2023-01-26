import java.awt.Graphics;
import java.awt.Color;
/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Circle implements FractalElement
{
    // instance variables - replace the example below with your own
    public double x;
    public double y;
    public int radius;
    public Color color;

    /** 
     * Constructor for objects of class Circle
     */
    public Circle(double x, double y, int radius, Color color)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }
    
    @Override
    public int getWidth(){
        return radius * 2;
    }
    
    @Override
    public int getHeight(){
        return radius * 2;
    }
    
    @Override
    public void draw(Graphics g,int outputWidth, int outputHeight){
        g.setColor(color);
        g.drawOval((int) (x - radius), (int) (y - radius), outputWidth, outputHeight);
        g.fillOval((int) (x - radius), (int) (y - radius), outputWidth, outputHeight);
    }
}
