package D03;

import java.util.Arrays;

public class LoadCharges {
    private long sumOfCharges;
    private final boolean isItFirst;

    public LoadCharges(boolean first) {
        this.sumOfCharges = 0L;
        this.isItFirst = first;
    }

    public void loadTheCharge(String line) {
        if(isItFirst) {
            sumOfCharges += findBestCharge(line);
        } else {
            sumOfCharges += findBest12Charges(line);
        }
    }

    private long findBestCharge(String fullLine) {
        int bestBest = 0;
        int secondBest = 0;

        for(int i = 0; i < fullLine.length() - 1; i++) {
            int current = Integer.parseInt(fullLine.substring(i, i + 1));
            if(bestBest < current) {
                bestBest = current;
                secondBest = 0;
            } else if(secondBest < current) {
                secondBest = current;
            }
        }
        int lastNumber = Integer.parseInt(fullLine.substring(fullLine.length() - 1));
        if(lastNumber > secondBest) {
            secondBest = lastNumber;
        }

        return (bestBest * 10L + secondBest);
    }

    private long findBest12Charges(String fullLine) {
        int[] bestBest = new int[12];
        long toReturn = 0L;

        for(int i = 0; i < fullLine.length() - 12; i++) {
            int current = Integer.parseInt(fullLine.substring(i, i + 1));
            boolean found = false;
            for(int j = 0; j < bestBest.length; j++) {
                if(found) {
                    bestBest[j] = 0;
                } else if(bestBest[j] < current) {
                    bestBest[j] = current;
                    found = true;
                }
            }
        }
        String last12 = fullLine.substring(fullLine.length() - 12);
        for(int i = 0; i < bestBest.length; i++) {
            int current = Integer.parseInt(last12.substring(i, i + 1));
            boolean found = false;
            for(int j = i; j < bestBest.length; j++) {
                if(found) {
                    bestBest[j] = 0;
                } else if(bestBest[j] < current) {
                    bestBest[j] = current;
                    found = true;
                }
            }
        }

        for(int i = 0; i < bestBest.length; i++) {
            double BIG = bestBest[i] * Math.pow(10, 11 - i);
            toReturn += (long) BIG;
        }
        System.out.println(Arrays.toString(bestBest) + " ----------> " + toReturn);
        return toReturn;
    }

    public long getSumOfCharges() {
        return sumOfCharges;
    }
}
