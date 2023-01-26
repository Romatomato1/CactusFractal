import java.awt.Dimension;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JColorChooser;
import javax.swing.BorderFactory;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
/**
 * Write a description of class GUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUI extends JFrame{

    private Subject subject;

    private JFrame frame;

    private JPanel panel;

    private JButton drawButton;

    private Toolkit toolkit;
    
    private int angleData;
    private int recursionDepthData;
    private double childRatioData;
    private Color cactusColorData;
    private Color pearColorData;
    
    /**
     * Constructor for objects of class GUI
     */
    public GUI(Subject subject){

        frame = new JFrame();
        panel = new JPanel();
        getContentPane().add(panel);

        setTitle("Cactus");
        setSize(270, 400);
        toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation((size.width - getWidth())/2, (size.height - getHeight())/2);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JLabel label_1 = new JLabel("Pick a recursion depth.");

        JSlider recursionDepth = new JSlider(JSlider.HORIZONTAL, 2, 10, 2);
        recursionDepth.setMajorTickSpacing(1);
        recursionDepth.setPaintTicks(true);
        recursionDepth.setPaintLabels(true);
        recursionDepth.addChangeListener(new ChangeListener(){
                public void stateChanged(ChangeEvent e){
                    recursionDepthData = recursionDepth.getValue();
                }
            });

        JLabel label_2 = new JLabel("Pick an angle for the leaves and pears.");

 
        JSlider angle = new JSlider(JSlider.HORIZONTAL, 10, 80, 10);
        angle.setMajorTickSpacing(10);
        angle.setMinorTickSpacing(1);
        angle.setPaintTicks(true);
        angle.setPaintLabels(true);
        angle.addChangeListener(new ChangeListener(){
                public void stateChanged(ChangeEvent e){
                    angleData = angle.getValue();
                }
            });

        JLabel label_3 = new JLabel("Pick a percent decrease for leaves.");

        JSlider percent = new JSlider(JSlider.HORIZONTAL, 30, 70, 30);
        percent.setMajorTickSpacing(10);
        percent.setMinorTickSpacing(1);
        percent.setPaintTicks(true);
        percent.setPaintLabels(true);
        percent.addChangeListener(new ChangeListener(){
                public void stateChanged(ChangeEvent e){
                    childRatioData = percent.getValue() / 100.0;
                }
            });

        JButton pearColor = new JButton("Pear Color Picker");    
        //draw.setBounds();
        pearColor.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
                    JColorChooser cactusPearColorChooser = new JColorChooser();
                    pearColorData = cactusPearColorChooser.showDialog(panel, "Choose Color",
                            Color.white);
                }
            });

        JButton cactusColor = new JButton("Cactus Color Picker");    
        //draw.setBounds();
        cactusColor.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
                    JColorChooser cactusColorChooser = new JColorChooser();
                    cactusColorData = cactusColorChooser.showDialog(panel, "Choose Color",
                            Color.white);
                }
            });
        cactusColor.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    GPanel gp = new GPanel();
                    gp.setColor(cactusColorData);
                    frame.add(gp);
                }
            });

        JButton draw = new JButton("Draw");    
        draw.setBounds(45, 63, 245, 234);
        draw.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    subject.setData(childRatioData, recursionDepthData, angleData, cactusColorData, pearColorData);
                    Display display = new Display(subject);
                }
            });

            JButton random = new JButton("I'm Feeling lucky");    
        //random.setBounds(45, 63, 245, 234);
        random.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    childRatioData = (Math.random() * 40 + 30) / 100;
                    angleData = (int)(Math.random() * 70 + 10);
                    recursionDepthData = (int)(Math.random() * 8 + 2);
                    Color randomColor1 =  new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
                    Color randomColor2 =  new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
                    cactusColorData = randomColor1;
                    pearColorData = randomColor2;
                }
            });
            
        JButton test = new JButton("Test");    
        //random.setBounds(45, 63, 245, 234);
        test.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    childRatioData = .5;
                    angleData = 45;
                    recursionDepthData = 5;
                    Color randomColor1 =  new Color(0, 0, 0);
                    Color randomColor2 =  new Color(56, 76, 225);
                    cactusColorData = randomColor1;
                    pearColorData = randomColor2;
                }
            });
            
        panel.add(cactusColor); 
        panel.add(pearColor);    
        panel.add(label_1);
        panel.add(recursionDepth);
        panel.add(label_2);
        panel.add(angle);
        panel.add(label_3);
        panel.add(percent);
        panel.add(random);
        panel.add(test);
        panel.add(draw);
        setVisible(true);
    }
    
    //Swatches
    
    public class GPanel extends JPanel{
        public Color color;
        
        @Override 
        public void paintComponent(Graphics g){
            g.drawRect(0,0,200,450);
            g.setColor(color);
            g.fillRect(0,20,20,45);
        }
        
        public void setColor(Color color){
            this.color = color;
        }
    }
}
