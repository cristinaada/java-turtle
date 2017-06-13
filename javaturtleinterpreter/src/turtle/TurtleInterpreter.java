package turtle;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import turtle.types.BouncyTurtle;
import turtle.types.ClusterTurtle;
import turtle.types.ContinuousTurtle;
import turtle.types.NormalTurtle;
import turtle.types.ReflectingTurtle;
import turtle.types.WrappingTurtle;
import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;

public class TurtleInterpreter {

  Scanner scanner;
  PrintStream printStream;
  Map<String, AnyTurtle> mapNamesTurtle = new HashMap<>();
  Paper paper = new Paper(10, 10);

  public TurtleInterpreter(Scanner scanner, PrintStream printStream) {
    this.scanner = scanner;
    this.printStream = printStream;
  }

  public void readAndProcess() {
    while (scanner.hasNext()) {
      String command = scanner.next();
      switch (command) {
        case "paper":
          newPaper();
          break;
        case "new":
          newTurtle(false, "");
          break;
        case "pen":
          updatePen();
          break;
        case "move":
          move();
          break;
        case "right":
          turnRight();
          break;
        case "left":
          turnLeft();
          break;
        case "show":
          printStream.println(paper.toString());
          break;
        default:
          System.err.println("Invalid command: " + command);
      }
    }
  }

  private void newPaper() {
    paper = new Paper(scanner.nextInt(), scanner.nextInt());
    mapNamesTurtle.clear();
  }

  private AnyTurtle newTurtle(boolean inCluster, String clusterName) {
    String type = scanner.next();
    String name = scanner.next();
    if(inCluster) {
      name = clusterName + "." + name;
    }

    AnyTurtle turtle;
    if(type.equals("cluster")) {
      turtle = makeCluster(name);
    }
    else {
      turtle = makeSingleTurtle(type);
    }
    mapNamesTurtle.put(name, turtle);
    return turtle;
  }

  private AnyTurtle makeSingleTurtle(String type) {
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    switch (type) {
      case "normal":
        return new NormalTurtle(x, y, Direction.NORTH, Pen.UP, paper);
      case "bouncy":
        return new BouncyTurtle(x, y, Direction.NORTH, Pen.UP, paper);
      case "continuous":
        return new ContinuousTurtle(x, y, Direction.NORTH, Pen.UP, paper);
      case "reflecting":
        return new ReflectingTurtle(x, y, Direction.NORTH, Pen.UP, paper);
      case "wrapping":
        return new WrappingTurtle(x, y, Direction.NORTH, Pen.UP, paper);
      default:
        System.err.println("Invalid turtle type: " + type);
        return null;
    }
  }

  private AnyTurtle makeCluster(String name) {
    int clusterSize = scanner.nextInt();
    List<AnyTurtle> cluster = new ArrayList<>(clusterSize);

    for(int i = 0; i < clusterSize; i++) {
      scanner.next();
      cluster.add(newTurtle(true, name));
    }
    return new ClusterTurtle(cluster);
  }

  private void updatePen() {
    AnyTurtle turtle = getTurtle();
    String command = scanner.next();
    if(command.length() == 1) {
      turtle.setMark(command.charAt(0));
    }
    else {
      switch (command) {
        case "up":
          turtle.setPenState(Pen.UP);
          break;
        case "down":
          turtle.setPenState(Pen.DOWN);
          break;
        default:
          System.err.println("Invalid command: pen " + command );
      }
    }
  }

  private void move() {
    AnyTurtle turtle = getTurtle();
    int distance = scanner.nextInt();
    turtle.move(distance);
  }

  private void turnRight() {
    AnyTurtle turtle = getTurtle();
    int times = scanner.nextInt() / 45;
    turtle.rotate(Rotation.RIGHT, times);
  }

  private void turnLeft() {
    AnyTurtle turtle = getTurtle();
    int times = scanner.nextInt() / 45;
    turtle.rotate(Rotation.LEFT, times);
  }

  private AnyTurtle getTurtle() {
    String name = scanner.next();
    if(mapNamesTurtle.containsKey(name)) {
      return mapNamesTurtle.get(name);
    }
    else {
      System.err.println("No " + name + " turtle.");
      return null;
    }
  }
}
