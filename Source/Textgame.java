import java.util.Scanner;
import java.util.Arrays;
import java.awt.*;
import javax.swing.*;

class TerminalOutput extends Thread {

int speed_ = Textgame.speed_;
char[] text_ = Textgame.text_;

@Override
public void run() {
        try {
                for (int iter = 0; iter < text_.length; iter++) {
                        System.out.print(text_[iter]);
                        try {
                                Thread.sleep(speed_);
                        } catch(Exception e) {
                                System.out.println("Error");
                        }
                }
        } catch(Exception e) {
                System.out.println("Error in terminal thread");
        }
}
}

class WindowOutput extends Thread {

int speed_ = Textgame.speed_;
char[] text_ = Textgame.text_;
char[] gameText_ = Textgame.gameText_;
JTextArea gameOutput = Textgame.gameOutput;

@Override
public void run() {
        try {
                // thread things
                for (int iter = 0; iter < gameText_.length; iter++) {
                        gameOutput.append(String.valueOf(gameText_[iter]));
                        gameOutput.setCaretPosition(gameOutput.getDocument().getLength());

                        try {
                                Thread.sleep(speed_);
                        } catch(Exception e) {
                                System.out.println("Error");
                        }
                }
        } catch(Exception e) {
                System.out.println("Error in terminal thread");
        }
}
}

public class Textgame {

private final static int MAX_WIDTH = 80;
public static int location[] = {0,0};
public static JTextArea gameOutput = new JTextArea();//(50,42);
public static int speed_ = 0;
public static char[] text_;
public static char[] gameText_;

String text = "";
String speed = "normal";

public static void main(String[] args) {

        Game game = new Game();
        String input = "";
        String message = "";

        // Debug only
        //for(int i = 0; i < 10; i++) {
        //  getInput(input);
        //}

        setupWindow();
        Game.main();

}

public static String getInput(String input) {

        int inventory[][] = new int[20][20];
        int item = 0;
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
                message = Map.search(location);
                gprint(message, "normal");

                gprint("Now what will you do? ", "normal");
                getInput(input);
                break;

        case "items":
                // List array of items on hand
                break;

        case "pickup":
                if(Inventory.addToInventory(inventory, item)) {
                        message = "Successfully picked up the " + item;
                        gprint(message, "normal");
                } else {
                        message = "You try to push the " + item + " into your pockets but find they're too full.";
                        gprint(message, "normal");
                }
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
                        gprint("Now what will you do? ", "normal");
                        getInput(input);
                        break;
                case "east":
                        location[1] = location[1] + 1;
                        gprint("Now what will you do? ", "normal");
                        getInput(input);
                        break;
                case "south":
                        location[0] = location[0] - 1;
                        gprint("Now what will you do? ", "normal");
                        getInput(input);
                        break;
                case "west":
                        location[1] = location[1] - 1;
                        gprint("Now what will you do? ", "normal");
                        getInput(input);
                        break;
                }
                break;

        }

        return input;
}

public static void gprint(String text, String speed) {

        String gameText = text;
        text = wrap(text);

        int iter = 0;
        int check = 0;
        text_ = text.toCharArray();
        gameText_ = gameText.toCharArray();
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
        case ("instant"):
                System.out.println(text);
                gameOutput.append(gameText);
                gameOutput.setCaretPosition(gameOutput.getDocument().getLength());
                return;
        }

        Thread tgOut = new TerminalOutput();
        Thread wgOut = new WindowOutput();

        tgOut.start();
        wgOut.start();

        return;
}

public static String wrap(String text) {
        String[] splitText = text.split(" ");
        String resultText = "";
        String lineText = "";

        for(int i = 0; i < splitText.length; i++) {
                if(lineText.isEmpty()) {

                        lineText += splitText[i];

                } else if(lineText.length() + splitText[i].length() < MAX_WIDTH) {

                        lineText += splitText[i];

                } else {

                        resultText += lineText + splitText[i] + "\n";
                        lineText = "";

                }

                lineText += " ";

        }

        if(!lineText.isEmpty()) {

                resultText += lineText + "\n";

        }

        return resultText;
}

public static void setupWindow() {

        JFrame frame = new JFrame("Text Game");
        JScrollPane gameOutputScroll = new JScrollPane(gameOutput);

        //DefaultCaret gameCaret = (DefaultCaret)gameOutput.getCaret();
        //gameCaret.setUpdatePolice(DefaultCaret.ALWAYS_UPDATE);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //gameOutput.setPreferredSize(new Dimension(256, 256));
        gameOutput.setEditable(false);
        gameOutput.setLineWrap(true);
        gameOutput.setWrapStyleWord(true);
        //frame.getContentPane().add(gameOutput, BorderLayout.CENTER);

        gameOutputScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        gameOutputScroll.setPreferredSize(new Dimension (512, 256));
        frame.getContentPane().add(gameOutputScroll, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

}
}
