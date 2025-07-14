import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class BouncingBall extends JPanel implements ActionListener, MouseMotionListener {
    private int ballX, ballY, ballRadius = 20;
    private double velocityY = 0, gravity = 0.5, bounce = -0.7;
    private int centerX, centerY, circleRadius = 150;
    private double angle = 0;
    private boolean dragging = false;
    private int prevMouseX;
    
    public BouncingBall() {
        Timer timer = new Timer(16, this);
        timer.start();
        addMouseMotionListener(this);
        
        centerX = 200;
        centerY = 200;
        ballX = centerX;
        ballY = centerY - circleRadius + ballRadius;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // Clear background
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        // Draw rotating circle
        g.setColor(Color.YELLOW);
        g2d.setStroke(new BasicStroke(3));
        g.drawOval(centerX - circleRadius, centerY - circleRadius, circleRadius * 2, circleRadius * 2);
        
        // Draw ball
        g.setColor(Color.BLACK);
        g.fillOval(ballX - ballRadius, ballY - ballRadius, ballRadius * 2, ballRadius * 2);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Apply gravity
        velocityY += gravity;
        ballY += velocityY;
        
        // Bounce if it hits the bottom
        if (ballY >= centerY + circleRadius - ballRadius) {
            ballY = centerY + circleRadius - ballRadius;
            velocityY *= bounce;
        }
        
        repaint();
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        if (!dragging) {
            dragging = true;
            prevMouseX = e.getX();
        }
        
        int dx = e.getX() - prevMouseX;
        angle += dx * 0.01; // Adjust rotation speed
        prevMouseX = e.getX();
        
        // Rotate ball position with respect to the circle
        ballX = (int) (centerX + Math.cos(angle) * (ballY - centerY));
        ballY = (int) (centerY + Math.sin(angle) * (ballY - centerY));
        
        repaint();
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {}
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball in Rotating Circle");
        BouncingBall panel = new BouncingBall();
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
