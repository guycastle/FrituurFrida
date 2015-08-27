package be.vdab.entities;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author guillaume.vandecasteele on 17/08/2015 at 15:57.
 */
public class FindTheFryGame implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<Integer, Boolean> progress;
    private final int fryLocation;
    private boolean won;

    public FindTheFryGame() {
        progress = new TreeMap<>();
        for (int i = 1; i <= 7; progress.put(i, false), i++);
        fryLocation = (int) (Math.random() * 7 + 1);
        won = false;
    }

    public int getFryLocation() {
        return fryLocation;
    }

    public boolean isOpen(int door) {
        return progress.get(door);
    }

    public void setOpen(int door) {
        progress.put(door, true);
        if (door == fryLocation) won = true;
    }

    public boolean isWon() {
        return won;
    }

    public Map<Integer, Boolean> getProgress() {
        return new TreeMap<>(progress);
    }
}
