import javax.swing.*;
import java.awt.*;

public class DrawingExample extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public DrawingExample() {
        setTitle("Drawing Example");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Draw a circle
        int circleX = 100;
        int circleY = 100;
        int circleRadius = 50;
        g.setColor(Color.RED);
        g.fillOval(circleX, circleY, circleRadius * 2, circleRadius * 2);

        // Draw waveforms
        int waveformX = 300;
        int waveformY = 100;
        int waveformWidth = 200;
        int waveformHeight = 100;
        g.setColor(Color.BLUE);

        // Draw the top waveform
        for (int x = 0; x < waveformWidth; x++) {
            int y = (int) (waveformHeight * Math.sin((double) x / waveformWidth * 2 * Math.PI));
            g.drawLine(waveformX + x, waveformY + waveformHeight / 2, waveformX + x, waveformY + waveformHeight / 2 - y);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DrawingExample example = new DrawingExample();
            example.setVisible(true);
        });
    }
}
