import DrawShapes.FreeHandDrawShape;
import DrawShapes.SavedImages;
//import Shapes3D.Home3D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class HomeScreenForm extends JFrame {
    private JPanel mainPanel;

    public HomeScreenForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Center the frame on the screen

        Font customFont = null;
        JButton shapesButton;
        JButton createShapesButton;
        JButton ThreeDButton;
        JButton GamesButton;
        JButton savedShapesButton;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("HCICoursework-Maxident/assets/BubblegumSans-Regular.ttf"));


            // Create the buttons
            shapesButton = new JButton("VIEW SHAPES");
            shapesButton.setPreferredSize(new Dimension(200, 70));
            shapesButton.setBackground(new Color(0x83CD2D));
            shapesButton.setBorderPainted(false);
            shapesButton.setFont(customFont.deriveFont(22.0f));


            createShapesButton = new JButton("2D SHAPES");
            createShapesButton.setPreferredSize(new Dimension(200, 70));
            createShapesButton.setBackground(new Color(0xDF4382));
            createShapesButton.setBorderPainted(false);
            createShapesButton.setFont(customFont.deriveFont(22.0f));

            ThreeDButton = new JButton("3D SHAPES");
            ThreeDButton.setPreferredSize(new Dimension(200, 70));
            ThreeDButton.setBackground(new Color(0xF68C11));
            ThreeDButton.setBorderPainted(false);
            ThreeDButton.setFont(customFont.deriveFont(22.0f));

            GamesButton = new JButton("DRAW");
            GamesButton.setPreferredSize(new Dimension(200, 70));
            GamesButton.setBackground(new Color(0x7B74B2));
            GamesButton.setBorderPainted(false);
            GamesButton.setFont(customFont.deriveFont(22.0f));

            savedShapesButton = new JButton("DRAWINGS");
            savedShapesButton.setPreferredSize(new Dimension(200, 70));
            savedShapesButton.setBackground(new Color(0xD4C545));
            savedShapesButton.setBorderPainted(false);
            savedShapesButton.setFont(customFont.deriveFont(22.0f));

        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Create the main panel
        mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                Image backgroundImage = new ImageIcon("HCICoursework-Maxident/assets/homeScreen.png").getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setBorder(new EmptyBorder(390, 10, 20, 10)); // Set padding around the main panel

        // Create a panel for the button rows
        JPanel buttonRowsPanel = new JPanel(new GridLayout(2, 1, 20, 5)); // 2 rows, 1 column, with spacing
        buttonRowsPanel.setOpaque(false); // Make the panel transparent

        // Create the first button row panel
        JPanel buttonRow1Panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
        buttonRow1Panel.setBackground(Color.decode("#104282"));
        buttonRow1Panel.add(shapesButton);
        buttonRow1Panel.add(createShapesButton);
        buttonRow1Panel.add(ThreeDButton);

// Create the second button row panel
        JPanel buttonRow2Panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
        buttonRow2Panel.setBackground(Color.decode("#104282"));
        buttonRow2Panel.add(GamesButton);
        buttonRow2Panel.add(savedShapesButton);


        // Add the button row panels to the button rows panel
        buttonRowsPanel.add(buttonRow1Panel);
        buttonRowsPanel.add(buttonRow2Panel);

        // Add the button rows panel to the main panel
        mainPanel.add(buttonRowsPanel, BorderLayout.CENTER);

        // Set the main panel as the content pane
        setContentPane(mainPanel);

        // Add action listeners to the buttons
        /*createShapesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ShapesForm shapesForm = new ShapesForm();
                shapesForm.setVisible(true);
            }
            });*/
        GamesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hide the current frame
                setVisible(false);

                // Create and show the new frame
                FreeHandDrawShape freeHandDrawShape = new FreeHandDrawShape();
                freeHandDrawShape.setVisible(true);

                // Reopen the current frame when the new frame is closed
                freeHandDrawShape.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        setVisible(true);
                    }
                });
            }
        });
        savedShapesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hide the current frame
                setVisible(false);

                // Create and show the new frame
                SavedImages savedImages = new SavedImages();
                savedImages.setVisible(true);

                // Reopen the current frame when the new frame is closed
                savedImages.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        setVisible(true);
                    }
                });
            }
        });
       /* ThreeDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home3D homeObj = new Home3D();
                homeObj.setVisible(true);
            }
        });*/

      /*  shapesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewShapes viewShapes = new viewShapes();
                viewShapes.setVisible(true);
            }
        });*/

       /* createShapesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ShapesForm shapesForm = new ShapesForm();
                shapesForm.setVisible(true);
            }
        });*/

        setUndecorated(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HomeScreenForm homeScreenForm = new HomeScreenForm();
                homeScreenForm.setVisible(true);
            }
        });
    }

}
