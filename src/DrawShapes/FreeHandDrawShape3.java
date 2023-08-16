package DrawShapes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FreeHandDrawShape3 extends JFrame {
    private Color c1 = new Color(13, 60, 85);
    private Color c2 = new Color(16, 107, 141);
    private Color c3 = new Color(19, 149, 186);
    private Color c4 = new Color(92, 167, 147);
    private Color c5 = new Color(89, 185, 94);
    private Color c6 = new Color(235, 200, 68);
    private Color c7 = new Color(236, 170, 56);
    private Color c8 = new Color(122, 90, 65);
    private Color c9 = new Color(241, 108, 32);
    private Color c10 = new Color(192, 46, 29);
    private Color c11 = new Color(192, 29, 86);
    private Color c12 = new Color(107, 44, 114, 255);


    private Shape selectedShape;

    private boolean fastDraw = false;

    private List<Point> startPointList =  new ArrayList<>();
    private List<Point> endPointList =  new ArrayList<>();
    private List<String> nameList =  new ArrayList<>();
    private List<Color> colorList =  new ArrayList<>();

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
    public FreeHandDrawShape3(String fileNameInput) {

        setTitle("Draw Shapes");

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null); // Disable default layout manager
        setLocationRelativeTo(null); // Center the window on the screen

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
        drawPanel.setBounds(0, 0, 600, 600);
        drawPanel.setBackground(Color.white);
        menuPanel.setBounds(600, 0, 200, 600);
//        menuPanel.setBackground(Color.red);
//        menuPanel.setBorder(BorderFactory.createMatteBorder(0, 4, 0, 0, Color.gray)); // Add left border

        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS)); // Use BoxLayout with vertical alignment
        menuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

//        menuPanel.add(Box.createVerticalGlue()); // Add vertical glue before the shape panel

        menuPanel.add(confirmPanel);
//        shapePanel.setBackground(Color.blue);
        confirmPanel.setLayout(new BoxLayout(confirmPanel, BoxLayout.Y_AXIS));
        confirmPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add buttons to the shape panel

        JCheckBox fast_drawCheckBox = new JCheckBox("Fast Draw");
        fast_drawCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmPanel.add(fast_drawCheckBox);
        JButton confirmButton = new JButton("Confirm Shape");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmPanel.add(confirmButton);
        fast_drawCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Checkbox is checked
                    System.out.println("Checkbox is checked");
                    confirmButton.setEnabled(false); // Disable the confirm button

                    fastDraw=true;
                    // Perform actions for checked state
                } else {
                    // Checkbox is unchecked
                    System.out.println("Checkbox is unchecked");
                    confirmButton.setEnabled(true); // Enable the confirm button
                    fastDraw=false;

                    // Perform actions for unchecked state
                }
            }
        });
        menuPanel.add(Box.createVerticalGlue()); // Add vertical glue before the shape panel

        menuPanel.add(shapePanel);
//        shapePanel.setBackground(Color.blue);
        shapePanel.setLayout(new GridLayout(0, 3, 0, 0));
        shapePanel.setBorder(BorderFactory.createEmptyBorder(0,3,0,20));
//        shapePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        shapePanel.setPreferredSize(new Dimension(1, 20));

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

        shapePanel.add(shapeButton1);
        shapePanel.add(shapeButton2);
        shapePanel.add(shapeButton3);
        shapePanel.add(shapeButton4);
        shapePanel.add(shapeButton5);

        menuPanel.add(Box.createVerticalGlue()); // Add vertical glue before the color panel

        menuPanel.add(colorPanel);
//        colorPanel.setBackground(Color.yellow);
        colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.Y_AXIS));
        colorPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add buttons to the color panel
        JButton colorButton1 = new JButton("Color picker");
        colorButton1.setAlignmentX(Component.CENTER_ALIGNMENT);
        colorPanel.add(colorButton1);
        colorPanel.add(swatchesPanel);

