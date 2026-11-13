import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmileyBlink extends JPanel implements ActionListener {
    private boolean eyeClosed = false;
    private Timer timer;

    public SmileyBlink() {
        // Timer triggers every 500 milliseconds (half a second) to blink
        timer = new Timer(500, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw yellow smiley face background
        g.setColor(Color.YELLOW);
        g.fillOval(100, 100, 250, 250);
        g.setColor(Color.BLACK);
        g.drawOval(100, 100, 250, 250); // Face outline

        // Left eye (blinks based on eyeClosed state)
        if (eyeClosed) {
            g.drawLine(170, 197, 195, 197);
        } else {
            g.fillOval(170, 185, 25, 25);
        }

        // Right eye (blinks based on eyeClosed state)
        if (eyeClosed) {
            g.drawLine(255, 197, 280, 197);
        } else {
            g.fillOval(255, 185, 25, 25);
        }

        // Draw smile arc
        g.drawArc(150, 215, 150, 100, 0, -180);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Toggle the eye blink state
        eyeClosed = !eyeClosed;
        repaint(); // Refresh the panel to show the new eye state
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Blinking Smiley");
        SmileyBlink smileyPanel = new SmileyBlink();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 450);
        frame.add(smileyPanel);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}