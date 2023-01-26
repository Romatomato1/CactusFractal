import java.util.ArrayList;
import java.awt.Color;
/**
 * Write a description of interface Subject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Subject {
    /**
     * An example of a method header - replace this comment with your own
     *
     * @param  y a sample parameter for a method
     */
    public abstract void registerObserver(Observer observer);

    /**
     * An example of a method header - replace this comment with your own
     *
     * @param  y a sample parameter for a method
     */
    public abstract void removeObserver(Observer observer);

    /**
     * An example of a method header - replace this comment with your own
     */
    public abstract void notifyObservers();
    
    /**
     * Method getData returns an ArrayList of Observer objects.
     *
     * @return an ArrayList of Observer objects.
     */
    public abstract ArrayList<FractalElement> getData();
    
    /**
     * Method setData makes the ArrayList of Observers 
     *
     * @param childRatio; the ratio of the parent to children.
     * @param recurstionDepth; the depth of the recursion of the cactus.
     * @param cactusColor; the color of a cactus.
     * @param pearColor; the color of the cactus pear
     */
    public abstract void setData(double childRatio, int recursionDepth, int angle, Color cactusColor, Color pearColor);
}