//        swatchesPanel.setBackground(Color.CYAN);
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


        colorButton2.setAlignmentX(Component.CENTER_ALIGNMENT);
        colorButton3.setAlignmentX(Component.CENTER_ALIGNMENT);
        colorButton4.setAlignmentX(Component.CENTER_ALIGNMENT);
        colorButton5.setAlignmentX(Component.CENTER_ALIGNMENT);
        colorButton6.setAlignmentX(Component.CENTER_ALIGNMENT);
        colorButton7.setAlignmentX(Component.CENTER_ALIGNMENT);
        colorButton8.setAlignmentX(Component.CENTER_ALIGNMENT);
        colorButton9.setAlignmentX(Component.CENTER_ALIGNMENT);
        colorButton10.setAlignmentX(Component.CENTER_ALIGNMENT);
        colorButton11.setAlignmentX(Component.CENTER_ALIGNMENT);
        colorButton12.setAlignmentX(Component.CENTER_ALIGNMENT);
        colorButton13.setAlignmentX(Component.CENTER_ALIGNMENT);

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
//        optionsPanel.setBackground(Color.orange);
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        optionsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add buttons to the options panel
        JButton optionsButton1 = new JButton("save");
        JButton optionsButton2 = new JButton("Undo");
        JButton optionsButton3 = new JButton("reset");
        optionsButton1.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionsButton2.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionsButton3.setAlignmentX(Component.CENTER_ALIGNMENT);
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
//                System.out.println("3 srt : " + startPoint); // Console log
//                System.out.println("3 end : " + endPoint); // Console log
                drawPanel.repaint();
            }
            public void mouseMoved(MouseEvent e) {
//                System.out.println("4 mos : " + e.getPoint()); // Console log
            }
        });
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
//                selectedShape = new Circle();
//                selectedShape =  null;
                startPoint =null;
                endPoint = null;
                System.out.println("2 shapeList size : "+ shapeList.size()); // Console log

//                drawPanel.repaint();
//                startPoint=null;
//                endPoint=null;
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
                selectedColor = JColorChooser.showDialog(FreeHandDrawShape3.this,
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
                BufferedImage image = new BufferedImage(drawPanel.getWidth(),drawPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = image.createGraphics();
                g2d.setColor(drawPanel.getBackground()); // Set background color to match the panel
                g2d.fillRect(0, 0, drawPanel.getWidth(), drawPanel.getHeight()); // Fill the background with the panel's color
                drawPanel.printAll(g2d);
                g2d.dispose();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
                String dateTime = dateFormat.format(new Date());
//                paint(g2d);
                try{

                    String filename = "HCICoursework-Maxident/src/DrawShapes/IMGS/drawpanel_image_" + dateTime + ".png";
                    File outputFile = new File(filename);
                    ImageIO.write(image, "png", new File(filename));
                    System.out.println("save Image"); // Console log

                } catch (Exception e2) {

                    e2.printStackTrace();
                }
                String filename2 = "HCICoursework-Maxident/src/DrawShapes/IMGS/"+dateTime+".txt";

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename2))) {
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
                } catch (IOException e2) {
                    e2.printStackTrace();
                }

