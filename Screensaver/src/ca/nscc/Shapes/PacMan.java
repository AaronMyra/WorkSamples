package ca.nscc.Shapes;

import ca.nscc.GUI.DrawingPane;

import java.awt.*;

public class PacMan extends Shape {

    public PacMan(int height, int width, int xPos, int yPos, Color color){
        this.setHeight(height);
        this.setWidth(width);
        this.setxPosition(xPos);
        this.setyPosition(yPos);
        this.setColor(color);
    }

    @Override
    public void drawShape(Graphics g, DrawingPane drawingPane) {
        g.setColor(this.getColor());
        g.fillArc(this.getxPosition(), this.getyPosition() + (this.getHeight() / 2), this.getWidth(), this.getHeight(), 45, 100);
        g.fillArc(this.getxPosition(), this.getyPosition() + (this.getHeight() / 2), this.getWidth(), this.getHeight(), 100, 145);
        g.fillArc(this.getxPosition(), this.getyPosition() + (this.getHeight() / 2), this.getWidth(), this.getHeight(), 145, 190);
    }

    public void closeMouth1(Graphics g) {
        g.setColor(this.getColor());
        g.fillArc(this.getxPosition(), this.getyPosition() + (this.getHeight() / 2), this.getWidth(), this.getHeight(), 25, 100);
        g.fillArc(this.getxPosition(), this.getyPosition() + (this.getHeight() / 2), this.getWidth(), this.getHeight(), 100, 145);
        g.fillArc(this.getxPosition(), this.getyPosition() + (this.getHeight() / 2), this.getWidth(), this.getHeight(), 145, 200);
    }

    public void closeMouth2(Graphics g) {
        g.setColor(this.getColor());
        g.fillArc(this.getxPosition(), this.getyPosition() + (this.getHeight() / 2), this.getWidth(), this.getHeight(), 10, 100);
        g.fillArc(this.getxPosition(), this.getyPosition() + (this.getHeight() / 2), this.getWidth(), this.getHeight(), 100, 145);
        g.fillArc(this.getxPosition(), this.getyPosition() + (this.getHeight() / 2), this.getWidth(), this.getHeight(), 145, 215);
    }

    public void closeMouth3(Graphics g) {
        g.setColor(this.getColor());
        g.fillArc(this.getxPosition(), this.getyPosition() + (this.getHeight() / 2), this.getWidth(), this.getHeight(), 5, 100);
        g.fillArc(this.getxPosition(), this.getyPosition() + (this.getHeight() / 2), this.getWidth(), this.getHeight(), 100, 145);
        g.fillArc(this.getxPosition(), this.getyPosition() + (this.getHeight() / 2), this.getWidth(), this.getHeight(), 145, 220);
    }

    @Override
    public void moveShape() {
        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());
    }
}
