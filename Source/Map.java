import java.util.Arrays;
import java.util.Random;

public class Map {

  public static int XstartingArea[][] = { {0,1,2,3}, {0,1,2,3}, {0,1,2,3}, {0,1,2,3}, {0,1,2,3} };
  public static int YstartingArea[][] = { {0,1,2,3}, {0,1,2,3}, {0,1,2,3}, {0,1,2,3}, {0,1,2,3} };

  public static void main() {
    // Build a grid map here and populate it
    // Whenever the player steps on a square that has something, an event starts
    // Items / monsters / etc will all be assigned to integers in a config

    // These for example would cover a 5x5 area, get the items in X and the Items
    // in Y and roll for each one.
  }
  public static String search(int[] location) {

    Random roll = new Random();
    int findChoice = 0;
    int findRoll = 0;
    int findSuccess;
    int findNum = 0;
    int inArea[][] = new int[5][5];
    int found[] = new int[5];

    int x = location[0];
    int y = location[1];

    inArea[0] = XstartingArea[x];
    inArea[1] = YstartingArea[y];

    for( int roll_ = 0; roll_ < 4; roll_++) {

      findChoice = roll.nextInt((10 - 0) + 1) + 0;

      if(findChoice < 5) {
        // Do the x thing
        findRoll = roll.nextInt((3-0) + 1) + 0;
        found[roll_] = inArea[0][findRoll];
      } else {
        // Do the y thing
        findRoll = roll.nextInt((3-0) + 1) + 0;
        found[roll_] = inArea[1][findRoll];
      }
    }
    return Arrays.toString(found);
  }
}
