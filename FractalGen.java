import java.util.ArrayList;
import java.awt.Color;
/**
 * Write a description of class FractalData here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FractalGen implements Subject
{
    // instance variables - replace the example below with your own
    private ArrayList<Observer> observers;

    private double childRatio;

    private int recursionDepth;

    private int angle;

    private Color cactusColor;

    private Color pearColor;

    /**
     * Constructor for objects of class FractalData
     */
    public FractalGen()
    {
        observers = new ArrayList<Observer>();
    }

    /**
     * An example of a method header - replace this comment with your own
     *
     * @param  y a sample parameter for a method
     */
    @Override
    public void registerObserver(Observer observer){
        observers.add(observer);
    }

    /**
     * An example of a method header - replace this comment with your own
     *
     * @param  y a sample parameter for a method
     */
    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    /**
     * An example of a method header - replace this comment with your own
     */
    @Override
    public void notifyObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * Method getData returns an ArrayList of Observer objects.
     *
     * @return an ArrayList of Observer objects.
     */
    @Override
    public ArrayList<FractalElement> getData(){
        ArrayList<FractalElement> fractalElements = new ArrayList<FractalElement>();
        Circle root = new Circle(350, 700, 100, cactusColor);
        addFractalElements(fractalElements, root, recursionDepth, 90);
        return fractalElements;
    }

    /**
     * Method addFractalElements
     *
     * @param fractalElements A parameter
     * @param rootCircle A parameter
     * @param recursionDepthCounter A parameter
     */
    private void addFractalElements(ArrayList<FractalElement> fractalElements, Circle rootCircle, int recursionDepthCounter, int orientation){
        if (recursionDepthCounter != 0){
            Color color = cactusColor;
            if (recursionDepthCounter == 2){
                color = pearColor;
            }
            double radius = rootCircle.radius;
            double childRadius = radius - childRatio * radius;
            double length = radius + childRadius;

            fractalElements.add(rootCircle);

            double xDistance = length * Math.cos(Math.toRadians(orientation + angle));
            double yDistance = length * Math.sin(Math.toRadians(orientation + angle));
            Circle left  = new Circle(rootCircle.x - xDistance, rootCircle.y - yDistance, (int)childRadius, color);
            addFractalElements(fractalElements, left,  recursionDepthCounter - 1, orientation + angle);
            xDistance = length * Math.cos(Math.toRadians(orientation - angle));
            yDistance = length * Math.sin(Math.toRadians(orientation - angle));
            Circle right = new Circle(rootCircle.x - xDistance, rootCircle.y - yDistance, (int)childRadius, color);
            addFractalElements(fractalElements, right, recursionDepthCounter - 1, orientation - angle);
        }
    }

    /**
     * Method setData makes the ArrayList of Observers 
     *
     * @param childRatio; the ratio of the parent to children.
     * @param recurstionDepth; the depth of the recursion of the cactus.
     * @param angle; the angle of the leaves relative to the stem.
     * @param cactusColor; the color of a cactus.
     * @param pearColor; the color of the cactus pear
     */
    @Override
    public void setData(double childRatio, int recursionDepth, int angle, Color cactusColor, Color pearColor){
        this.childRatio = childRatio;
        this.recursionDepth = recursionDepth;
        this.angle = angle;
        this.cactusColor = cactusColor;
        this.pearColor = pearColor;
    }
}
