package be.vdab.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author guillaume.vandecasteele on 17/08/2015 at 19:23.
 */
public class GuessTheSauceGame implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<String> mirror = new ArrayList<>();
    private List<String> progress = new ArrayList<>();
    private String solution;
    private int attempts;
    private String displayName;


    public GuessTheSauceGame(String sauce) {
        displayName = sauce;
        solution = sauce.toLowerCase();
        mirror = Arrays.asList(solution.split(""));
        for (int i = 0; i < solution.length(); progress.add("."), i++);
        attempts = 0;

    }

    public int getAttempts() {
        return attempts;
    }

    public String getSolution() {
        return displayName;
    }

    public String getProgress() {
        return convertListToString(progress);
    }

    public boolean isWon() {
        return getProgress().equalsIgnoreCase(solution);
    }


    public String convertListToString(List<String> lst) {
        StringBuilder returnValue = new StringBuilder();
        lst.set(0, lst.get(0).toUpperCase());
        for (String str : lst) {
            returnValue.append(str);
        }
        return returnValue.toString();
    }

    public void checkGuess(String ch) {
        if (mirror.contains(ch)) {
            if (progress.contains(ch)) attempts++;
            else {
                do {
                    int result = mirror.indexOf(ch);
                    mirror.set(result, ".");
                    progress.set(result, ch);
                }
                while (mirror.contains(ch));
            }
        }
        else attempts++;
    }
}
