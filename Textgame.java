import java.util.Scanner;
import java.util.Arrays;

public class Textgame {

public static int location[] = {0,0};
String text = "";
String speed = "normal";

  public static void main(String[] args) {

    Begin begin = new Begin();
    String input = "";
    String message = "";

    Begin.main();

  }

  public static String getInput(String input) {

    String message = "";
    Scanner input_ = new Scanner(System.in);
    input = input_.nextLine();
    String sep[] = input.split(" ", 2);

    switch(sep[0]) {
      case "help":
        message = "Commands\n\n";
        gprint(message, "fast");
        message = "save - save the game state \nload - load a game state\n\nwalk (north, east, south, west) - walk one square in the given direction\nsearch - search the area\nuse - try to use an item\nitems - list your items\npick up [item] - pick up an item\n\n";
        gprint(message, "fast");
        message = "You can bring these up at any time by typing \"help\"\n\n";
        gprint(message, "fast");
        gprint("Now, what will you do? ", "normal");
        getInput(input);
        break;

      case "save":
        // Save game to [name] file
        break;

      case "load":
        // Load [name]'s game
        break;

      case "search":
        // Search from map.java, roll for skill
        message = Arrays.toString(Map.search(location));
        System.out.println(message);
        gprint(message, "normal");
        gprint("Now what will you do? ", "normal");
        getInput(input);
        break;

      case "items":
        // List array of items on hand
        break;

      case "pickup":
        // Pickup the [item]
        break;

      case "use":
        // Try to use [item]
        break;

      case "walk":
        // Walk in [direction]
        switch(sep[1]) {
          case "north":
            location[0] = location[0] + 1;
            // Check map array for anything in this area monster wise, if so start it
            break;
          case "east":
            location[1] = location[1] + 1;
            break;
          case "south":
            location[0] = location[0] - 1;
            break;
          case "west":
            location[1] = location[1] - 1;
            break;
        }
        break;

    }

    return input;
  }

  public static void gprint(String text, String speed) {

    int iter = 0;
    int check = 0;
    int speed_ = 0;
    char[] text_ = text.toCharArray();
    String message = "";

    switch(speed) {
      case "slow":
        speed_ = 100;
        break;
      case "normal":
        speed_ = 50;
        break;
      case "fast":
        speed_ = 25;
        break;
      case("instant"):
        System.out.println(text);
        return;
    }

    for (iter = 0; iter < text_.length; iter++) {
      System.out.print(text_[iter]);

      try {
        Thread.sleep(speed_);
      }
      catch(Exception e) {
        System.out.println("Error");
      }

      if(check++ == 100) {
        check = 0;
        System.out.print("\n" + Arrays.toString(location) + "  ");
      }

    }
    return;
  }
}
