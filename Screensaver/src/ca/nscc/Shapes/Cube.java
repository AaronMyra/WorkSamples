package ca.nscc.Shapes;

import ca.nscc.GUI.DrawingPane;

import java.awt.*;

public class Cube extends Shape {

    public Cube(int height, int width, int xPos, int yPos, Color color){
        this.setHeight(height);
        this.setWidth(width);
        this.setxPosition(xPos);
        this.setyPosition(yPos);
        this.setColor(color);
    }

    @Override
    public void drawShape(Graphics g, DrawingPane drawingPane) {
        g.setColor(this.getColor());
        g.drawRect(this.getxPosition(), this.getyPosition() + (this.getHeight() / 3), ((this.getWidth() / 3) *2), ((this.getHeight() / 3)* 2));
        g.drawRect(this.getxPosition() + (this.getWidth() / 3), this.getyPosition(), ((this.getWidth() / 3) *2), ((this.getHeight() / 3)* 2));
        g.drawLine(this.getxPosition(), this.getyPosition() + (this.getHeight() / 3), this.getxPosition() + (this.getWidth() / 3), this.getyPosition());
        g.drawLine(this.getxPosition(), this.getyPosition() + this.getHeight(), this.getxPosition() + (this.getWidth() / 3), this.getyPosition() + ((this.getHeight() / 3) * 2));
        g.drawLine(this.getxPosition() + ((this.getWidth() / 3) * 2), this.getyPosition() + this.getHeight(), this.getxPosition() + this.getWidth(), this.getyPosition() + ((this.getHeight() / 3) * 2));
        g.drawLine(this.getxPosition() + ((this.getWidth() / 3) * 2), this.getyPosition() + (this.getHeight() / 3), this.getxPosition() + (this.getWidth()), this.getyPosition());

    }

    @Override
    public void moveShape() {
        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());
    }
}
