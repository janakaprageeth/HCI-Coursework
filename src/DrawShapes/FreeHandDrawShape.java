package DrawShapes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FreeHandDrawShape extends JFrame {
  private Color  c1 = new Color(255, 0, 0);      // Red
    private Color  c2 = new Color(0, 255, 0);      // Green
    private Color  c3 = new Color(0, 0, 255);      // Blue
    private Color c4 = new Color(255, 255, 0);    // Yellow
    private Color c5 = new Color(255, 0, 255);    // Magenta
    private Color c6 = new Color(0, 255, 255);    // Cyan
    private Color c7 = new Color(128, 128, 128);  // Gray
    private Color c8 = new Color(255, 165, 0);    // Orange
    private Color c9 = new Color(0, 128, 0);      // Dark Green
    private Color c10 = new Color(128, 0, 0);     // Dark Red
    private Color c11 = new Color(0, 0, 128);     // Dark Blue
    private Color c12 = new Color(255, 0, 0, 128); // Transparent Red



    private Shape selectedShape;

    private boolean fastDraw = false;
    private List<Shapes2> shapeList = new ArrayList<>();;
    private JPanel drawPanel;
    private JPanel shapePanel;
    private JPanel menuPanel;
    private JPanel colorPanel;
    private JPanel confirmPanel;

    private JPanel optionsPanel;
    private JPanel swatchesPanel;
    private Point startPoint;
    private Point endPoint;
    private Color selectedColor = Color.black;
    public FreeHandDrawShape() {
        setTitle("Draw Shapes");

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null); // Disable default layout manager
        setLocationRelativeTo(null); // Center the window on the screen

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        drawPanel = new Drawpanel2();
        menuPanel = new JPanel();
        shapePanel = new JPanel();
        confirmPanel = new JPanel();

        colorPanel = new JPanel();
        optionsPanel = new JPanel();
        swatchesPanel = new JPanel();

        getContentPane().add(drawPanel);
        getContentPane().add(menuPanel);

        // Set bounds for the panels
        drawPanel.setBounds(0, 0, 400, 600);
        drawPanel.setBackground(Color.white);
        menuPanel.setBounds(400, 0, 300, 600);


        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS)); // Use BoxLayout with vertical alignment
        menuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);



        menuPanel.add(confirmPanel);

        confirmPanel.setLayout(new BoxLayout(confirmPanel, BoxLayout.Y_AXIS));
        confirmPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        menuPanel.add(Box.createVerticalGlue()); // Add vertical glue before the shape panel

        menuPanel.add(shapePanel);

        shapePanel.setLayout(new GridLayout(0, 3, 0, 0));
        shapePanel.setBorder(BorderFactory.createEmptyBorder(0,3,0,20));

        shapePanel.setPreferredSize(new Dimension(1, 20));

        gbc.gridx = 0;
        gbc.gridy = 0;

        // Add buttons to the shape panel
        JButton shapeButton1 = new JButton();
        JButton shapeButton2 = new JButton();
        JButton shapeButton3 = new JButton();
        JButton shapeButton4 = new JButton();
        JButton shapeButton5 = new JButton();

        shapeButton1.setIcon(new ImageIcon(createSquareImage()));
        shapeButton2.setIcon(new ImageIcon(createCircleImage()));
        shapeButton3.setIcon(new ImageIcon(createRectangleImage()));
        shapeButton4.setIcon(new ImageIcon(createOvalImage()));
        shapeButton5.setIcon(new ImageIcon(createTriangleImage()));
        shapeButton1.setAlignmentX(Component.CENTER_ALIGNMENT);
        shapeButton2.setAlignmentX(Component.CENTER_ALIGNMENT);
        shapeButton3.setAlignmentX(Component.CENTER_ALIGNMENT);
        shapeButton4.setAlignmentX(Component.CENTER_ALIGNMENT);
        shapeButton5.setAlignmentX(Component.CENTER_ALIGNMENT);

        shapePanel.add(shapeButton1,gbc);
        shapePanel.add(shapeButton2);
        shapePanel.add(shapeButton3);
        shapePanel.add(shapeButton4,gbc);
        shapePanel.add(shapeButton5,gbc);

        menuPanel.add(Box.createVerticalGlue()); // Add vertical glue before the color panel

        menuPanel.add(colorPanel);

        colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.Y_AXIS));
        colorPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add buttons to the color panel
        JButton colorButton1 = new JButton("Color picker");
        colorButton1.setAlignmentX(Component.RIGHT_ALIGNMENT);
        colorPanel.add(colorButton1);
        colorPanel.add(swatchesPanel);

       swatchesPanel.setBackground(Color.CYAN);
       colorButton1.setBackground(Color.pink);


        JButton colorButton2 = new JButton(" ");
        JButton colorButton3 = new JButton(" ");
        JButton colorButton4 = new JButton(" ");
        JButton colorButton5 = new JButton(" ");
        JButton colorButton6 = new JButton(" ");
        JButton colorButton7 = new JButton(" ");
        JButton colorButton8 = new JButton(" ");
        JButton colorButton9 = new JButton(" ");
        JButton colorButton10 = new JButton(" ");
        JButton colorButton11 = new JButton(" ");
        JButton colorButton12 = new JButton(" ");
        JButton colorButton13 = new JButton(" ");

        colorButton2.setBackground(c1);
        colorButton3.setBackground(c2);
        colorButton4.setBackground(c3);
        colorButton5.setBackground(c4);
        colorButton6.setBackground(c5);
        colorButton7.setBackground(c6);
        colorButton8.setBackground(c7);
        colorButton9.setBackground(c8);
        colorButton10.setBackground(c9);
        colorButton11.setBackground(c10);
        colorButton12.setBackground(c11);
        colorButton13.setBackground(c12);


        colorButton2.setAlignmentX(Component.RIGHT_ALIGNMENT);
        colorButton3.setAlignmentX(Component.RIGHT_ALIGNMENT);
        colorButton4.setAlignmentX(Component.RIGHT_ALIGNMENT);
        colorButton5.setAlignmentX(Component.RIGHT_ALIGNMENT);
        colorButton6.setAlignmentX(Component.RIGHT_ALIGNMENT);
        colorButton7.setAlignmentX(Component.RIGHT_ALIGNMENT);
        colorButton8.setAlignmentX(Component.RIGHT_ALIGNMENT);
        colorButton9.setAlignmentX(Component.RIGHT_ALIGNMENT);
        colorButton10.setAlignmentX(Component.RIGHT_ALIGNMENT);
        colorButton11.setAlignmentX(Component.RIGHT_ALIGNMENT);
        colorButton12.setAlignmentX(Component.RIGHT_ALIGNMENT);
        colorButton13.setAlignmentX(Component.RIGHT_ALIGNMENT);

        swatchesPanel.add(colorButton2);
        swatchesPanel.add(colorButton3);
        swatchesPanel.add(colorButton4);
        swatchesPanel.add(colorButton5);
        swatchesPanel.add(colorButton6);
        swatchesPanel.add(colorButton7);
        swatchesPanel.add(colorButton8);
        swatchesPanel.add(colorButton9);
        swatchesPanel.add(colorButton10);
        swatchesPanel.add(colorButton11);
        swatchesPanel.add(colorButton12);
        swatchesPanel.add(colorButton13);

        menuPanel.add(Box.createVerticalGlue()); // Add vertical glue before the options panel

        menuPanel.add(optionsPanel);
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.X_AXIS));
        optionsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add buttons to the options panel
        JButton optionsButton1 = new JButton("save");
        JButton optionsButton2 = new JButton("Undo");
        JButton optionsButton3 = new JButton("reset");

        optionsButton1.setBackground(Color.orange);
        optionsButton2.setBackground(Color.darkGray);
        optionsButton3.setBackground(Color.RED);

        optionsButton1.setAlignmentY(Component.CENTER_ALIGNMENT);
        optionsButton2.setAlignmentY(Component.CENTER_ALIGNMENT);
        optionsButton3.setAlignmentY(Component.CENTER_ALIGNMENT);


        optionsPanel.add(optionsButton1);
        optionsPanel.add(optionsButton2);
        optionsPanel.add(optionsButton3);

        menuPanel.add(Box.createVerticalGlue()); // Add vertical glue after the options panel


        drawPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
                endPoint = startPoint;
                System.out.println("1 srt : "+ startPoint); // Console log
                System.out.println("1 end : "+ endPoint); // Console log
                drawPanel.repaint();

            }

            public void mouseReleased(MouseEvent e) {
                endPoint = e.getPoint();
                System.out.println("2 srt : " + startPoint); // Console log
                System.out.println("2 end : " + endPoint); // Console log
                selectedShape =selectedShape;
                drawPanel.repaint();

                if (fastDraw){
                    System.out.println("2 selectedShape name : "+selectedShape.name ); // Console log
                    shapeList.add(selectedShape);

                    switch (selectedShape.name){
                        case "Square":
                            System.out.println("2 Square : " ); // Console log
                            selectedShape = new Square();
                            break;
                        case "Circle":
                            System.out.println("2 Circle : " ); // Console log
                            selectedShape = new Circle();
                            break;
                        case "Rectangle":
                            System.out.println("2 Rectangle : " ); // Console log
                            selectedShape = new Rectangle();
                            break;
                        case "Oval":
                            System.out.println("2 Oval : " ); // Console log
                            selectedShape = new Oval();
                            break;
                        case "Triangle":
                            System.out.println("2 Triangle : " ); // Console log
                            selectedShape = new Triangle();
                            break;

                    }
                    startPoint =null;
                    endPoint = null;
                    System.out.println("2 shapeList size : "+ shapeList.size()); // Console log

                }

            }
        });

        drawPanel.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                endPoint = e.getPoint();
                drawPanel.repaint();
            }
            public void mouseMoved(MouseEvent e) {

            }
        });
        shapeButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedShape = new Square();
                drawPanel.repaint();
            }
        });
        shapeButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedShape = new Circle();
                drawPanel.repaint();
            }
        });
        shapeButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedShape = new Rectangle();
                drawPanel.repaint();
            }
        });
        shapeButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedShape = new Oval();
                drawPanel.repaint();
            }
        });
        shapeButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedShape = new Triangle();
                drawPanel.repaint();
            }
        });
        colorButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor = JColorChooser.showDialog(FreeHandDrawShape.this,
                        "Choose a color", colorPanel.getBackground());
                drawPanel.repaint();
            }
        });
        colorButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor = c1;
                drawPanel.repaint();
            }
        });
        colorButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor = c2;
                drawPanel.repaint();
            }
        });
        colorButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor = c3;
                drawPanel.repaint();
            }
        });
        colorButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor = c4;
                drawPanel.repaint();
            }
        });

        colorButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor = c5;
                drawPanel.repaint();
            }
        });

        colorButton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor = c6;
                drawPanel.repaint();
            }
        });

        colorButton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor = c7;
                drawPanel.repaint();
            }
        });

        colorButton9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor = c8;
                drawPanel.repaint();
            }
        });

        colorButton10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor = c9;
                drawPanel.repaint();
            }
        });

        colorButton11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor = c10;
                drawPanel.repaint();
            }
        });

        colorButton12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor = c11;
                drawPanel.repaint();
            }
        });

        colorButton13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor = c12;
                drawPanel.repaint();
            }
        });

        optionsButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BufferedImage image = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = image.createGraphics();
                g2d.setColor(drawPanel.getBackground());
                g2d.fillRect(0, 0, drawPanel.getWidth(), drawPanel.getHeight());
                drawPanel.printAll(g2d);
                g2d.dispose();

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
                String dateTime = dateFormat.format(new Date());

                try {
                    // Get the current working directory
                    String workingDir = System.getProperty("user.dir");

                    // Construct the absolute paths for the files
                    String imagePath = workingDir + "/src/DrawShapes/IMGS/drawpanel_image_" + dateTime + ".png";
                    String textFilePath = workingDir + "/src/DrawShapes/IMGS/" + dateTime + ".txt";

                    File imageFile = new File(imagePath);
                    ImageIO.write(image, "png", imageFile);
                    System.out.println("Saved Image: " + imageFile.getAbsolutePath());

                    // Save the text file
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(textFilePath))) {
                        for (Shapes2 shape : shapeList) {
                            String line = shape.getName() + ","
                                    + shape.getStart().x + ","
                                    + shape.getStart().y + ","
                                    + shape.getEnd().x + ","
                                    + shape.getEnd().y + ","
                                    + shape.getColor().getRed() + ","
                                    + shape.getColor().getGreen() + ","
                                    + shape.getColor().getBlue();
                            writer.write(line);
                            writer.newLine();
                        }
                        System.out.println("Saved Text File: " + textFilePath);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.err.println("Error saving image: " + ex.getMessage());
                }
            }
        });

        optionsButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!shapeList.isEmpty()) {
                    shapeList.remove(shapeList.size() - 1);
                    drawPanel.repaint();
                }
            }
        });
        optionsButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shapeList.clear();
                drawPanel.repaint();
            }
        });

        setVisible(true);

    }
    private static Image createSquareImage() {
        BufferedImage image = new BufferedImage(25, 25, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.DARK_GRAY);
        g2d.setStroke(new BasicStroke(2)); // Set the stroke width
        g2d.drawRect(1, 1, 23, 23); // Draw the outline of the square
        g2d.dispose();
        return image;
    }

    // Create a circle image
    private static Image createCircleImage() {
        BufferedImage image = new BufferedImage(25, 25, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.DARK_GRAY);
        g2d.setStroke(new BasicStroke(2)); // Set the stroke width
        g2d.drawOval(1, 1, 23, 23); // Draw the outline of the circle
        g2d.dispose();
        return image;
    }


    // Create a rectangle image
    private static Image createRectangleImage() {
        BufferedImage image = new BufferedImage(25, 15, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.DARK_GRAY);
        g2d.setStroke(new BasicStroke(2)); // Set the stroke width
        g2d.drawRect(1, 1, 23, 13); // Draw the outline of the rectangle
        g2d.dispose();
        return image;
    }

    private static Image createTriangleImage() {
        BufferedImage image = new BufferedImage(25, 20, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.DARK_GRAY);
        g2d.setStroke(new BasicStroke(2)); // Set the stroke width

        int[] xPoints = {1, 12, 23}; // x-coordinates of the triangle's vertices
        int[] yPoints = {19, 1, 19}; // y-coordinates of the triangle's vertices

        g2d.drawPolygon(xPoints, yPoints, 3); // Draw the outline of the triangle

        g2d.dispose();
        return image;
    }



    // Create an oval image
    private static Image createOvalImage() {
        BufferedImage image = new BufferedImage(25, 15, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.DARK_GRAY);
        g2d.setStroke(new BasicStroke(2)); // Set the stroke width
        g2d.drawOval(1, 1, 23, 13); // Draw the outline of the oval
        g2d.dispose();
        return image;
    }

    private class Drawpanel2 extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if( (startPoint!=null)&&(startPoint!=endPoint) ){
                if (selectedShape != null) {
                    for (Shapes2 shape : shapeList) {

                        if(shape.getName()!=null){
                            System.out.println("q1shape : "+ shape); // Console log

                            System.out.println("q1name : "+ shape.getName()); // Console log
                            System.out.println("getStart : "+ shape.getStart()); // Console log
                            System.out.println("getEnd : "+ shape.getEnd()); // Console log
                            System.out.println("getColor : "+ shape.getColor()); // Console log

                            shape.draw(g,shape.getStart(), shape.getEnd(), shape.getColor());
                            System.out.println("q12name : "+ shape.getName()); // Console log


                        }

                    }
                    selectedShape.draw(g, startPoint, endPoint, selectedColor);
                }else{
                    selectedShape = new Circle();


                }

            }
            else{
                for (Shapes2 shape : shapeList) {

                    if(shape.getName()!=null){
                        System.out.println("q1shape : "+ shape); // Console log

                        System.out.println("q1name : "+ shape.getName()); // Console log
                        System.out.println("getStart : "+ shape.getStart()); // Console log
                        System.out.println("getEnd : "+ shape.getEnd()); // Console log
                        System.out.println("getColor : "+ shape.getColor()); // Console log

                        shape.draw(g,shape.getStart(), shape.getEnd(), shape.getColor());
                        System.out.println("q12name : "+ shape.getName()); // Console log


                    }

                }
            }

        }
    }


    public static void main(String[] args) {
        FreeHandDrawShape frame = new FreeHandDrawShape();
    }
}
