package turtle;

public class Paper {

  private int width = 0;
  private int height = 0;
  private char[][] grid;

  public Paper(int width, int height) {
    this.width = width;
    this.height = height;
    initialiseGrid();
  }

  private void initialiseGrid() {
    grid = new char[width][height];
    for(int i = 0; i < width; i++) {
      for(int j = 0; j < height; j++){
        grid[i][j] = ' ';
      }
    }
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public boolean isOnPaper(int x, int y) {
    return (x < width && x >= 0 && y < height && y >= 0);
  }

  public void markLocation(int x, int y, char mark) {
    if(isOnPaper(x, y)) grid[x][y] = mark;
  }

  @Override
  public String toString() {
    char[] charList = new char[(width + 1) * height];
    int k = 0;

    for(int j = height - 1; j >= 0; j--) {
      for(int i = 0; i < width; i++){
        charList[k++] = grid[i][j];
      }
      charList[k] = '\n';
      k++;
    }

    return new String(charList);
  }
}
