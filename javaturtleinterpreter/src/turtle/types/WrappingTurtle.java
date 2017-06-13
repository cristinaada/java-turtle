package turtle.types;

import turtle.Paper;
import turtle.Turtle;
import turtle.util.Direction;
import turtle.util.Pen;

public class WrappingTurtle extends Turtle {

  public WrappingTurtle(int xCoord, int yCoord, Direction direction, Pen penState, Paper paper) {
    super(xCoord,yCoord,direction,penState, paper);
  }

  public void move(int steps) {
    for(int i = 0; i < steps; i++) {
      if(!nextStepOnPaper()){
        wrapCoordinates();
        xCoord += direction.getNextX();
        yCoord += direction.getNextY();
      }
      markLocation();
    }
  }

  private void wrapCoordinates() {
    int nextX = xCoord + direction.getNextX();
    int nextY = yCoord + direction.getNextY();
    boolean topOrBottom = nextY == -1 || nextY == paper.getHeight();
    boolean sides = nextX == -1 || nextX == paper.getHeight();

    if(topOrBottom) {
      wrapY();
    }
    if(sides) {
      wrapX();
    }
  }

  private void wrapX() {
    if(xCoord == 0) {
      xCoord = paper.getWidth();
    }
    else {
      xCoord = -1;
    }
  }

  private void wrapY() {
    if(yCoord == 0) {
      yCoord = paper.getHeight();
    }
    else {
      yCoord = -1;
    }
  }
}


