import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class IndianFlagWithClouds extends JPanel {

    // Method to draw the flag
    private void drawIndianFlag(Graphics2D g) {
        int x = 100, y = 100;
        int width = 300, height = 60;

        // Saffron
        g.setColor(new Color(255, 153, 51));
        g.fillRect(x, y, width, height);

        // White
        g.setColor(Color.WHITE);
        g.fillRect(x, y + height, width, height);

        // Green
        g.setColor(new Color(19, 136, 8));
        g.fillRect(x, y + 2 * height, width, height);

        // Ashoka Chakra
        g.setColor(Color.BLUE);
        int centerX = x + width / 2;
        int centerY = y + height + height / 2;
        int radius = 20;
        g.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

        for (int i = 0; i < 24; i++) {
            double angle = Math.toRadians(i * 15);
            int x1 = (int) (centerX + radius * Math.cos(angle));
            int y1 = (int) (centerY + radius * Math.sin(angle));
            g.drawLine(centerX, centerY, x1, y1);
        }

        // Flag Pole
        g.setColor(new Color(102, 51, 0));
        g.fillRect(x - 10, y, 10, 400);
    }

    // Method to draw clouds
    private void drawClouds(Graphics2D g) {
        g.setColor(Color.LIGHT_GRAY);
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int x = 50 + rand.nextInt(700);
            int y = 20 + rand.nextInt(150);
            drawSingleCloud(g, x, y);
        }
    }

    private void drawSingleCloud(Graphics2D g, int x, int y) {
        g.fillOval(x, y, 60, 40);
        g.fillOval(x + 20, y - 10, 60, 50);
        g.fillOval(x + 40, y, 60, 40);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(135, 206, 235)); // Sky blue background

        Graphics2D g2d = (Graphics2D) g;
        drawClouds(g2d);
        drawIndianFlag(g2d);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Indian Flag Flying with Cloudy Sky");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new IndianFlagWithClouds());
        frame.setVisible(true);
    }
}