//                for (Shapes2 shape : shapeList) {
//                    shape.getStart();
//                    System.out.println("name : "+ shape.getName()); // Console log
//                    System.out.println("stat : "+ shape.getStart()); // Console log
//                    System.out.println("end : "+ shape.getEnd()); // Console log
//                    System.out.println("clr : "+ shape.getColor()); // Console log
//
//                }

            }
        });

        optionsButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if( (startPoint==null)&&(selectedShape!=null)   ){
                    if (!shapeList.isEmpty()) {
                        shapeList.remove(shapeList.size() - 1);
                        drawPanel.repaint();
                        System.out.println("12   : "); // Console log

                    }
                }else{
                    System.out.println("22   : "); // Console log
                    startPoint =null;
                    endPoint = null;
                    drawPanel.repaint();

                }
                System.out.println("32   : "); // Console log

                drawPanel.repaint();


            }
        });
        optionsButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shapeList.clear();
                drawPanel.repaint();
            }
        });

        setVisible(true);
        loadCanvasData(fileNameInput);

        drawCanvasData();
        System.out.println("finalshapeList : "+ shapeList); // Console log


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
    private void loadCanvasData(String fileNameInput){

        try (BufferedReader reader = new BufferedReader(new FileReader(fileNameInput))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 8) {
                    String name = parts[0].trim();
                    int startX = Integer.parseInt(parts[1].trim());
                    int startY = Integer.parseInt(parts[2].trim());
                    int endX = Integer.parseInt(parts[3].trim());
                    int endY = Integer.parseInt(parts[4].trim());
                    int red = Integer.parseInt(parts[5].trim());
                    int green = Integer.parseInt(parts[6].trim());
                    int blue = Integer.parseInt(parts[7].trim());


                    System.out.println("name : "+name); // Console log
                    System.out.println("startX : "+startX); // Console log
                    System.out.println("startY : "+startY); // Console log
                    System.out.println("endX : "+endX); // Console log
                    System.out.println("endY : "+endY); // Console log
                    System.out.println("red : "+red); // Console log
                    System.out.println("green : "+green); // Console log
                    System.out.println("blue : "+blue); // Console log

                    Point startPoint = new Point(startX, startY);
                    Point endPoint = new Point(endX, endY);
                    Color selectedColor = new Color(red, green, blue);


//                    switch (name){
//                        case "Square":
//                            System.out.println("2 Square : " ); // Console log
//                            selectedShape = new Square();
//                            break;
//                        case "Circle":
//                            System.out.println("2 Circle : " ); // Console log
//                            selectedShape = new Circle();
//                            break;
//                        case "Rectangle":
//                            System.out.println("2 Rectangle : " ); // Console log
//                            selectedShape = new Rectangle();
//                            break;
//                        case "Oval":
//                            System.out.println("2 Oval : " ); // Console log
//                            selectedShape = new Oval();
//                            break;
//                        case "Triangle":
//                            System.out.println("2 Triangle : " ); // Console log
//                            selectedShape = new Triangle();
//                            break;
//
//                    }
                    this.startPointList.add(startPoint);
                    this.endPointList.add(endPoint);
                    this.nameList.add(name);
                    this.colorList.add(selectedColor);

//                    this.startPoint = startPoint;
//                    this.endPoint = endPoint;
//                    this.selectedColor = selectedColor;
//                    drawPanel.repaint();
//                    System.out.println("cehck45  : "+ selectedShape.getName()); // Console log
//                    System.out.println("cehck45getColor  : "+ selectedShape.getColor()); // Console log
//                    System.out.println("cehck45  : "+ selectedShape.getEnd()); // Console log
//                    System.out.println("cehck45 getStart : "+ selectedShape.getStart()); // Console log
//
//                    shapeList.add(selectedShape);



                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("startPointList : "+ startPointList); // Console log
        System.out.println("endPointList : "+ endPointList); // Console log
        System.out.println("nameList : "+ nameList); // Console log
        System.out.println("colorList : "+ colorList); // Console log



    }

    private void drawCanvasData(){
        System.out.println("startPointList : "+ startPointList); // Console log
        System.out.println("endPointList : "+ endPointList); // Console log
        System.out.println("nameList : "+ nameList); // Console log
        System.out.println("colorList : "+ colorList); // Console log


        for (int i = 0; i < nameList.size(); i++) {
            String loopName = nameList.get(i);
            String name ="";
            switch (loopName){
                case "Square":
                    System.out.println("2 Square : " ); // Console log
                    selectedShape = new Square();
                    name = "Square";
                    break;
                case "Circle":
                    System.out.println("2 Circle : " ); // Console log
                    selectedShape = new Circle();
                    name = "Circle";
                    break;
                case "Rectangle":
                    System.out.println("2 Rectangle : " ); // Console log
                    selectedShape = new Rectangle();
                    name = "Rectangle";
                    break;
                case "Oval":
                    System.out.println("2 Oval : " ); // Console log
                    selectedShape = new Oval();
                    name = "Oval";
                    break;
                case "Triangle":
                    System.out.println("2 Triangle : " ); // Console log
                    selectedShape = new Triangle();
                    name = "Triangle";
                    break;

            }
            System.out.println("shapeListLOOP CHECK : "+ shapeList); // Console log
            System.out.println("selectedShapeLOOP CHECK : "+ selectedShape); // Console log

            startPoint = startPointList.get(i);
            endPoint = endPointList.get(i);
            selectedColor = colorList.get(i);

            selectedShape.setValues(name,startPointList.get(i),endPointList.get(i),colorList.get(i));
//            drawPanel.repaint();

            shapeList.add(selectedShape);



        }
        drawPanel.repaint();
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
//                selectedShape = new Circle();
//                selectedShape =  null;
        startPoint =null;
        endPoint = null;

        System.out.println("checkpointshapeshapeList : "+ shapeList); // Console log

        for (Shapes2 shape : shapeList) {
            System.out.println("checkpointshape : "+ shape); // Console log
            System.out.println("q7name : "+ shape.getName()); // Console log
            System.out.println("getStart : "+ shape.getStart()); // Console log
            System.out.println("getEnd : "+ shape.getEnd()); // Console log
            System.out.println("getColor : "+ shape.getColor()); // Console log
            System.out.println("checkpointname : "+ shape.getName()); // Console log
//            if(shape.getName()!=null){
//                System.out.println("q7shape : "+ shape); // Console log
//
//                System.out.println("q7name : "+ shape.getName()); // Console log
//                System.out.println("getStart : "+ shape.getStart()); // Console log
//                System.out.println("getEnd : "+ shape.getEnd()); // Console log
//                System.out.println("getColor : "+ shape.getColor()); // Console log
//                System.out.println("q7name : "+ shape.getName()); // Console log
//
//
//            }

        }

    }

    private class Drawpanel2 extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            System.out.println("r11111111111111111111e[paint"); // Console log
            //                Square sqr = new Square();
//                sqr.draw(g,startPoint, endPoint);
            if( (startPoint!=null)&&(startPoint!=endPoint) ){
                System.out.println("2222222222222222222[paint"); // Console log
                if (selectedShape != null) {
                    System.out.println("333333333333333333333[paint"); // Console log
                    for (Shapes2 shape : shapeList) {
                        System.out.println("44444444444444444444[paint"); // Console log
                        if(shape.getName()!=null){
                            System.out.println("555555555555555555555[paint"); // Console log
                            System.out.println("q1shape : "+ shape); // Console log

                            System.out.println("q1name : "+ shape.getName()); // Console log
                            System.out.println("getStart : "+ shape.getStart()); // Console log
                            System.out.println("getEnd : "+ shape.getEnd()); // Console log
                            System.out.println("getColor : "+ shape.getColor()); // Console log

                            shape.draw(g,shape.getStart(), shape.getEnd(), shape.getColor());
                            System.out.println("q12name : "+ shape.getName()); // Console log


                        }

                    }
                    System.out.println("99999999999999999999999[paint"); // Console log
                    selectedShape.draw(g, startPoint, endPoint, selectedColor);
                    System.out.println(".......................[paint"+selectedShape); // Console log
                    System.out.println(".......................[paint"+selectedShape.getStart()); // Console log

                }else{
                    selectedShape = new Circle();
                }
            }
            else{
                System.out.println("66666666666666666666[paint"); // Console log
                for (Shapes2 shape : shapeList) {
                    System.out.println("777777777777777777777777[paint"); // Console log
                    if(shape.getName()!=null){
                        System.out.println("8888888888888888888888[paint"); // Console log
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


//            g.setColor(Color.RED);
//            g.fillRect(350, 250, 100, 100);
        }
    }


    public static void main(String[] args) {
        FreeHandDrawShape3 frame = new FreeHandDrawShape3("HCICoursework-Maxident/src/DrawShapes/IMGS/shapes.txt");
    }
}

