package DrawShapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class SavedImages extends JFrame {

    private JPanel gridPanel;
    private File[] imageFiles;

    public SavedImages() {
        setTitle("Image Grid Viewer");
        setSize(800, 600);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(0, 3, 10, 10));
        JScrollPane scrollPane = new JScrollPane(gridPanel);
        add(scrollPane, BorderLayout.CENTER);


        String path = "HCI/src/DrawShapes/IMGS";
        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            // Path exists and is a directory
            System.out.println("Path exists: " + directory.getAbsolutePath());
        } else {
            // Path does not exist or is not a directory
            System.out.println("Path does not exist or is not a directory.");
        }

//        this.dispose();

        loadImages(this);

//        pack();
        setVisible(true);
    }

    private void loadImages(SavedImages savedImages) {
        String path = "C:/Users/Admin/Desktop/HCI/src/DrawShapes/IMGS/";

        File directory = new File("C:/Users/Admin/Desktop/HCI/src/DrawShapes/IMGS/");
        imageFiles = directory.listFiles();

        System.out.println("imageFiles : " + imageFiles); // Console log

        if (imageFiles != null) {
            for (File file : imageFiles) {
                System.out.println("file name : " + file.getName()); // Console log

                if (file.isFile() && file.getName().toLowerCase().endsWith(".png")) {

                    String fileName = file.getName();

// Remove the "drawpanel_image_" prefix
                    String middlePart = fileName.substring("drawpanel_image_".length());

// Remove the ".png" suffix
                    middlePart = middlePart.substring(0, middlePart.length() - ".png".length());
                    System.out.println("middlePart name : " + middlePart); // Console log

                    String txtFilePath = path + "/" + middlePart + ".txt";
                    System.out.println("txtFilePath  : " + txtFilePath); // Console log

                    ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
                    Image image = imageIcon.getImage().getScaledInstance(200, -1, Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(image);

                    JLabel imageLabel = new JLabel(imageIcon);
                    imageLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {

                            FreeHandDrawShape3 freeHandDrawShape3 = new FreeHandDrawShape3(txtFilePath);
                            freeHandDrawShape3.setVisible(true);
                            savedImages.setVisible(false);
                            freeHandDrawShape3.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosed(WindowEvent e) {
                                    gridPanel.removeAll();
                                    loadImages(savedImages);

                                    savedImages.setVisible(true);

                                }
                            });
//                            openImage(file.getAbsolutePath());
                        }
                    });

                    gridPanel.add(imageLabel);
                }
            }
        }

    }

    private void openImage(String imagePath) {
        JFrame imageFrame = new JFrame();
        imageFrame.setTitle("Image Viewer");
        imageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        imageFrame.setLocationRelativeTo(null);

        ImageIcon imageIcon = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(imageIcon);
        imageFrame.getContentPane().add(imageLabel);

        imageFrame.pack();
        imageFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SavedImages());
    }
}