package turtle.types;

import java.util.List;
import turtle.AnyTurtle;
import turtle.util.Pen;
import turtle.util.Rotation;

public class ClusterTurtle implements AnyTurtle {

  private List<AnyTurtle> turtles;

  public ClusterTurtle(List<AnyTurtle> turtles) {
    this.turtles = turtles;
  }

  public void setPenState(Pen penState) {
    for(AnyTurtle anyTurtle : turtles) {
      anyTurtle.setPenState(penState);
    }
  }

  public void setMark(char mark) {
    for(AnyTurtle anyTurtle : turtles) {
      anyTurtle.setMark(mark);
    }
  }

  public void rotate(Rotation rotation, int times) {
    for(AnyTurtle anyTurtle : turtles) {
      anyTurtle.rotate(rotation, times);
    }
  }

  public void markLocation() {
    for(AnyTurtle anyTurtle : turtles) {
      anyTurtle.markLocation();
    }
  }

  public void move(int steps) {
    for(AnyTurtle anyTurtle : turtles) {
      anyTurtle.move(steps);
    }
  }
}
