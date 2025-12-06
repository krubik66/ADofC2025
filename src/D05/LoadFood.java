package D05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LoadFood {
    private long sumOfFresh;
    private final boolean isItFirst;
    private boolean areThoseItems = false;
    private boolean isItFinished = false;
    private final ArrayList<String> ranges = new ArrayList<>();

    public LoadFood(boolean first) {
        this.sumOfFresh = 0;
        this.isItFirst = first;
    }

    public void loadTheCharge(String line) {
        if(!isItFinished) {
            if (areThoseItems) {
                if (isItFirst) {
                    sumOfFresh += findThatItem(line);
                } else {
                    sumOfFresh += getAllRanges();
                    isItFinished = true;
                }
            } else {
                if (line.isEmpty()) {
                    areThoseItems = true;
                } else {
                    ranges.add(line);
                }
            }
        }
    }

    private int findThatItem(String line) {
        int toReturn = 0;
        for (String range : ranges) {
            if (toReturn == 0 && isInRange(line, range)) {
                toReturn = 1;
            }
        }
        return toReturn;
    }

    private boolean isInRange(String line, String range) {
        String[] splited = range.split("-");
        long number = Long.parseLong(line);
        return (number >= Long.parseLong(splited[0]) && number <= Long.parseLong(splited[1]));
    }

    private long getAllRanges() {
        long toReturn = 0;
        long currentBiggest = 0;
        ranges.sort(Comparator.comparingLong(
                item -> Long.parseLong(item.split("-")[0])
        ));

        for(String range : ranges) {
            String[] splited = range.split("-");
            if(currentBiggest < Long.parseLong(splited[0])) {
                toReturn++;
            }
            toReturn += Math.max(currentBiggest, Long.parseLong(splited[1])) - Math.max(currentBiggest, Long.parseLong(splited[0]));
            currentBiggest = Math.max(currentBiggest, Long.parseLong(splited[1]));
        }

        return toReturn;
    }

    public long getSumOfFresh() {
        return sumOfFresh;
    }
}
