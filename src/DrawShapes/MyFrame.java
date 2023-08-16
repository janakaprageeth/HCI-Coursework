package DrawShapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame extends JFrame {
    private Shape selectedShape;

    private JPanel drawPanel;
    private JPanel shapePanel;
    private JPanel menuPanel;
    private JPanel colorPanel;
    private JPanel optionsPanel;
    private Point startPoint;
    private Point endPoint;
    private Color selectedColor = Color.black;
    public MyFrame() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null); // Disable default layout manager
        setLocationRelativeTo(null); // Center the window on the screen

        drawPanel = new Drawpanel2();
        menuPanel = new JPanel();
        shapePanel = new JPanel();
        colorPanel = new JPanel();
        optionsPanel = new JPanel();

        getContentPane().add(drawPanel);
        getContentPane().add(menuPanel);

        // Set bounds for the panels
        drawPanel.setBounds(0, 0, 600, 600);
        drawPanel.setBackground(Color.green);
        menuPanel.setBounds(600, 0, 200, 600);
        menuPanel.setBackground(Color.red);
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS)); // Use BoxLayout with vertical alignment
        JButton optionsButton1 = new JButton("save");

        setVisible(true);

    }
    private class Drawpanel2 extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            //                Square sqr = new Square();
//                sqr.draw(g,startPoint, endPoint);
            if(startPoint!=null){
                if (selectedShape != null) {
                    selectedShape.draw(g, startPoint, endPoint, selectedColor);
                }else{
                    selectedShape = new Circle();


                }

            }


//            g.setColor(Color.RED);
//            g.fillRect(350, 250, 100, 100);
        }
    }


    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
    }
}
