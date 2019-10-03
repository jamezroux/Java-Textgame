import java.util.Arrays;

public class Game {
public static void main() {

        Textgame game = new Textgame();

        String name = "";
        String input = "";
        String message = "";

        // Load screen and controls
        message = "##########################################";
        Textgame.gprint(message, "normal");
        message = "#                                        #";
        Textgame.gprint(message, "fast");
        Textgame.gprint(message, "fast");
        message = "#   Welcome to the world of [*][*][*].   #";
        Textgame.gprint(message, "normal");
        message = "#                                        #";
        Textgame.gprint(message, "fast");
        message = "#                                        #";
        Textgame.gprint(message, "fast");
        message = "##########################################";
        Textgame.gprint(message, "normal");
        message = "#                                        #";
        Textgame.gprint(message, "fast");
        message = "#  Controls:                             #";
        Textgame.gprint(message, "normal");
        message = "#  save - save the game                  #";
        Textgame.gprint(message, "normal");
        message = "#  load - load a saved game              #";
        Textgame.gprint(message, "normal");
        message = "#  walk [north/east/south/west]          #";
        Textgame.gprint(message, "normal");
        message = "#  search - search the current area      #";
        Textgame.gprint(message, "normal");
        message = "#  items - list your available items     #";
        Textgame.gprint(message, "normal");
        message = "#  pickup [item] - pickup an item        #";
        Textgame.gprint(message, "normal");
        message = "#  use [item] - use an item              #";
        Textgame.gprint(message, "normal");
        message = "#                                        #";
        Textgame.gprint(message, "fast");
        message = "##########################################\n";
        Textgame.gprint(message, "normal");

        // We start the game
        message = "In a small dark room, a player opens their eyes. Revealing... nothing. Their eyes have yet to ajust to the darkness as they scamble around. It appears they're in a square room as wide as they are tall.\n";
        Textgame.gprint(message, "normal");
        message = "But the player realizes something. Not only is this room dark, but so is their head. There's nothing in there.";
        Textgame.gprint(message, "normal");
        message = "\nNo name...";
        Textgame.gprint(message, "slow");
        message = "\nNo face...";
        Textgame.gprint(message, "slow");
        message = "\nNo memories at all...";
        Textgame.gprint(message, "slow");
        message = "\n...   ...   ...\n";
        Textgame.gprint(message, "slow");
        message = "The player falls against the wall, realizing how trapped they've become in this dark place. Even in their own head. As they fall, their arm hits the wall, skidding across the rough texture. As they fall they feel grooves in the surface. Immediately they begin rubbing their fingers across the grooves, trying to make sense of anything at all. Their eyes are slowly beginning to adjust, letters emerging from the darkness. But they can't quite make them out. The player thinks it's their name. So tell me, what do you think your name is?\n";
        Textgame.gprint(message, "normal");

        name = Textgame.getInput(input);

        message = "\nThe player believes they can make out a word, and as they attempt to sound it out a name rises to their mind. " + name + ". " + name + " had no idea what they were doing here. But at least they had a name. A beginning. At least they knew they could remember.";
        Textgame.gprint(message, "normal");
        clear();

        message = "  [][][]";
        Textgame.gprint(message, "fast");
        message = "[]     []";
        Textgame.gprint(message, "fast");
        message = "[]           [][]   [][]  [][][]  [][] []  [] [][][";
        Textgame.gprint(message, "fast");
        message = "[]   [][][] []  [] []  [] []   [] []_[] [][]  []/";
        Textgame.gprint(message, "fast");
        message = "[]      []  []  [] []  [] []   [] []-[]  []   []\\";
        Textgame.gprint(message, "fast");
        message = " [][][][]    [][]   [][]  [][][]  [][]   []   [][][";
        Textgame.gprint(message, "fast");

        // From here you would call a level funcition, the main function
        // is basically just to get their name and give them the controls

        // Look into generating levels depending on how the player does

        System.exit(0);
}

public static void clear() {

        for(int line = 0; line < 100; line++) {
                System.out.println("");
        }
        return;
}
}
