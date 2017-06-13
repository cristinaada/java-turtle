package turtle.types;
import turtle.Paper;
import turtle.Turtle;
import turtle.util.Direction;
import turtle.util.Pen;

public class BouncyTurtle extends Turtle {

    public BouncyTurtle(int xCoord, int yCoord, Direction direction, Pen penState, Paper paper) {
      super(xCoord,yCoord,direction,penState, paper);
    }

    public void move(int steps) {
      for(int i = 0; i < steps; i++) {
        if(!nextStepOnPaper()){
          direction = direction.opposite();
        }
        markLocation();
      }
    }
}
