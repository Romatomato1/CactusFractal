import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Write a description of class Display here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Display extends JFrame implements Observer {
    // instance variables - replace the example below with your own
    private Subject subject;

    private JFrame frame;

    private GPanel panel;

    private Toolkit toolkit;

    /**
     * Constructor for objects of class DrawFractal
     */
    public Display(Subject subject)
    {
        this.subject = subject;
        this.subject.registerObserver(this);
        frame = new JFrame(); 
        panel = new GPanel();
        setTitle("Cactus Image");
        setSize(1000, 1000);
        getContentPane().add(panel);
        setVisible(true);
    }

    @Override
    public  void update(){
        subject.getData();
    }

    public class GPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            for (FractalElement fe : subject.getData()){
                fe.draw(g, fe.getWidth(), fe.getHeight());
            }
        }
    }
}
