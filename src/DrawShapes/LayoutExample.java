package DrawShapes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LayoutExample {

    private final int ypt = 8;
    private final int xpt = 8;

    private String[] borderConstraints = {
            BorderLayout.PAGE_START,
            BorderLayout.LINE_START,
            BorderLayout.CENTER,
            BorderLayout.LINE_END,
            BorderLayout.PAGE_END
    };

    private JButton[] buttons;

    private GridBagConstraints gbc;

    private JPanel borderPanel;
    private JPanel flowPanel;
    private JPanel gridPanel;
    private JPanel gridBagPanel;
    private JPanel cardPanel;

    public LayoutExample() {
        buttons = new JButton[16];
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(ypt, xpt, ypt, xpt);
    }

    private void displayGUI() {
        JFrame frame = new JFrame("Layout");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel(
                new GridLayout(0, 1, xpt, xpt));
        contentPane.setBorder(
                BorderFactory.createEmptyBorder(xpt, xpt, xpt, xpt));
        borderPanel = new JPanel(new BorderLayout(xpt, xpt));
        borderPanel.setBorder(
                BorderFactory.createTitledBorder("Border"));
        borderPanel.setOpaque(true);
        borderPanel.setBackground(Color.WHITE);
        for (int i = 0; i < 4; i++) {
            buttons[i] = new JButton(borderConstraints[i]);
            borderPanel.add(buttons[i], borderConstraints[i]);
        }
        contentPane.add(borderPanel);

        flowPanel = new JPanel(new FlowLayout(
                FlowLayout.CENTER, xpt, xpt));
        flowPanel.setBorder(
                BorderFactory.createTitledBorder("Flow"));
        flowPanel.setOpaque(true);
        flowPanel.setBackground(Color.WHITE);
        for (int i = 4; i < 8; i++) {
            buttons[i] = new JButton(Integer.toString(i));
            flowPanel.add(buttons[i]);
        }
        contentPane.add(flowPanel);

        gridPanel = new JPanel(new GridLayout(5, 5, xpt, xpt));
        gridPanel.setBorder(
                BorderFactory.createTitledBorder("Grid"));
        gridPanel.setOpaque(true);
        gridPanel.setBackground(Color.pink);
        for (int i = 8; i < 12; i++) {
            buttons[i] = new JButton(Integer.toString(i));
            gridPanel.add(buttons[i]);
        }
        contentPane.add(gridPanel);

        gridBagPanel = new JPanel(new GridBagLayout());
        gridBagPanel.setBorder(
                BorderFactory.createTitledBorder("GridBag"));
        gridBagPanel.setOpaque(true);
        gridBagPanel.setBackground(Color.CYAN);
        buttons[12] = new JButton(Integer.toString(12));
        addComp(gridBagPanel, buttons[12], 0, 0, 1, 1
                , GridBagConstraints.BOTH, 0.33, 0.5);
        buttons[13] = new JButton(Integer.toString(13));
        addComp(gridBagPanel, buttons[13], 1, 0, 1, 1
                , GridBagConstraints.BOTH, 0.33, 0.5);
        buttons[14] = new JButton(Integer.toString(14));
        addComp(gridBagPanel, buttons[14], 2, 0, 1, 1
                , GridBagConstraints.BOTH, 0.33, 0.5);
        buttons[15] = new JButton(Integer.toString(15));
        addComp(gridBagPanel, buttons[15], 0, 1, 3, 1
                , GridBagConstraints.BOTH, 1.0, 0.5);
        contentPane.add(gridBagPanel);



        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JPanel getPanel(Color bColor) {
        JPanel panel = new JPanel(new FlowLayout(
                FlowLayout.CENTER, xpt, xpt));
        panel.setOpaque(true);
        panel.setBackground(bColor.darker().darker());
        JButton swapperButton = new JButton("Next");
        swapperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.next(cardPanel);
            }
        });

        panel.add(swapperButton);

        return panel;
    }

    private void addComp(JPanel panel, JComponent comp
            , int x, int y, int gWidth
            , int gHeight, int fill
            , double weightx, double weighty) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = gWidth;
        gbc.gridheight = gHeight;
        gbc.fill = fill;
        gbc.weightx = weightx;
        gbc.weighty = weighty;

        panel.add(comp, gbc);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                new LayoutExample().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}