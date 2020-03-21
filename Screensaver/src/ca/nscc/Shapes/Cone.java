package ca.nscc.Shapes;

import ca.nscc.GUI.DrawingPane;
import ca.nscc.Shapes.Shape;

import java.awt.*;

public class Cone extends Shape {

    public Cone(int height, int width, int xPos, int yPos, Color color){
        this.setHeight(height);
        this.setWidth(width);
        this.setxPosition(xPos);
        this.setyPosition(yPos);
        this.setColor(color);
    }

    @Override
    public void drawShape(Graphics g, DrawingPane drawingPane) {
        g.setColor(this.getColor());
        g.drawOval(this.getxPosition(), this.getyPosition() + ((this.getHeight() / 3) * 2), this.getWidth(), (this.getHeight() / 3));
        g.drawLine(this.getxPosition() + (this.getWidth() / 2), this.getyPosition(), this.getxPosition(), this.getyPosition() + ((this.getHeight() / 8) * 7));
        g.drawLine(this.getxPosition() + (this.getWidth() / 2), this.getyPosition(), this.getxPosition() + this.getWidth(), this.getyPosition() + ((this.getHeight() / 8) * 7));
    }

    @Override
    public void moveShape() {
        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());
    }
}
