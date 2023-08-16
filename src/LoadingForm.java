import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.*;

public class LoadingForm extends JFrame {
    private JProgressBar progressBar;
    private JLabel loadingLabel;
    private Timer timer;
    private String loadingText = "LOADING";
    private Clip backgroundMusic;

    public LoadingForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create a panel to hold the components
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("HCICoursework-Maxident/assets/loading.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };

        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(200, 100, 330, 100)); // Set padding around the panel

        // Create a progress bar
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.decode("#104282")); // Set the progress bar color
        panel.add(progressBar, BorderLayout.CENTER);

        // Create a loading label
        loadingLabel = new JLabel(loadingText, JLabel.CENTER);
        loadingLabel.setFont(loadingLabel.getFont().deriveFont(Font.BOLD, 25));
        panel.add(loadingLabel, BorderLayout.SOUTH);

        add(panel);

        // Create a timer to update the progress bar and animate the loading label
        int progressBarDelay = 30; // Delay in milliseconds for the progress bar animation
        int loadingLabelDelay = 300; // Delay in milliseconds for the loading label animation
        int duration = 3000; // Duration in milliseconds (3 seconds)
        int progressBarSteps = duration / progressBarDelay; // Number of steps for progress bar
        int loadingLabelSteps = duration / loadingLabelDelay; // Number of steps for loading label animation
        progressBar.setMaximum(progressBarSteps);

        timer = new Timer(progressBarDelay, new ActionListener() {
            int progress = 0;
            int progressBarAnimationIndex = 0;
            int loadingLabelAnimationIndex = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                progress++;
                progressBar.setValue(progress);

                // Animate the loading label with ellipsis
                if (progress % (loadingLabelDelay / progressBarDelay) == 0) {
                    loadingLabel.setText(loadingText + getEllipsis(loadingLabelAnimationIndex));
                    loadingLabelAnimationIndex = (loadingLabelAnimationIndex + 1) % 5;
                }

                if (progress >= progressBarSteps) {
                    timer.stop();
                    dispose();
                    HomeScreenForm homeScreenForm = new HomeScreenForm();
                    homeScreenForm.setVisible(true);
                }
            }
        });
        timer.setInitialDelay(0);
        timer.start();

        setUndecorated(true);

        // Load and play the background music
        try {
            File musicFile = new File("HCICoursework-Maxident/assets/audio.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioStream);
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to generate the ellipsis animation
    private String getEllipsis(int animationIndex) {
        StringBuilder ellipsis = new StringBuilder();
        for (int i = 0; i < animationIndex; i++) {
            ellipsis.append('.');
        }
        return ellipsis.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoadingForm loadingForm = new LoadingForm();
                loadingForm.setVisible(true);
            }
        });
    }
}
