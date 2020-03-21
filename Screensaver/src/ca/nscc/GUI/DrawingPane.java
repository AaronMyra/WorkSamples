package ca.nscc.GUI;

import ca.nscc.Shapes.*;
import ca.nscc.Shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

public class DrawingPane extends JPanel {

    //Variables
    private ArrayList<Shape> shapes;
    private Timer timer = new Timer(50, new TimerAction());
    private Random random = new Random();
    private int randomNum, randomBound = 25, shapeLimit = 10;

    public DrawingPane() {

        //SHAPE ARRAY
        shapes = new ArrayList<>();

        //Start Timer
        timer.start();

        //Add MOUSE LISTENER
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                randomNum = random.nextInt(7);
                //randomNum = 6;
                switch (randomNum){

                    //Square Shape
                    case 0:                         //Random Height, Random Width, Cursor xPos, Cursor yPos
                        Shape newRect = new Square(random.nextInt(randomBound), random.nextInt(randomBound), e.getX(), e.getY(),
                                                    //New Color with random RGB values
                                                    new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)),
                                                    new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                        shapes.add(newRect);
                        break;

                    //Circle shape
                    case 1:              //Random Height, Random Width, Cursor xPos, Cursor yPos
                        Shape newCirc = new Circle(random.nextInt(randomBound), random.nextInt(randomBound), e.getX(), e.getY(),
                                                    //2X New Colors with random RGB values
                                                    new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)),
                                                    new Color(random.nextInt(255), random.nextInt(255),random.nextInt(255)));
                        shapes.add(newCirc);
                        break;

                    //Mario Image
                    case 2:
                        Shape newMario = new Mario(random.nextInt(randomBound), random.nextInt(randomBound), e.getX(), e.getY());
                        shapes.add(newMario);
                        break;

                    //Octagon Shape
                    case 3:
                        Shape newOctagon = new Octagon(random.nextInt(randomBound), random.nextInt(randomBound), e.getX(), e.getY(),
                                                        //New Color with random RGB values
                                                        new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                        shapes.add(newOctagon);
                        break;

                    //Pac-man shape
                    case 4:
                        Shape newPacMan = new PacMan(random.nextInt(randomBound), random.nextInt(randomBound), e.getX(), e.getY(),
                                                    //New Color with random RGB values
                                                    new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                        shapes.add(newPacMan);
                        break;

                    case 5:
                        Shape newCube = new Cube(random.nextInt(randomBound), random.nextInt(randomBound), e.getX(), e.getY(),
                                //New Color with random RGB values
                                new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                        shapes.add(newCube);
                        break;

                    case 6:
                        Shape newCone = new Cone(random.nextInt(randomBound), random.nextInt(randomBound), e.getX(), e.getY(),
                                //New Color with random RGB values
                                new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                        shapes.add(newCone);
                        break;
                }
                if (shapes.size() > shapeLimit){
                    shapes.remove(shapes.size() - shapeLimit);
                }
                paintComponent(getGraphics());
            }
        });
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for (Shape currentShape : shapes) {
            currentShape.drawShape(g, this);
        }
    }

    private void animateShape(){

        for (Shape currentShape : shapes) {
                currentShape.moveShape();
                detectCollision(currentShape);
        }
        this.repaint();
    }


    private class TimerAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            animateShape();
        }
    }

    public void detectCollision(Shape currentShape) {

        if (currentShape.getxPosition() <= 0 || currentShape.getxPosition() + currentShape.getWidth() >= this.getWidth()) {
            currentShape.setxSpeed(currentShape.getxSpeed() * -1);
        }

        else if (currentShape.getyPosition() <= 0 || currentShape.getyPosition() + currentShape.getHeight() >= this.getHeight()) {
            currentShape.setySpeed(currentShape.getySpeed() * -1);
        }

        for (Shape otherShape : shapes) {
            Rectangle r1 = currentShape.getBorderBox();
            Rectangle r2 = otherShape.getBorderBox();
            if (r1.intersects(r2)) {
                currentShape.setxSpeed(currentShape.getxSpeed() * -1);
                currentShape.setySpeed(currentShape.getySpeed() * -1);
                otherShape.setxSpeed(otherShape.getxSpeed() * -1);
                otherShape.setySpeed(otherShape.getySpeed() * -1);

                //Constant circle color change? (Trippy)
                if (currentShape instanceof Circle){
                    currentShape.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                    ((Circle) currentShape).setSecondColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                }
                //Tried to animate pac-man mouth
//            if (currentShape instanceof PacMan){
//                ((PacMan) currentShape).closeMouth1(getGraphics());
//                ((PacMan) currentShape).closeMouth2(getGraphics());
//                ((PacMan) currentShape).closeMouth3(getGraphics());
//            }
            }
        }
    }
}
