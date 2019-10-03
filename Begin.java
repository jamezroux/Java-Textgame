public class Begin {
  public static void main() {

    Textgame game = new Textgame();

    String input = "";
    String message = "";

    message = "\n\n##########################################";
    Textgame.gprint(message, "instant");
    message = "#                                        #";
    Textgame.gprint(message, "instant");
    Textgame.gprint(message, "instant");
    message = "#   Welcome to the world of [*][*][*].   #";
    Textgame.gprint(message, "instant");
    message = "#                                        #";
    Textgame.gprint(message, "instant");
    message = "#                                        #";
    Textgame.gprint(message, "instant");
    message = "##########################################\n\n";
    Textgame.gprint(message, "instant");
    message = "You've awoken in a grassy area, unsure of how you got here, where here is, and why you came to this place. As you look around you see a wide field full of lush grass and dotted with small trees. You look up and see a yellow haze sky, both suns gazing down on the land. You wish you could remember what happened as you begin to realize, you remember nothing at all. You decide the first thing you need is a name, a ground.\n\n";
    Textgame.gprint(message, "normal");
    message = "What is your name? ";
    Textgame.gprint(message, "instant");
    String name = Textgame.getInput(input);
    message = "\n\n" + name + "... It sounds right to you. You feel like this really is your name, and you hope more memories come back to you.\n\n";
    Textgame.gprint(message, "normal");
    message = "You look north and see what appears to be a small pond in the valley, looking south you can see the valley turns into a desert, you can see no end.\n\n";
    Textgame.gprint(message, "normal");

    // We gotta tell them how to play sometime
    message = "Commands\n\n";
    Textgame.gprint(message, "fast");
    message = "save - save the game state \nload - load a game state\n\nwalk (north, east, south, west) - walk one square in the given direction\nsearch - search the area\nuse - try to use an item\nitems - list your items\npick up [item] - pick up an item\n\n";
    Textgame.gprint(message, "fast");
    message = "You can bring these up at any time by typing \"help\"\n\n";
    Textgame.gprint(message, "fast");

    message = "\"" + name;
    Textgame.gprint(message, "slow");
    message = "\" you think to yourself, \"it's going to be night soon. What should I do?\" ";
    Textgame.gprint(message, "normal");
    input = Textgame.getInput(input);
    message = "\n\n\"I'm going to " + input + "\" you say aloud to yourself. And begin walking.";
    Textgame.gprint(message, "normal");

  }
}
