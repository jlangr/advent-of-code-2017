package com.langrsoft;

public class JumpList {
    int[] counts;
    int current = 0;
    int count = 0;

    public JumpList(int... counts) {
        this.counts = counts;
    }

    public int currentIndex() {
        return current;
    }

    public int[] updatedList() {
        return counts;
    }

    public void next() {
        int jump = counts[current];
        counts[current]++;
        current += jump;
        count++;
    }

    public void run() {
        while (inBounds())
            next();
    }

    private boolean inBounds() {
        return current >= 0 && current < counts.length;
    }

    public int count() {
        return count;
    }
}
