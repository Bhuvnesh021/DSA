package stream_apis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class JumpingBallWithBoy extends JPanel implements ActionListener {
    private int ballY = 100;
    private int ballVelocity = 5;
    private Color ballColor = Color.RED;
    private Timer timer;
    private Random rand = new Random();

    public JumpingBallWithBoy() {
        timer = new Timer(50, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the ball
        g.setColor(ballColor);
        g.fillOval(150, ballY, 50, 50);

        // Draw the boy
        g.setColor(Color.BLACK);
        g.drawOval(300, 100, 40, 40); // Head
        g.drawLine(320, 140, 320, 200); // Body
        g.drawLine(320, 160, 290, 180); // Left arm
        g.drawLine(320, 160, 350, 180); // Right arm (holding bat)
        g.drawLine(320, 200, 300, 250); // Left leg
        g.drawLine(320, 200, 340, 250); // Right leg

        // Draw the bat
        g.setColor(new Color(139, 69, 19)); // Brown color
        g.fillRect(350, 160, 10, 60);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Ball bouncing logic
        ballY += ballVelocity;
        if (ballY > getHeight() - 50 || ballY < 0) {
            ballVelocity = -ballVelocity;
            ballColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Jumping Ball and Boy with Bat");
        JumpingBallWithBoy panel = new JumpingBallWithBoy();
        frame.add(panel);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
