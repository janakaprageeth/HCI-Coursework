package DrawShapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class SavedImages2 extends JFrame {

    private JPanel gridPanel;
    private File[] imageFiles;

    public SavedImages2() {
        setTitle("Image Grid Viewer");
        setSize(800, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(0, 3, 10, 10));
        JScrollPane scrollPane = new JScrollPane(gridPanel);
        add(scrollPane, BorderLayout.CENTER);

        loadImages();

        pack();
        setVisible(true);
    }

    private void loadImages() {
        File directory = new File("DrawShapes/IMGS");
        imageFiles = directory.listFiles();

        if (imageFiles != null) {
            for (File file : imageFiles) {
                if (file.isFile()) {
                    ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
                    Image image = imageIcon.getImage().getScaledInstance(200, -1, Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(image);

                    JLabel imageLabel = new JLabel(imageIcon);
                    imageLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            openImage(file.getAbsolutePath());
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
        SwingUtilities.invokeLater(() -> new SavedImages2());
    }
}
