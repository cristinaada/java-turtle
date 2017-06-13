package turtle.util;

public enum Rotation {
  LEFT(-1),
  RIGHT(1);

  public final int way;

  Rotation(int way) {
    this.way = way;
  }

}