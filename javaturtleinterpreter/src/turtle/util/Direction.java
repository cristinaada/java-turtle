package turtle.util;

public enum Direction {
  NORTH(0, 1),
  NORTHEAST(1, 1),
  EAST(1, 0),
  SOUTHEAST(1, -1),
  SOUTH(0, -1),
  SOUTHWEST(-1, -1),
  WEST(-1, 0),
  NORTHWEST(-1, 1);

  private final int nextX;
  private final int nextY;

  Direction(int nextX, int nextY) {
    this.nextX = nextX;
    this.nextY = nextY;
  }

  public int getNextX() {
    return nextX;
  }

  public int getNextY() {
    return nextY;
  }

  public Direction getReflection(boolean topOrBottom) {
      switch (this) {
        case NORTHEAST:
          if(topOrBottom) return SOUTHEAST;
          else return NORTHWEST;
        case SOUTHEAST:
          if(topOrBottom) return NORTHEAST;
          else return SOUTHWEST;
        case SOUTHWEST:
          if(topOrBottom) return NORTHWEST;
          else return SOUTHEAST;
        case NORTHWEST:
          if(topOrBottom) return SOUTHWEST;
          else return NORTHEAST;
        default:
          return this.opposite();
      }
  }

  public Direction opposite() {
    return Direction.values()[(ordinal() + 4) % Direction.values().length];
  }

  public Direction rotate(Rotation rotation) {
    int directionsNumber = Direction.values().length;
    int x = (ordinal() + rotation.way) % directionsNumber;
    if(x < 0) {
      x += directionsNumber;
    }
    return Direction.values()[x];
  }


}