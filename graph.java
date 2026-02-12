import javax.swing.*;
import java.awt.*;

public class graph extends JPanel {
    private double yesB, yesA, noB, noA;

    public graph(double yesB, double yesA, double noB, double noA) {
        this.yesB = yesB;
        this.yesA = yesA;
        this.noB = noB;
        this.noA = noA;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int margin = 60;
        int barWidth = 60;

        //draw Axes
        g2.drawLine(margin, height - margin, width - margin, height - margin); 
        g2.drawLine(margin, margin, margin, height - margin); 

        //draw Bars
        drawBar(g2, margin + 40, height - margin, barWidth, yesB, Color.RED, "AI (Before)");
        drawBar(g2, margin + 110, height - margin, barWidth, yesA, new Color(255, 160, 0), "AI (After)");
        drawBar(g2, margin + 230, height - margin, barWidth, noB, Color.PINK, "Non-AI (Before)");
        drawBar(g2, margin + 300, height - margin, barWidth, noA, Color.ORANGE, "Non-AI (After)");

        //title
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.BOLD, 16));
        g2.drawString("Average Grade Improvement: AI vs Non-AI", width / 2 - 150, 30);
    }

    private void drawBar(Graphics2D g2, int x, int yBase, int width, double value, Color color, String label) {
        int barHeight = (int) (value * ((getHeight() - 120) / 100.0));
        
        g2.setColor(color);
        g2.fillRect(x, yBase - barHeight, width, barHeight);
        
        g2.setColor(Color.BLACK);
        g2.drawRect(x, yBase - barHeight, width, barHeight);
        
        //draw the value on top of the bar
        String valStr = String.format("%.2f", value);
        g2.drawString(valStr, x + (width/2) - 15, yBase - barHeight - 5);
        
        //draw label below
        g2.setFont(new Font("Arial", Font.PLAIN, 10));
        g2.drawString(label, x, yBase + 20);
    }
}