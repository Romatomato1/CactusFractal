import java.awt.Graphics;
/**
 * Write a description of interface FractalElement here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface FractalElement{
    public abstract void draw(Graphics g,int outputWidth, int inputWidth);
    
    public abstract int getWidth();
    
    public abstract int getHeight();
}
