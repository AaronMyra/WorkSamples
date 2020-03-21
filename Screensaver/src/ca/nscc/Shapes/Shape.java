package ca.nscc.Shapes;

import ca.nscc.GUI.DrawingPane;
import ca.nscc.Interface.Moveable;

import java.awt.*;

public abstract class Shape implements Moveable {

    private int height, width, xPosition, yPosition, xSpeed = 5, ySpeed = -3;
    private Color color;
    private int baseHeight = 25, baseWidth = 25;

    public abstract void drawShape(Graphics g, DrawingPane drawingPane);
    public abstract void moveShape();
    public Rectangle getBorderBox() { return new Rectangle(this.xPosition, this.yPosition, this.width, this.height); }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height + this.baseHeight; }
    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width + this.baseWidth; }
    public int getxPosition() { return xPosition; }
    public void setxPosition(int xPosition) { this.xPosition = xPosition; }
    public int getyPosition() { return yPosition; }
    public void setyPosition(int yPosition) { this.yPosition = yPosition; }
    public int getxSpeed() { return xSpeed; }
    public void setxSpeed(int xSpeed) { this.xSpeed = xSpeed; }
    public int getySpeed() { return ySpeed; }
    public void setySpeed(int ySpeed) { this.ySpeed = ySpeed; }
    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }

}
