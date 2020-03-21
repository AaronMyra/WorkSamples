package ca.nscc.Shapes;

import ca.nscc.GUI.DrawingPane;

import java.awt.*;

public class Circle extends Shape {

    private Color secondColor;

    public void setSecondColor(Color secondColor) { this.secondColor = secondColor; }

    public Circle(int height, int width, int xPos, int yPos, Color color1, Color color2){
        this.setHeight(height);
        this.setWidth(width);
        this.setxPosition(xPos);
        this.setyPosition(yPos);
        this.setColor(color1);
        this.secondColor = color2;
    }

    @Override
    public void drawShape(Graphics g, DrawingPane drawingPane) {
        GradientPaint gradient = new GradientPaint(this.getxPosition(), this.getyPosition(), this.getColor(),
                this.getxPosition() + this.getWidth(), this.getyPosition() + this.getHeight(), this.secondColor);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(gradient);
        g2d.fillOval(this.getxPosition(), this.getyPosition(), this.getWidth(), this.getHeight());
    }

    @Override
    public void moveShape() {
        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());
    }
}

