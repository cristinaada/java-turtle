package turtle;

import turtle.util.Pen;
import turtle.util.Rotation;

public interface AnyTurtle {

  void setPenState(Pen penState);

  void setMark(char mark);

  void rotate(Rotation rotation, int times);

  void markLocation();

  void move(int steps);
}
