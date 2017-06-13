package turtle.types;

import turtle.Paper;
import turtle.Turtle;
import turtle.util.Direction;
import turtle.util.Pen;

public class ReflectingTurtle extends Turtle {

  public ReflectingTurtle(int xCoord, int yCoord, Direction direction, Pen penState, Paper paper) {
    super(xCoord,yCoord,direction,penState, paper);
  }

  public void move(int steps) {
    for(int i = 0; i < steps; i++) {
      if(!nextStepOnPaper()) {
        int nextX = xCoord + direction.getNextX();
        int nextY = yCoord + direction.getNextY();

        boolean topOrBottom = nextY == -1 || nextY == paper.getHeight();
        boolean sides = nextX == -1 || nextX == paper.getHeight();
        boolean corner = sides && topOrBottom;

        if(corner) {
          direction = direction.opposite();
        }
        else {
          reflectCoordinates(topOrBottom, direction);
          direction = direction.getReflection(topOrBottom);
        }

      }
      markLocation();
    }
  }

  private void reflectCoordinates(boolean topOrBottom, Direction direction) {
    if (topOrBottom) xCoord += direction.getNextX();
    else yCoord += direction.getNextY();
  }
}
