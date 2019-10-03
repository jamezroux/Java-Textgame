import java.util.Random;

public class Map {

  public static int XstartingArea[][] = { {1,2,3}, {1,2,3}, {1,2,3}, {1,2,3}, {1,2,3} };
  public static int YstartingArea[][] = { {1,2,3}, {1,2,3}, {1,2,3}, {1,2,3}, {1,2,3} };

  public static void main() {
    // Build a grid map here and populate it
    // Whenever the player steps on a square that has something, an event starts
    // Items / monsters / etc will all be assigned to integers in a config

    // These for example would cover a 5x5 area, get the items in X and the Items
    // in Y and roll for each one.
  }
  public static int[][] search(int[] location) {

    Random roll = new Random();
    int findSuccess;
    int findNum = 0;
    int inArea[][] = new int[10][10];
    int found[][] = new int[10][10];

    int x = location[0];
    int y = location[1];

    inArea[0] = XstartingArea[x];
    inArea[1] = YstartingArea[y];

    for( int roll_ = 0; roll_ < inArea.length; roll_++) {

      findSuccess = roll.nextInt((10 - 1) + 1) + 1;

      if(findSuccess > 5) {
        found[findNum] = inArea[roll_];
        findNum++;
      }

    }
    return found;
  }
}
