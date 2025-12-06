package D04;

import java.util.ArrayList;

public class HayBales {
    private int sumOfMovables;
    private final boolean isItFirst;
    private final ArrayList<char[]> storage = new ArrayList<char[]>();
    private int lastRemoved = 0;

    public HayBales(boolean first) {
        this.sumOfMovables = 0;
        this.isItFirst = first;
    }

    public void checkThePositions() {
        if(isItFirst) {
            goThroughAll();
        } else {
            goThroughAllAndRemove();
        }
    }

    public void loadStorageLine(String fullLine) {
        storage.add(fullLine.toCharArray());
    }

    private void goThroughAll() {
        for(int i = 0; i < storage.size(); i++) {
            checkLine(i);
        }
    }

    private void goThroughAllAndRemove() {
        for(int i = 0; i < storage.size(); i++) {
            checkAndClearLine(i);
        }
        while(lastRemoved > 0) {
            lastRemoved = 0;
            for(int i = 0; i < storage.size(); i++) {
                checkAndClearLine(i);
            }
        }
    }

    private void checkLine(int lineNumber) {
        for(int i = 0; i < storage.get(lineNumber).length; i++) {
            if(storage.get(lineNumber)[i] == '@') {
                int counter = 0;
                for (int x = -1; x < 2; x++) {
                    for (int y = -1; y < 2; y++) {
                        counter += mark(i + x, lineNumber + y);
                    }
                }
                if (counter < 5) {
                    sumOfMovables++;
//                    System.out.println("x: " + i + ", y: " + lineNumber + " ---------------> " + counter);
                }
            }
        }
    }

    private void checkAndClearLine(int lineNumber) {
        for(int i = 0; i < storage.get(lineNumber).length; i++) {
            if(storage.get(lineNumber)[i] == '@') {
                int counter = 0;
                for (int x = -1; x < 2; x++) {
                    for (int y = -1; y < 2; y++) {
                        counter += mark(i + x, lineNumber + y);
                    }
                }
                if (counter < 5) {
                    sumOfMovables++;
                    storage.get(lineNumber)[i] = '.';
                    lastRemoved++;
//                    System.out.println("x: " + i + ", y: " + lineNumber + " ---------------> " + counter);
                }
            }
        }
    }

    private int mark(int x, int y) {
        if(y >= 0 && y < storage.size() && x >= 0 && x < storage.get(0).length) {
            if ('@' == storage.get(y)[x]) {
                return 1;
            }
        }
        return 0;
    }

    public int getSumOfMovables() {
        return sumOfMovables;
    }
}
