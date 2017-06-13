package turtle;
import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;

public abstract class Turtle implements AnyTurtle{
  protected Direction direction;
  private Pen penState;
  protected int xCoord;
  protected int yCoord;
  protected Paper paper;
  private char mark = '*';

  public Turtle(int xCoord, int yCoord, Direction direction, Pen penState,
      Paper paper) {
    this.xCoord = xCoord;
    this.yCoord = yCoord;
    this.direction = direction;
    this.penState = penState;
    this.paper = paper;
  }

  public void setPenState(Pen penState) {
    this.penState = penState;
  }

  public void setMark(char mark) {
    this.mark = mark;
  }

  public void rotate(Rotation rotation, int times) {
    while(times > 0) {
      direction = direction.rotate(rotation);
      times--;
    }
  }

  public void markLocation() {
    if(penState == Pen.DOWN) {
      paper.markLocation(xCoord, yCoord, mark);
    }
  }

  protected boolean nextStepOnPaper() {
    int nextX = xCoord + direction.getNextX();
    int nextY = yCoord + direction.getNextY();
    if(paper.isOnPaper(nextX, nextY)) {
      xCoord = nextX;
      yCoord = nextY;
      return true;
    }
    else {
      return false;
    }
  }

  public abstract void move(int steps);

}
