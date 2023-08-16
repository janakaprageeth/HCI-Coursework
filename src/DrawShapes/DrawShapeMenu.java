package DrawShapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawShapeMenu extends JFrame {

    public DrawShapeMenu() {
        setTitle("Draw Shape");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        JButton openSavedImagesButton = new JButton("Open your saved images");
        openSavedImagesButton.setBackground(Color.BLUE);
        openSavedImagesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SavedImages savedImages = new SavedImages();
                savedImages.setVisible(true);
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(openSavedImagesButton, gbc);

        JButton openFreeHandDrawShapeButton = new JButton("Draw your own shapes");
        openFreeHandDrawShapeButton.setBackground(Color.GREEN);
        openFreeHandDrawShapeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FreeHandDrawShape freeHandDrawShape = new FreeHandDrawShape();
                freeHandDrawShape.setVisible(true);
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(openFreeHandDrawShapeButton, gbc);
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DrawShapeMenu());
    }
}
